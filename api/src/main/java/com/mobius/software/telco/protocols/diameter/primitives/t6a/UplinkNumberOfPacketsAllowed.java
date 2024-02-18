package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
	6.4.37	Uplink-Number-Of-Packets-Allowed
	The Uplink-Number-Of-Packets-Allowed AVP is of type Unsigned32. It shall contain information of octets k+1 to k+4 as specified in figure 8.38-10 of 3GPP TS 29.274 [33].	
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UPLINK_NUMBER_OF_PACKETS_ALLOWED, vendorId = VendorIDs.TGPP_ID,must = false, name = "Uplink-Number-Of-Packets-Allowed")
public interface UplinkNumberOfPacketsAllowed extends DiameterUnsigned32
{
}