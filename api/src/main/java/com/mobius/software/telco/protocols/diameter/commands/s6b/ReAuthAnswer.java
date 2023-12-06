package com.mobius.software.telco.protocols.diameter.commands.s6b;
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
 * 	9.2.2.6.2	Re-Auth-Answer (RAA) Command
	The Diameter Re-Auth-Answer (ASA) command shall be indicated by the Command-Code field set to 258 and the "R" bit cleared in the Command Flags field and is sent from a PDN-GW to a 3GPP AAA Server or 3GPP AAA Proxy. The ABNF for the RAA commands shall be as follows:

	< Re-Auth-Answer >  ::=	< Diameter Header: 258, PXY, 16777272 >
				 < Session-Id >
				 [ DRMP ]
				 { Result-Code }
				 { Origin-Host }
				 { Origin-Realm }
				 [ User-Name ]
				...
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777272, commandCode = 258, request = false, proxyable = true, name="Re-Auth-Answer")
public interface ReAuthAnswer extends S6bAnswer
{	
}