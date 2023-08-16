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
 * 	5.3.39 APN-Aggregate-Max-Bitrate-DL AVP
	The APN-Aggregate-Max-Bitrate-DL AVP (AVP code 1040) is of type Unsigned32, and it indicates the maximum
	aggregate bit rate in bits per seconds for the downlink direction across all non-GBR bearers related with the same APN.
	When provided in a CC-Request, it indicates the subscribed maximum bitrate and/or the maximum bitrate retained in
	the PCEF. When provided in a CC-Answer, it indicates the maximum bandwidth authorized by PCRF.
	When the Extended-BW-NR feature is supported and the value to be transmitted exceeds 2^32-1, the Extended-APNAMBR-DL AVP shall be used; see subclause 4.5.30 and subclause 5.3.134. 
 */
@DiameterAvpDefinition(code = 1040L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "APN-Aggregate-Max-Bitrate-DL")
public interface APNAggregateMaxBitrateDL extends DiameterUnsigned32
{
}