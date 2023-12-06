package com.mobius.software.telco.protocols.diameter.commands.rfc5778;
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
 * 	16a.4.5	STR Command
	The STR command, defined in IETF RFC 6733 (Diameter Base) [111], is indicated by the Command-Code field set to 275 and the ‘R’ bit set in the Command Flags field. It is sent by the GGSN/P-GW to the Diameter server to terminate a DIAMETER session corresponding to an IP-CAN session of a certain user.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	Message Format:
	<ST-Request> ::= < Diameter Header: 275, REQ, PXY >
                      	< Session-Id >
                      	{ Origin-Host }
                      	{ Origin-Realm }
                      	{ Destination-Realm }
                      	{ Auth-Application-Id }
                      	{ Termination-Cause }
                      	[ User-Name ]
                      	[ Destination-Host ]
                      *	[ Class ]
                      	[ Origin-State-Id ]
                      *	[ Proxy-Info ]
                      *	[ Route-Record ]
                      *	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 275, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest
{
}