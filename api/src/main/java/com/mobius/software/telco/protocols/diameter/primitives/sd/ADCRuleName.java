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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.3.5	ADC-Rule-Name AVP
	The ADC-Rule-Name AVP (AVP code 1096) is of type OctetString, and it defines a name for ADC rule. For ADC rules provided by the PCRF it uniquely identifies an ADC rule within one TDF session. For predefined ADC rules, it uniquely identifies an ADC rule within the TDF. 
 */
@DiameterAvpDefinition(code = 1096L, vendorId = KnownVendorIDs.TGPP_ID, name = "ADC-Rule-Name")
public interface ADCRuleName extends DiameterOctetString
{
}