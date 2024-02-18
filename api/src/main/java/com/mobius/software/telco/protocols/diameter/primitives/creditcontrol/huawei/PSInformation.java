package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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

/**
*
* @author yulian oifa
*
*/
/* 	3.2.579  PS-Information AVP

	AVP Name
	PS-Information

	AVP Code
	874

	AVP Data Type
	Grouped

	Vendor ID
	10415

	Description
	Indicates the PS service information group, used to store the information about the volume charging.
	The PS-Information AVP is an AVP group. The detailed ABNF syntax is as follows:

	PS-Information ::= <AVP Header: 874> 
                   [3GPP-Charging-Id] 
                   [3GPP-PDP-Type] 
                   [PDP-Address] 
                   [QoS] 
                   [SGSN-Address] 
                   [GGSN-Address] 
                   [CG-Address] 
                   [3GPP-IMSI-MCC-MNC] 
                   [3GPP-GGSN-MCC-MNC] 
                   [3GPP-NSAPI] 
                   [3GPP-Session-Stop-Indicator] 
                   [3GPP-Selection-Mode] 
                   [3GPP-Charging-Characteristics] 
                   [3GPP-SGSN-MCC-MNC] 
                   [3GPP-MS-TimeZone] 
                   [3GPP-CAMEL-Charging-Info] 
                   [Charging-Rule-Base-Name] 
                   [3GPP-User-Location-Info] 
                   [3GPP-RAT-Type] 
                   [PS-Furnish-Charging-Information] 
                   [PDP-Context-Type] 
                   [SP-Id] 
                   [Service-Id] 
                   [Service-Type] 
                   [Content-Id] 
                   [BearerType] 
                   [StartTime] 
                   [StopTime] 
                   [BearerProtocolType] 
                   [ChargingID] 
                   [ServiceLevel] 
                   [Message-Id] 
*/
@DiameterAvpDefinition(code = TgppAvpCodes.PS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "PS-Information")
public interface PSInformation extends com.mobius.software.telco.protocols.diameter.primitives.accounting.PSInformation 
{
	String getSPId();
	
	void setSPId(String value);
	
	String getServiceId();
	
	void setServiceId(String value);
	
	Long getBearerType();
	
	void setBearerType(Long value);	
	
	String getMessageID();
	
	void setMessageID(String value);	
	
	String getContentID();
	
	void setContentId(String value);	
	
	Long getBearerProtocolType();
	
	void setBearerProtocolType(Long value);	
	
	Long getServiceLevel();
	
	void setServiceLevel(Long value);	
	
	Long getRecipientAmount();
	
	void setRecipientAmount(Long value);	
	
	String getChargingID();
	
	void setChargingID(String value);
}