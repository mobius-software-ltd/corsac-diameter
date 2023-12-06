package com.mobius.software.telco.protocols.diameter.commands.sd;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReporting;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleRemove;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  5b.6.5	CC-Answer (CCA) Command
	The CCA command, indicated by the Command-Code field set to 272 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the TDF in response to the CCR command. It is used to provision ADC rules and event triggers for the TDF session and to acknowledge the report of the application's traffic start/stop.

	Message Format:
	<CC-Answer> ::=  < Diameter Header: 272, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { CC-Request-Type }
				 { CC-Request-Number }
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				 [ Framed-Ipv6-Prefix ]
				 [ QoS-Information ]
				*[ Event-Trigger ]
				*[ CSG-Information-Reporting ]
				 [ Event-Report-Indication ]
				 [ Origin-State-Id ]
				*[ Redirect-Host ]
				 [ Redirect-Host-Usage ]
				 [ Redirect-Max-Cache-Time ]
				*[ ADC-Rule-Remove ]
				*[ ADC-Rule-Install ]
				 [ Revalidation-Time ]
				*[ Usage-Monitoring-Information ] 
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ Supported-Features ]
				*[ Load ]
				*[ AVP ]

	NOTE 1:	For the Solicited application reporting, only CC-Request-Type equal to UPDATE_REQUEST and TERMINATION_REQUEST are used. 

	NOTE 2:	Framed-Ipv6-Prefix AVP is applicable only for the Unsolicited Application Reporting.
	
	NOTE 3	Load AVP is only applicable to the unsolicited application reporting.
 */
@DiameterCommandDefinition(applicationId = 16777303, commandCode = 272, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends AuthenticationAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);
	
	List<CSGInformationReporting> getCSGInformationReporting();
	
	void setCSGInformationReporting(List<CSGInformationReporting> value);	
	
	EventReportIndication getEventReportIndication();
	
	void setEventReportIndication(EventReportIndication value);
	
	List<ADCRuleRemove> getADCRuleRemove();
	
	void setADCRuleRemove(List<ADCRuleRemove> value);	
	
	List<ADCRuleInstall> getADCRuleInstall();
	
	void setADCRuleInstall(List<ADCRuleInstall> value);	
	
	public Date getRevalidationTime();
	
	void setRevalidationTime(Date value);
	
	List<UsageMonitoringInformation> getUsageMonitoringInformation();
	
	void setUsageMonitoringInformation(List<UsageMonitoringInformation> value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);
}