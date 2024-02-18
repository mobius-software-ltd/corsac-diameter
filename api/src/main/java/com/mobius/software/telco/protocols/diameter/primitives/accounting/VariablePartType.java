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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.242aC Variable-Part-Type AVP
	The Variable-Part-Type AVP (AVP Code 3909) is of type Unsigned32 and holds the type of the variable part.
	The following values are defined:

	0 Integer
	1 Number
	2 Time
	3 Date
	4 Currency
	5-127 Reserved for future standardization
	128-255 Reserved for operator-defined types 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.VARIABLE_PART_TYPE, vendorId = VendorIDs.TGPP_ID, name = "Variable-Part-Type")
public interface VariablePartType extends DiameterUnsigned32
{
}