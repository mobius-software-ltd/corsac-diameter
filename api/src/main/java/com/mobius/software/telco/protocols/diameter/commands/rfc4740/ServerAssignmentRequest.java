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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserDataAlreadyAvailableEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.3.  Server-Assignment-Request (SAR) Command

   	The Server-Assignment-Request (SAR) command is indicated by the
   	Command-Code set to 284 and the Command Flags' 'R' bit set.  The
   	Diameter client in a SIP server sends this command to the Diameter
   	server to indicate the completion of the authentication process and
   	to request that the Diameter server store the URI of the SIP server
   	that is currently serving the user.  The main functions of the
   	Diameter SAR command are to inform the Diameter server of the URI of
   	the SIP server allocated to the user, and to store or clear it from
   	the Diameter server.  Additionally, the Diameter client can request
   	to download the user profile or part of it.

   	During the registration procedure, a SIP server becomes assigned to
   	the user.  The Diameter client in the assigned SIP server MUST
   	include its own URI in the SIP-Server-URI AVP of the
   	Server-Assignment-Request (SAR) Diameter message and send it to the
   	Diameter server.  The Diameter server then becomes aware of the
   	allocation of the SIP server to the user name and the server's URI.

   	The Diameter client in the SIP server MAY send a Diameter SAR message
   	because of other reasons.  These reasons are identified in the
   	SIP-Server-Assignment-Type AVP (Section 9.4) value.  For instance, a
   	Diameter client in a SIP server may contact the Diameter server to
   	request deregistration of a user, to inform the Diameter server of an
   	authentication failure, or just to download the user profile.  For a
   	complete description of all the SIP-Server-Assignment-Type AVP
   	values, see Section 9.4.

   	Typically the reception of a SIP REGISTER request in a SIP server
   	will trigger the Diameter client in the SIP server to send the
   	Diameter SAR message.  However, if a SIP server is receiving other
   	SIP request, such as INVITE, and the SIP server does not have the
   	user profile, the Diameter client in the SIP server may send the
   	Diameter SAR message to the Diameter server in order to download the
   	user profile and make the Diameter server aware of the SIP server
   	assigned to the user.

   	The user profile is an important piece of information that dictates
   	the behavior of the SIP server when triggering or providing services
   	for the user.  Typically the user profile is divided into:

   	o  	Services to be rendered to the user when the user is registered
      	and initiates a SIP request.

   	o  	Services to be rendered to the user when the user is registered
      	and a SIP request destined to that user arrives to the SIP proxy.

   	o  	Services to be rendered to the user when the user is not
      	registered and a SIP request destined to that user arrives to the
      	SIP proxy.

   	The SIP-Server-Assignment-Type AVP indicates the reason why the
   	Diameter client (SIP server) contacted the Diameter server.  If the
   	Diameter client sets the SIP-Server-Assignment-Type AVP value to
   	REGISTRATION, RE_REGISTRATION, UNREGISTERED_USER, NO_ASSIGNMENT,
   	AUTHENTICATION_FAILURE or AUTHENTICATION_TIMEOUT, the Diameter client
   	MUST include exactly one SIP-AOR AVP in the Diameter SAR message.

   	The SAR message MAY contain zero or more SIP-Supported-User-Data-Type
   	AVPs.  Each of them contains a type of user data understood by the
   	SIP server.  This allows the Diameter client to provide an indication
   	to the Diameter server of the different format of user data
   	understood by the SIP server.  The Diameter server uses this
   	information to select one or more SIP-User-Data AVPs that will be
   	included in the SAA message.

   	The Message Format of the SAR command is as follows:

    <SAR> ::= < Diameter Header: 284, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { SIP-Server-Assignment-Type }
                 { SIP-User-Data-Already-Available }
                 [ Destination-Host ]
                 [ User-Name ]
                 [ SIP-Server-URI ]
               * [ SIP-Supported-User-Data-Type ]
               * [ SIP-AOR ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 6, commandCode = 284, request = true, proxyable = true, name="Server-Assignment-Request")
public interface ServerAssignmentRequest extends AuthenticationRequest
{
	SIPServerAssignmentTypeEnum getSIPServerAssignmentType();
	
	void setSIPServerAssignmentType(SIPServerAssignmentTypeEnum value);
	
	SIPUserDataAlreadyAvailableEnum getSIPUserDataAlreadyAvailable();
	
	void setSIPUserDataAlreadyAvailable(SIPUserDataAlreadyAvailableEnum value);
	
	String getSIPServerURI();
	
	void setSIPServerURI(String value);
	
	List<String> getSIPSupportedUserDataType();
	
	void setSIPSupportedUserDataType(List<String> value);
	
	List<String> getSIPAOR();
	
	void setSIPAOR(List<String> value);		
}