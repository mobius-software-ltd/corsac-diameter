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

import org.restcomm.cluster.ClusteredID;
import org.restcomm.cluster.IDGenerator;

import com.mobius.software.common.dal.timers.WorkerPool;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;

/**
*
* @author yulian oifa
*
*/
public interface DiameterStack
{
	ClassLoader getClassLoader();
	
	DiameterProvider<?,?,?,?,?> getProvider(Class<?> providerClass);
		
	//package is required for credit control and others that has multiple options
	DiameterProvider<?,?,?,?,?> getProvider(Long applicationID,Package parentPackage);
	
	void registerCustomProvider(DiameterProvider<?,?,?,?,?> provider,Package parentPackage);
	
	WorkerPool getWorkerPool();
	
	IDGenerator<?> getIDGenerator();
	
	ClusteredID<?> generateID();
	
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
	
	Map<String,Long> getMessagesSentByType();
    
    Map<String,Long> getMessagesReceivedByType();
    
    Map<Long,Long> getErrorsSentByType();
    
    Map<Long,Long> getErrorsReceivedByType();
    
    Map<String,Long> getOutgoingSessionByApplication();
    
    Map<String,Long> getIncomingSessionsByApplication();  
    
    Map<Long,Long> getSessionEndedByResultCode();
    
    Map<Long,Long> getSessionEndedByResultCodeAndApplication(ApplicationID applicationID);
    
    Map<String,Long> getMessagesSentByTypeAndApplication(ApplicationID applicationID);
    
    Map<String,Long> getMessagesReceivedByTypeAndApplication(ApplicationID applicationID);
    
    Map<Long,Long> getErrorsSentByTypeAndApplication(ApplicationID applicationID);
    
    Map<Long,Long> getErrorsReceivedByTypeAndApplication(ApplicationID applicationID);
    
    Map<String,Long> getLinkMessagesSentByTypeAndApplication(String linkID, ApplicationID applicationID);
    
    Map<String,Long> getLinkMessagesReceivedByTypeAndApplication(String linkID, ApplicationID applicationID);
    
    Map<Long,Long> getLinkErrorsSentByTypeAndApplication(String linkID, ApplicationID applicationID);
    
    Map<Long,Long> getLinkErrorsReceivedByTypeAndApplication(String linkID, ApplicationID applicationID);
    
    Map<String,Map<String,Long>> getLinkMessagesSentByTypeAndApplication(String linkID);
    
    Map<String,Map<String,Long>> getLinkMessagesReceivedByTypeAndApplication(String linkID);
    
    Map<String,Map<Long,Long>> getLinkErrorsSentByTypeAndApplication(String linkID);
    
    Map<String,Map<Long,Long>> getLinkErrorsReceivedByTypeAndApplication(String linkID);
    
    void messageReceived(DiameterMessage message, String linkID);
    
    void messageSent(DiameterMessage message, String linkID);
    
    void newIncomingSession(ApplicationID applicationID);
    
    void newOutgoingSession(ApplicationID applicationID);
    
    void sessionEnded(Long resultCode, ApplicationID applicationID);
    
    void registerGlobalApplication(Package providerPackageName, Package packageName) throws DiameterException;
    
    DiameterParser getGlobalParser();
    
    Boolean isSessionLess();

	Boolean isNewIncomingSessionAllowed();
}