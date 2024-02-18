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
 * 	7.2.160D Radio-Resources-Indicator AVP
	The Radio-Resources-Indicator AVP (AVP code 3465) is of type Integer32 and identifies whether the operatorprovided radio resources or the configured radio resources were used for ProSe direct communication. The allowed
	values are:

	1 Operator-provided
	2 Configured 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RADIO_RESOURCES_INDICATOR, vendorId = VendorIDs.TGPP_ID, name = "Radio-Resources-Indicator")
public interface RadioResourcesIndicator extends DiameterEnumerated<RadioResourcesIndicatorEnum>
{
}