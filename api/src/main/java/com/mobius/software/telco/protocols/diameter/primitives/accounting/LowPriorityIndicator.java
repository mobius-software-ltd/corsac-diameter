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
 * 	7.2.97A Low-Priority-Indicator AVP
	The Low-Priority-Indicator AVP (AVP code 2602) is of type Enumerated and indicates if the PDN connection has a
	low priority, i.e. for Machine Type Communications. It can be one of the following values:

	0 NO
	1 YES
 */
@DiameterAvpDefinition(code = 2602L, vendorId = KnownVendorIDs.TGPP_ID, name = "Low-Priority-Indicator")
public interface LowPriorityIndicator extends DiameterEnumerated<LowPriorityIndicatorEnum>
{
}