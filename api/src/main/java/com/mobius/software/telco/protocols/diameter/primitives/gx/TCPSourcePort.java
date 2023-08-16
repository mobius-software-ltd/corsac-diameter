package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.129 TCP-Source-Port AVP (Non-3GPP-EPS access type)
	The TCP-Source-Port AVP (AVP Code 2843) is of type Unsigned32. When Untrusted WLAN over S2b access is
	supported as defined in Annex D.4, it contains the TCP source port number used for the IKEv2 tunnel in the case that a
	NAT and firewall are detected and the IKEv2 messages exchanged between the UE and the ePDG are transported using
	the firewall traversal tunnel as described in 3GPP TS 24.302 [59]. 
 */
@DiameterAvpDefinition(code = 2843L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "TCP-Source-Port")
public interface TCPSourcePort extends DiameterUnsigned32
{
}