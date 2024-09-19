package com.mobius.software.telco.protocols.diameter.test.t4;
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
import com.mobius.software.telco.protocols.diameter.app.t4.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.t4.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.t4.T4ClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeliveryReportAnswer;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeliveryReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.t4.T4Answer;
import com.mobius.software.telco.protocols.diameter.commands.t4.T4Request;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.t4.T4ProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t4.SMDeliveryOutcomeT4Enum;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


/**
*
* @author yulian oifa
*
*/
public class T4DeliveryReportTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(T4DeliveryReportTest.class);
	
	@Test
	public void testDeliveryReport() throws Exception
	{
		
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong draReceived=new AtomicLong(0L);
		final AtomicLong draReceivedByListener=new AtomicLong(0L);
		final AtomicLong drrReceived=new AtomicLong(0L);
		final AtomicLong drrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof T4Answer)
					drrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof T4Request)
					draReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		T4ProviderImpl provider = (T4ProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.T4), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.t4"));
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
			public void onInitialAnswer(T4Answer answer, ClientAuthSessionStateless<T4Request> session, String linkID, AsyncCallback callback)
			{
				draReceivedByListener.incrementAndGet();
			}
		});
		
		T4ProviderImpl serverProvider = (T4ProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.T4), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.t4"));
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
			public void onInitialRequest(T4Request request, ServerAuthSessionStateless<T4Answer> session, String linkID, AsyncCallback callback)
			{
				drrReceivedByListener.incrementAndGet();
				DeliveryReportRequest drr=(DeliveryReportRequest)request;
				try
				{
					DeliveryReportAnswer dra = serverProvider.getMessageFactory().createDeliveryReportAnswer(drr, drr.getHopByHopIdentifier(), drr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(dra, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Delivery Report Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Delivery Report Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		byte[] data=new byte[] { 0x01,0x02,0x03,0x04,0x05};
		ByteBuf smRPSMEA = Unpooled.wrappedBuffer(data);
		
		UserIdentifier userIdentifier = provider.getAvpFactory().getUserIdentifier();
		userIdentifier.setUserName("ddd");
		
		DeliveryReportRequest request = provider.getMessageFactory().createDeliveryReportRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(),userIdentifier,smRPSMEA,SMDeliveryOutcomeT4Enum.SUCCESSFUL_TRANSFER);
		T4ClientSession clientSession = (T4ClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Delivery Report Request," + ex.getMessage(),ex);
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
		
		assertEquals(draReceived.get() , 1L);
		assertEquals(draReceivedByListener.get() , 1L);
		assertEquals(drrReceived.get() , 1L);
		assertEquals(drrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}
	
	@Test
	public void testDuplicateDeliveryReport() throws Exception
	{
		super.setupRemote(1000L,2000L);
		super.setupLocal(1000L,2000L);
		
		final AtomicLong draReceived=new AtomicLong(0L);
		final AtomicLong draReceivedByListener=new AtomicLong(0L);
		final AtomicLong drrReceived=new AtomicLong(0L);
		final AtomicLong drrReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof T4Answer)
					drrReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof T4Request)
					draReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		T4ProviderImpl provider = (T4ProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.T4), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.t4"));
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
			public void onInitialAnswer(T4Answer answer, ClientAuthSessionStateless<T4Request> session, String linkID, AsyncCallback callback)
			{
				draReceivedByListener.incrementAndGet();
			}
		});
		
		T4ProviderImpl serverProvider = (T4ProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.T4), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.t4"));
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
			public void onInitialRequest(T4Request request, ServerAuthSessionStateless<T4Answer> session, String linkID, AsyncCallback callback)
			{
				drrReceivedByListener.incrementAndGet();
				DeliveryReportRequest drr=(DeliveryReportRequest)request;
				try
				{
					DeliveryReportAnswer dra = serverProvider.getMessageFactory().createDeliveryReportAnswer(drr, drr.getHopByHopIdentifier(), drr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(dra, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Delivery Report Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending Delivery Report Answer," + ex.getMessage(),ex);
				}
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		byte[] data=new byte[] { 0x01,0x02,0x03,0x04,0x05};
		ByteBuf smRPSMEA = Unpooled.wrappedBuffer(data);
		
		UserIdentifier userIdentifier = provider.getAvpFactory().getUserIdentifier();
		userIdentifier.setUserName("ddd");
		
		DeliveryReportRequest request = provider.getMessageFactory().createDeliveryReportRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(),userIdentifier,smRPSMEA,SMDeliveryOutcomeT4Enum.SUCCESSFUL_TRANSFER);
		T4ClientSession clientSession = (T4ClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Delivery Report Request," + ex.getMessage(),ex);
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
		
		assertEquals(draReceived.get() , 1L);
		assertEquals(draReceivedByListener.get() , 1L);
		assertEquals(drrReceived.get() , 2L);
		assertEquals(drrReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
}