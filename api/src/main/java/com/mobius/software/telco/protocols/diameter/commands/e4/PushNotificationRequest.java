package com.mobius.software.telco.protocols.diameter.commands.e4;
/*
 * Mobius Software LTD
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.e4.AccessNetworkType;
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.e4.IPConnectivityStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.e4.InitialGateSettingDescription;
import com.mobius.software.telco.protocols.diameter.primitives.e4.QoSProfileDescription;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.1.3 Push-Notification-Request command
	The Push-Notification-Request (PNR) command, indicated by the Command-Code field set to 309 and the "R" bit set in
	the Command Flags field, is sent by a Diameter server to a Diameter client in order to notify changes in the user data in
	the server. This command is defined in TS 129 329 [4] and used with additional AVPs defined in the present document.
	Message Format:

	< Push-Notification-Request > ::= < Diameter Header: 309, REQ, PXY, 16777231 >
				 < Session-Id >
				 { Vendor-Specific-Application-Id }
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Host }
				 { Destination-Realm }
				 [ Globally-Unique-Address]
				 [ User-Name]
				 [ Logical-Access-Id]
				 [ Physical-Access-Id]
				 [ Access-Network-Type]
				 [ Initial-Gate-Setting-Description]
				*[ QoS-Profile-Description]
				 [ IP-Connectivity-Status]
				 [ QoS-Profile-ID]
				 [ Initial-Gate-Setting-ID]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.E4, commandCode = CommandCodes.PUSH_NOTIFICATION, request = true, proxyable = true, name="Push-Notification-Request")
public interface PushNotificationRequest extends E4Request
{
	GloballyUniqueAddress getGloballyUniqueAddress();
	
	void setGloballyUniqueAddress(GloballyUniqueAddress value);
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);	
	
	String getPhysicalAccessID();
	
	void setPhysicalAccessID(String value);	
	
	AccessNetworkType getAccessNetworkType();
	
	void setAccessNetworkType(AccessNetworkType value);
	
	public InitialGateSettingDescription getInitialGateSettingDescription();
	
	void setInitialGateSettingDescription(InitialGateSettingDescription value);
	
	public List<QoSProfileDescription> getQoSProfileDescription();
	
	void setQoSProfileDescription(List<QoSProfileDescription> value);
	
	public IPConnectivityStatusEnum getIPConnectivityStatus();
	
	void setIPConnectivityStatus(IPConnectivityStatusEnum value);
	
	String getQoSProfileID();
	 
	void setQoSProfileID(String value);
	 		
	String getInitialGateSettingID();
	 
	void setInitialGateSettingID(String value);
}