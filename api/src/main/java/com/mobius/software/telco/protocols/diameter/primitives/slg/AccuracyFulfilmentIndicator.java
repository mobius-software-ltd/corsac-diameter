package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
 * 	7.4.15	Accuracy-Fulfilment-Indicator
	The Accuracy-Fulfilment-Indicator AVP is of type Enumerated. The following values are defined:

	REQUESTED_ACCURACY_FULFILLED (0)

	REQUESTED_ACCURACY_NOT_FULFILLED (1)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ACCURACY_FULFILMENT_INDICATIOR, vendorId = VendorIDs.TGPP_ID, name = "Accuracy-Fulfilment-Indicator")
public interface AccuracyFulfilmentIndicator extends DiameterEnumerated<AccuracyFulfilmentIndicatorEnum>
{
}