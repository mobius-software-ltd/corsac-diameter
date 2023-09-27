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
 * 	7.4.21	Pseudonym-Indicator
	The Pseudonym-Indicator AVP is of type Enumerated. It defines if a pseudonym is requested. The following values are defined:

	PSEUDONYM_NOT_REQUESTED (0)

	PSEUDONYM_REQUESTED (1)

	Default value if AVP is not present is: PSEUDONYM_NOT_REQUESTED (0).
 */
@DiameterAvpDefinition(code = 2519L, vendorId = KnownVendorIDs.TGPP_ID, name = "Pseudonym-Indicator")
public interface PseudonymIndicator extends DiameterEnumerated<PseudonymIndicatorEnum>
{
}