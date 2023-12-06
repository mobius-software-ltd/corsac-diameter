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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.10.  Registration-Termination-Answer (RTA) Command

   	The Registration-Termination-Answer (RTA) is indicated by the
   	Command-Code set to 287 and the Command Flags' 'R' bit cleared.  The
   	Diameter client sends this command in response to a previously
   	received Diameter Registration-Termination-Request (RTR) command.

   	In addition to the values already defined in RFC 3588 [RFC3588], the
   	Result-Code AVP may contain one of the values defined in
   	Section 10.1.

   	If the SIP server (Diameter client) requires a User-Name AVP value to
   	process the Diameter RTR request, but the Diameter RTR message did
   	not contain a User-Name AVP value, the Diameter client MUST set the
   	Result-Code AVP value to DIAMETER_USER_NAME_REQUIRED (see Section
   	10.1.2) and return it in a Diameter RTA message.

   	The SIP server (Diameter client) applies the administrative
   	deregistration to each of the URIs included in each of the SIP-AOR
   	AVP values, or, if there is no SIP-AOR AVP present in the Diameter
   	RTR request, to all the URIs allocated to the User-Name AVP value.

   	The value of the SIP-Deregistration-Reason AVP in the Diameter RTR
   	command has an effect on the actions performed at the SIP server
   	(Diameter client):

   	o  	If the value is set to PERMANENT_TERMINATION, then the user has
      	terminated his/her registration to the realm.  If informing the
      	interested parties (e.g., subscribers to the "reg" event
      	[RFC3680]) about the administrative deregistration is supported
      	through SIP procedures, the SIP server (Diameter client) will do
      	so.  The Diameter Client in the SIP Server SHOULD NOT request a
      	new user registration.  The SIP server clears the registration
      	state of the deregistered AORs.

   	o  	If the value is set to NEW_SIP_SERVER_ASSIGNED, the Diameter
      	server informs the SIP server (Diameter client) that a new SIP
      	server has been allocated to the user, due to some reason.  The
      	SIP server, if supported through SIP procedures, will inform the
      	interested parties (e.g., subscribers to the "reg" event
      	[RFC3680]) about the administrative deregistration at this SIP
      	server.  The Diameter client in the SIP server SHOULD NOT request
      	a new user registration.  The SIP server clears the registration
      	state of the deregistered SIP AORs.

   	o  	If the value is set to SIP_SERVER_CHANGE, the Diameter server
      	informs the SIP server (Diameter client) that a new SIP server has
      	to be allocated to the user, e.g., due to user's capabilities
      	requiring a new SIP server, or not enough resources in the current
      	SIP server.  If informing the interested parties about the
      	administrative deregistration is supported through SIP procedures
      	(e.g., subscriptions to the "reg" event [RFC3680]), the SIP server
      	will do so.  The Diameter client in the SIP Server SHOULD NOT
      	request a new user registration.  The SIP server clears the
      	registration state of the deregistered SIP AORs.

   	o  	If the value is set to REMOVE_SIP_SERVER, the Diameter server
      	informs the SIP server (Diameter client) that the SIP server will
      	no longer be bound in the Diameter server with that user.  The SIP
      	server can delete all data related to the user.

   	The Message Format of the RTA command is as follows:

   	<RTA> ::= < Diameter Header: 287, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Result-Code }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Authorization-Lifetime ]
                 [ Auth-Grace-Period ]
                 [ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 6, commandCode = 287, request = false, proxyable = true, name="Registration-Termination-Answer")
public interface RegistrationTerminationAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);
}