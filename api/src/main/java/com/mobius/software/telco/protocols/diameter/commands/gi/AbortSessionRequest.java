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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	16a.4.7	ASR Command
	The Abort-Session-Request (ASR) command, defined in IETF RFC 6733 (Diameter Base) [111], is indicated by the Command-Code set to 274 and the message flags’ ‘R’ bit set, is sent by the Diameter server to the GGSN to request that the PDP Context identified by the 3GPP-NSAPI AVP is to be terminated. The absence of the 3GPP-NSAPI AVP will indicate to the GGSN that all the PDP contexts for this particular user and sharing the same user session need to be deleted.  Similarly, for P-GW, the ASR command is sent by the Diamater server to the P-GW to request that the EPS bearer identified by the 3GPP-NSAPI AVP is to be terminated. In the absence of the 3GPP-NSAPI AVP or if the value of 3GPP-NSAPI AVP points to the default EPS bearer, the P-GW shall terminate the IP-CAN session associated with the same user session.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate optional AVPs for Gi/Sgi, or modified existing AVPs.
	Message Format:
	<ASR>  ::= < Diameter Header: 274, REQ, PXY >
                 	< Session-Id >
                 	{ Origin-Host }
                 	{ Origin-Realm }
                 	{ Destination-Realm }
                 	{ Destination-Host }
                 	{ Auth-Application-Id }
                 	[ Origin-State-Id ]
                 *	[ Proxy-Info ]
                 	[ 3GPP-NSAPI ]
                 *	[ Route-Record ]
                 *	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NASREQ, commandCode = CommandCodes.ABORT_SESSION, request = true, proxyable = true, name="Abort-Session-Request")
public interface AbortSessionRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest
{
	ByteBuf getTGPPNSAPI();
	
	void setTGPPNSAPI(ByteBuf value);	
}