package com.mobius.software.telco.protocols.diameter.commands.sgmb;
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
 * 	20.4.5	Abort-Session-Request Command
	The Abort-Session-Request (ASR) command, defined in IETF RFC 6733 (DIAMETER BASE) [111], is indicated by the Command-Code set to 274 and the message flags’ ‘R’ bit set, is sent by the BM-SC to the MBMS GW to request that the session identified by the Session-Id be stopped.
	The relevant AVPs that are of use for the SGmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for SGmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	Message Format
      
    <ASR>  ::= 	< Diameter Header: 274, REQ, PXY >
                 	< Session-Id >
                 	{ Origin-Host }
                 	{ Origin-Realm }
                 	{ Destination-Realm }
                 	{ Destination-Host }
                 	{ Auth-Application-Id }
                 	[ Origin-State-Id ]
                 *	[ Proxy-Info ]
                 *	[ Route-Record ]
                 	[ Restart-Counter ]
 */
@DiameterCommandDefinition(applicationId = 16777292, commandCode = 274, request = true, proxyable = true, name="Abort-Session-Request")
public interface AbortSessionRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest
{
	Long getRestartCounter();
	
	void setRestartCounter(Long value);	
}