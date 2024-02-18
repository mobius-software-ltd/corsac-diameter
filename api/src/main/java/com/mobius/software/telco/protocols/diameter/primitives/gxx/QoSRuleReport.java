package com.mobius.software.telco.protocols.diameter.primitives.gxx;
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
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCCRuleStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RuleFailureCodeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5a.3.5	QoS-Rule-Report AVP (All access types)
	The QoS-Rule-Report AVP (AVP code 1055) is of type Grouped, and it is used to report the status of QoS rules.
	QoS-Rule-Name AVP is a reference for a specific QoS rule at the BBERF that has been successfully installed, modified or removed (for dynamic QoS rules), or activated or deactivated (for predefined QoS rules). QoS-Rule-Base-Name AVP is a reference for a group of QoS rules predefined at the BBERF that has been successfully activated or deactivated.
	The QoS-Rule-Report AVP can also be used to report the status of the QoS rules which cannot be installed/activated or enforced at the BBERF. In this condition, the QoS-Rule-Name AVP is used to indicate a specific QoS rule which cannot be installed/activated or enforced and the QoS-Rule-Base-Name AVP is used to indicate a group of QoS rules which cannot be activated. The Rule-Failure-Code AVP indicates the reason that the QoS rules cannot be successfully installed/activated or enforced.
	If the RuleVersioning feature is supported, the Content-Version AVP(s) shall be included if it was included in the QoS-Rule-Definition AVP when the corresponding QoS rule was installed or modified.
	AVP Format:
	QoS-Rule-Report ::= < AVP Header: 1055>
						*[ QoS-Rule-Name ]
						*[ QoS-Rule-Base-Name ]
						 [ PCC-Rule-Status ]
						 [ Rule-Failure-Code ]
						*[ Content-Version ]
						*[ AVP ]

	Multiple instances of QoS-Rule-Report AVPs shall be used in the case it is required to report different PCC-Rule-Status or Rule-Failure-Code values for different rules within the same Diameter command. If the Content-Version AVP is included within a QoS-Rule-Report AVP, then only the one corresponding QoS-Rule-Name AVP shall be included.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.QOS_RULE_REPORT, vendorId = VendorIDs.TGPP_ID, name = "QoS-Rule-Report")
public interface QoSRuleReport extends DiameterGroupedAvp
{
	List<ByteBuf> getQoSRuleName();
	
	void setQoSRuleName(List<ByteBuf> value);	
	
	List<String> getQoSRuleBaseName();
	
	void setQoSRuleBaseName(List<String> value);	
	
	PCCRuleStatusEnum getPCCRuleStatus();
	
	void setPCCRuleStatus(PCCRuleStatusEnum value);	
	
	RuleFailureCodeEnum getRuleFailureCode();
	
	void setRuleFailureCode(RuleFailureCodeEnum value);	
	
	List<Long> getContentVersion();
	
	void setContentVersion(List<Long> value);				  
}