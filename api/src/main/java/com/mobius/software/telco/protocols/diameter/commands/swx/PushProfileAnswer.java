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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	The Push-Profile-Answer (PPA) command, indicated by the Command-Code field set to 305 and the 'R' bit cleared in the Command Flags field, is sent by the HSS in response to the Push-Profile-Request command. The Result-Code or Experimental-Result AVP may contain one of the values defined in clause 6.2 of 3GPP TS 29.229 [24] in addition to the values defined in IETF RFC 6733 [58].
	Message Format
	
	< Push-Profile-Answer > ::=	< Diameter Header: 305, PXY, 16777265 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Access-Network-Info ]
			 [ Local-Time-Zone ]
			*[ Supported-Features ]
			…
			*[ AVP ]

	NOTE:	As the Diameter commands described in this specification have been defined based on the former specification of the Diameter base protocol, the Vendor-Specific-Application-Id AVP is still listed as a required AVP (an AVP indicated as {AVP}) in the command code format specifications defined in this specification to avoid backward compatibility issues, even if the use of this AVP has been deprecated in the new specification of the Diameter base protocol (IETF RFC 6733 [58]).
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SWX, commandCode = CommandCodes.PUSH_PROFILE, request = false, proxyable = true, name="Push-Profile-Answer")
public interface PushProfileAnswer extends SwxAnswer
{	
	public AccessNetworkInfo getAccessNetworkInfo();
	
	void setAccessNetworkInfo(AccessNetworkInfo value);
	
	LocalTimeZone getLocalTimeZone();
	
	void setLocalTimeZone(LocalTimeZone value);
}