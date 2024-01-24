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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ApplicationDetectionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CreditManagementStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleReport;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.6.4	CC-Request (CCR) Command
	The CCR command, indicated by the Command-Code field set to 272 and the 'R' bit set in the Command Flags field, is sent by the TDF to the PCRF in order to request ADC rules or to inform PCRF about the application detection. It is also sent to the PCRF in case of TDF session termination, following receipt of the corresponding RAR command from the PCRF.
	Message Format:

	<CC-Request> ::= < Diameter Header: 272, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 [ OC-Supported-Features ]
				 { CC-Request-Type }
				 { CC-Request-Number }
				 [ Credit-Management-Status ]
				 [ Destination-Host ]
				 [ Origin-State-Id ] 
				 [ Framed-IP-Address ]
				 [ Framed-Ipv6-Prefix ]
				*[ ADC-Rule-Report]
				*[ Application-Detection-Information ]
				*[ Event-Trigger]
				 [ Event-Report-Indication ]
				*[ Usage-Monitoring-Information ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ Supported-Features ]
				*[ AVP ]

	NOTE 1:	For the Solicited application reporting, only CC-Request-Type equal to UPDATE_REQUEST and TERMINATION_REQUEST are used.
 */
@DiameterCommandDefinition(applicationId = 16777303, commandCode = 272, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	CreditManagementStatus getCreditManagementStatus();
	
	void setCreditManagementStatus(CreditManagementStatus value);
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	List<ADCRuleReport> getADCRuleReport();
	
	void setADCRuleReport(List<ADCRuleReport> value);	
	
	List<ApplicationDetectionInformation> getApplicationDetectionInformation();
	
	void setApplicationDetectionInformation(List<ApplicationDetectionInformation> value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	EventReportIndication getEventReportIndication();
	
	void setEventReportIndication(EventReportIndication value);	
	
	List<UsageMonitoringInformation> getUsageMonitoringInformation();
	
	void setUsageMonitoringInformation(List<UsageMonitoringInformation> value);	
	
	List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);	
}