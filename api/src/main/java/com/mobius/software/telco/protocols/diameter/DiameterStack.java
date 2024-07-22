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

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.common.dal.timers.WorkerPool;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
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
	
	WorkerPool getWorkerPool();
	
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
}