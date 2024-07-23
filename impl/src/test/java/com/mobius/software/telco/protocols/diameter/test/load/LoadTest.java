package com.mobius.software.telco.protocols.diameter.test.load;
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

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.mm10.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.mm10.MM10ClientSession;
import com.mobius.software.telco.protocols.diameter.app.mm10.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessAnswer;
import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.mm10.MM10ProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.OriginatingInterfaceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServedUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.TriggerEventEnum;
/**
*
* @author yulian oifa
*
*/
public class LoadTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(LoadTest.class);
	
	@Test
	public void testQueue() throws Exception
	{
		super.setupRemote(1000L,1000L);
		super.setupLocal(1000L,1000L);
		
		final AtomicLong mpaReceived=new AtomicLong(0L);
		final AtomicLong mpaReceivedByListener=new AtomicLong(0L);
		final AtomicLong mprReceived=new AtomicLong(0L);
		final AtomicLong mprReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, AsyncCallback callback)
			{
				if(message instanceof MessageProcessAnswer)
					mprReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, AsyncCallback callback)
			{
				if(message instanceof MessageProcessRequest)
					mpaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		MM10ProviderImpl provider = (MM10ProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.MM10), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.mm10"));
		ClusteredID<?> listenerID=generator.generateID();
		provider.setClientListener(listenerID, new ClientListener()
		{
			@Override
			public void onTimeout()
			{
				timeoutReceived.incrementAndGet();
			}
			
			@Override
			public void onIdleTimeout()
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onInitialAnswer(DiameterAnswer answer, ClientAuthSessionStateless<MessageProcessRequest> session, AsyncCallback callback)
			{
				if(answer instanceof MessageProcessAnswer)
					mpaReceivedByListener.incrementAndGet();
			}
		});
		
		MM10ProviderImpl serverProvider = (MM10ProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.MM10), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.mm10"));
		serverProvider.setServerListener(listenerID, new ServerListener()
		{
			@Override
			public void onTimeout()
			{
				timeoutReceived.incrementAndGet();
			}
			
			@Override
			public void onIdleTimeout()
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onInitialRequest(DiameterRequest request, ServerAuthSessionStateless<MessageProcessAnswer> session, AsyncCallback callback)
			{
				if(request instanceof MessageProcessRequest)
				{
					mprReceivedByListener.incrementAndGet();
					MessageProcessRequest mpr=(MessageProcessRequest)request;
					try
					{
						MessageProcessAnswer mpa = serverProvider.getMessageFactory().createMessageProcessAnswer(mpr, mpr.getHopByHopIdentifier(), mpr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
						session.sendInitialAnswer(mpa, new AsyncCallback()
						{
							@Override
							public void onSuccess()
							{
								
							}
							
							@Override
							public void onError(DiameterException ex)
							{
								logger.error("An error occured while sending Message Process Answer," + ex.getMessage(),ex);
							}
						});
					}
					catch(DiameterException ex)
					{
						logger.error("An error occured while sending Message Process Answer," + ex.getMessage(),ex);
					}
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		ConcurrentLinkedQueue<MM10ClientSession> sessions = new ConcurrentLinkedQueue<MM10ClientSession>();
		for(int i=0;i<1000;i++)
		{
			DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkIDs.get(i%localLinkIDs.size()));
			Date eventTimestamp=new Date();
			ServedUserIdentity sui = provider.getAvpFactory().getServedUserIdentity();
			sui.setMSISDN("12345");
			
			InitialRecipientAddress ira = provider.getAvpFactory().getInitialRecipientAddress(1L, "1234");
			List<InitialRecipientAddress> initialRecipientAddresses = new ArrayList<>();
			initialRecipientAddresses.add(ira);

			MessageProcessRequest request = provider.getMessageFactory().createMessageProcessRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), eventTimestamp, TriggerEventEnum.MM1_DELIVERY, sui, initialRecipientAddresses, OriginatingInterfaceEnum.MM7);
			MM10ClientSession clientSession = (MM10ClientSession)provider.getSessionFactory().createClientSession(request);
			sessions.offer(clientSession);
			clientSession.sendInitialRequest(request, new AsyncCallback()
			{
				@Override
				public void onSuccess()
				{
				}
				
				@Override
				public void onError(DiameterException ex)
				{
					logger.error("An error occured while sending Message Process Request," + ex.getMessage(),ex);					
				}
			});
		}
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		while(sessions.size()>0)
			assertEquals(sessions.poll().getSessionState(),SessionStateEnum.IDLE);
		
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
		
		assertEquals(mpaReceived.get() , 1000L);
		assertEquals(mpaReceivedByListener.get() , 1000L);
		assertEquals(mprReceived.get() , 1000L);
		assertEquals(mprReceivedByListener.get() , 1000L);
		assertEquals(timeoutReceived.get() , 0L);
		
		assertEquals(localStack.getSessionStorage().getSessionsCount(),0);
		assertEquals(serverStack.getSessionStorage().getSessionsCount(),0);
		assertEquals(localStack.getRequestsStorage().getRequestsCount(),0);
		assertEquals(serverStack.getRequestsStorage().getRequestsCount(),0);							
	}
}