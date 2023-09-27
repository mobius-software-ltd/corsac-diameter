package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.9	Vertical-Requested
	The Vertical-Requested AVP is of type Enumerated. The following values are defined:
	
	VERTICAL_COORDINATE_IS_NOT REQUESTED (0)
	
	VERTICAL_COORDINATE_IS_REQUESTED (1)

	Default value if AVP is not present is: VERTICAL_COORDINATE_IS_NOT_REQUESTED (0).
 */
@DiameterAvpDefinition(code = 2507L, vendorId = KnownVendorIDs.TGPP_ID, name = "Vertical-Requested")
public interface VerticalRequested extends DiameterEnumerated<VerticalRequestedEnum>
{
}