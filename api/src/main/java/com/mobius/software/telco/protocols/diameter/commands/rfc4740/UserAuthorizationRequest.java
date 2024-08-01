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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserAuthorizationTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.1.  User-Authorization-Request (UAR) Command

   	The User-Authorization-Request (UAR) is indicated by the Command-Code
   	set to 283 and the Command Flags' 'R' bit set.  The Diameter client
   	in a SIP server sends this command to the Diameter server to request
   	authorization for the SIP User Agent to route a SIP REGISTER request.
   	Because the SIP REGISTER request implicitly carries a permission to
   	bind an AOR to a contact address, the Diameter client uses the
   	Diameter UAR as a first authorization request towards the Diameter
   	server to authorize the registration.  For instance, the Diameter
   	server can verify that the AOR is a legitimate user of the realm.

   	The Diameter client in the SIP server requests authorization for one
   	of the possible values defined in the SIP-User-Authorization-Type AVP
   	(Section 9.10).

   	The user name used for authentication of the user is conveyed in a
   	User-Name AVP (defined in the Diameter base protocol, RFC 3588
   	[RFC3588]).  The location of the authentication user name in the SIP
   
   	REGISTER request varies depending on the authentication mechanism.
   	When the authentication mechanism is HTTP Digest as defined in RFC
   	2617 [RFC2617], the authentication user name is found in the
   	"username" directive of the SIP Authorization header field value.
   	This Diameter SIP application only provides support for HTTP Digest
   	authentication in SIP; other authentication mechanisms are not
   	currently supported.

   	The SIP or SIPS URI to be registered is conveyed in the SIP-AOR AVP
   	(Section 9.8).  Typically this SIP or SIPS URI is found in the To
   	header field value of the SIP REGISTER request that triggered the
   	Diameter UAR message.

   	The SIP-Visited-Network-Id AVP indicates the network that is
   	providing SIP services (e.g., SIP proxy functionality or any other
   	kind of services) to the SIP User Agent.

   	The Message Format of the UAR command is as follows:

    <UAR> ::= < Diameter Header: 283, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { SIP-AOR }
                 [ Destination-Host ]
                 [ User-Name ]
                 [ SIP-Visited-Network-Id ]
                 [ SIP-User-Authorization-Type ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SIP_APPLICATION, commandCode = CommandCodes.USER_AUTHORIZATION, request = true, proxyable = true, name="User-Authorization-Request")
public interface UserAuthorizationRequest extends AuthenticationRequest
{
	
	String getSIPAOR();
	
	void setSIPAOR(String value) throws MissingAvpException;
	
	String getSIPVisitedNetworkId();
	
	void setSIPVisitedNetworkId(String value);
	
	SIPUserAuthorizationTypeEnum getSIPUserAuthorizationType();
	
	void setSIPUserAuthorizationType(SIPUserAuthorizationTypeEnum value);
}