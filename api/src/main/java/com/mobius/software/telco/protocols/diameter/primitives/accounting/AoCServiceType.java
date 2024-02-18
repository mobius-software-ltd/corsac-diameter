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
 * 	7.2.19 AoC-Service-Type AVP
	The AoC-Service-Type AVP (AVP code 2313) is of type Enumerated and defines the type of AoC information to be
	provided to the subscriber. It can be one of the following values:

	0 NONE
	1 AOC-S	
	2 AOC-D
	3 AOC-E 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AOC_SERVICE_TYPE, vendorId = VendorIDs.TGPP_ID, name = "AoC-Service-Type")
public interface AoCServiceType extends DiameterEnumerated<AoCServiceTypeEnum>
{
}