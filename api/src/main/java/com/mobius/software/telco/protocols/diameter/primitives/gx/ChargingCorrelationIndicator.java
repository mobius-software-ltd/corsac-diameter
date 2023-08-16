package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.67 Charging-Correlation-Indicator AVP (All access types)
	The Charging-Correlation-Indicator AVP (AVP code 1073) is of type Enumerated.
	If the Charging-Correlation-Indicator AVP is included within a Charging-Rule-Install AVP it indicates that the AccessNetwork-Charging-Identifier-Gx AVP assigned to the dynamic PCC rules need to be provided.
	The following values are defined:

	CHARGING_IDENTIFIER_REQUIRED (0)
 		This value shall be used to indicate that the Access-Network-Charging-Identifier-Gx AVP for the dynamic PCC
		rule(s) shall be reported to the PCRF by the PCEF.
 */
@DiameterAvpDefinition(code = 1073L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Charging-Correlation-Indicator")
public interface ChargingCorrelationIndicator extends DiameterEnumerated<ChargingCorrelationIndicatorEnum>
{
}