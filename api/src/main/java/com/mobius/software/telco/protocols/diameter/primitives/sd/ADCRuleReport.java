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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleFailureCodeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.3.6	ADC-Rule-Report AVP
	The ADC-Rule-Report AVP (AVP code 1097) is of type Grouped, and it is used to report the status of ADC rules.
	The ADC-Rule-Report AVP is used to report the status of the ADC rules which cannot be installed/activated or enforced at the TDF. In this condition, the ADC-Rule-Name AVP is used to indicate a specific ADC rule which cannot be installed/activated or enforced, and the ADC-Rule-Base-Name AVP is used to indicate a group of ADC rules which cannot be activated. The PCC-Rule-Status AVP is set to INACTIVE. The Rule-Failure-Code indicates the reason that the ADC rules cannot be successfully installed/activated or enforced.
	The ADC-Rule-Report AVP can also be used to report the status of the ADC rules for which credit is no longer available or credit has been reallocated after the former out of credit indication. When reporting an out of credit condition, the Final-Unit-Indication AVP indicates the termination action the TDF applies to the ADC rules as instructed by the OCS.
	AVP Format:

	ADC-Rule-Report ::=	 < AVP Header: 1097 >
						*[ ADC-Rule-Name ]
						*[ ADC-Rule-Base-Name ]
						 [ PCC-Rule-Status ]
						 [ Rule-Failure-Code ]
						 [ Final-Unit-Indication ]
						*[ AVP ]

	Multiple instances of ADC-Rule-Report AVPs shall be used in the case it is required to report different PCC-Rule-Status or Rule-Failure-Code values for different groups of rules within the same Diameter command.
 */
@DiameterAvpDefinition(code = 1097L, vendorId = KnownVendorIDs.TGPP_ID, name = "ADC-Rule-Report")
public interface ADCRuleReport extends DiameterGroupedAvp
{
	List<ByteBuf> getADCRuleName();
	
	void setADCRuleName(List<ByteBuf> value);	
	
	List<String> getADCRuleBaseName();
	
	void setADCRuleBaseName(List<String> value);	
	
	PCCRuleStatusEnum getPCCRuleStatus();
	
	void setPCCRuleStatus(PCCRuleStatusEnum value);	
	
	RuleFailureCodeEnum getRuleFailureCode();
	
	void setRuleFailureCode(RuleFailureCodeEnum value);	
	
	FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication value);		  
}