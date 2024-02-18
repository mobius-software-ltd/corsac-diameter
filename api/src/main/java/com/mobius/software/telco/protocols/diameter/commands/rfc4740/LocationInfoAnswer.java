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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerCapabilities;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.6.  Location-Info-Answer (LIA) Command

   	The Location-Info-Answer (LIA) is indicated by the Command-Code set
   	to 285 and the Command Flags' 'R' bit cleared.  The Diameter server
   	sends this command in response to a previously received Diameter
   	Location-Info-Request (LIR) command.

   	In addition to the values already defined in RFC 3588 [RFC3588], the
   	Result-Code AVP may contain one of the values defined in
   	Section 10.1.  When the Diameter server finds an error in processing
   	the Diameter LIR message, the Diameter server MUST stop the process
   	of the message and answer with a Diameter LIA message that includes
   	the appropriate error code in the Result-Code AVP value.  When there
   	is no error, the Diameter server MUST set the Result-Code AVP value
   	to DIAMETER_SUCCESS in the Diameter LIA message.

   	One of the errors that the Diameter server may find is that the
   	SIP-AOR AVP value is not a valid user in the realm.  In such cases,
   	the Diameter server MUST set the Result-Code AVP value to
   	DIAMETER_ERROR_USER_UNKNOWN and return it in a Diameter LIA message.	

   	If the Diameter server cannot process the Diameter LIR command, e.g.,
   	due to a database error, the Diameter server MUST set the Result-Code
   	AVP value to DIAMETER_UNABLE_TO_COMPLY and return it in a Diameter
   	LIA message.  The Diameter server MUST NOT include any SIP-Server-URI
   	or SIP-Server-Capabilities AVP in the Diameter LIA message.

   	The Diameter server may or may not be aware of a SIP server assigned
   	to the SIP-AOR AVP value included in the Diameter LIR message.  If
   	the Diameter server is aware of a SIP server allocated to that
   	particular user, the Diameter server MUST include the URI of such SIP
   	server in the SIP-Server-URI AVP and return it in a Diameter LIA
   	message.  This is typically the situation when the user is either
   	registered, or unregistered but a SIP server is still assigned to the
   	user.

   	When the Diameter server is not aware of a SIP server allocated to
   	the user (typically the case when the user unregistered), the
   	Result-Code AVP value in the Diameter LIA message depends on whether
   	the Diameter server is aware that the user has services defined for
   	unregistered users:

   	o  	Those users who have services defined for unregistered users may
      	require the allocation of a SIP server to trigger and perhaps
      	execute those services.  Therefore, when the Diameter server is
      	not aware of an assigned SIP server, but the user has services
      	defined for unregistered users, the Diameter server MUST set the
      	Result-Code AVP value to DIAMETER_UNREGISTERED_SERVICE and return
      	it in a Diameter LIA message.  The Diameter server MAY also
      	include a SIP-Server-Capabilities AVP to facilitate the SIP server
      	(Diameter client) with the selection of an appropriate SIP server
      	with the required capabilities.  Absence of the SIP-Server-
      	Capabilities AVP indicates to the SIP server (Diameter client)
      	that any SIP server is suitable to be allocated for the user.

   	o  	Those users who do not have service defined for unregistered users
      	do not require further processing.  The Diameter server MUST set
      	the Result-Code AVP value to
      	DIAMETER_ERROR_IDENTITY_NOT_REGISTERED and return it to the
      	Diameter client in a Diameter LIA message.  The SIP server
      	(Diameter client) may return the appropriate SIP response (e.g.,
      	480 (Temporarily unavailable)) to the original SIP request.

   	The Message Format of the LIA command is as follows:

    <LIA> ::= < Diameter Header: 285, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Result-Code }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ SIP-Server-URI ]
                 [ SIP-Server-Capabilities ]
                 [ Auth-Grace-Period ]
                 [ Authorization-Lifetime ]
                 [ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SIP_APPLICATION, commandCode = CommandCodes.LOCATION_INFO, request = false, proxyable = true, name="Location-Info-Answer")
public interface LocationInfoAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;	
	
	String getSIPServerURI();
	
	void setSIPServerURI(String value);	
	
	SIPServerCapabilities getSIPServerCapabilities();
	
	void setSIPServerCapabilities(SIPServerCapabilities value);		
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);
}