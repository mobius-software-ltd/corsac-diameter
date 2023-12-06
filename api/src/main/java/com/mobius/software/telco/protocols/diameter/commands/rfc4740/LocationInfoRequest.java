package com.mobius.software.telco.protocols.diameter.commands.rfc4740;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.5.  Location-Info-Request (LIR) Command

   	The Location-Info-Request (LIR) is indicated by the Command-Code set
   	to 285 and the Command Flags' 'R' bit set.  The Diameter client in a
   	SIP server sends this command to the Diameter server to request
   	routing information, e.g., the URI of the SIP server assigned to the
   	SIP-AOR AVP value allocated to the users.

   	The Message Format of the LIR command is as follows:

    <LIR> ::= < Diameter Header: 285, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { SIP-AOR }
                 [ Destination-Host ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 6, commandCode = 285, request = true, proxyable = true, name="Location-Info-Request")
public interface LocationInfoRequest extends AuthenticationRequest
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
	
	String getSIPAOR();
	
	void setSIPAOR(String value);
}