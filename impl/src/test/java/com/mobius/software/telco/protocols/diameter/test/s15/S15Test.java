package com.mobius.software.telco.protocols.diameter.test.s15;
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

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationID;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.s15.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.s15.S15ClientSession;
import com.mobius.software.telco.protocols.diameter.app.s15.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.s15.S15ProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;


/**
*
* @author yulian oifa
*
*/
public class S15Test extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(S15Test.class);
	
	@Test
	public void testChargingInterrogation() throws Exception
	{
		
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong ccaReceived=new AtomicLong(0L);
		final AtomicLong ccaReceivedByListener=new AtomicLong(0L);
		final AtomicLong ccrReceived=new AtomicLong(0L);
		final AtomicLong ccrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CreditControlAnswer)
					ccrReceived.incrementAndGet();
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof CreditControlRequest)
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
		
		S15ProviderImpl provider = (S15ProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.S15), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.s15"));
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
				
				if(ccaReceived.get() == 1L) 
				{
					
				try{
					
					DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
					
					Long ccRequestNumber = new Long(4);
					
					CreditControlRequest updateRequest = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(),localLink.getDestinationHost(), localLink.getDestinationRealm(),CcRequestTypeEnum.UPDATE_REQUEST,ccRequestNumber);
					
					session.sendInitialRequest(updateRequest, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							logger.info("The Update request has been successfully processed.");
							 
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Credit Control Update Request," + ex.getMessage(),ex);
						}
					});
					
				}
				catch(DiameterException ex)
				{
				
				}
				
				}
				
				else if(ccaReceived.get() == 2L) 
				{
					try
					{
						DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
						
						Long ccRequestNumber = new Long(4);

						CreditControlRequest terminationRequest = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(),localLink.getDestinationHost(), localLink.getDestinationRealm(),CcRequestTypeEnum.TERMINATION_REQUEST,ccRequestNumber);
											
						session.sendInitialRequest(terminationRequest, new AsyncCallback()
						{
	
								@Override
							    public void onSuccess()
							    {
							    	logger.info("The Termination request has been successfully processed.");
							    }
	
							    @Override
							    public void onError(DiameterException ex) 
							    {
							        logger.error("An error occurred while sending third Charging Interrogation Termination Request," + ex.getMessage(), ex);
							    }
							});
					}
					
					catch(DiameterException ex)
					{
						
					}
					
						
				}
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
		
		S15ProviderImpl serverProvider = (S15ProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.S15), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.s15"));
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
			public void onInitialRequest(CreditControlRequest request, ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
				ccrReceivedByListener.incrementAndGet();
				CreditControlRequest ccr=(CreditControlRequest)request;
				try
				{
					
					CreditControlAnswer cca = serverProvider.getMessageFactory().createCreditControlAnswer(ccr, ccr.getHopByHopIdentifier(), ccr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(cca, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							 logger.info("The response was successfully sent"); 
							 
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Credit Control Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Credit Control Answer," + ex.getMessage(),ex);
				}
			}

			@Override
			public void onReauthAnswer(ReAuthAnswer answer,ServerCCSession<CreditControlAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session,String linkID, AsyncCallback callback) 
			{
				
			}

			@Override
			public void onSessionTerminationRequest(SessionTerminationRequest request,ServerCCSession<CreditControlAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session,String linkID, AsyncCallback callback) 
			{
				
			}

			@Override
			public void onAbortSessionAnswer(AbortSessionAnswer answer,ServerCCSession<CreditControlAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session,String linkID, AsyncCallback callback)
			{
							
			}
			
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
	
		Long ccRequestNumber = new Long(4);
		
		CreditControlRequest request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(),localLink.getDestinationHost(), localLink.getDestinationRealm(),CcRequestTypeEnum.INITIAL_REQUEST,ccRequestNumber);
		
		S15ClientSession clientSession = (S15ClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
		    public void onSuccess() 
			{
		        logger.info("The first request has been successfully processed"); 
			}

		    @Override
		    public void onError(DiameterException ex)
		    {
		        logger.error("An error occurred while sending Credit Control Request," + ex.getMessage(), ex);
		    }
		   
		});
		
		try
		{
			Thread.sleep(responseTimeout * 2);
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
		
		assertEquals(ccaReceived.get() , 3L);
		assertEquals(ccaReceivedByListener.get() , 3L);
		assertEquals(ccrReceived.get() , 3L);
		assertEquals(ccrReceivedByListener.get() , 3L);
		
		Map<String, Long> localIncomingSessions = localStack.getIncomingSessionsByApplication();
		Map<String, Long> localOutgoingSessions = localStack.getOutgoingSessionByApplication();
		Map<String, Long> serverIncomingSessions = serverStack.getIncomingSessionsByApplication();
		Map<String, Long> serverOutgoingSessions = serverStack.getOutgoingSessionByApplication();
		
		assertEquals(localIncomingSessions.size(),0);
		assertEquals(localOutgoingSessions.size(),1);
		assertEquals(serverIncomingSessions.size(),1);
		assertEquals(serverOutgoingSessions.size(),0);
		
		assertEquals(localOutgoingSessions.get(ApplicationID.S15.name()),new Long(1L));
		assertEquals(serverIncomingSessions.get(ApplicationID.S15.name()),new Long(1L));
		
		assertEquals(timeoutReceived.get() , 0L);
	}
}


	