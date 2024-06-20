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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleRemove;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.6.6	Re-Auth-Request (RAR) Command
	The RAR command, indicated by the Command-Code field set to 258 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the TDF in order to provision ADC rules using the PUSH procedure for solicited application reporting. It is also used to provision event triggers and to report event report indications for the TDF session for solicited application reporting and to request the TDF session termination for both solicited and unsolicited application reporting.
	Message Format:

	<RA-Request> ::= < Diameter Header: 258, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Destination-Host }
				 { Re-Auth-Request-Type }
				 [ Session-Release-Cause ]
				 [ Origin-State-Id ]
				 [ OC-Supported-Features ]
				 [ QoS-Information ]
				*[ Event-Trigger ]
				*[ CSG-Information-Reporting ]
				 [ Event-Report-Indication ]
				*[ ADC-Rule-Remove ]
				*[ ADC-Rule-Install ]
				 [ Revalidation-Time ]
				*[ Usage-Monitoring-Information ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SD, commandCode = CommandCodes.REAUTH, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends AuthenticationRequest,com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value) throws MissingAvpException;
	
	SessionReleaseCauseEnum getSessionReleaseCause();
	
	void setSessionReleaseCause(SessionReleaseCauseEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	List<CSGInformationReportingEnum> getCSGInformationReporting();
	
	void setCSGInformationReporting(List<CSGInformationReportingEnum> value);
	
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
}