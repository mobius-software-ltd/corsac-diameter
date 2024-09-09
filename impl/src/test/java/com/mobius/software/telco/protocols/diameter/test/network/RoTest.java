package com.mobius.software.telco.protocols.diameter.test.network;
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
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.ro.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.ro.RoClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.ro.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.ro.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.ro.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.ro.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.ro.RoProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class RoTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(RoTest.class);
	
	@Test
	public void testEvent() throws Exception
	{
		super.setupRemote(new BasicServerRoSessionListener(),new EmptyServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong ccaReceived=new AtomicLong(0L);
		final AtomicLong ccaReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CreditControlAnswer)
					ccaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RoProviderImpl provider = (RoProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.CREDIT_CONTROL), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.ro"));
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
			public void onInitialAnswer(CreditControlAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				ccaReceivedByListener.incrementAndGet();
			}

			@Override
			public void onReauthRequest(ReAuthRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onSessionTerminationAnswer(SessionTerminationAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onAbortSessionRequest(AbortSessionRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		CreditControlRequest request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.EVENT_REQUEST, 1L);
		RoClientSession clientSession = (RoClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
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
		
		assertEquals(ccaReceived.get() , 1L);
		assertEquals(ccaReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
	
	@Test
	public void testNonEvent() throws Exception
	{
		super.setupRemote(new BasicServerRoSessionListener(),new EmptyServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong ccaReceived=new AtomicLong(0L);
		final AtomicLong ccaReceivedByListener=new AtomicLong(0L);
		final AtomicLong rarReceived=new AtomicLong(0L);
		final AtomicLong rarReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CreditControlAnswer)
					ccaReceived.incrementAndGet();	
				else if(message instanceof ReAuthRequest)
					rarReceived.incrementAndGet();
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RoProviderImpl provider = (RoProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.CREDIT_CONTROL), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.ro"));
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
			public void onInitialAnswer(CreditControlAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				ccaReceivedByListener.incrementAndGet();
			}

			@Override
			public void onReauthRequest(ReAuthRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				rarReceivedByListener.incrementAndGet();
				
				try
				{
					ReAuthAnswer raa = provider.getMessageFactory().createReAuthAnswer(request, request.getHopByHopIdentifier(), request.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendReauthAnswer(raa, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending ReAuth Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(Exception ex)
				{
					logger.warn("AN error occured while sendind RAA," + ex.getMessage(),ex);
				}
			}

			@Override
			public void onSessionTerminationAnswer(SessionTerminationAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onAbortSessionRequest(AbortSessionRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{	
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		CreditControlRequest request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.INITIAL_REQUEST, 1L);
		RoClientSession clientSession = (RoClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
				
		assertEquals(clientSession.getSessionState(),SessionStateEnum.OPEN);
		
		request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.UPDATE_REQUEST, 2L);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(clientSession.getSessionState(),SessionStateEnum.OPEN);
		
		request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.UPDATE_REQUEST, 3001L);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(clientSession.getSessionState(),SessionStateEnum.OPEN);
		
		request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.TERMINATION_REQUEST, 3L);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
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
		
		assertEquals(ccaReceived.get() , 4L);
		assertEquals(ccaReceivedByListener.get() , 4L);
		assertEquals(rarReceived.get() , 1L);
		assertEquals(rarReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
	
	@Test
	public void testNonEventWithError() throws Exception
	{
		super.setupRemote(new BasicServerRoSessionListener(),new EmptyServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong ccaReceived=new AtomicLong(0L);
		final AtomicLong ccaReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CreditControlAnswer)
					ccaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RoProviderImpl provider = (RoProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.CREDIT_CONTROL), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.ro"));
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
			public void onInitialAnswer(CreditControlAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				ccaReceivedByListener.incrementAndGet();
			}

			@Override
			public void onReauthRequest(ReAuthRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onSessionTerminationAnswer(SessionTerminationAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onAbortSessionRequest(AbortSessionRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		CreditControlRequest request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.INITIAL_REQUEST, 1L);
		RoClientSession clientSession = (RoClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(clientSession.getSessionState(),SessionStateEnum.OPEN);
		
		request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.UPDATE_REQUEST, 1001L);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
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
		
		assertEquals(ccaReceived.get() , 2L);
		assertEquals(ccaReceivedByListener.get() , 2L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
	
	
	@Test
	public void testNonEventWithTimeout() throws Exception
	{
		super.setupRemote(new BasicServerRoSessionListener(),new EmptyServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong ccaReceived=new AtomicLong(0L);
		final AtomicLong ccaReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CreditControlAnswer)
					ccaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RoProviderImpl provider = (RoProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.CREDIT_CONTROL), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.ro"));
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
			public void onInitialAnswer(CreditControlAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				ccaReceivedByListener.incrementAndGet();
			}

			@Override
			public void onReauthRequest(ReAuthRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onSessionTerminationAnswer(SessionTerminationAnswer answer, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onAbortSessionRequest(AbortSessionRequest request, ClientCCSession<CreditControlRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		CreditControlRequest request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.INITIAL_REQUEST, 1L);
		RoClientSession clientSession = (RoClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(clientSession.getSessionState(),SessionStateEnum.OPEN);
		
		request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), "1", CcRequestTypeEnum.UPDATE_REQUEST, 2001L);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Accounting Request," + ex.getMessage(),ex);
			}
		});
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(clientSession.getSessionState(),SessionStateEnum.PENDING);
		
		//make sure timeout is processed
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
		
		assertEquals(ccaReceived.get() , 1L);
		assertEquals(ccaReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 2L);
	}		
}