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
 * 	7.1.2 User-Data-Answer command
	The User-Data-Answer (UDA) command, indicated by the Command-Code field set to 306 and the "R" bit cleared in
	the Command Flags field, is sent by a server in response to the User-Data-Request command. This command is defined
	in TS 129 329 [4] and used with additional AVPs defined in the present document. The Experimental-Result AVP may
	contain one of the values defined in clause 7.2 or in TS 129 229 [3].
	Message Format:
	
	< User-Data-Answer > ::= < Diameter Header: 306, PXY, 16777231 >
				 < Session-Id >
				 { Vendor-Specific-Application-Id }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Globally-Unique-Address ]
				 [ User-Name ]
				 [ Logical-Access-Id ]
				 [ Physical-Access-Id ]
				 [ Access-Network-Type ]
				 [ Initial-Gate-Setting-Description ]
				*[ Qos-Profile-Description ]
				 [ IP-Connectivity-Status ]
				 [ QoS-Profile-ID ]
				 [ Initial-Gate-Setting-ID ]
				*[ AVP ]
				*[ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
*/
@DiameterCommandDefinition(applicationId = 16777231, commandCode = 306, request = false, proxyable = true, name="User-Data-Answer")
public interface UserDataAnswer extends E4Answer
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
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);
}