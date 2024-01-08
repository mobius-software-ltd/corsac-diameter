package com.mobius.software.telco.protocols.diameter.commands.pc2;
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
 * 	6.6.4	ProXimity-Application-Request (XAR) command
	The XAR command, indicated by the Command-Code field set to 8388727 and the 'R' bit set in the Command Flags field, is sent by the ProSe Application Server to the ProSe Function as part of the discovery authorization update procedure.
	Message Format:

	<XA-Request> ::= <Diameter Header: 8388727, REQ, PXY >
				 < Session-Id >
				 { Auth-Application-Id }
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 [ Destination-Host ]
				 [ Origin-State-Id ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				 { ProSe-Request-Type }
				 [ Requesting-RPAUID ]
				*[ Banned-User-Target}
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777350, commandCode = 8388727, request = true, proxyable = true, name="XA-Request")
public interface ProXimityApplicationRequest extends Pc2Request
{
}