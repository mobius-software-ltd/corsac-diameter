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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAccountingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserData;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.  Server-Assignment-Answer (SAA) Command

   	The Server-Assignment-Answer (SAA) is indicated by the Command-Code
   	set to 284 and the Command Flags' 'R' bit cleared.  The Diameter
   	server sends this command in response to a previously received
   	Diameter Server-Assignment-Request (SAR) command.  The response may
   	include the user profile or part of it, if requested.

   	In addition to the values already defined in RFC 3588 [RFC3588], the
   	Result-Code AVP may contain one of the values defined in
   	Section 10.1.

   	The Result-Code AVP value in the Diameter SAA message may indicate a
   	success or an error in the execution of the Diameter SAR command.  If
   	Result-Code AVP value in the Diameter SAA message does not contain an
   	error code, the SAA message MAY include one or more SIP-User-Data
   	AVPs that typically contain the profile of the user, indicating
   	services that the SIP server can provide to that user.

   	The Diameter server MAY include one or more
   	SIP-Supported-User-Data-Type AVPs, each one identifying a type of
   	user data format supported in the Diameter server.  If there is not a
   	common supported user data type between the Diameter client and the
   	Diameter server, the Diameter server SHOULD declare its list of
   	supported user data types by including one or more
   	SIP-Supported-User-Data-Type AVPs in a Diameter SAA message.  This
   	indication is merely for debugging reasons, since there is not a
   	fallback mechanism that allows the Diameter client to retrieve the
   	profile in a supported format.

   	If the Diameter server requires a User-Name AVP value to process the
   	Diameter SAR request, but the Diameter SAR message did not contain a
   	User-Name AVP value, the Diameter server MUST set the Result-Code AVP
   	value to DIAMETER_USER_NAME_REQUIRED (see Section 10.1.2) and return
   	it in a Diameter SAA message.  Upon reception of this Diameter SAA
   	message with the Result-Code AVP value set to
   	DIAMETER_USER_NAME_REQUIRED, the SIP server typically requests
   	authentication by generating a SIP 401 (Unauthorized) or SIP 407
   	(Proxy Authentication Required) response back to the originator.

   	If the User-Name AVP is included in the Diameter SAR message, upon
   	reception of the Diameter SAR message, the Diameter server MUST
   	verify the existence of the user in the realm, i.e., the User-Name
   	AVP value is a valid user within that realm.  If the Diameter server
   	does not recognize the user name received in the User-Name AVP, the
   	Diameter server MUST build a Diameter Server-Assignment-Answer (SAA)
   	message and MUST set the Result-Code AVP to
   	DIAMETER_ERROR_USER_UNKNOWN.

   	Then the Diameter server MUST authorize that User-Name AVP value is a
   	valid authentication name for the SIP or SIPS URI included in the
   	SIP-AOR AVP of the Diameter SAR message.  If this authorization
   	fails, the Diameter server must set the Result-Code AVP to
   	DIAMETER_ERROR_IDENTITIES_DONT_MATCH and send it in a Diameter
   	Server-Assignment-Answer (SAA) message.

   	After successful execution of the Diameter SAR command, the Diameter
   	server MUST clear the "authentication pending" flag and SHOULD move
   	the temporarily stored SIP server URI to permanent storage.

   	The actions of the Diameter server upon reception of the Diameter SAR
   	message depend on the value of the SIP-Server-Assignment-Type:

   	o  	If the SIP-Server-Assignment-Type AVP value in the Diameter SAR
      	message is set to REGISTRATION or RE_REGISTRATION, the Diameter
      	server SHOULD verify that there is only one SIP-AOR AVP.
      	Otherwise, the Diameter server MUST answer with a Diameter SAA
      	message with the Result-Code AVP value set to
      	DIAMETER_AVP_OCCURS_TOO_MANY_TIMES and MUST NOT include any
      	SIP-User-Data AVP.  If there is only one SIP-AOR AVP and if the
      	SIP-User-Data-Already-Available AVP value is set to
      	USER_DATA_NOT_AVAILABLE, then the Diameter server SHOULD include
      	one or more user profile data with the SIP or SIPS URI (SIP-AOR
      	AVP) and all other SIP identities associated with that AVP in the
      	SIP-User-Data AVP value of the Diameter SAA message.  On selecting
      	the type of user data, the Diameter server SHOULD take into
      	account the supported formats at the SIP server
      	(SIP-Supported-User-Data-Type AVP in the SAR message) and the
      	local policy.  Additionally, the Diameter server MUST set the
      	Result-Code AVP value to DIAMETER_SUCCESS in the Diameter SAA
      	message.  The Diameter server considers the SIP AOR authenticated
      	and registered.

   	o  	If the SIP-Server-Assignment-Type AVP value in the Diameter SAR
      	message is set to UNREGISTERED_USER, then the Diameter server MUST
      	store the SIP server address included in the SIP-Server-URI AVP
      	value.  The Diameter server will return the SIP server address in
      	Diameter Location-Info-Answer (LIA) messages.  If the
      	SIP-User-Data-Already-Available AVP value is set to
      	USER_DATA_NOT_AVAILABLE, then the Diameter server SHOULD include
      	one or more user profile data associated with the SIP or SIPS URI
      	(SIP-AOR AVP) and associated identities in the SIP-User-Data AVP
      	value of the Diameter SAA message.  On selecting the type of user
      	data, the Diameter server SHOULD take into account the supported
      	formats at the SIP server (SIP-Supported-User-Data-Type AVP in the
      	SAR message) and the local policy.  The Diameter server MUST set
      	the Result-Code AVP value to DIAMETER_SUCCESS.  The Diameter
      	server considers the SIP AOR UNREGISTERED, but with a SIP server
      	allocated to trigger and provide services for unregistered users.
      	Note that in case of UNREGISTERED_USER (SIP-Server-Assignment-Type
      	AVP), the Diameter server MUST verify that there is only one
      	SIP-AOR AVP.  Otherwise, the Diameter server MUST answer the
      	Diameter SAR message with a Diameter SAA message, and it MUST set
      	the Result-Code AVP value to DIAMETER_AVP_OCCURS_TOO_MANY_TIMES
      	and MUST NOT include any SIP-User-Data AVP.
      	If the User-Name AVP was not present in the Diameter SAR message
      	and the SIP-AOR is not known for the Diameter server, the Diameter
      	server MUST NOT include a User-Name AVP in the Diameter SAA
      	message and MUST set the Result-Code AVP value to
      	DIAMETER_ERROR_USER_UNKNOWN.

   	o  	If the SIP-Server-Assignment-Type AVP value in the Diameter SAR
      	message is set to TIMEOUT_DEREGISTRATION, USER_DEREGISTRATION,
      	DEREGISTRATION_TOO_MUCH_DATA, or ADMINISTRATIVE_DEREGISTRATION,
      	the Diameter server MUST clear the SIP server address associated
      	with all SIP AORs indicated in each of the SIP-AOR AVP values
      	included in the Diameter SAR message.  The Diameter server
      	considers all of these SIP AORs as not registered.  The Diameter
      	server MUST set the Result-Code AVP value to DIAMETER_SUCCESS in
      	the Diameter SAA message.

   	o  	If the SIP-Server-Assignment-Type AVP value in the Diameter SAR
      	message is set to TIMEOUT_DEREGISTRATION_STORE_SERVER_NAME or
      	USER_DEREGISTRATION_STORE_SERVER_NAME, the Diameter server MAY
      	keep the SIP server address associated with the SIP AORs included
      	in the SIP-AOR AVP values of the Diameter SAR message, even though
      	the SIP AORs become unregistered.  This feature allows a SIP
      	server to request that the Diameter server remain an assigned SIP
      	server for those SIP AORs (SIP-AOR AVP values) allocated to the
      	same user name, and avoid SIP server assignment.  The Diameter
      	server MUST consider all these SIP AORs as not registered.  If the
      	Diameter server honors the request of the Diameter client (SIP
      	server) to remain as an allocated SIP server, then the Diameter
      	server MUST keep the SIP server assigned to those SIP AORs
      	allocated to the username and MUST set the Result-Code AVP value
      	to DIAMETER_SUCCESS in the Diameter SAA message.  Otherwise, when
      	the Diameter server does not honor the request of the Diameter
      	client (SIP server) to remain as an allocated SIP server, the
      	Diameter server MUST clear the SIP server name assigned to those
      	SIP AORs and it MUST set the Result-Code AVP value to
      	DIAMETER_SUCCESS_SERVER_NAME_NOT_STORED in the Diameter SAA
      	message.

   	o  	If the SIP-Server-Assignment-Type AVP value in the Diameter SAR
      	message is set to NO_ASSIGNMENT, the Diameter server SHOULD first
      	verify that the SIP-Server-URI AVP value in the Diameter SAR
      	message is the same URI as the one assigned to the SIP-AOR AVP
      	value.  If they differ, then the Diameter server MUST set the
      	Result-Code AVP value to DIAMETER_UNABLE_TO_COMPLY in the Diameter
      	SAA message.  Otherwise, if the SIP-User-Data-Already-Available
      	AVP value is set to USER_DATA_NOT_AVAILABLE, then the Diameter
      	server SHOULD include the user profile data with the SIP or SIPS
      	URI (SIP-AOR AVP) and all other SIP identities associated with
      	that AVP in the SIP-User-Data AVP value of the Diameter SAA
      	message.  On selecting the type of user data, the Diameter server
      	SHOULD take into account the supported formats at the SIP server
      	(SIP-Supported-User-Data-Type AVP in the SAR message) and the
      	local policy.

   	o  	If the SIP-Server-Assignment-Type AVP value in the Diameter SAR
      	message is set to AUTHENTICATION_FAILURE or
      	AUTHENTICATION_TIMEOUT, the Diameter server MUST verify that there
      	is exactly one SIP-AOR AVP in the Diameter SAR message.  If the
      	number of occurrences of the SIP-AOR AVP is not exactly one, the
      	Diameter server MUST set the Result-Code AVP value to
      	DIAMETER_AVP_OCCURS_TOO_MANY_TIMES in the Diameter SAA message,
      	and SHOULD not take further actions.  If there is exactly one
      	SIP-AOR AVP in the Diameter SAR message, the Diameter server MUST
      	clear the address of the SIP server assigned to the SIP AOR
      	allocated to the user name, and the Diameter server MUST set the
      	Result-Code AVP value to DIAMETER_SUCCESS in the Diameter SAA
      	message.  The Diameter server MUST consider the SIP AOR as not
      	registered.

   	The Message Format of the SAA command is as follows:

    <SAA> ::= < Diameter Header: 284, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Result-Code }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
               * [ SIP-User-Data ]
                 [ SIP-Accounting-Information ]
               * [ SIP-Supported-User-Data-Type ]
                 [ User-Name ]
                 [ Auth-Grace-Period ]
                 [ Authorization-Lifetime ]
                 [ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SIP_APPLICATION, commandCode = CommandCodes.SERVER_ASSIGNMENT, request = false, proxyable = true, name="Server-Assignment-Answer")
public interface ServerAssignmentAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;	
	
	List<SIPUserData> getSIPUserData();
	
	void setSIPUserData(List<SIPUserData> value);	
	
	SIPAccountingInformation getSIPAccountingInformation();
	
	void setSIPAccountingInformation(SIPAccountingInformation value);		
	
	List<String> getSIPSupportedUserDataType();
	
	void setSIPSupportedUserDataType(List<String> value);		
	    		  
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);	
}