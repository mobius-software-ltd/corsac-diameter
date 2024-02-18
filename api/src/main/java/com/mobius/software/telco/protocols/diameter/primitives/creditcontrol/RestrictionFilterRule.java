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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpFilterRule;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.36.  Restriction-Filter-Rule AVP

   The Restriction-Filter-Rule AVP (AVP Code 438) is of type
   IPFilterRule and provides filter rules corresponding to services that
   are to remain accessible even if there are no more service units
   granted.  The access device has to configure the specified filter
   rules for the subscriber and MUST drop all the packets not matching
   these filters.  Zero, one, or more such AVPs MAY be present in a
   Credit-Control-Answer message or in an AA-Answer message.
 */
@DiameterAvpDefinition(code = AvpCodes.RESTRICTION_FILTER_RULE, vendorId = -1L, name = "Restriction-Filter-Rule")
public interface RestrictionFilterRule extends DiameterIpFilterRule
{
}