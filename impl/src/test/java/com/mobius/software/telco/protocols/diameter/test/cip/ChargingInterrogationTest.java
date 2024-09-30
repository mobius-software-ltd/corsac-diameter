package com.mobius.software.telco.protocols.diameter.test.cip;
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

import java.util.ArrayList;
import java.util.List;
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
import com.mobius.software.telco.protocols.diameter.app.cip.ChargingInterrogationClientSession;
import com.mobius.software.telco.protocols.diameter.app.cip.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.cip.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.cip.ChargingInterrogationProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;


/**
*
* @author yulian oifa
*
*/
public class ChargingInterrogationTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(ChargingInterrogationTest.class);
	
	@Test
	public void testChargingInterrogation() throws Exception
	{
		
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong ciaReceived=new AtomicLong(0L);
		final AtomicLong ciaReceivedByListener=new AtomicLong(0L);
		final AtomicLong cirReceived=new AtomicLong(0L);
		final AtomicLong cirReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof ChargingInterrogationAnswer)
					cirReceived.incrementAndGet();
				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof ChargingInterrogationRequest)
					ciaReceived.incrementAndGet();
				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		ChargingInterrogationProviderImpl provider = (ChargingInterrogationProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.CIP), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.cip"));
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
			public void onInitialAnswer(ChargingInterrogationAnswer answer, ClientCCSession<ChargingInterrogationRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				ciaReceivedByListener.incrementAndGet();
			}
			
			@Override
			public void onReauthRequest(ReAuthRequest request, ClientCCSession<ChargingInterrogationRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				
			}

			@Override
			public void onSessionTerminationAnswer(SessionTerminationAnswer answer, ClientCCSession<ChargingInterrogationRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				
			}

			@Override
			public void onAbortSessionRequest(AbortSessionRequest request, ClientCCSession<ChargingInterrogationRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
			
			}
		});
		
		ChargingInterrogationProviderImpl serverProvider = (ChargingInterrogationProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.CIP), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.cip"));
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
			public void onInitialRequest(ChargingInterrogationRequest request, ServerCCSession<ChargingInterrogationAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
				cirReceivedByListener.incrementAndGet();
				ChargingInterrogationRequest cir=(ChargingInterrogationRequest)request;
				try
				{
					DiameterLink serverLink = serverStack.getNetworkManager().getLink(localLinkID);
					
					ChargingInterrogationAnswer cia = serverProvider.getMessageFactory().createChargingInterrogationAnswer(serverLink.getLocalHost(),serverLink.getLocalRealm(), cir.getHopByHopIdentifier(), cir.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS,cir.getSessionId(),cir.getCcRequestType(),cir.getCcRequestNumber());
					session.sendInitialAnswer(cia, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Charging Interrogation Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Charging Interrogation Answer," + ex.getMessage(),ex);
				}
			}

			@Override
			public void onReauthAnswer(ReAuthAnswer answer,ServerCCSession<ChargingInterrogationAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session,String linkID, AsyncCallback callback) 
			{
				
			}

			@Override
			public void onSessionTerminationRequest(SessionTerminationRequest request,ServerCCSession<ChargingInterrogationAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session,String linkID, AsyncCallback callback) 
			{
				
			}

			@Override
			public void onAbortSessionAnswer(AbortSessionAnswer answer,ServerCCSession<ChargingInterrogationAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session,String linkID, AsyncCallback callback)
			{
							
			}
			
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		String chargingContextId = new String("chargingContextId");
		Long ccRequestNumber = new Long(4);
		String subscriptionIdData = new String("1234567");
		
		SubscriptionId sId = provider.getAvpFactory().getSubscriptionId(SubscriptionIdTypeEnum.END_USER_E164, subscriptionIdData);
		List<SubscriptionId> subscriptionId = new ArrayList<>();
		subscriptionId.add(sId);

		ChargingInterrogationRequest request = provider.getMessageFactory().createChargingInterrogationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationRealm(),chargingContextId,CcRequestTypeEnum.INITIAL_REQUEST,ccRequestNumber,subscriptionId);
		ChargingInterrogationRequest secondrequest = provider.getMessageFactory().createChargingInterrogationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationRealm(), chargingContextId, CcRequestTypeEnum.UPDATE_REQUEST, ccRequestNumber, subscriptionId);
		ChargingInterrogationRequest thirdrequest = provider.getMessageFactory().createChargingInterrogationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationRealm(), chargingContextId, CcRequestTypeEnum.TERMINATION_REQUEST, ccRequestNumber, subscriptionId);
		
		ChargingInterrogationClientSession clientSession = (ChargingInterrogationClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
		    public void onSuccess() 
			{
		        logger.info("The first request has been successfully processed");
		        
		        try
				{
					Thread.sleep(responseTimeout);
				}
				catch(InterruptedException ex)
				{
					
				}
				
				assertEquals(clientSession.getSessionState(),SessionStateEnum.OPEN);
				
				clientSession.sendInitialRequest(secondrequest, new AsyncCallback() 
				{
				    @Override
				    public void onSuccess()
				    {
				    	logger.info("The second request has been successfully processed.");
				    	
				    	try
						{
							Thread.sleep(responseTimeout);
						}
						catch(InterruptedException ex)
						{
							
						}
						
						assertEquals(clientSession.getSessionState(),SessionStateEnum.OPEN);
						
						clientSession.sendInitialRequest(thirdrequest, new AsyncCallback() 
						{
						    @Override
						    public void onSuccess()
						    {
						    	logger.info("The third request has been successfully processed.");

						    }

						    @Override
						    public void onError(DiameterException ex) 
						    {
						        logger.error("Error sending the second request: " + ex.getMessage(), ex);
						    }
						});

				    }

				    @Override
				    public void onError(DiameterException ex) 
				    {
				        logger.error("Error sending the second request: " + ex.getMessage(), ex);
				    }
				});
				
			}

		    @Override
		    public void onError(DiameterException ex)
		    {
		        logger.error("An error occurred while sending ChargingInterrogation Request," + ex.getMessage(), ex);
		    }
		});
		
		try
		{
			Thread.sleep(responseTimeout * 3);
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
		
		assertEquals(ciaReceived.get() , 3L);
		assertEquals(ciaReceivedByListener.get() , 3L);
		assertEquals(cirReceived.get() , 3L);
		assertEquals(cirReceivedByListener.get() , 3L);
		
		Map<String, Long> localIncomingSessions = localStack.getIncomingSessionsByApplication();
		Map<String, Long> localOutgoingSessions = localStack.getOutgoingSessionByApplication();
		Map<String, Long> serverIncomingSessions = serverStack.getIncomingSessionsByApplication();
		Map<String, Long> serverOutgoingSessions = serverStack.getOutgoingSessionByApplication();
		
		assertEquals(localIncomingSessions.size(),0);
		assertEquals(localOutgoingSessions.size(),1);
		assertEquals(serverIncomingSessions.size(),1);
		assertEquals(serverOutgoingSessions.size(),0);
		
		assertEquals(localOutgoingSessions.get(ApplicationID.CIP.name()),new Long(1L));
		assertEquals(serverIncomingSessions.get(ApplicationID.CIP.name()),new Long(1L));
		
		assertEquals(timeoutReceived.get() , 0L);
	}
}
	