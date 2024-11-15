package com.mobius.software.telco.protocols.diameter.test.pc2;
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
import com.mobius.software.telco.protocols.diameter.app.pc2.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.pc2.PC2ClientSession;
import com.mobius.software.telco.protocols.diameter.app.pc2.ServerListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc2.Pc2Answer;
import com.mobius.software.telco.protocols.diameter.commands.pc2.Pc2Request;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityApplicationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityApplicationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.pc2.PC2ProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeRequestTypeEnum;

/**
*
* @author yulian oifa
*
*/
public class ProXimityApplicationTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(ProXimityApplicationTest.class);
	
	@Test
	public void testPC2Application() throws Exception
	{
		super.setupRemote(0L,0L);
		super.setupLocal(0L,0L);
		
		final AtomicLong xaaReceived=new AtomicLong(0L);
		final AtomicLong xaaReceivedByListener=new AtomicLong(0L);
		final AtomicLong xraReceived=new AtomicLong(0L);
		final AtomicLong xraReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof ProXimityApplicationAnswer)
					xraReceived.incrementAndGet();				
			}
		});
		
		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof ProXimityApplicationRequest)
					xaaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		PC2ProviderImpl provider = (PC2ProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.PC2), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.pc2"));
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
			public void onInitialAnswer(Pc2Answer answer, ClientAuthSessionStateless<Pc2Request> session, String linkID,AsyncCallback callback)
			{
				xaaReceivedByListener.incrementAndGet();
			}
			
		});
		
		PC2ProviderImpl serverProvider = (PC2ProviderImpl)serverStack.getProvider(Long.valueOf(ApplicationIDs.PC2), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.pc2"));
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
			public void onInitialRequest(Pc2Request request, ServerAuthSessionStateless<Pc2Answer> session,String linkID, AsyncCallback callback)
			{
				xraReceivedByListener.incrementAndGet();
				ProXimityApplicationRequest xra=(ProXimityApplicationRequest)request;
				try
				{
					ProXimityApplicationAnswer xaa = serverProvider.getMessageFactory().createProXimityApplicationAnswer(xra, xra.getHopByHopIdentifier(), xra.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS, xra.getAuthApplicationId(), ProSeRequestTypeEnum.AUTHORIZATION_RESPONSE);
					session.sendInitialAnswer(xaa, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending ProXimity Application Answer," + ex.getMessage(),ex);
						}
					});
				}
				catch(DiameterException ex)
				{
					logger.error("An error occured while sending ProXimity Application Answer," + ex.getMessage(),ex);
				}
			}
			
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		
		ProSeRequestTypeEnum proSeRequestType = ProSeRequestTypeEnum.APPLICATION_REGISTRATION_FOR_PROSE;
		
		ProXimityApplicationRequest request = provider.getMessageFactory().createProXimityApplicationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), proSeRequestType);
		
		PC2ClientSession clientSession = (PC2ClientSession)provider.getSessionFactory().createClientSession(request);
		
		clientSession.sendInitialRequest(request, new AsyncCallback()
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
		
		assertEquals(xaaReceived.get() , 1L);
		assertEquals(xaaReceivedByListener.get() , 1L);
		assertEquals(xraReceived.get() , 1L);
		assertEquals(xraReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}
	
}