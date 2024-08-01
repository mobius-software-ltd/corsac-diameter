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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthDataItem;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.8.  Multimedia-Auth-Answer (MAA) Command

   	The Multimedia-Auth-Answer (MAA) is indicated by the Command-Code set
   	to 286 and the Command Flags' 'R' bit cleared.  The Diameter server
   	sends this command in response to a previously received Diameter
   	Multimedia-Auth-Request (MAR) command.

   	In addition to the values already defined in RFC 3588 [RFC3588], the
   	Result-Code AVP may contain one of the values defined in
   	Section 10.1.

   	If the Diameter server requires a User-Name AVP value to process the
   	Diameter MAR request, but the Diameter MAR message did not contain a
   	User-Name AVP value, the Diameter server MUST set the Result-Code AVP
   	value to DIAMETER_USER_NAME_REQUIRED (see Section 10.1.2) and return
   	it in a Diameter MAA message.  The Diameter server MAY include a
   	SIP-Number-Auth-Items AVP and one or more SIP-Auth-Data-Item AVPs
   	with authentication information (e.g., a challenge).  Upon reception
   	of this Diameter MAA message with the Result-Code AVP value set to
   	DIAMETER_USER_NAME_REQUIRED, the SIP server typically requests
   	authentication by generating a SIP 401 (Unauthorized) or SIP 407
   	(Proxy Authentication Required) response back to the originator.

   	If the User-Name AVP is present in the Diameter MAR message, the
   	Diameter server MUST verify the existence of the user in the realm,
   	i.e., the User-Name AVP value is a valid user within that realm.  If
   	the Diameter server does not recognize the user name received in the
   	User-Name AVP, the Diameter server MUST build a Diameter
   	Multimedia-Auth-Answer (MAA) message and MUST set the Result-Code AVP
   	to DIAMETER_ERROR_USER_UNKNOWN.

   	If the SIP-Methods AVP value of the Diameter MAR message is set to
   	REGISTER and a User-Name AVP is present, then the Diameter server
   	MUST authorize that User-Name AVP value is able to use the URI
   	included in the SIP-AOR AVP.  If this authorization fails, the
   	Diameter server must set the Result-Code AVP to
   	DIAMETER_ERROR_IDENTITIES_DONT_MATCH and send it in a Diameter
   	Multimedia-Auth-Answer (MAA) message.

	Note: Correlation between User-Name and SIP-AOR AVP values is only
    required for SIP REGISTER request, to prevent a user from
    registering a SIP-AOR allocated to another user.  In other types
    of SIP requests (e.g., INVITE), the SIP-AOR indicates the intended
    destination of the request, rather than the originator of it.

   	The Diameter server MUST verify whether the authentication scheme
   	(SIP-Authentication-Scheme AVP value) indicated in the grouped
   	SIP-Auth-Data-Item AVP is supported or not.  If that authentication
   	scheme is not supported, then the Diameter server MUST set the
   	Result-Code AVP to DIAMETER_ERROR_AUTH_SCHEME_NOT_SUPPORTED and send
   	it in a Diameter Multimedia-Auth-Answer (MAA) message.

   	If the SIP-Number-Auth-Items AVP is present in the Diameter MAR
   	message, it indicates the number of authentication data items that
   	the Diameter client is requesting.  It is RECOMMENDED that the
   	Diameter server, when building the Diameter MAA message, includes a
   	number of SIP-Auth-Data-Item AVPs that are a subset of the
   	authentication data items requested by the Diameter client in the
   	SIP-Number-Auth-Items AVP value of the Diameter MAR message.

   	If the SIP-Server-URI AVP is present in the Diameter MAR message,
   	then the Diameter server MUST compare the stored SIP server (assigned
   	to the user) with the SIP-Server-URI AVP value (received in the
   	Diameter MAR message).  If they don't match, the Diameter server MUST
   	temporarily save the newly received SIP server assigned to the user,
   	and MUST set an "authentication pending" flag for the user.  If they
   	match, the Diameter server shall clear the "authentication pending"
   	flag for the user.

   	In any other situation, if there is a success in processing the
   	Diameter MAR command and the Diameter server stored the
   	SIP-Server-URI, the Diameter server MUST set the Result-Code AVP
   	value to DIAMETER_SUCCESS and return it in a Diameter MAA message.

   	If there is a success in processing the Diameter MAR command, but the
   	Diameter server does not store the SIP-Server-URI because the AVP was
   	not present in the Diameter MAR command, then the Diameter server
   	MUST set the Result-Code AVP value to either:

   	1.  DIAMETER_SUCCESS_AUTH_SENT_SERVER_NOT_STORED, if the Diameter
       	server is sending authentication credentials to create a
       	challenge.

   	2.  DIAMETER_SUCCESS_SERVER_NAME_NOT_STORED, if the Diameter server
       	successfully authenticated the user and authorized the SIP server
       	to proceed with the SIP request.

   	Otherwise, the Diameter server MUST set the Result-Code AVP value to
   	DIAMETER_UNABLE_TO_COMPLY, and it MUST NOT include any
   	SIP-Auth-Data-Item AVP.

   	The Message Format of the MAA command is as follows:

    <MAA> ::= < Diameter Header: 286, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Result-Code }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ User-Name ]
                 [ SIP-AOR ]
                 [ SIP-Number-Auth-Items ]
               * [ SIP-Auth-Data-Item ]
                 [ Authorization-Lifetime ]
                 [ Auth-Grace-Period ]
                 [ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SIP_APPLICATION, commandCode = CommandCodes.MULTIMEDIA_AUTH, request = false, proxyable = true, name="Multimedia-Auth-Answer")
public interface MultimediaAuthAnswer extends AuthenticationAnswer
{
	String getSIPAOR();
	
	void setSIPAOR(String value);	
	
	Long getSIPNumberAuthItems();
	
	void setSIPNumberAuthItems(Long value);	
	
	List<SIPAuthDataItem> getSIPAuthDataItem();
	
	void setSIPAuthDataItem(List<SIPAuthDataItem> value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);		
}