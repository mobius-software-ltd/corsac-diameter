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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.139	List-Of-Measurements
	The List-Of-Measurements AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits is defined 
	in 3GPP TS 32.422 [23]. The most significant bit is bit 8 of the first octet.
 */
@DiameterAvpDefinition(code = 1625L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "List-Of-Measurements")
public interface ListOfMeasurements extends DiameterUnsigned32
{
}