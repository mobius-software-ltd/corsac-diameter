package com.mobius.software.telco.protocols.diameter.commands.gi;
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
 * 	16a.4.6	STA Command
	The STA command, defined in IETF RFC 6733 (Diameter Base) [111], is indicated by the Command-Code field set to 275 and the ‘R’ bit cleared in the Command Flags field. It is sent by the Diameter server to the GGSN/P-GW in response to an STR command.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	Message Format:
	<ST-Answer>  ::= < Diameter Header: 275, PXY >
                       	< Session-Id >
                       	{ Result-Code }
                       	{ Origin-Host }
                       	{ Origin-Realm }
                       	[ User-Name ]
                      *	[ Class ]
                       	[ Error-Message ]
                       	[ Error-Reporting-Host ]
                       	[ Failed-AVP ]
                       	[ Origin-State-Id ]
                      *	[ Redirect-Host ]
                       	[ Redirect-Host-Usage ]
                       	[ Redirect-Max-Cache-Time ]
                      *	[ Proxy-Info ]
                      *	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NASREQ, commandCode = CommandCodes.SESSION_TERMINATION, request = false, proxyable = true, name="Session-Termination-Answer")
public interface SessionTerminationAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationAnswer
{
}