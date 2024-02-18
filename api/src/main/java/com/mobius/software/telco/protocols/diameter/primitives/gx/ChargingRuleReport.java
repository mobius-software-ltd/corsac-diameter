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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.18	Charging-Rule-Report AVP (All access types)
	The Charging-Rule-Report AVP (AVP code 1018) is of type Grouped, and it is used to report the status of PCC rules.
	Charging-Rule-Name AVP is a reference for a specific PCC rule at the PCEF that has been successfully installed, modified or removed (for dynamic PCC rules), or activated or deactivated (for predefined PCC rules) because of trigger from the MS. Charging-Rule-Base-Name AVP is a reference for a group of PCC rules predefined at the PCEF that has been successfully activated or deactivated because of trigger from the MS.
	The Charging-Rule-Report AVP can also be used to report the status of the PCC rules which cannot be installed/activated or enforced at the PCEF. In this condition, the Charging-Rule-Name AVP is used to indicate a specific PCC rule which cannot be installed/activated or enforced, and the Charging-Rule-Base-Name AVP is used to indicate a group of PCC rules which cannot be activated. The Rule-Failure-Code indicates the reason that the PCC rules cannot be successfully installed/activated or enforced.
	The Charging-Rule-Report AVP can also be used to report the status of the PCC rules for which credit is no longer available or credit has been reallocated after the former out of credit indication or credit management session failure has been detected by the OCS. When reporting an out of credit condition, the Final-Unit-Indication AVP indicates the termination action the PCEF applies to the PCC rules as instructed by the OCS.
	The Charging-Rule-Report AVP can also be used to report the status of the PCC rules for which corresponding NBIFOM routing rule was rejected by the UE or which corresponding access is removed. In the case that UE rejects the NBIFOM routing rule, the Charging-Rule-Name AVP is used to indicate a specific PCC rule which corresponding NBIFOM routing rule was rejected. The Rule-Failure-Code AVP indicates the reason for the rejection of the routing rule.
	For GPRS scenarios where the bearer binding is performed by the PCRF, the Bearer-Identifier AVP may be included within the Charging-Rule-Report AVP.
	If the RuleVersioning feature is supported, the Content-Version AVP(s) shall be included if it was included in the Charging-Rule-Definition AVP when the corresponding PCC rule was installed or modified.
	AVP Format:

	Charging-Rule-Report ::= < AVP Header: 1018 >
		*[ Charging-Rule-Name ]
		*[ Charging-Rule-Base-Name ]
		 [ Bearer-Identifier ]
		 [ PCC-Rule-Status ]
		 [ Rule-Failure-Code ]
		 [ Final-Unit-Indication ]
		*[ RAN-NAS-Release-Cause ]
		*[ Content-Version ]
		*[ AVP ]

	Multiple instances of Charging-Rule-Report AVPs shall be used in the case it is required to report different PCC-Rule-Status or Rule-Failure-Code values for different groups of rules within the same Diameter command. If the Content-Version is included in a Charging-Rule-Report AVP, then only the one corresponding Charging-Rule-Name AVP shall be included.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CHARGING_RULE_REPORT, vendorId = VendorIDs.TGPP_ID, name = "Charging-Rule-Report")
public interface ChargingRuleReport extends DiameterGroupedAvp
{
	List<ByteBuf> getChargingRuleName();
	
	void setChargingRuleName(List<ByteBuf> value);	
	
	List<String> getChargingRuleBaseName();
	
	void setChargingRuleBaseName(List<String> value);	
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);	
	
	PCCRuleStatusEnum getPCCRuleStatus();
	
	void setPCCRuleStatus(PCCRuleStatusEnum value);	
	
	RuleFailureCodeEnum getRuleFailureCode();
	
	void setRuleFailureCode(RuleFailureCodeEnum value);	
	
	FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication value);	
	
	List<ByteBuf> getRANNASReleaseCause();
	
	void setRANNASReleaseCause(List<ByteBuf> value);	
	
	List<Long> getContentVersion();
	
	void setContentVersion(List<Long> value);				  
}