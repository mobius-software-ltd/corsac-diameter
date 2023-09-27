package com.mobius.software.telco.protocols.diameter.primitives.np;
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
	5.3.9	Conditional-Restriction AVP
	The Conditional-Restriction AVP (AVP code 4007) is of type Unsigned32 and it shall contain a bit mask, and indicates what conditional reporting restrictions apply. Conditional reporting restrictions shall apply when this AVP is provided. The bit 0 shall be the least significant bit. For example, to get the value of bit 0, a bit mask of 0x0001 should be used. The meaning of the bits shall be as defined below:
	Table 5.3.9.1: Conditional-Restriction over Np

	Bit	Name
	Description

	0 UE location info not included in RUCI
	This bit, when set, indicates that the location information of the UE shall not be included in RUCI for reporting.
 */
@DiameterAvpDefinition(code = 4007L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Conditional-Restriction")
public interface ConditionalRestriction extends DiameterUnsigned32
{
}