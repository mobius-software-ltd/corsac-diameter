package com.mobius.software.telco.protocols.diameter.commands.gx;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalPolicyInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRAInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRARemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANRuleSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RemovalOfAccessEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 *  5.6.3	CC-Answer (CCA) Command
	The CCA command, indicated by the Command-Code field set to 272 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the PCEF in response to the CCR command. It is used to provision PCC rules and event triggers for the bearer/session and to provide the selected bearer control mode for the IP-CAN session. If the PCRF performs the bearer binding, PCC rules will be provisioned at bearer level. The primary and secondary CCF and/or primary and secondary OCS addresses may be included in the initial provisioning.
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
				*[ Supported-Features ]
				 [ Bearer-Control-Mode ]
				*[ Event-Trigger ]
				 [ Event-Report-Indication ]
				 [ Origin-State-Id ]
				*[ Redirect-Host ]
				 [ Redirect-Host-Usage ]
				 [ Redirect-Max-Cache-Time ]
				*[ Charging-Rule-Remove ]
				*[ Charging-Rule-Install ]
				 [ Charging-Information ]
				 [ Online ]
				 [ Offline ]
				*[ QoS-Information ]
				 [ Revalidation-Time ]
				 [ Default-EPS-Bearer-QoS ]
				 [ Default-QoS-Information ]
				 [ Bearer-Usage ]
				*[ Usage-Monitoring-Information ]
				*[ CSG-Information-Reporting ]
				 [ User-CSG-Information ]
				 [ PRA-Install ]
				 [ PRA-Remove ]
				 [ Presence-Reporting-Area-Information ]
				 [ Session-Release-Cause ]
				 [ NBIFOM-Support ]
				 [ NBIFOM-Mode ]
				 [ Default-Access ]
				 [ RAN-Rule-Support ]
				*[ Routing-Rule-Report ]
			  0*4[ Conditional-Policy-Information ]
				 [ Removal-Of-Access ]
				 [ IP-CAN-Type ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ Load ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GX, commandCode = CommandCodes.CREDIT_CONTROL, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends AuthenticationAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException;
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value) throws MissingAvpException;
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	BearerControlModeEnum getBearerControlMode();
	
	void setBearerControlMode(BearerControlModeEnum value);
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);
	
	EventReportIndication getEventReportIndication();
	
	void setEventReportIndication(EventReportIndication value);
	
	List<ChargingRuleRemove> getChargingRuleRemove();
	
	void setChargingRuleRemove(List<ChargingRuleRemove> value);	
	
	List<ChargingRuleInstall> getChargingRuleInstall();
	
	void setChargingRuleInstall(List<ChargingRuleInstall> value);	
	
	ChargingInformation getChargingInformation();
	
	void setChargingInformation(ChargingInformation value);	
	
	OnlineEnum getOnline();
	
	void setOnline(OnlineEnum value);	
	
	OfflineEnum getOffline();
	
	void setOffline(OfflineEnum value);	
	
	List<QoSInformation> getQoSInformation();
	
	void setQoSInformation(List<QoSInformation> value);	
	
	public Date getRevalidationTime();
	
	void setRevalidationTime(Date value);
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS();
	
	void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value);
	
	public DefaultQoSInformation getDefaultQoSInformation();
	
	void setDefaultQoSInformation(DefaultQoSInformation value);
	
	public BearerUsageEnum getBearerUsage();
	
	void setBearerUsage(BearerUsageEnum value);
	
	List<UsageMonitoringInformation> getUsageMonitoringInformation();
	
	void setUsageMonitoringInformation(List<UsageMonitoringInformation> value);	
	
	List<CSGInformationReportingEnum> getCSGInformationReporting();
	
	void setCSGInformationReporting(List<CSGInformationReportingEnum> value);	
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
	
	PRAInstall getPRAInstall();
	
	void setPRAInstall(PRAInstall value);
	
	PRARemove getPRARemove();
	
	void setPRARemove(PRARemove value);
	
	PresenceReportingAreaInformation getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(PresenceReportingAreaInformation value);
	
	SessionReleaseCauseEnum getSessionReleaseCause();
	
	void setSessionReleaseCause(SessionReleaseCauseEnum value);
	
	NBIFOMSupportEnum getNBIFOMSupport();
	
	void setNBIFOMSupport(NBIFOMSupportEnum value);	
	
	NBIFOMModeEnum getNBIFOMMode();
	
	void setNBIFOMMode(NBIFOMModeEnum value);	
	
	IPCANTypeEnum getDefaultAccess();
	
	void setDefaultAccess(IPCANTypeEnum value);
	
	RANRuleSupportEnum getRANRuleSupport();
	
	void setRANRuleSupport(RANRuleSupportEnum value);
	
	List<RoutingRuleReport> getRoutingRuleReport();
	
	void setRoutingRuleReport(List<RoutingRuleReport> value);
	
	List<ConditionalPolicyInformation> getConditionalPolicyInformation();
	
	void setConditionalPolicyInformation(List<ConditionalPolicyInformation> value) throws AvpOccursTooManyTimesException;
	
	RemovalOfAccessEnum getRemovalOfAccess();
	
	void setRemovalOfAccess(RemovalOfAccessEnum value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	public List<String> getRouteRecords();
	
	public void setRouteRecords(List<String> value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);	
}