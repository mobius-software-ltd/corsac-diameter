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
 * 	7.4.51	Prioritized-List-Indicator
	The Prioritized-List-Indicator AVP is of type Enumerated and it indicates if the PLMN-ID-List is provided in prioritized order or not. The following values are defined:

	NOT_PRIORITIZED  (0)

	PRIORITIZED (1)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PRIORITIZED_LIST_INDICATOR, vendorId = VendorIDs.TGPP_ID, must = false, name = "Prioritized-List-Indicator")
public interface PrioritizedListIndicator extends DiameterEnumerated<PrioritizedListIndicatorEnum>
{
}