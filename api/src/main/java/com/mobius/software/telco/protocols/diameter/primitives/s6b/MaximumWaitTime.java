package com.mobius.software.telco.protocols.diameter.primitives.s6b;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	9.2.3.2.7	Maximum-Wait-Time

	The Maximum-Wait-Time is of type Unsigned32. It indicates the number of milliseconds since the Origination-Time-Stamp 
	during which the originator of a request waits for a response. See 3GPP TS 29.274 [38].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MAXIMUM_WAIT_TIME, vendorId = VendorIDs.TGPP_ID, must = false, name = "Maximum-Wait-Time")
public interface MaximumWaitTime extends DiameterUnsigned32
{
}