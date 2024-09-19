package com.mobius.software.telco.protocols.diameter.test.nt;
/*
 * Mobius Software LTD
 * Copyright 2019 - 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.nt.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.nt.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.nt.NtClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.nt.BackgroundDataTransferRequest;
import com.mobius.software.telco.protocols.diameter.commands.nt.BackgroundDataTransferAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.nt.NtProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferRequestTypeEnum;

/**
*
* @author yulian oifa
*
*/
public class NtTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(NtTest.class);
	
	@Test
	public void testNt() throws Exception
	{
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong btaReceived=new AtomicLong(0L);
		final AtomicLong btaReceivedByListener=new AtomicLong(0L);
		final AtomicLong btrReceived=new AtomicLong(0L);
		final AtomicLong btrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof BackgroundDataTransferAnswer)
					btrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof BackgroundDataTransferRequest)
					btaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		NtProviderImpl provider = (NtProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.NT), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.nt"));
		ClusteredID<?> listenerID=generator.generateID();
		provider.setClientListener(listenerID, new ClientListener()
		{
			@Override
			public void onTimeout(DiameterRequest request,DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}
			
			@Override
			public void onIdleTimeout(DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onInitialAnswer(BackgroundDataTransferAnswer answer, ClientAuthSessionStateless<BackgroundDataTransferRequest> session, String linkID, AsyncCallback callback)
			{
				btaReceivedByListener.incrementAndGet();
			}
		});
		
		NtProviderImpl serverProvider = (NtProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.NT), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.nt"));
		serverProvider.setServerListener(listenerID, new ServerListener()
		{
			@Override
			public void onTimeout(DiameterRequest request,DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}
			
			@Override
			public void onIdleTimeout(DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onInitialRequest(BackgroundDataTransferRequest request, ServerAuthSessionStateless<BackgroundDataTransferAnswer> session, String linkID, AsyncCallback callback)
			{
				btrReceivedByListener.incrementAndGet();
				BackgroundDataTransferRequest btr=(BackgroundDataTransferRequest)request;
				try
				{
					BackgroundDataTransferAnswer bta = serverProvider.getMessageFactory().createBackgroundDataTransferAnswer(btr, btr.getHopByHopIdentifier(), btr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(bta, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Background Data Transfer Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Background Data Transfer Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		BackgroundDataTransferRequest request = provider.getMessageFactory().createBackgroundDataTransferRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(),TransferRequestTypeEnum.TRANSFER_POLICY_NOTIFICATION);
		NtClientSession clientSession = (NtClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Background Data Transfer Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(clientSession.getSessionState(),SessionStateEnum.IDLE);
		
		//make sure no timeout is processed
		try
		{
			Thread.sleep(idleTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		super.stopLocal();
		super.stopRemote();
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(btaReceived.get() , 1L);
		assertEquals(btaReceivedByListener.get() , 1L);
		assertEquals(btrReceived.get() , 1L);
		assertEquals(btrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}
	
	@Test
	public void testDuplicateEvent() throws Exception
	{
		super.setupRemote(1000L,2000L);
		super.setupLocal(1000L,2000L);
		
		final AtomicLong btaReceived=new AtomicLong(0L);
		final AtomicLong btaReceivedByListener=new AtomicLong(0L);
		final AtomicLong btrReceived=new AtomicLong(0L);
		final AtomicLong btrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof BackgroundDataTransferAnswer)
					btrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof BackgroundDataTransferRequest)
					btaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		NtProviderImpl provider = (NtProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.NT), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.nt"));
		ClusteredID<?> listenerID=generator.generateID();
		provider.setClientListener(listenerID, new ClientListener()
		{
			@Override
			public void onTimeout(DiameterRequest request,DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}
			
			@Override
			public void onIdleTimeout(DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onInitialAnswer(BackgroundDataTransferAnswer answer, ClientAuthSessionStateless<BackgroundDataTransferRequest> session, String linkID, AsyncCallback callback)
			{
				btaReceivedByListener.incrementAndGet();
			}
		});
		
		NtProviderImpl serverProvider = (NtProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.NT), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.nt"));
		serverProvider.setServerListener(listenerID, new ServerListener()
		{
			@Override
			public void onTimeout(DiameterRequest request,DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}
			
			@Override
			public void onIdleTimeout(DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onInitialRequest(BackgroundDataTransferRequest request, ServerAuthSessionStateless<BackgroundDataTransferAnswer> session, String linkID, AsyncCallback callback)
			{
				btrReceivedByListener.incrementAndGet();
				BackgroundDataTransferRequest btr=(BackgroundDataTransferRequest)request;
				try
				{
					BackgroundDataTransferAnswer bta = serverProvider.getMessageFactory().createBackgroundDataTransferAnswer(btr, btr.getHopByHopIdentifier(), btr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(bta, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Background Data Transfer Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Message Process Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		BackgroundDataTransferRequest request = provider.getMessageFactory().createBackgroundDataTransferRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(),TransferRequestTypeEnum.TRANSFER_POLICY_NOTIFICATION);
		NtClientSession clientSession = (NtClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Background Data Transfer Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(clientSession.getSessionState(),SessionStateEnum.IDLE);
		
		localLink.sendMessage(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
				
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				
			}
		});
		
		//make sure no timeout is processed
		try
		{
			Thread.sleep(idleTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		super.stopLocal();
		super.stopRemote();
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(btaReceived.get() , 1L);
		assertEquals(btaReceivedByListener.get() , 1L);
		assertEquals(btrReceived.get() , 2L);
		assertEquals(btrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
}