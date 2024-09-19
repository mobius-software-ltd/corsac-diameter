package com.mobius.software.telco.protocols.diameter.test.swx;
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
import com.mobius.software.telco.protocols.diameter.app.swx.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.swx.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.swx.SwxClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.SwxAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.SwxRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.swx.SwxProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ReasonCodeEnum;

/**
*
* @author yulian oifa
*
*/
public class SwxRegistrationTerminationTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(SwxRegistrationTerminationTest.class);
	
	@Test
	public void testSwxRegistrationTermination() throws Exception
	{
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong rtaReceived=new AtomicLong(0L);
		final AtomicLong rtaReceivedByListener=new AtomicLong(0L);
		final AtomicLong rtrReceived=new AtomicLong(0L);
		final AtomicLong rtrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof SwxAnswer)
					rtrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof SwxRequest)
					rtaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		SwxProviderImpl provider = (SwxProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.SWX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.swx"));
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
			public void onInitialAnswer(SwxAnswer answer, ClientAuthSessionStateless<SwxRequest> session, String linkID, AsyncCallback callback)
			{
				rtaReceivedByListener.incrementAndGet();
			}
		});
		
		SwxProviderImpl serverProvider = (SwxProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.SWX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.swx"));
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
			public void onInitialRequest(SwxRequest request, ServerAuthSessionStateless<SwxAnswer> session, String linkID, AsyncCallback callback)
			{
				
				rtrReceivedByListener.incrementAndGet();
				RegistrationTerminationRequest rtr=(RegistrationTerminationRequest)request;
				try
				{
					RegistrationTerminationAnswer rta = serverProvider.getMessageFactory().createRegistrationTerminationAnswer(rtr, rtr.getHopByHopIdentifier(), rtr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(rta, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Registration Termination Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Registration Termination Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		String username=new String("name");
		DeregistrationReason deregistrationReason = provider.getAvpFactory().getDeregistrationReason(ReasonCodeEnum.PERMANENT_TERMINATION);
		
		RegistrationTerminationRequest request = provider.getMessageFactory().createRegistrationTerminationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(),username,deregistrationReason);
		SwxClientSession clientSession = (SwxClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Registration Termination Request," + ex.getMessage(),ex);
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
		
		assertEquals(rtaReceived.get() , 1L);
		assertEquals(rtaReceivedByListener.get() , 1L);
		assertEquals(rtrReceived.get() , 1L);
		assertEquals(rtrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}
	
	@Test
	public void testDuplicateRegistrationTermination() throws Exception
	{
		super.setupRemote(1000L,2000L);
		super.setupLocal(1000L,2000L);
		
		final AtomicLong rtaReceived=new AtomicLong(0L);
		final AtomicLong rtaReceivedByListener=new AtomicLong(0L);
		final AtomicLong rtrReceived=new AtomicLong(0L);
		final AtomicLong rtrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof SwxAnswer)
					rtrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof SwxRequest)
					rtaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		SwxProviderImpl provider = (SwxProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.SWX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.swx"));
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
			public void onInitialAnswer(SwxAnswer answer, ClientAuthSessionStateless<SwxRequest> session, String linkID, AsyncCallback callback)
			{
				rtaReceivedByListener.incrementAndGet();
			}
		});
		
		SwxProviderImpl serverProvider = (SwxProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.SWX), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.swx"));
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
			public void onInitialRequest(SwxRequest request, ServerAuthSessionStateless<SwxAnswer> session, String linkID, AsyncCallback callback)
			{
				
				rtrReceivedByListener.incrementAndGet();
				RegistrationTerminationRequest rtr=(RegistrationTerminationRequest)request;
				try
				{
					RegistrationTerminationAnswer rta = serverProvider.getMessageFactory().createRegistrationTerminationAnswer(rtr, rtr.getHopByHopIdentifier(), rtr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(rta, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Registration Termination Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Registration Termination Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		String username=new String("name");
		DeregistrationReason deregistrationReason = provider.getAvpFactory().getDeregistrationReason(ReasonCodeEnum.PERMANENT_TERMINATION);
		
		RegistrationTerminationRequest request = provider.getMessageFactory().createRegistrationTerminationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(),username,deregistrationReason);
		SwxClientSession clientSession = (SwxClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Registration Termination Request," + ex.getMessage(),ex);
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
		
		assertEquals(rtaReceived.get() , 1L);
		assertEquals(rtaReceivedByListener.get() , 1L);
		assertEquals(rtrReceived.get() , 2L);
		assertEquals(rtrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
}