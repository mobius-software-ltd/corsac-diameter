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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.12.  Push-Profile-Answer (PPA) Command

   	The Push-Profile-Answer (PPA) is indicated by the Command-Code set to
   	288 and the Command Flags' 'R' bit cleared.  The Diameter client
   	sends this command in response to a previously received Diameter
   	Push-Profile-Request (PPR) command.

   	In addition to the values already defined in RFC 3588 [RFC3588], the
   	Result-Code AVP may contain one of the values defined in
   	Section 10.1.

   	If there is no error when processing the received Diameter PPR
   	message, the SIP server (Diameter client) MUST download the received
   	user profile from the SIP-User-Data AVP values in the Diameter PPR
   	message and store it associated with the user specified in the
   	User-Name AVP value.

   	If the SIP server does not recognize or does not support some of the
   	data transferred in the SIP-User-Data AVP values, the Diameter client
   	in the SIP server MUST return a Diameter PPA message that includes a

   	Result-Code AVP set to the value
   	DIAMETER_ERROR_NOT_SUPPORTED_USER_DATA.
	
   	If the SIP server (Diameter client) receives a Diameter PPR message
   	with a User-Name AVP that is unknown, the Diameter client MUST set
   	the Result-Code AVP value to DIAMETER_ERROR_USER_UNKNOWN and MUST
   	return it to the Diameter server in a Diameter PPA message.

   	If the SIP server (Diameter client) receives in the
   	SIP-User-Data-Content AVP value (of the grouped SIP-User-Data AVP)
   	more data than it can accept, it MUST set the Result-Code AVP value
   	to DIAMETER_ERROR_TOO_MUCH_DATA and MUST return it to the Diameter
   	server in a Diameter PPA message.  The SIP server MUST NOT override
   	the existing user profile with the one received in the PPR message.

   	If the Diameter server receives the Result-Code AVP value set to
   	DIAMETER_ERROR_TOO_MUCH_DATA in a Diameter PPA message, it SHOULD
   	force a new re-registration of the user by sending to the Diameter
   	client a Diameter Registration-Termination-Request (RTR) with the
   	SIP-Deregistration-Reason AVP value set to SIP_SERVER_CHANGE.  This
   	will force a re-registration of the user and will trigger a selection
   	of a new SIP server.

   	If the Diameter client is not able to honor the command, for any
   	other reason, it MUST set the Result-Code AVP value to
   	DIAMETER_UNABLE_TO_COMPLY and it MUST return it in a Diameter PPA
   	message.

   	The Message Format of the PPA command is as follows:

    <PPA> ::= < Diameter Header: 288, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Result-Code }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 6, commandCode = 288, request = false, proxyable = true, name="Push-Profile-Answer")
public interface PushProfileAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);
}