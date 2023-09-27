package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
	6.4.34	ROHC-Max-CID AVP
	The ROHC-Max-CID AVP (AVP code 3532) is of type Unsigned32.
	It shall indicate the MAX_CID parameter for the compressor (see IETF RFC 5795 [29] and IETF RFC 3095 [30]). The value for the LARGE_CIDS parameter (usage of short CID representation or large CID representation) shall be deducted from the MAX_CID parameter as follows: 
	If MAX_CID > 15 then LARGE_CIDS = TRUE else LARGE_CIDS = FALSE
*/
@DiameterAvpDefinition(code = 3532L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "ROHC-Max-CID")
public interface ROHCMaxCID extends DiameterUnsigned32
{
}