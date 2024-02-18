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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.9.  Registration-Termination-Request (RTR) Command

   	The Registration-Termination-Request (RTR) command is indicated by
   	the Command-Code set to 287 and the Command Flags' 'R' bit set.  The
   	Diameter server sends this command to the Diameter client in a SIP
   	server to indicate to the SIP server that one or more SIP AORs have
   	to be deregistered.  The command allows an operator to
   	administratively cancel the registration of a user from a centralized
   	Diameter server.

   	The Diameter server has the capability to initiate the deregistration
   	of a user and inform the SIP server by means of the Diameter RTR
   	command.  The Diameter server can decide whether only one SIP AOR is
   	going to be deregistered, a list of SIP AORs, or all the SIP AORs
   	allocated to the user.

   	The absence of a SIP-AOR AVP in the Diameter RTR message indicates
   	that all the SIP AORs allocated to the user identified by the
   	User-Name AVP are being deregistered.

   	The Diameter server MUST include a SIP-Deregistration-Reason AVP
   	value to indicate the reason for the deregistration.

   	The Message Format of the RTR command is as follows:

    <RTR> ::= < Diameter Header: 287, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Host }
                 { SIP-Deregistration-Reason }
                 [ Destination-Realm ]
                 [ User-Name ]
               * [ SIP-AOR ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SIP_APPLICATION, commandCode = CommandCodes.REGISTRATION_TERMINATION, request = true, proxyable = true, name="Registration-Termination-Request")
public interface RegistrationTerminationRequest extends AuthenticationRequest
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;
	
	SIPDeregistrationReason getSIPDeregistrationReason();
	
	void setSIPDeregistrationReason(SIPDeregistrationReason value) throws MissingAvpException;	
	
	List<String> getSIPAOR();
	
	void setSIPAOR(List<String> value);		
}