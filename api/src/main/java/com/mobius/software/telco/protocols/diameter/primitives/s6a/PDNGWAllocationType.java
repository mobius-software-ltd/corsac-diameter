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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.44	PDN-GW-Allocation-Type
	The PDN-GW-Allocation-Type AVP is of type Enumerated. It shall indicate whether the PDN GW address included in MIP6-Agent-Info has been statically allocated (i.e. provisioned in the HSS by the operator), or dynamically selected by other nodes. The following values are defined:

	STATIC (0)

	DYNAMIC (1)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PDN_GW_ALLOCATION_TYPE, vendorId = VendorIDs.TGPP_ID, name = "PDN-GW-Allocation-Type")
public interface PDNGWAllocationType extends DiameterEnumerated<PDNGWAllocationTypeEnum>
{
}