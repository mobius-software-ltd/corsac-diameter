package com.mobius.software.telco.protocols.diameter.test.slh;
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
import com.mobius.software.telco.protocols.diameter.app.slh.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.slh.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.slh.SlhClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.slh.LCSRoutingInfoAnswer;
import com.mobius.software.telco.protocols.diameter.commands.slh.LCSRoutingInfoRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.slh.SlhProviderImpl;

/**
*
* @author yulian oifa
*
*/
public class SlhTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(SlhTest.class);
	
	@Test
	public void testSlh() throws Exception
	{
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong riaReceived=new AtomicLong(0L);
		final AtomicLong riaReceivedByListener=new AtomicLong(0L);
		final AtomicLong rirReceived=new AtomicLong(0L);
		final AtomicLong rirReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof LCSRoutingInfoAnswer)
					rirReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof LCSRoutingInfoRequest)
					riaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		SlhProviderImpl provider = (SlhProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.SLH), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.slh"));
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
			public void onInitialAnswer(LCSRoutingInfoAnswer answer, ClientAuthSessionStateless<LCSRoutingInfoRequest> session, String linkID, AsyncCallback callback)
			{
				riaReceivedByListener.incrementAndGet();
			}
		});
		
		SlhProviderImpl serverProvider = (SlhProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.SLH), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.slh"));
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
			public void onInitialRequest(LCSRoutingInfoRequest request, ServerAuthSessionStateless<LCSRoutingInfoAnswer> session, String linkID, AsyncCallback callback)
			{
				rirReceivedByListener.incrementAndGet();
				LCSRoutingInfoRequest rir=(LCSRoutingInfoRequest)request;
				try
				{
					LCSRoutingInfoAnswer ria = serverProvider.getMessageFactory().createLCSRoutingInfoAnswer(rir, rir.getHopByHopIdentifier(), rir.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(ria, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending LCS Routing Info Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending LCS Routing Info Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		LCSRoutingInfoRequest request = provider.getMessageFactory().createLCSRoutingInfoRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm());
		SlhClientSession clientSession = (SlhClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending LCS Routing Info Request," + ex.getMessage(),ex);
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
		
		assertEquals(riaReceived.get() , 1L);
		assertEquals(riaReceivedByListener.get() , 1L);
		assertEquals(rirReceived.get() , 1L);
		assertEquals(rirReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}
	
	@Test
	public void testDuplicateEvent() throws Exception
	{
		super.setupRemote(1000L,2000L);
		super.setupLocal(1000L,2000L);
		
		final AtomicLong riaReceived=new AtomicLong(0L);
		final AtomicLong riaReceivedByListener=new AtomicLong(0L);
		final AtomicLong rirReceived=new AtomicLong(0L);
		final AtomicLong rirReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof LCSRoutingInfoAnswer)
					rirReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof LCSRoutingInfoRequest)
					riaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		SlhProviderImpl provider = (SlhProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.SLH), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.slh"));
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
			public void onInitialAnswer(LCSRoutingInfoAnswer answer, ClientAuthSessionStateless<LCSRoutingInfoRequest> session, String linkID, AsyncCallback callback)
			{
				riaReceivedByListener.incrementAndGet();
			}
		});
		
		SlhProviderImpl serverProvider = (SlhProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.SLH), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.slh"));
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
			public void onInitialRequest(LCSRoutingInfoRequest request, ServerAuthSessionStateless<LCSRoutingInfoAnswer> session, String linkID, AsyncCallback callback)
			{
				rirReceivedByListener.incrementAndGet();
				LCSRoutingInfoRequest rir=(LCSRoutingInfoRequest)request;
				try
				{
					LCSRoutingInfoAnswer ria = serverProvider.getMessageFactory().createLCSRoutingInfoAnswer(rir, rir.getHopByHopIdentifier(), rir.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(ria, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending LCS Routing Info Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending LCS Routing Info Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		LCSRoutingInfoRequest request = provider.getMessageFactory().createLCSRoutingInfoRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm());
		SlhClientSession clientSession = (SlhClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending LCS Routing Info Request," + ex.getMessage(),ex);
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
		
		assertEquals(riaReceived.get() , 1L);
		assertEquals(riaReceivedByListener.get() , 1L);
		assertEquals(rirReceived.get() , 2L);
		assertEquals(rirReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
}