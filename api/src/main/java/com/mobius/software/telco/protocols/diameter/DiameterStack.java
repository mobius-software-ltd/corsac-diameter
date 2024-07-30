package com.mobius.software.telco.protocols.diameter;
/*
 * Mobius Software LTD, Open Source Cloud Communications
 * Copyright 2023, Mobius Software LTD and individual contributors
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

import java.util.Map;

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.common.dal.timers.CountableQueue;
import com.mobius.software.common.dal.timers.PeriodicQueuedTasks;
import com.mobius.software.common.dal.timers.Task;
import com.mobius.software.common.dal.timers.Timer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;

/**
*
* @author yulian oifa
*
*/
public interface DiameterStack
{
	//package is required for credit control and others that has multiple options
	DiameterProvider<?,?,?,?,?> getProvider(Long applicationID,Package parentPackage);
	
	CountableQueue<Task> getQueue();
	
	PeriodicQueuedTasks<Timer> getPeriodicQueue();
	
	IDGenerator<?> getIDGenerator();
	
	Long getResponseTimeout();
	
	Long getIdleTimeout();
	
	void setIdleTimeout(Long value);
	
	Long getDuplicatesTimeout();
	
	Long getDuplicatesCheckPeriod();
	
	String generateNewSessionID();
	
	void sendRequest(DiameterRequest message,AsyncCallback callback);
	
	void sendAnswer(DiameterAnswer message,String destinationHost,String destinationRealm,AsyncCallback callback);
	
	NetworkManager getNetworkManager();
	
	Long getOriginalStateId();
	
	Long getNextHopByHopIdentifier();
	
	String getProductName();
	
	Long  getVendorID();
	
	Long getFirmwareRevision();
	
	void stop();
	
	DiameterSessionStorage getSessionStorage();
	
	IncomingRequestsStorage getRequestsStorage();
	
	Map<Integer,Long> getMessagesSentByType();
    
    Map<Integer,Long> getMessagesReceivedByType();
    
    Map<Long,Long> getErrorsSentByType();
    
    Map<Long,Long> getErrorsReceivedByType();
    
    Map<Long,Long> getOutgoingSessionByApplication();
    
    Map<Long,Long> getIncomingSessionsByApplication();  
    
    Map<Long,Long> getSessionEndedByResultCode();
    
    Map<Long,Long> getSessionEndedByResultCodeAndApplication(long applicationID);
    
    Map<Integer,Long> getMessagesSentByTypeAndApplication(long applicationID);
    
    Map<Integer,Long> getMessagesReceivedByTypeAndApplication(long applicationID);
    
    Map<Long,Long> getErrorsSentByTypeAndApplication(long applicationID);
    
    Map<Long,Long> getErrorsReceivedByTypeAndApplication(long applicationID);
    
    Map<Integer,Long> getLinkMessagesSentByTypeAndApplication(String linkID, long applicationID);
    
    Map<Integer,Long> getLinkMessagesReceivedByTypeAndApplication(String linkID, long applicationID);
    
    Map<Long,Long> getLinkErrorsSentByTypeAndApplication(String linkID, long applicationID);
    
    Map<Long,Long> getLinkErrorsReceivedByTypeAndApplication(String linkID, long applicationID);
    
    void messageReceived(DiameterMessage message, String linkID);
    
    void messageSent(DiameterMessage message, String linkID);
    
    void newIncomingSession(long applicationID);
    
    void newOutgoingSession(long applicationID);
    
    void sessionEnded(Long resultCode, long applicationID);
}