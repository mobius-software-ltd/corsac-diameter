package com.mobius.software.telco.protocols.diameter.commands.gqtag;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.1.5 Session-Termination-Request (STR) command
	The STR command, indicated by the Command-Code field set to 275 and the 'R' bit set in the Command Flags field, is
	sent by the AF to inform the SPDF that an authorized session shall be terminated.
	Message Format:

	<ST-Request> ::= < Diameter Header: 275, REQ, PXY >
			  < Session-Id >
			  { Origin-Host }
			  { Origin-Realm }
			  { Destination-Realm }
			  { Termination-Cause }
			  { Auth-Application-Id }
			  [ Destination-Host ]
			 *[ Class ] 
			  [ Origin-State-Id ]
			 *[ Proxy-Info ]
			 *[ Route-Record ]
			 *[ AVP ] 
*/
@DiameterCommandDefinition(applicationId = 16777222, commandCode = 275, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends com.mobius.software.telco.protocols.diameter.commands.gq.SessionTerminationRequest
{
}