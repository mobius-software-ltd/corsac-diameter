package com.mobius.software.telco.protocols.diameter;

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

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

/**
*
* @author yulian oifa
*
*/
public interface NetworkManager
{
	void addLink(String linkId, InetAddress remoteAddress, Integer remotePort, InetAddress localAddress, Integer localPort, Boolean isServer, Boolean isSctp, String localHost, String localRealm, String destinationHost, String destinationRealm, Boolean rejectUnmandatoryAvps) throws DiameterException;
	
	void removeLink(String linkId) throws DiameterException;
	
	void startLink(String linkId) throws DiameterException;
	
	void stopLink(String linkId, AsyncCallback callback) throws DiameterException;
	
	DiameterLink getLink(String linkId);
	
	void registerApplication(String linkId, List<VendorSpecificApplicationId> vendorApplicationIds, List<Long> authApplicationIds, List<Long> acctApplicationIds, Package providerPackageName, Package packageName) throws DiameterException;
	
	void stop();
	
	void addNetworkListener(String listenerId,NetworkListener listener);
	
	void removeNetworkListener(String listenerId);
	
	void sendMessage(String linkId,DiameterMessage message,AsyncCallback callback) throws DiameterException;
	
	void sendRequest(DiameterRequest message,AsyncCallback callback);
	
	void sendAnswer(DiameterAnswer message, String destinationHost, String destinationRealm, AsyncCallback callback);
}