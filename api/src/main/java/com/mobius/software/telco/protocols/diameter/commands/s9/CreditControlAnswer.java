package com.mobius.software.telco.protocols.diameter.commands.s9;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionDecisionInfo;

/**
*
* @author yulian oifa
*
*/

/*
 *  5.5.3	CC-Answer (CCA) Command
	The CCA command, indicated by the Command-Code field set to 272 and the 'R' bit cleared in the Command Flags field, is sent by the H-PCRF to the V-PCRF in response to the CCR command. It is used to provision PCC/QoS rules and event triggers for the subsession/session
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
				*[ Supported-Features]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ QoS-Rule-Install ]
				*[ QoS-Rule-Remove ]
 				*[ QoS-Information ]
				 [ Bearer-Control-Mode ]
				*[ Event-Trigger ]
				 [ Charging-Information ]
				*[ Subsession-Decision-Info ]
				*[ CSG-Information-Reporting ]
			  0*2[ AN-GW-Address ]
				 [ Origin-State-Id ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ Load ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S9, commandCode = CommandCodes.CREDIT_CONTROL, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends AuthenticationAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException;
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value) throws MissingAvpException;
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	List<QoSRuleRemove> getQoSRuleRemove();
	
	void setQoSRuleRemove(List<QoSRuleRemove> value);	
	
	List<QoSRuleInstall> getQoSRuleInstall();
	
	void setQoSRuleInstall(List<QoSRuleInstall> value);	
	
	List<QoSInformation> getQoSInformation();
	
	void setQoSInformation(List<QoSInformation> value);	
	
	BearerControlModeEnum getBearerControlMode();
	
	void setBearerControlMode(BearerControlModeEnum value);
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);
	
	ChargingInformation getChargingInformation();
	
	void setChargingInformation(ChargingInformation value);
	
	List<SubsessionDecisionInfo> getSubsessionDecisionInfo();
	
	void setSubsessionDecisionInfo(List<SubsessionDecisionInfo> value);	
	
	List<CSGInformationReportingEnum> getCSGInformationReporting();
	
	void setCSGInformationReporting(List<CSGInformationReportingEnum> value);	
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value) throws MissingAvpException, AvpOccursTooManyTimesException;
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);	
}