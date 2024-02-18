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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.97 UDP-Source-Port AVP (3GPP-EPS and Non-3GPP-EPS access types)
	The UDP-Source-Port AVP (AVP Code 2806) is of type Unsigned32 and contains the UDP source port number in the
	case that NA(P)T is detected for supporting interworking with fixed broadband access network as defined in Annex E.
	When Untrusted WLAN over S2b access is supported as defined in Annex D.4, it contains the UDP source port number
	used for the IKEv2 tunnel in the case that a NAT is detected and the IKEv2 messages exchanged between the UE and
	the ePDG are encapsulated in the UDP messages according to IETF RFC 3948 [58]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UDP_SOURCE_PORT, vendorId = VendorIDs.TGPP_ID, must = false, name = "UDP-Source-Port")
public interface UDPSourcePort extends DiameterUnsigned32
{
}