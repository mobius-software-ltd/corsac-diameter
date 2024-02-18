package com.mobius.software.telco.protocols.diameter.primitives.gq;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.35 Overbooking-indicator
	The Overbooking-indicator AVP (AVP code 460) is of type Enumerated. Indicates that the SPDF should require
	processing the resource request in overbooking mode. The following values are specified The overbooking-indicator
	may be used when having a session initiation or when having a session modification.

	• Overbooking-indicator (0) means that no overbooking mode is required

	• Overbooking-indicator (1) means that overbooking is mode required
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.OVERBOOKING_INDICATOR, vendorId = VendorIDs.ETSI_ID, must = false, name = "Overbooking-Indicator")
public interface OverbookingIndicator extends DiameterEnumerated<OverbookingIndicatorEnum>
{
}