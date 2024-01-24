package com.mobius.software.telco.protocols.diameter.commands.swx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPUserData;
import com.mobius.software.telco.protocols.diameter.primitives.swx.PPRFlags;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.2.2	HSS Initiated Update of User Profile Procedure
	The Push-Profile-Request (PPR) command, indicated by the Command-Code field set to 305 and the 'R' bit set in the Command Flags field, is sent by the HSS to the 3GPP AAA Server in order to update the subscription data whenever a modification has occurred in the subscription data; this corresponds to clause 8.1.2.3. This command is also sent by HSS to indicate a restart event to the 3GPP AAA Server, so the registration data and the dynamic data previously stored in HSS can be restored; this corresponds to clause 8.1.2.4.1.
	Message Format
	
	< Push-Profile-Request > ::=	< Diameter Header: 305, REQ, 16777265 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Host }
			 { Destination-Realm }
			 { User-Name }
			 [ Non-3GPP-User-Data ]
			 [ PPR-Flags ]
			*[ Supported-Features ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777265, commandCode = 305, request = true, proxyable = true, name="Push-Profile-Request")
public interface PushProfileRequest extends SwxRequest
{
	Non3GPPUserData getNon3GPPUserData();
	 
	void setNon3GPPUserData(Non3GPPUserData value);
	
	PPRFlags getPPRFlags();
	
	void setPPRFlags(PPRFlags value);
}