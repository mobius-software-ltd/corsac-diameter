package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 * 	5.3.41	Max-Supported-Bandwidth-DL AVP
	The Max-Supported-Bandwidth-DL AVP (AVP code 543) is of type Unsigned32, and it indicates the maximum supported bandwidth in bits per second for a downlink IP flow as defined in 3GPP TS 26.114 [41]. The bandwidth contains all the overhead coming from the IP-layer and the layers above, e.g. IP, UDP, RTP and RTP payload.
	When the Extended-BW-E2EQOSMTSI-NR feature is supported and the value to be transmitted exceeds 2^32-1, the Extended-Max-Supported-Bandwidth-DL AVP shall be used, see clause 4.4.10 and clause 5.3.54.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MAX_SUPPORTED_BANDWIDTH_DL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Max-Supported-Bandwidth-DL")
public interface MaxSupportedBandwidthDL extends DiameterUnsigned32
{
}