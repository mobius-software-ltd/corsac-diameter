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
 * 	5.3.26 Guaranteed-Bitrate-UL AVP
	The Guaranteed–Bitrate-UL AVP (AVP code 1026) is of type Unsigned32, and it indicates the guaranteed bitrate in bits
	per second for an uplink service data flow. The bandwidth contains all the overhead coming from the IP-layer and the
	layers above, e.g. IP, UDP, RTP and RTP payload.
	When the Extended-BW-NR feature is supported and the value to be transmitted exceeds 2^32-1, the Extended-GBRUL AVP shall be used; see subclause 4.5.30 and subclause 5.3.137.
*/
@DiameterAvpDefinition(code = 1026L, vendorId = KnownVendorIDs.TGPP_ID, name = "Guaranteed-Bitrate-UL")
public interface GuaranteedBitrateUL extends DiameterUnsigned32
{
}