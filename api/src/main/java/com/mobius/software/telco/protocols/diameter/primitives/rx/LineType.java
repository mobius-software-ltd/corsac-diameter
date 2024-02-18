package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 * 	5.3.78	Line-Type AVP
	The Line-Type AVP (AVP code 581) is of type Unsigned32 and it indicates the type of wireline (DSL or PON) for the wireline BBF access.
	The following values are defined in this specification:

	0 (DSL):
		This value shall be used to indicate DSL line.

	1 (PON):
		This value shall be used to indicate PON line.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LINE_TYPE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Line-Type")
public interface LineType extends DiameterEnumerated<LineTypeEnum>
{
}