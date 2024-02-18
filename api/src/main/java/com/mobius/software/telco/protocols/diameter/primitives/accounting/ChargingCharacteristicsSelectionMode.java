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
 * 	7.2.39A Charging-Characteristics-Selection-Mode AVP
	The Charging-Characteristics-Selection-Mode AVP (AVP code 2066) is of type Enumerated and indicates how the
	applied Charging-Characteristics was selected. It may take following values:
	
	0 Serving-Node-Supplied
	1 Subscription-specific
	2 APN-specific
	3 Home-Default
	4 Roaming-Default
	5 Visiting-Default
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CHARGING_CHARACTERISTICS_SELECTION_MODE, vendorId = VendorIDs.TGPP_ID, name = "Charging-Characteristics-Selection-Mode")
public interface ChargingCharacteristicsSelectionMode extends DiameterEnumerated<ChargingCharacteristicsSelectionModeEnum>
{
}