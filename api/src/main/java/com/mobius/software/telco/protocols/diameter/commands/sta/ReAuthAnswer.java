package com.mobius.software.telco.protocols.diameter.commands.sta;
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
 * 	5.2.2.3.2	Re-Auth-Answer (RAA) Command
	The Diameter Re-Auth-Answer (ASA) command, indicated by the Command-Code field set to 258 and the "R" bit cleared in the Command Flags field, is sent from a Trusted Non-3GPP access network to a 3GPP AAA Server/Proxy. ABNF for the RAA commands is as follows:

	< Re-Auth-Answer >  ::=	< Diameter Header: 258, PXY, 16777250 >
			 < Session-Id >
			 [ DRMP ]
			 { Result-Code }
			 { Origin-Host }
			 { Origin-Realm }
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.STA, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Answer")
public interface ReAuthAnswer extends StaAnswer,com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer
{	
}