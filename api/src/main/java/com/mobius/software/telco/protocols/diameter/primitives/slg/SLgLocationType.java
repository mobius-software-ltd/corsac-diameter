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
 * 	7.4.2	SLg-Location-Type
	The SLg-Location-Type AVP is of type Enumerated. The following values are defined:

	CURRENT_LOCATION (0)
	
	CURRENT_OR_LAST_KNOWN_LOCATION (1)

	INITIAL_LOCATION (2)

	ACTIVATE_DEFERRED_LOCATION (3)

	CANCEL_DEFERRED_LOCATION (4)

	NOTIFICATION_VERIFICATION_ONLY (5)
 */
@DiameterAvpDefinition(code = 2500L, vendorId = KnownVendorIDs.TGPP_ID, name = "SLg-Location-Type")
public interface SLgLocationType extends DiameterEnumerated<SLgLocationTypeEnum>
{
}