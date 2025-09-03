package com.mobius.software.telco.protocols.diameter.test.sy;
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

import com.mobius.software.common.dal.timers.RunnableTimer;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.sy.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.sy.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.sy.SyClientSession;
import com.mobius.software.telco.protocols.diameter.app.sy.SyServerSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingLimitAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingLimitRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingStatusNotificationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingStatusNotificationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.sy.SyProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sy.SLRequestTypeEnum;

/**
 *
 * @author yulian oifa
 *
 */
public class SyTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(SyTest.class);

	@Test
	public void testEvent() throws Exception
	{
		super.setupRemote(0L, 0L, false);
		super.setupLocal(0L, 0L);

		final AtomicLong snaReceived = new AtomicLong(0L);
		final AtomicLong snaReceivedByListener = new AtomicLong(0L);
		final AtomicLong ssnaReceived = new AtomicLong(0L);
		final AtomicLong ssnaReceivedByListener = new AtomicLong(0L);
		final AtomicLong snrReceived = new AtomicLong(0L);
		final AtomicLong snrReceivedByListener = new AtomicLong(0L);
		final AtomicLong ssnrReceived = new AtomicLong(0L);
		final AtomicLong ssnrReceivedByListener = new AtomicLong(0L);
		final AtomicLong staReceived = new AtomicLong(0L);
		final AtomicLong staReceivedByListener = new AtomicLong(0L);
		final AtomicLong strReceived = new AtomicLong(0L);
		final AtomicLong strReceivedByListener = new AtomicLong(0L);
		final AtomicLong timeoutReceived = new AtomicLong(0L);

		DiameterStack localStack = this.localStack;
		DiameterStack serverStack = this.serverStack;

		// usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		DiameterLink serverLink = serverStack.getNetworkManager().getLink(localLinkID);

		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if (message instanceof SpendingLimitAnswer)
					snaReceived.incrementAndGet();
				else if (message instanceof SpendingStatusNotificationRequest)
					ssnrReceived.incrementAndGet();
				else if (message instanceof SessionTerminationAnswer)
					staReceived.incrementAndGet();
			}
		});

		serverStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if (message instanceof SpendingLimitRequest)
					snrReceived.incrementAndGet();
				else if (message instanceof SpendingStatusNotificationAnswer)
					ssnaReceived.incrementAndGet();
				else if (message instanceof SessionTerminationRequest)
					strReceived.incrementAndGet();
			}
		});

		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch (InterruptedException ex)
		{

		}

		SyProviderImpl provider = (SyProviderImpl) localStack.getProvider(Long.valueOf(ApplicationIDs.SY), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.sy"));
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
			public void onReauthRequest(ReAuthRequest request, ClientAuthSession<SpendingLimitRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{

			}

			@Override
			public void onAbortSessionRequest(AbortSessionRequest request, ClientAuthSession<SpendingLimitRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{

			}

			@Override
			public void onSessionTerminationAnswer(SessionTerminationAnswer answer, ClientAuthSession<SpendingLimitRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				staReceivedByListener.incrementAndGet();
			}

			@Override
			public void onInitialAnswer(SpendingLimitAnswer answer, ClientAuthSession<SpendingLimitRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				snaReceivedByListener.incrementAndGet();
			}

			@Override
			public void onSpendingStatusNotificationRequest(SpendingStatusNotificationRequest request, ClientAuthSession<SpendingLimitRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest> session, String linkID, AsyncCallback callback)
			{
				ssnrReceivedByListener.incrementAndGet();

				try
				{
					SpendingStatusNotificationAnswer ssna = provider.getMessageFactory().createSpendingStatusNotificationAnswer(request, request.getHopByHopIdentifier(), request.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					((SyClientSession) session).sendStatusNotificationAnswer(ssna, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{

						}

						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending SSNA," + ex.getMessage(), ex);
						}
					});
				}
				catch (DiameterException ex)
				{
					logger.error("An error occured while sending SSNA," + ex.getMessage(), ex);
				}

				Long startTime = System.currentTimeMillis();
				workerPool.addTimer(new RunnableTimer(new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							SessionTerminationRequest str = provider.getMessageFactory().createSessionTerminationRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), session.getID(), TerminationCauseEnum.ADMIN_RESET);
							session.sendSessionTerminationRequest(str, new AsyncCallback()
							{
								@Override
								public void onSuccess()
								{

								}

								@Override
								public void onError(DiameterException ex)
								{
									logger.error("An error occured while sending STR," + ex.getMessage(), ex);
								}
							});
						}
						catch (DiameterException ex)
						{
							logger.error("An error occured while sending STR," + ex.getMessage(), ex);
						}
					}
				}, startTime + 500, session.getID()));
			}
		});

		SyProviderImpl serverProvider = (SyProviderImpl) serverStack.getProvider(Long.valueOf(ApplicationIDs.SY), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.sy"));
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
			public void onAbortSessionAnswer(AbortSessionAnswer answer, ServerAuthSession<SpendingLimitAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{

			}

			@Override
			public void onReauthAnswer(ReAuthAnswer answer, ServerAuthSession<SpendingLimitAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{

			}

			@Override
			public void onSpendingStatusNotificationAnswer(SpendingStatusNotificationAnswer answer, ServerAuthSession<SpendingLimitAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
				ssnaReceivedByListener.incrementAndGet();
			}

			@Override
			public void onSessionTerminationRequest(SessionTerminationRequest request, ServerAuthSession<SpendingLimitAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
				strReceivedByListener.incrementAndGet();

				try
				{
					SessionTerminationAnswer sna = serverProvider.getMessageFactory().createSessionTerminationAnswer(request, request.getHopByHopIdentifier(), request.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendSessionTerminationAnswer(sna, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{

						}

						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending STA," + ex.getMessage(), ex);
						}
					});
				}
				catch (DiameterException ex)
				{
					logger.error("An error occured while sending STA," + ex.getMessage(), ex);
				}
			}

			@Override
			public void onInitialRequest(SpendingLimitRequest request, ServerAuthSession<SpendingLimitAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer> session, String linkID, AsyncCallback callback)
			{
				snrReceivedByListener.incrementAndGet();
				try
				{
					SpendingLimitAnswer sna = serverProvider.getMessageFactory().createSpendingLimitAnswer(request, request.getHopByHopIdentifier(), request.getEndToEndIdentifier(), ResultCodes.DIAMETER_SUCCESS);
					session.sendInitialAnswer(sna, new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{

						}

						@Override
						public void onError(DiameterException ex)
						{
							logger.error("An error occured while sending SNA," + ex.getMessage(), ex);
						}
					});
				}
				catch (DiameterException ex)
				{
					logger.error("An error occured while sending SNA," + ex.getMessage(), ex);
				}

				Long startTime = System.currentTimeMillis();
				workerPool.addTimer(new RunnableTimer(new Runnable()
				{
					@Override
					public void run()
					{						
						try
						{
							SpendingStatusNotificationRequest ssnr = serverProvider.getMessageFactory().createSpendingStatusNotificationRequest(serverLink.getLocalHost(), serverLink.getLocalRealm(), serverLink.getDestinationHost(), serverLink.getDestinationRealm(), session.getID());
							((SyServerSession) session).sendStatusNotificationRequest(ssnr, new AsyncCallback()
							{
								@Override
								public void onSuccess()
								{

								}

								@Override
								public void onError(DiameterException ex)
								{
									logger.error("An error occured while sending SSNR," + ex.getMessage(), ex);
								}
							});
						}
						catch (DiameterException ex)
						{
							logger.error("An error occured while sending SSNR," + ex.getMessage(), ex);
						}
					}
				}, startTime + 1000, session.getID()));
			}
		});

		SpendingLimitRequest request = provider.getMessageFactory().createSpendingLimitRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), SLRequestTypeEnum.INITIAL_REQUEST);
		SyClientSession clientSession = (SyClientSession) provider.getSessionFactory().createClientSession(request);
		
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
			Thread.sleep(responseTimeout * 5);
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

		assertEquals(snaReceived.get(), 1L);
		assertEquals(snaReceivedByListener.get(), 1L);
		assertEquals(snrReceived.get(), 1L);
		assertEquals(snrReceivedByListener.get(), 1L);
		assertEquals(ssnaReceived.get(), 1L);
		assertEquals(ssnaReceivedByListener.get(), 1L);
		assertEquals(ssnrReceived.get(), 1L);
		assertEquals(ssnrReceivedByListener.get(), 1L);
		assertEquals(strReceived.get(), 1L);
		assertEquals(strReceivedByListener.get(), 1L);
		assertEquals(staReceived.get(), 1L);
		assertEquals(staReceivedByListener.get(), 1L);
		assertEquals(timeoutReceived.get(), 0L);
	}
}