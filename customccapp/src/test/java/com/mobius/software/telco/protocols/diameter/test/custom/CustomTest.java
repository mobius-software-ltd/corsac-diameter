package com.mobius.software.telco.protocols.diameter.test.custom;
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

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.custom.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.custom.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.custom.СustomClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.custom.CustomProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;

/**
 *
 * @author yulian oifa
 *
 */
public class CustomTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(CustomTest.class);

	@Test
	public void testEvent() throws Exception
	{
		super.setupRemote(0L, 0L);
		super.setupLocal(0L, 0L);

		final AtomicLong ccaReceived = new AtomicLong(0L);
		final AtomicLong ccaReceivedByListener = new AtomicLong(0L);
		final AtomicLong ccrReceived = new AtomicLong(0L);
		final AtomicLong ccrReceivedByListener = new AtomicLong(0L);
		final AtomicLong timeoutReceived = new AtomicLong(0L);

		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;

		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if (message instanceof CreditControlAnswer)
					ccaReceived.incrementAndGet();
			}
		});

		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if (message instanceof CreditControlRequest)
					ccrReceived.incrementAndGet();
			}
		});

		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch (InterruptedException ex)
		{

		}

		CustomProviderImpl provider = (CustomProviderImpl) localStack.getProvider(Long.valueOf(99999), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.custom"));
		ClusteredID<?> listenerID = generator.generateID();
		provider.setClientListener(listenerID, new ClientListener()
		{
			@Override
			public void onTimeout(DiameterRequest request, DiameterSession session)
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

		CustomProviderImpl serverProvider = (CustomProviderImpl) serverStack.getProvider(Long.valueOf(99999), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.custom"));
		serverProvider.setServerListener(listenerID, new ServerListener()
		{
			@Override
			public void onTimeout(DiameterRequest request, DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onIdleTimeout(DiameterSession session)
			{
				timeoutReceived.incrementAndGet();
			}

			@Override
			public void onInitialRequest(CreditControlRequest request, ServerCCSession<CreditControlAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
				ccrReceivedByListener.incrementAndGet();
				CreditControlRequest ccr = (CreditControlRequest) request;
				try
				{
					CreditControlAnswer cca = serverProvider.getMessageFactory().createCreditControlAnswer(ccr, ccr.getHopByHopIdentifier(), ccr.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(cca, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{

						}

						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending Message Process Answer," + ex.getMessage(), ex);
						}
					});
				}
				catch (DiameterException ex)
				{
					logger.error("An error occured while sending Message Process Answer," + ex.getMessage(), ex);
				}
			}

			@Override
			public void onReauthAnswer(ReAuthAnswer answer, ServerCCSession<CreditControlAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onSessionTerminationRequest(SessionTerminationRequest request, ServerCCSession<CreditControlAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
			}

			@Override
			public void onAbortSessionAnswer(AbortSessionAnswer answer, ServerCCSession<CreditControlAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
			}
		});

		// usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		CreditControlRequest request = provider.getMessageFactory().createCreditControlRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), CcRequestTypeEnum.TERMINATION_REQUEST, 1L);
		СustomClientSession clientSession = (СustomClientSession) provider.getSessionFactory().createClientSession(request);
		clientSession.sendInitialRequest(request, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
			}

			@Override
			public void onError(DiameterException ex)
			{
				logger.error("An error occured while sending Message Process Request," + ex.getMessage(), ex);
			}
		});

		try
		{
			Thread.sleep(responseTimeout);
		}
		catch (InterruptedException ex)
		{

		}

		assertEquals(clientSession.getSessionState(), SessionStateEnum.IDLE);

		// make sure no timeout is processed
		try
		{
			Thread.sleep(idleTimeout * 2);
		}
		catch (InterruptedException ex)
		{

		}

		super.stopLocal();
		super.stopRemote();

		try
		{
			Thread.sleep(responseTimeout);
		}
		catch (InterruptedException ex)
		{

		}

		assertEquals(ccaReceived.get(), 1L);
		assertEquals(ccaReceivedByListener.get(), 1L);
		assertEquals(ccrReceived.get(), 1L);
		assertEquals(ccrReceivedByListener.get(), 1L);
		assertEquals(timeoutReceived.get(), 0L);
	}
}