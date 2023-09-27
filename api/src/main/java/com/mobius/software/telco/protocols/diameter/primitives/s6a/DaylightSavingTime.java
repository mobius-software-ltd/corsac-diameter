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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.164	Daylight-Saving-Time
	The Daylight-Saving-Time AVP is of type Enumerated and shall contain the Daylight Saving Time (in steps of 1 hour) used to adjust for summertime the time zone of the location where the UE is attached in the visited network.
	The following values are defined:

	NO_ADJUSTMENT (0)

	PLUS_ONE_HOUR_ADJUSTMENT (1)

	PLUS_TWO_HOURS_ADJUSTMENT (2)
 */
@DiameterAvpDefinition(code = 1650L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Daylight-Saving-Time")
public interface DaylightSavingTime extends DiameterEnumerated<DaylightSavingTimeEnum>
{
}