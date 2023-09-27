package com.mobius.software.telco.protocols.diameter.primitives.s6c;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	5.3.3.22	Maximum-UE-Availability-Time
	The Maximum-UE-Availability-Time is of type Time and in shall contain the timestamp (in UTC) until which a UE using a power saving mechanism (such as extended idle mode DRX) is expected to be reachable for SM Delivery.
 */
@DiameterAvpDefinition(code = 3329L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Maximum-UE-Availability-Time")
public interface MaximumUEAvailabilityTime extends DiameterTime
{
}