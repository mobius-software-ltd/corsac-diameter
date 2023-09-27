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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.39B Charging-Per-IP-CAN-Session-Indicator AVP
	The Charging-Per-IP-CAN-Session-Indicator AVP (AVP code 4400) is of type of Enumerated. It indicates whether the
	charging per IP-CAN session is active for offline charging. If this AVP is not present, that means charging per IP-CAN
	session is not active.
	The following value is defined:
	
	0 Inactive
	1 Active
 */
@DiameterAvpDefinition(code = 4400L, vendorId = KnownVendorIDs.TGPP_ID, name = "Charging-Per-IP-CAN-Session-Indicator")
public interface ChargingPerIPCANSessionIndicator extends DiameterEnumerated<ChargingPerIPCANSessionIndicatorEnum>
{
}