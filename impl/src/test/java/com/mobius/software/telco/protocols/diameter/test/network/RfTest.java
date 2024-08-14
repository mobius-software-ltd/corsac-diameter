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

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationID;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.CommandCode;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ClientAccSession;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.app.rf.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.rf.RfClientSession;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.rf.RfProviderImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class RfTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	private static final Logger logger = LogManager.getLogger(RfTest.class);
	
	@Test
	public void testEvent() throws Exception
	{
		super.setupRemote(new EmptyServerRoSessionListener(),new BasicServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong aaaReceived=new AtomicLong(0L);
		final AtomicLong aaaReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof AccountingAnswer)
					aaaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RfProviderImpl provider = (RfProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.ACCOUNTING), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.rf"));
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
			public void onAccountingResponse(AccountingAnswer answer, ClientAccSession<AccountingRequest> session, String linkID, AsyncCallback callback)
			{
				aaaReceivedByListener.incrementAndGet();
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		AccountingRequest request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.EVENT_RECORD, 1L);
		RfClientSession clientSession = (RfClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		assertEquals(aaaReceived.get() , 1L);
		assertEquals(aaaReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
	
	@Test
	public void testNonEvent() throws Exception
	{
		super.setupRemote(new EmptyServerRoSessionListener(),new BasicServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong aaaReceived=new AtomicLong(0L);
		final AtomicLong aaaReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof AccountingAnswer)
					aaaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RfProviderImpl provider = (RfProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.ACCOUNTING), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.rf"));
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
			public void onAccountingResponse(AccountingAnswer answer, ClientAccSession<AccountingRequest> session,String linkID, AsyncCallback callback)
			{
				aaaReceivedByListener.incrementAndGet();
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		AccountingRequest request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.START_RECORD, 1L);
		RfClientSession clientSession = (RfClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.INTERIM_RECORD, 2L);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.STOP_RECORD, 3L);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		assertEquals(aaaReceived.get() , 3L);
		assertEquals(aaaReceivedByListener.get() , 3L);
		assertEquals(timeoutReceived.get() , 0L);
	}		
	
	@Test
	public void testNonEventWithError() throws Exception
	{
		super.setupRemote(new EmptyServerRoSessionListener(),new BasicServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong aaaReceived=new AtomicLong(0L);
		final AtomicLong aaaReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof AccountingAnswer)
					aaaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RfProviderImpl provider = (RfProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.ACCOUNTING), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.rf"));
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
			public void onAccountingResponse(AccountingAnswer answer, ClientAccSession<AccountingRequest> session, String linkID, AsyncCallback callback)
			{
				aaaReceivedByListener.incrementAndGet();
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		AccountingRequest request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.START_RECORD, 1L);
		RfClientSession clientSession = (RfClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.INTERIM_RECORD, 1001L);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		assertEquals(aaaReceived.get() , 2L);
		assertEquals(aaaReceivedByListener.get() , 2L);
		assertEquals(timeoutReceived.get() , 0L);
		
		//statistics validation
		//messages
		Map<String, Long> localMessagesReceived = localStack.getMessagesReceivedByType();
		Map<String, Long> localMessagesSent = localStack.getMessagesSentByType();
				
		assertEquals(localMessagesReceived.size(),4);
		assertEquals(localMessagesSent.size(),4);
				
		assertEquals(localMessagesReceived.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
				
		assertEquals(localMessagesReceived.get(CommandCode.DISCONNECT_PEER.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.DISCONNECT_PEER.name()),1L);
				
		assertTrue(localMessagesReceived.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
		assertTrue(localMessagesSent.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
				
		assertEquals(localMessagesReceived.get(CommandCode.ACCOUNTING.name()),2L);
		assertEquals(localMessagesSent.get(CommandCode.ACCOUNTING.name()),2L);
				
		//sessions 
		Map<String, Long> localIncomingSessions = localStack.getIncomingSessionsByApplication();
		Map<String, Long> localOutgoingSessions = localStack.getOutgoingSessionByApplication();
		Map<Long, Long> localSessionsEnded = localStack.getSessionEndedByResultCode();
		
		assertEquals(localIncomingSessions.size(),0);
		assertEquals(localOutgoingSessions.size(),1);
		assertEquals(localSessionsEnded.size(),1);
				
		assertEquals(localOutgoingSessions.get(ApplicationID.ACC.name()),1L);
		assertEquals(localSessionsEnded.get(ResultCodes.DIAMETER_UNABLE_TO_COMPLY),1L);
				
		//errors
		Map<Long, Long> localErrorsReceived = localStack.getErrorsReceivedByType();
		Map<Long, Long> localErrorsSent = localStack.getErrorsSentByType();
				
		assertEquals(localErrorsReceived.size(),1);
		assertEquals(localErrorsSent.size(),0);
				
		assertEquals(localErrorsReceived.get(ResultCodes.DIAMETER_UNABLE_TO_COMPLY),1L);
		
		//sessions by application
		localSessionsEnded = localStack.getSessionEndedByResultCodeAndApplication(ApplicationID.ACC);
						
		assertEquals(localSessionsEnded.size(),1);
						
		assertEquals(localSessionsEnded.get(ResultCodes.DIAMETER_UNABLE_TO_COMPLY),1L);
						
		localSessionsEnded = localStack.getSessionEndedByResultCodeAndApplication(ApplicationID.COMMON);
						
		assertEquals(localSessionsEnded.size(),0);
		
		//messages by application
		localMessagesReceived = localStack.getMessagesReceivedByTypeAndApplication(ApplicationID.ACC);
		localMessagesSent = localStack.getMessagesSentByTypeAndApplication(ApplicationID.ACC);
				
		assertEquals(localMessagesReceived.size(),1);
		assertEquals(localMessagesSent.size(),1);
		
		assertEquals(localMessagesReceived.get(CommandCode.ACCOUNTING.name()),2L);
		assertEquals(localMessagesSent.get(CommandCode.ACCOUNTING.name()),2L);
				
		localMessagesReceived = localStack.getMessagesReceivedByTypeAndApplication(ApplicationID.COMMON);
		localMessagesSent = localStack.getMessagesSentByTypeAndApplication(ApplicationID.COMMON);
				
		assertEquals(localMessagesReceived.size(),3);
		assertEquals(localMessagesSent.size(),3);
				
		assertEquals(localMessagesReceived.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
				
		assertEquals(localMessagesReceived.get(CommandCode.DISCONNECT_PEER.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.DISCONNECT_PEER.name()),1L);
				
		assertTrue(localMessagesReceived.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
		assertTrue(localMessagesSent.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
				
		//errors by application
				
		localErrorsReceived = localStack.getErrorsReceivedByTypeAndApplication(ApplicationID.ACC);
		localErrorsSent = localStack.getErrorsSentByTypeAndApplication(ApplicationID.ACC);
				
		assertEquals(localErrorsReceived.size(),1);
		assertEquals(localErrorsSent.size(),0);
				
		assertEquals(localErrorsReceived.get(ResultCodes.DIAMETER_UNABLE_TO_COMPLY),1L);
		
		localErrorsReceived = localStack.getErrorsReceivedByTypeAndApplication(ApplicationID.COMMON);
		localErrorsSent = localStack.getErrorsSentByTypeAndApplication(ApplicationID.COMMON);
				
		assertEquals(localErrorsReceived.size(),0);
		assertEquals(localErrorsSent.size(),0);
				
		//messages by link and application
				
		localMessagesReceived = localStack.getLinkMessagesReceivedByTypeAndApplication(localLinkID, ApplicationID.ACC);
		localMessagesSent = localStack.getLinkMessagesSentByTypeAndApplication(localLinkID, ApplicationID.ACC);
		
		assertEquals(localMessagesReceived.size(),1);
		assertEquals(localMessagesSent.size(),1);
		
		assertEquals(localMessagesReceived.get(CommandCode.ACCOUNTING.name()),2L);
		assertEquals(localMessagesSent.get(CommandCode.ACCOUNTING.name()),2L);
		
		localMessagesReceived = localStack.getLinkMessagesReceivedByTypeAndApplication(localLinkID, ApplicationID.COMMON);
		localMessagesSent = localStack.getLinkMessagesSentByTypeAndApplication(localLinkID, ApplicationID.COMMON);
		
		assertEquals(localMessagesReceived.size(),3);
		assertEquals(localMessagesSent.size(),3);
		
		assertEquals(localMessagesReceived.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
		
		assertEquals(localMessagesReceived.get(CommandCode.DISCONNECT_PEER.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.DISCONNECT_PEER.name()),1L);
		
		assertTrue(localMessagesReceived.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
		assertTrue(localMessagesSent.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
				
		//errors by link and application
		localErrorsReceived = localStack.getLinkErrorsReceivedByTypeAndApplication(localLinkID, ApplicationID.ACC);
		localErrorsSent = localStack.getLinkErrorsSentByTypeAndApplication(localLinkID, ApplicationID.ACC);
		
		assertEquals(localErrorsReceived.size(),1);
		assertNull(localErrorsSent);
		
		assertEquals(localErrorsReceived.get(ResultCodes.DIAMETER_UNABLE_TO_COMPLY),1L);
		
		localErrorsReceived = localStack.getLinkErrorsReceivedByTypeAndApplication(localLinkID, ApplicationID.COMMON);
		localErrorsSent = localStack.getLinkErrorsSentByTypeAndApplication(localLinkID, ApplicationID.COMMON);
		
		assertEquals(localErrorsReceived.size(),0);
		assertNull(localErrorsSent);
	}		
	
	
	@Test
	public void testNonEventWithTimeout() throws Exception
	{
		super.setupRemote(new EmptyServerRoSessionListener(),new BasicServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong aaaReceived=new AtomicLong(0L);
		final AtomicLong aaaReceivedByListener=new AtomicLong(0L);
		final AtomicLong timeoutReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
			{
				if(message instanceof AccountingAnswer)
					aaaReceived.incrementAndGet();				
			}
		});
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		RfProviderImpl provider = (RfProviderImpl)localStack.getProvider(Long.valueOf(ApplicationIDs.ACCOUNTING), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.rf"));
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
			public void onAccountingResponse(AccountingAnswer answer, ClientAccSession<AccountingRequest> session, String linkID, AsyncCallback callback)
			{
				aaaReceivedByListener.incrementAndGet();
			}
		});
		
		//usually its not needed to get link, here we use it to read hosts/realms
		DiameterLink localLink = localStack.getNetworkManager().getLink(localLinkID);
		AccountingRequest request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.START_RECORD, 1L);
		RfClientSession clientSession = (RfClientSession)provider.getSessionFactory().createClientSession(request);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		request = provider.getMessageFactory().createAccountingRequest(localLink.getLocalHost(), localLink.getLocalRealm(), localLink.getDestinationHost(), localLink.getDestinationRealm(), AccountingRecordTypeEnum.INTERIM_RECORD, 2001L);
		clientSession.sendAccountingRequest(request, new AsyncCallback()
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
		
		assertEquals(aaaReceived.get() , 1L);
		assertEquals(aaaReceivedByListener.get() , 1L);
		assertEquals(timeoutReceived.get() , 2L);
		
		//statistics validation
		//messages
		Map<String, Long> localMessagesReceived = localStack.getMessagesReceivedByType();
		Map<String, Long> localMessagesSent = localStack.getMessagesSentByType();
						
		assertEquals(localMessagesReceived.size(),4);
		assertEquals(localMessagesSent.size(),4);
						
		assertEquals(localMessagesReceived.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
						
		assertEquals(localMessagesReceived.get(CommandCode.DISCONNECT_PEER.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.DISCONNECT_PEER.name()),1L);
						
		assertTrue(localMessagesReceived.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
		assertTrue(localMessagesSent.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
						
		assertEquals(localMessagesReceived.get(CommandCode.ACCOUNTING.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.ACCOUNTING.name()),2L);
						
		//sessions 
		Map<String, Long> localIncomingSessions = localStack.getIncomingSessionsByApplication();
		Map<String, Long> localOutgoingSessions = localStack.getOutgoingSessionByApplication();
		Map<Long, Long> localSessionsEnded = localStack.getSessionEndedByResultCode();
				
		assertEquals(localIncomingSessions.size(),0);
		assertEquals(localOutgoingSessions.size(),1);
		assertEquals(localSessionsEnded.size(),1);
						
		assertEquals(localOutgoingSessions.get(ApplicationID.ACC.name()),1L);
		assertEquals(localSessionsEnded.get(ResultCodes.DIAMETER_SESSION_TIMEOUT),1L);
						
		//errors
		Map<Long, Long> localErrorsReceived = localStack.getErrorsReceivedByType();
		Map<Long, Long> localErrorsSent = localStack.getErrorsSentByType();
						
		assertEquals(localErrorsReceived.size(),0);
		assertEquals(localErrorsSent.size(),0);
						
		//sessions by application
		localSessionsEnded = localStack.getSessionEndedByResultCodeAndApplication(ApplicationID.ACC);
								
		assertEquals(localSessionsEnded.size(),1);
								
		assertEquals(localSessionsEnded.get(ResultCodes.DIAMETER_SESSION_TIMEOUT),1L);
								
		localSessionsEnded = localStack.getSessionEndedByResultCodeAndApplication(ApplicationID.COMMON);
								
		assertEquals(localSessionsEnded.size(),0);
				
		//messages by application
		localMessagesReceived = localStack.getMessagesReceivedByTypeAndApplication(ApplicationID.ACC);
		localMessagesSent = localStack.getMessagesSentByTypeAndApplication(ApplicationID.ACC);
						
		assertEquals(localMessagesReceived.size(),1);
		assertEquals(localMessagesSent.size(),1);
				
		assertEquals(localMessagesSent.get(CommandCode.ACCOUNTING.name()),2L);
		assertEquals(localMessagesReceived.get(CommandCode.ACCOUNTING.name()),1L);
						
		localMessagesReceived = localStack.getMessagesReceivedByTypeAndApplication(ApplicationID.COMMON);
		localMessagesSent = localStack.getMessagesSentByTypeAndApplication(ApplicationID.COMMON);
						
		assertEquals(localMessagesReceived.size(),3);
		assertEquals(localMessagesSent.size(),3);
						
		assertEquals(localMessagesReceived.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
						
		assertEquals(localMessagesReceived.get(CommandCode.DISCONNECT_PEER.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.DISCONNECT_PEER.name()),1L);
						
		assertTrue(localMessagesReceived.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
		assertTrue(localMessagesSent.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
						
		//errors by application
						
		localErrorsReceived = localStack.getErrorsReceivedByTypeAndApplication(ApplicationID.ACC);
		localErrorsSent = localStack.getErrorsSentByTypeAndApplication(ApplicationID.ACC);
						
		assertEquals(localErrorsReceived.size(),0);
		assertEquals(localErrorsSent.size(),0);
						
		localErrorsReceived = localStack.getErrorsReceivedByTypeAndApplication(ApplicationID.COMMON);
		localErrorsSent = localStack.getErrorsSentByTypeAndApplication(ApplicationID.COMMON);
						
		assertEquals(localErrorsReceived.size(),0);
		assertEquals(localErrorsSent.size(),0);
						
		//messages by link and application
						
		localMessagesReceived = localStack.getLinkMessagesReceivedByTypeAndApplication(localLinkID, ApplicationID.ACC);
		localMessagesSent = localStack.getLinkMessagesSentByTypeAndApplication(localLinkID, ApplicationID.ACC);
				
		assertEquals(localMessagesReceived.size(),1);
		assertEquals(localMessagesSent.size(),1);
				
		assertEquals(localMessagesReceived.get(CommandCode.ACCOUNTING.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.ACCOUNTING.name()),2L);
				
		localMessagesReceived = localStack.getLinkMessagesReceivedByTypeAndApplication(localLinkID, ApplicationID.COMMON);
		localMessagesSent = localStack.getLinkMessagesSentByTypeAndApplication(localLinkID, ApplicationID.COMMON);
				
		assertEquals(localMessagesReceived.size(),3);
		assertEquals(localMessagesSent.size(),3);
				
		assertEquals(localMessagesReceived.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.CAPABILITIES_EXCHANGE.name()),1L);
				
		assertEquals(localMessagesReceived.get(CommandCode.DISCONNECT_PEER.name()),1L);
		assertEquals(localMessagesSent.get(CommandCode.DISCONNECT_PEER.name()),1L);
				
		assertTrue(localMessagesReceived.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
		assertTrue(localMessagesSent.get(CommandCode.DEVICE_WATCHDOG.name())>=1L);
						
		//errors by link and application
		localErrorsReceived = localStack.getLinkErrorsReceivedByTypeAndApplication(localLinkID, ApplicationID.ACC);
		localErrorsSent = localStack.getLinkErrorsSentByTypeAndApplication(localLinkID, ApplicationID.ACC);
				
		assertNull(localErrorsReceived);
		assertNull(localErrorsSent);
				
		localErrorsReceived = localStack.getLinkErrorsReceivedByTypeAndApplication(localLinkID, ApplicationID.COMMON);
		localErrorsSent = localStack.getLinkErrorsSentByTypeAndApplication(localLinkID, ApplicationID.COMMON);
				
		assertNull(localErrorsReceived);
		assertNull(localErrorsSent);
	}		
}