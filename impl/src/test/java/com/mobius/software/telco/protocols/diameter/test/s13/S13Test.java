package com.mobius.software.telco.protocols.diameter.test.s13;
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
import com.mobius.software.telco.protocols.diameter.app.s13.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.s13.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.s13.S13ClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.s13.MEIdentityCheckRequest;
import com.mobius.software.telco.protocols.diameter.commands.s13.MEIdentityCheckAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s13.S13Answer;
import com.mobius.software.telco.protocols.diameter.commands.s13.S13Request;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.s13.S13ProviderImpl;


/**
*
* @author yulian oifa
*
*/
public class S13Test extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(S13Test.class);
	
	@Test
	public void testNt() throws Exception
	{
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong ecaReceived=new AtomicLong(0L);
		final AtomicLong ecaReceivedByListener=new AtomicLong(0L);
		final AtomicLong ecrReceived=new AtomicLong(0L);
		final AtomicLong ecrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof MEIdentityCheckAnswer)
					ecrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof MEIdentityCheckRequest)
					ecaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		S13ProviderImpl provider = (S13ProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.S13), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.s13"));
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
			public void onInitialAnswer(MEIdentityCheckAnswer answer, ClientAuthSessionStateless<MEIdentityCheckRequest> session, String linkID, AsyncCallback callback)
			{
				ecaReceivedByListener.incrementAndGet();
			}
		});
		
		S13ProviderImpl serverProvider = (S13ProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.S13), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.s13"));
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
			public void onInitialRequest(MEIdentityCheckRequest request, ServerAuthSessionStateless<MEIdentityCheckAnswer> session, String linkID, AsyncCallback callback)
			{
				ecrReceivedByListener.incrementAndGet();
				MEIdentityCheckRequest ecr=(MEIdentityCheckRequest)request;
				try
				{
					MEIdentityCheckAnswer eca = serverProvider.getMessageFactory().createMEIdentityCheckAnswer(ecr, ecr.getHopByHopIdentifier(), ecr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(eca, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending ME Identity Check Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending ME Identity Check Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		MEIdentityCheckRequest request = provider.getMessageFactory().createMEIdentityCheckRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm());
		S13ClientSession clientSession = (S13ClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending ME Identity Check Request," + ex.getMessage(),ex);
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
		
		assertEquals(ecaReceived.get() , 1L);
		assertEquals(ecaReceivedByListener.get() , 1L);
		assertEquals(ecrReceived.get() , 1L);
		assertEquals(ecrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}
	
	@Test
	public void testDuplicateEvent() throws Exception
	{
		super.setupRemote(1000L,2000L);
		super.setupLocal(1000L,2000L);
		
		final AtomicLong ecaReceived=new AtomicLong(0L);
		final AtomicLong ecaReceivedByListener=new AtomicLong(0L);
		final AtomicLong ecrReceived=new AtomicLong(0L);
		final AtomicLong ecrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof S13Answer)
					ecrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof S13Request)
					ecaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		S13ProviderImpl provider = (S13ProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.S13), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.s13"));
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
			public void onInitialAnswer(MEIdentityCheckAnswer answer, ClientAuthSessionStateless<MEIdentityCheckRequest> session, String linkID, AsyncCallback callback)
			{
				ecaReceivedByListener.incrementAndGet();
			}
		});
		
		S13ProviderImpl serverProvider = (S13ProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.S13), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.s13"));
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
			public void onInitialRequest(MEIdentityCheckRequest request, ServerAuthSessionStateless<MEIdentityCheckAnswer> session, String linkID, AsyncCallback callback)
			{
				ecrReceivedByListener.incrementAndGet();
				MEIdentityCheckRequest ecr=(MEIdentityCheckRequest)request;
				try
				{
					MEIdentityCheckAnswer eca = serverProvider.getMessageFactory().createMEIdentityCheckAnswer(ecr, ecr.getHopByHopIdentifier(), ecr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(eca, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending ME Identity Check Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending ME Identity Check Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		MEIdentityCheckRequest request = provider.getMessageFactory().createMEIdentityCheckRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm());
		S13ClientSession clientSession = (S13ClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending ME Identity Check Request," + ex.getMessage(),ex);
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
		
		assertEquals(ecaReceived.get() , 1L);
		assertEquals(ecaReceivedByListener.get() , 1L);
		assertEquals(ecrReceived.get() , 2L);
		assertEquals(ecrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
}