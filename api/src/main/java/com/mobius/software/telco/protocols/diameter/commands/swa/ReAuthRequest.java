package com.mobius.software.telco.protocols.diameter.commands.swa;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	4.2.2.4.1	Re-Auth-Request (RAR) Command
	The Diameter Re-Auth-Request (RAR) command, indicated by the Command-Code field set to 258 and the "R" bit set in the Command Flags field, shall be sent from a 3GPP AAA server to an untrusted non-3GPP access network NAS. ABNF for the RAR command shall be as follows:

	< Re-Auth-Request >  ::=	< Diameter Header: 258, REQ, PXY, 16777250 >
			 < Session-Id >
			 [ DRMP ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 { Destination-Host }
			 { Auth-Application-Id }
			 { Re-Auth-Request-Type }
			 [ User-Name ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.STA, commandCode = CommandCodes.REAUTH, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends com.mobius.software.telco.protocols.diameter.commands.sta.ReAuthRequest
{
}