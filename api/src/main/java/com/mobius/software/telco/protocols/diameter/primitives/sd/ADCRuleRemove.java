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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.3.2	ADC-Rule-Remove AVP
	The ADC-Rule-Remove AVP (AVP code 1093) is of type Grouped, and it is used to deactivate or remove ADC rules as instructed from the PCRF.
	ADC-Rule-Name AVP is a reference for a specific dynamic ADC rule to be removed or for a specific predefined ADC rule to be deactivated. The ADC-Rule-Base-Name AVP is a reference for a group of predefined ADC rules to be deactivated.
	AVP Format:

	ADC-Rule-Remove ::= < AVP Header: 1093 >
							*[ ADC-Rule-Name ]
							*[ ADC-Rule-Base-Name ]
							*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ADC_RULE_REMOVE, vendorId = VendorIDs.TGPP_ID, name = "ADC-Rule-Remove")
public interface ADCRuleRemove extends DiameterGroupedAvp
{
	List<ByteBuf> getADCRuleName();
	
	void setADCRuleName(List<ByteBuf> value);	
	
	List<String> getADCRuleBaseName();
	
	void setADCRuleBaseName(List<String> value);	  
}