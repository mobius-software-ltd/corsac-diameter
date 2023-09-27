package com.mobius.software.telco.protocols.diameter.primitives.sd;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.3.4	ADC-Rule-Base-Name AVP
	The ADC-Rule-Base-Name AVP (AVP code 1095) is of type UTF8String, and it indicates the name of a predefined group of ADC rules.
 */
@DiameterAvpDefinition(code = 1095L, vendorId = KnownVendorIDs.TGPP_ID, name = "ADC-Rule-Base-Name")
public interface ADCRuleBaseName extends DiameterUTF8String
{
}