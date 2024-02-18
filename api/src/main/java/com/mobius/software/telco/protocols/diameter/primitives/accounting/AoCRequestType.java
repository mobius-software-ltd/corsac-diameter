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
 * 	7.2.16 AoC-Request-Type AVP
	The AoC-Request-Type AVP (AVP code 2055) is of type enumerated and tags if the client is looking for AoCI in
	conjunction to the Request-Type and Request-Action AVPs. It can be one of the following values:

	0 AoC_NOT_REQUESTED
	1 AoC_FULL
	2 AoC_COST_ONLY
	3 AoC_TARIFF_ONLY 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AOC_REQUEST_TYPE, vendorId = VendorIDs.TGPP_ID, name = "AoC-Request-Type")
public interface AoCRequestType extends DiameterEnumerated<AoCRequestTypeEnum>
{
}