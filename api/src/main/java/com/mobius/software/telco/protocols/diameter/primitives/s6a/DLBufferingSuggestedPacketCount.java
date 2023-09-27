package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.188	DL-Buffering-Suggested-Packet-Count
	The DL-Buffering-Suggested-Packet-Count AVP is of type Integer32. It shall indicate whether extended buffering of downlink packets at the SGW, for High Latency Communication, is requested or not. When requested, it may also suggest the number of downlink packets to buffer at the SGW for this user.
	The following values are defined:

	"Extended DL Data Buffering NOT REQUESTED"	0

	"Extended DL Data Buffering REQUESTED, without a suggested number of packets"	-1

	"Extended DL Data Buffering REQUESTED, with a suggested number of packets"	> 0

	"Extended DL Data Buffering REQUESTED", with or without a suggested number of packets to be buffered for this user, indicates that extended buffering of downlink packets at the SGW is applicable to this user.

	"Extended DL Data Buffering NOT REQUESTED" indicates that extended buffering of downlink packets at the SGW is not applicable to this user.
*/
@DiameterAvpDefinition(code = 1674L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "DL-Buffering-Suggested-Packet-Count")
public interface DLBufferingSuggestedPacketCount extends DiameterInteger32
{
}