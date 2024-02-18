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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.5	LCS-Priority
	The LCS-Priority AVP is of type Unsigned32. It indicates the priority of the location request. The value 0 shall indicate the highest priority, and the value 1 shall indicate normal priority. All other values shall be treated as 1 (normal priority). For details, refer to 3GPP TS 22.071 [15]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LCS_PRIORITY, vendorId = VendorIDs.TGPP_ID, name = "LCS-Priority")
public interface LCSPriority extends DiameterUnsigned32
{
}