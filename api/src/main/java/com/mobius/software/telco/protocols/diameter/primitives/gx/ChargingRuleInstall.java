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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.2 Charging-Rule-Install AVP (All access types)
	The Charging-Rule-Install AVP (AVP code 1001) is of type Grouped, and it is used to activate, install or modify PCC
	rules as instructed from the PCRF to the PCEF.
	For installing a new PCC rule or modifying a PCC rule already installed, Charging-Rule-Definition AVP shall be used.
	For activating a specific PCC rule predefined at the PCEF, Charging-Rule-Name AVP shall be used as a reference for
	that PCC rule. The Charging-Rule-Base-Name AVP is a reference that may be used for activating a group of PCC rules
	predefined at the PCEF.
	For GPRS scenarios where the bearer binding is performed by the PCRF, the Bearer Identifier AVP shall be included as
	part of Charging-Rule-Install AVP. 
		
	If present within Charging-Rule-Install AVP, the Bearer-Identifier AVP indicates that the PCC rules within this
	Charging-Rule-Install AVP shall be installed or activated within the IP CAN bearer identified by the Bearer-Identifier
	AVP.

	If no Bearer-Identifier AVP is included within the Charging-Rule-Install AVP, the PCEF shall select an IP CAN bearer
	for each of the PCC rules within this Charging-Rule-Install AVP, where the PCC rule is installed or activated.
	
	If Rule-Activation-Time or Rule-Deactivation-Time is specified then it applies to all the PCC rules within the
	Charging-Rule-Install AVP.

	If Resource-Allocation-Notification AVP is included then it applies to all the rules within the Charging-Rule-Install
	AVP. If a Charging-Rule-Install AVP does not include the Resource-Allocation-Notification AVP, the resource
	allocation shall not be notified by the PCEF even if this AVP was present in previous installations of the same rule.

	If the Charging-Correlation-Indicator AVP is included within the Charging-Rule-Install AVP, it indicates that the PCEF
	shall provide the assigned access network charging identifier for the dynamic PCC Rules that are provided in the
	Charging-Rule-Definition AVP(s) within the Access-Network-Charging-Identifier-Gx AVP.

	If the Monitoring-Flags AVP is included within the Charging-Rule-Install AVP, it is used to indicate the monitoring
	action related to the corresponding service data flow. It applies to all the PCC rules within the Charging-Rule-Install
	AVP. If the Monitoring-Flags AVP is provided, the value will be valid for the PCC rules until the new value is provided
	for the PCC rules.
	
	IP-CAN-Type AVP identifies the access to be used for transporting the service data flows in NBIFOM scenario. If the
	IP-CAN-Type AVP is omitted and NBIFOM applies to the corresponding IP-CAN session, the traffic identified by the
	PCC rule is to be transferred on the NBIFOM default access even if this AVP was present in previous installations of
	the same rule. Only the 3GPP-EPS and Non-3GPP-EPS IP-CAN type values are applicable in this release.
	
	NOTE: The IP-CAN-Type AVP is always included in the Charging-Rule-Install AVP when a PCC rule is
	installed or modified if the PCC rule is intended to be bound to the non-default access.

	AVP Format:
	
	Charging-Rule-Install ::= < AVP Header: 1001 >
		 *[ Charging-Rule-Definition ]
		 *[ Charging-Rule-Name ]
		 *[ Charging-Rule-Base-Name ]
		  [ Bearer-Identifier ]
		  [ Monitoring-Flags ]
		  [ Rule-Activation-Time ]
		  [ Rule-Deactivation-Time ]
		  [ Resource-Allocation-Notification ]
		  [ Charging-Correlation-Indicator ]
		  [ IP-CAN-Type ]
		 *[ AVP ] 
 */
@DiameterAvpDefinition(code = 1001L, vendorId = KnownVendorIDs.TGPP_ID, name = "Charging-Rule-Install")
public interface ChargingRuleInstall extends DiameterGroupedAvp
{
	List<ChargingRuleDefinition> getChargingRuleDefinition();
	
	void setChargingRuleDefinition(List<ChargingRuleDefinition> value);	
	
	List<ByteBuf> getChargingRuleName();
	
	void setChargingRuleName(List<ByteBuf> value);	
	
	List<String> getChargingRuleBaseName();
	
	void setChargingRuleBaseName(List<String> value);	
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);
	
	Long getMonitoringFlags();
	
	void setMonitoringFlags(Long value);	
	
	Date getRuleActivationTime();
	
	void setRuleActivationTime(Date value);	
	
	Date getRuleDeactivationTime();
	
	void setRuleDeactivationTime(Date value);	
	
	ResourceAllocationNotificationEnum getResourceAllocationNotification();
	
	void setResourceAllocationNotification(ResourceAllocationNotificationEnum value);	
	
	ChargingCorrelationIndicatorEnum getChargingCorrelationIndicator();
	
	void setChargingCorrelationIndicator(ChargingCorrelationIndicatorEnum value);	
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);	 				  
}