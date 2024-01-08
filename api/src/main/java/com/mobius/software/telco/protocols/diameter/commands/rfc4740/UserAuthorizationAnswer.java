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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerCapabilities;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.  User-Authorization-Answer (UAA) Command

   	The User-Authorization-Answer (UAA) is indicated by the Command-Code
   	set to 283 and the Command Flags' 'R' bit cleared.  The Diameter
   	server sends this command in response to a previously received
   	Diameter User-Authorization-Request (UAR) command.  The Diameter
   	server indicates the result of the requested registration
   	authorization.  Additionally, the Diameter server may indicate a
   	collection of SIP capabilities that assists the Diameter client to
   	select a SIP proxy to the AOR under registration.

   	In addition to the values already defined in RFC 3588 [RFC3588], the
   	Result-Code AVP may contain one of the values defined in
   	Section 10.1.

   	Whenever the Diameter server fails to process the Diameter UAR
   	message, it MUST stop processing and return the relevant error in the
   	Diameter UAA message.  When there is success in the process, the
   	Diameter server MUST set the code to DIAMETER_SUCCESS in the Diameter
   	UAA message.

   	If the Diameter server requires a User-Name AVP value to process the
   	Diameter UAR request, but the Diameter UAR message did not contain a
   	User-Name AVP value, the Diameter server MUST set the Result-Code AVP
   	value to DIAMETER_USER_NAME_REQUIRED (see Section 10.1.2) and return
   	it in a Diameter UAA message.  Upon reception of this Diameter UAA
   	message with the Result-Code AVP value set to
   	DIAMETER_USER_NAME_REQUIRED, the SIP server typically requests
   	authentication by sending a SIP 401 (Unauthorized) or SIP 407 (Proxy
   	Authentication Required) response back to the originator.

   	When the authorization procedure succeeds, the Diameter server
   	constructs a User-Authorization-Answer (UAA) message that MUST
   	include (1) the address of the SIP server already assigned to the
   	user name, (2) the capabilities needed by the SIP server (Diameter
   	client) to select another SIP server for the user, or (3) a
   	combination of the previous two options.

   	If the Diameter server is already aware of a SIP server allocated to
   	the user, the Diameter UAA message contains the address of that SIP
   	server.

   	The Diameter UAA message contains the capabilities required by a SIP
   	server to trigger and execute services.  It is required that these
   	capabilities are present in the Diameter UAA message due to the
   	possibility that the Diameter client (in the SIP server) allocates a
   	different SIP server to trigger and execute services for that
   	particular user.

   	If a User-Name AVP is present in the Diameter UAR message, then the
   	Diameter server MUST verify the existence of the user in the realm,
   	i.e., the User-Name AVP value is a valid user within that realm.  If
   	the Diameter server does not recognize the user name received in the
   	User-Name AVP, the Diameter server MUST build a Diameter User-
   	Authorization-Answer (UAA) message and MUST set the Result-Code AVP
   	to DIAMETER_ERROR_USER_UNKNOWN.

   	If a User-Name AVP is present in the Diameter UAR message, then the
   	Diameter server MUST authorize that User-Name AVP value is able to
   	register the SIP or SIPS URI included in the SIP-AOR AVP.  If this
   	authorization fails, the Diameter server must set the Result-Code AVP
   	to DIAMETER_ERROR_IDENTITIES_DONT_MATCH and send it in a Diameter
   	User-Authorization-Answer (UAA) message.

      Note: Correlation between User-Name and SIP-AOR AVP values is
      required in order to avoid registration of a SIP-AOR allocated to
      another user.

   	If there is a SIP-Visited-Network-Id AVP in the Diameter UAR message,
   	and the SIP-User-Authorization-Type AVP value received in the
   	Diameter UAR message is set to REGISTRATION or REGISTRATION&
   	CAPABILITIES, then the Diameter server SHOULD verify whether the user
   	is allowed to roam into the network specified in the
   	SIP-Visited-Network-Id AVP in the Diameter UAR message.  If the user
   	is not allowed to roam into that network, the Diameter AAA server
   	MUST set the Result-Code AVP value in the Diameter UAA message to
   	DIAMETER_ERROR_ROAMING_NOT_ALLOWED.

   	If the SIP-User-Authorization-Type AVP value received in the Diameter
   	UAR message is set to REGISTRATION or REGISTRATION&CAPABILITIES, then
   	the Diameter server SHOULD verify whether the SIP-AOR AVP value is
   	authorized to register in the Home Realm.  Where the SIP AOR is not
   	authorized to register in the Home Realm, the Diameter server MUST
   	set the Result-Code AVP to DIAMETER_AUTHORIZATION_REJECTED and send
   	it in a Diameter UAA message.

   	When the SIP-User-Authorization-Type AVP is not present in the
   	Diameter UAR message, or when it is present and its value is set to
   	REGISTRATION, then:

   	o  	If the Diameter server is not aware of any previous registration
      	of the user name (including registrations of other SIP AORs
      	allocated to the same user name), then the Diameter server does
      	not know of any SIP server allocated to the user.  In this case,
      	the Diameter server MUST set the Result-Code AVP value to
      	DIAMETER_FIRST_REGISTRATION in the Diameter UAA message, and the
      	Diameter server SHOULD include the required SIP server
      	capabilities in the SIP-Server-Capabilities AVP value in the
      	Diameter UAA message.  The SIP-Server-Capabilities AVP assists the
      	Diameter client (SIP server) to select an appropriate SIP server
      	for the user, according to the required capabilities.

   	o  	In some cases, the Diameter server is aware of a previously
      	assigned SIP server for the same or different SIP AORs allocated
      	to the same user name.  In these cases, re-assignment of a new SIP
		server may or may not be needed, depending on the capabilities of
      	the SIP server.  The Diameter server MUST always include the
      	allocated SIP server URI in the SIP-Server-URI AVP of the UAA
      	message.  If the Diameter server does not return the SIP
      	capabilities, the Diameter server MUST set the Result-Code AVP in
      	the Diameter UAA message to DIAMETER_SUBSEQUENT_REGISTRATION.
      	Otherwise (i.e., if the Diameter server includes a
      	SIP-Server-Capabilities AVP), then the Diameter server MUST set
      	the Result-Code AVP in the Diameter UAA message to
      	DIAMETER_SERVER_SELECTION.  Then the Diameter client determines,
      	based on the received information, whether it needs to select a
      	new SIP server.

   	When the SIP-User-Authorization-Type AVP value received in the
   	Diameter UAR message is set to REGISTRATION&CAPABILITIES, then
   	Diameter Server MUST return the list of capabilities in the
   	SIP-Server-Capabilities AVP value of the Diameter UAA message, it
   	MUST set the Result-Code to DIAMETER_SUCCESS, and it MUST NOT return
   	a SIP-Server-URI AVP.  The SIP-Server-Capabilities AVP enables the
   	SIP server (Diameter client) to select another appropriate SIP server
   	for invoking and executing services for the user, depending on the
   	required capabilities.  The Diameter server MAY leave the list of
   	capabilities empty to indicate that any SIP server can be selected.

   	When the SIP-User-Authorization-Type AVP value received in the
   	Diameter UAR message is set to DEREGISTRATION, then:

   	o  	If the Diameter server is aware of a SIP server assigned to the
      	SIP AOR under deregistration, the Diameter server MUST set the
      	Result-Code AVP to DIAMETER_SUCCESS and MUST set the
      	SIP-Server-URI AVP value to the known SIP server, and return them
      	in the Diameter UAA message.

   	o  	If the Diameter server is not aware of a SIP server assigned to
      	the SIP AOR under deregistration, then the Diameter server MUST
      	set the Result-Code AVP in the Diameter UAA message to
      	DIAMETER_ERROR_IDENTITY_NOT_REGISTERED.

   	The Message Format of the UAA command is as follows:

    <UAA> ::= < Diameter Header: 283, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Result-Code }
                 { Origin-Host }
                 { Origin-Realm }
                 [ SIP-Server-URI ]
                 [ SIP-Server-Capabilities ]
                 [ Authorization-Lifetime ]
                 [ Auth-Grace-Period ]
                 [ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 6, commandCode = 283, request = false, proxyable = true, name="User-Authorization-Answer")
public interface UserAuthorizationAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	String getSIPServerURI();
	
	void setSIPServerURI(String value);	
	
	SIPServerCapabilities getSIPServerCapabilities();
	
	void setSIPServerCapabilities(SIPServerCapabilities value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);	
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);		
}