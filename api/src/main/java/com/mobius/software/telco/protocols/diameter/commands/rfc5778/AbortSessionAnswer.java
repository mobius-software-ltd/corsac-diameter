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
 * 	16a.4.8	ASA Command
	The Abort-Session-Answer (ASA) command, defined in IETF RFC 6733 (Diameter Base) [111], is indicated by the Command-Code set to 274 and the message flags’ ‘R’ bit clear, is sent in response to the ASR.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate optional AVPs for Gi/Sgi or modified existing AVPs.
	Message Format:
	<ASA>  ::= < Diameter Header: 274, PXY >
                 	< Session-Id >
                 	{ Result-Code }
                 	{ Origin-Host }
                 	{ Origin-Realm }
                 	[ User-Name ]
                 	[ Origin-State-Id ]
                 	[ Experimental-Result ]
                 	[ Error-Message ]
                 	[ Error-Reporting-Host ]
                  	[ Failed-AVP ]
                 *	[ Redirected-Host ]
                 	[ Redirected-Host-Usage ]
                 	[ Redirect-Max-Cache-Time ]
                 *	[ Proxy-Info ]
                 *	[ AVP ]

	The Experimental-Result AVP contains an Experimental-Result-Code AVP and will signal to the Diameter server that the IP-CAN bearer (e.g. PDP context) has been succesfully terminated as requested. See subclause 16a.6 for the description of the Experimental-Result-Code AVP.
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 274, request = false, proxyable = true, name="Abort-Session-Answer")
public interface AbortSessionAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer
{	
}