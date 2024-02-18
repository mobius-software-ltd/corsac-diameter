package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
 * 	7.2.160G Rate-Control-Time-Unit AVP
	The Rate-Control-Time-Unit AVP (AVP code 3939) is of type Unsigned32 and holds a time unit for rate control.It has
	the following values:
	
	0 Unrestricted
	This value is used to indicate the number of data PDUs is not restricted.
	1 Minute
	2 Hour
	3 Day
	4 Week 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RATE_CONTROL_TIME_UNIT, vendorId = VendorIDs.TGPP_ID, name = "Rate-Control-Time-Unit")
public interface RateControlTimeUnit extends DiameterEnumerated<RateControlTimeUnitEnum>
{
}