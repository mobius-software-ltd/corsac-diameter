package com.mobius.software.telco.protocols.diameter.primitives.tsp;
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
 *	6.4.7	Priority-Indication AVP
	The Priority-Indication (AVP code 3006) is of type Enumerated, and identifies priority of the device trigger.
	The following values are defined:

	Non-Priority (0)
	This value indicates that the device trigger has non-priority.

	Priority (1)
	This value indicates that the device trigger has priority.
 */
@DiameterAvpDefinition(code = 3006L, vendorId = KnownVendorIDs.TGPP_ID, name = "Priority-Indication")
public interface PriorityIndication extends DiameterEnumerated<PriorityIndicationEnum>
{
}