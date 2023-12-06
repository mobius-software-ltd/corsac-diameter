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
 * 	7.1.7 Abort-Session-Request (ASR) command
	The ASR command, indicated by the Command-Code field set to 274 and the 'R' bit set in the Command Flags field, is
	sent by the SPDF to inform the AF that all bearer resources for the authorized session have become unavailable.
	Message Format:

	<AS-Request> ::= < Diameter Header: 274, REQ, PXY >
			  < Session-Id >
			  { Origin-Host }
			  { Origin-Realm }
			  { Destination-Realm }
			  { Destination-Host }
			  { Auth-Application-Id }
			  { Abort-Cause }
			  [ Origin-State-Id ]
			 *[ Proxy-Info ]
			 *[ Route-Record ]
			  [ AVP ] 
 */
@DiameterCommandDefinition(applicationId = 16777222, commandCode = 274, request = true, proxyable = true, name="Abort-Session-Request")
public interface AbortSessionRequest extends com.mobius.software.telco.protocols.diameter.commands.gq.AbortSessionRequest
{		
}