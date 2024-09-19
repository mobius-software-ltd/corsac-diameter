package com.mobius.software.telco.protocols.diameter.test.cxdx;
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
import com.mobius.software.telco.protocols.diameter.app.cxdx.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.CxDxAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.CxDxRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.cxdx.CxDxProviderImpl;

/**
*
* @author yulian oifa
*
*/
public class CxdxUserAuthorizationTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(CxdxUserAuthorizationTest.class);
	
	@Test
	public void testUserAuthorization() throws Exception
	{
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong uaaReceived=new AtomicLong(0L);
		final AtomicLong uaaReceivedByListener=new AtomicLong(0L);
		final AtomicLong uarReceived=new AtomicLong(0L);
		final AtomicLong uarReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CxDxAnswer)
					uarReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CxDxRequest)
					uaaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		CxDxProviderImpl provider = (CxDxProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.CX_DX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.cxdx"));
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
			public void onInitialAnswer(CxDxAnswer answer, ClientAuthSessionStateless<CxDxRequest> session, String linkID, AsyncCallback callback)
			{
				uaaReceivedByListener.incrementAndGet();
			}
		});
		
		CxDxProviderImpl serverProvider = (CxDxProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.CX_DX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.cxdx"));
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
			public void onInitialRequest(CxDxRequest request, ServerAuthSessionStateless<CxDxAnswer> session, String linkID, AsyncCallback callback)
			{
				uarReceivedByListener.incrementAndGet();
				UserAuthorizationRequest uar=(UserAuthorizationRequest)request;
				try
				{
					UserAuthorizationAnswer saa = serverProvider.getMessageFactory().createUserAuthorizationAnswer(uar, uar.getHopByHopIdentifier(), uar.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(saa, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending User Authorization Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending User Authorization Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		 
		UserAuthorizationRequest request = provider.getMessageFactory().createUserAuthorizationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm());
		CxDxClientSession clientSession = (CxDxClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending User Authorization Request," + ex.getMessage(),ex);
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
		
		assertEquals(uaaReceived.get() , 1L);
		assertEquals(uaaReceivedByListener.get() , 1L);
		assertEquals(uarReceived.get() , 1L);
		assertEquals(uarReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}
	
	@Test
	public void testDuplicateUserAuthorization() throws Exception
	{
		super.setupRemote(1000L,2000L);
		super.setupLocal(1000L,2000L);
		
		final AtomicLong uaaReceived=new AtomicLong(0L);
		final AtomicLong uaaReceivedByListener=new AtomicLong(0L);
		final AtomicLong uarReceived=new AtomicLong(0L);
		final AtomicLong uarReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CxDxAnswer)
					uarReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CxDxRequest)
					uaaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		CxDxProviderImpl provider = (CxDxProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.CX_DX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.cxdx"));
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
			public void onInitialAnswer(CxDxAnswer answer, ClientAuthSessionStateless<CxDxRequest> session, String linkID, AsyncCallback callback)
			{
				uaaReceivedByListener.incrementAndGet();
			}
		});
		
		CxDxProviderImpl serverProvider = (CxDxProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.CX_DX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.cxdx"));
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
			public void onInitialRequest(CxDxRequest request, ServerAuthSessionStateless<CxDxAnswer> session, String linkID, AsyncCallback callback)
			{
				uarReceivedByListener.incrementAndGet();
				UserAuthorizationRequest uar=(UserAuthorizationRequest)request;
				try
				{
					UserAuthorizationAnswer uaa = serverProvider.getMessageFactory().createUserAuthorizationAnswer(uar, uar.getHopByHopIdentifier(), uar.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(uaa, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending User Authorization Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending User Authorization Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		UserAuthorizationRequest request = provider.getMessageFactory().createUserAuthorizationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm());
		CxDxClientSession clientSession = (CxDxClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending User Authorization Request," + ex.getMessage(),ex);
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
		
		assertEquals(uaaReceived.get() , 1L);
		assertEquals(uaaReceivedByListener.get() , 1L);
		assertEquals(uarReceived.get() , 2L);
		assertEquals(uarReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
}