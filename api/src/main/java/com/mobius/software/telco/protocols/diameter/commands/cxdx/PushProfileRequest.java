package com.mobius.software.telco.protocols.diameter.commands.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AllowedWAFWWSFIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserData;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.11	Push-Profile-Request (PPR) Command
	The Push-Profile-Request (PPR) command, indicated by the Command-Code field set to 305 and the 'R' bit set in the Command Flags field, is sent by a Diameter Multimedia server to a Diameter Multimedia client in order to update the subscription data and for SIP Digest authentication the authentication data of a multimedia user in the Diameter Multimedia client whenever a modification has occurred in the subscription data or digest password that constitutes the data used by the client.
	Message Format

	< Push-Profile-Request > ::=	< Diameter Header: 305, REQ, PXY, 16777216 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Host }
			 { Destination-Realm }
			 { User-Name }
			*[ Supported-Features ]
			 [ User-Data ]
			 [ Charging-Information ]
			 [ SIP-Auth-Data-Item ]
			 [ Allowed-WAF-WWSF-Identities ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777216, commandCode = 305, request = true, proxyable = true, name="Push-Profile-Request")
public interface PushProfileRequest extends CxDxRequest
{
	List<UserData> getUserData();
	
	void setUserData(List<UserData> value);	
	
	ChargingInformation getChargingInformation();
	 
	void setChargingInformation(ChargingInformation value);
	
	SIPAuthDataItem getSIPAuthDataItem();
	
	void setSIPAuthDataItem(SIPAuthDataItem value); 
	
	AllowedWAFWWSFIdentities getAllowedWAFWWSFIdentities();
	 
	void setAllowedWAFWWSFIdentities(AllowedWAFWWSFIdentities value);	
}