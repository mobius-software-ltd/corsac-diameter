package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.12.  Cost-Unit AVP

   The Cost-Unit AVP (AVP Code 424) is of type UTF8String, and it is
   used to display a human-readable string to the end user.  It
   specifies the applicable unit to the Cost-Information AVP when the
   service cost is a cost per unit (e.g., cost of the service is $1 per
   minute).  The Cost-Unit setting can be minutes, hours, days,
   kilobytes, megabytes, etc.
 */
@DiameterAvpDefinition(code = AvpCodes.COST_UNIT, vendorId = -1L, name = "Cost-Unit")
public interface CostUnit extends DiameterUTF8String
{
}