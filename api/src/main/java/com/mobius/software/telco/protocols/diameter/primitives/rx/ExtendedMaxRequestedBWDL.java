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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.52	Extended-Max-Requested-BW-DL AVP
	The Extended-Max-Requested-BW-DL AVP (AVP code 554) is of type Unsigned32, and it indicates the maximum requested bandwidth in kbit per second for a downlink IP flow. The bandwidth contains all the overhead coming from the IP-layer and the layers above, e.g. IP, UDP, RTP and RTP payload.
	When provided in an AA-Request, it indicates the maximum requested bandwidth. When provided in an AA-Answer, it indicates the maximum bandwidth acceptable by PCRF.
 */
@DiameterAvpDefinition(code = 554L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Extended-Max-Requested-BW-DL")
public interface ExtendedMaxRequestedBWDL extends DiameterUnsigned32
{
}