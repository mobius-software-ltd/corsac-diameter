package com.mobius.software.telco.protocols.diameter.primitives.s9;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANRuleSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RemovalOfAccessEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleRemove;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.1	Subsession-Decision-Info
	The Subsession-Decision-Info AVP (AVP code 2200) is of type Grouped, and it is used to manage PCC/QoS rules and event information within an S9 subsession from the H-PCRF to the V-PCRF.
	The information contained within this grouped AVP pertains only to the subsession identified by the Subsession-Id AVP.
	The Session-Release-Cause AVP is only applicable when the Subsession-Decision-Info AVP is provided in a RAR.
	The Result-Code AVP and Experimental-Result-Code AVP are only applicable when the Subsession-Decision-Info AVP is provided in a CCA. The Result-Code AVP or Experimental-Result-Code AVP may be provided to inform the V-PCRF of possible errors when processing subsession information that was provided in a corresponding CCR command.
	AVP Format:
	Subsession-Decision-Info ::= < AVP Header: 2200 >
                             { Subsession-Id }
                          0*2[ AN-GW-Address ]
                             [ Result-Code ]
                             [ Experimental-Result-Code ]
                            *[ Charging-Rule-Remove ]
                            *[ Charging-Rule-Install ]
                             [ Event-Report-Indication ]
                            *[ QoS-Rule-Install ]
                            *[ QoS-Rule-Remove ]
                             [ Default-EPS-Bearer-QoS ]
                             [ Framed-Ipv6-Prefix ]
                            *[ Usage-Monitoring-Information ]
                             [ Session-Release-Cause ]
                             [ Bearer-Control-Mode ]
                            *[ Event-Trigger ]
                             [ Revalidation-Time ]
                             [ Default-Access ]
                             [ NBIFOM-Support ]
                             [ NBIFOM-Mode ]
                             [ RAN-Rule-Support ]
                            *[ Routing-Rule-Report]
                             [ Removal-Of-Access ]
                             [ IP-CAN-Type ]
                             [ Online ]
                             [ Offline ]
                            *[ QoS-Information ]
                            *[ AVP ]
 */
@DiameterAvpDefinition(code = 2200L, vendorId = KnownVendorIDs.TGPP_ID, name = "Subsession-Decision-Info")
public interface SubsessionDecisionInfo extends DiameterGroupedAvp
{
	Long getSubsessionId();
	
	void setSubsessionId(Long value);
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value);
	
	public Long getResultCode();
	
	void setResultCode(Long value);
	
	Long getExperimentalResultCode();
	
	void setExperimentalResultCode(Long experimentalResultCode);	
	
	List<ChargingRuleRemove> getChargingRuleRemove();
	
	void setChargingRuleRemove(List<ChargingRuleRemove> value);	
	
	List<ChargingRuleInstall> getChargingRuleInstall();
	
	void setChargingRuleInstall(List<ChargingRuleInstall> value);	
	
	EventReportIndication getEventReportIndication();
	
	void setEventReportIndication(EventReportIndication value);
	
	List<QoSRuleRemove> getQoSRuleRemove();
	
	void setQoSRuleRemove(List<QoSRuleRemove> value);	
	
	List<QoSRuleInstall> getQoSRuleInstall();
	
	void setQoSRuleInstall(List<QoSRuleInstall> value);
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS();
	
	void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value);
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	List<UsageMonitoringInformation> getUsageMonitoringInformation();
	
	void setUsageMonitoringInformation(List<UsageMonitoringInformation> value);	
	
	SessionReleaseCauseEnum getSessionReleaseCause();
	
	void setSessionReleaseCause(SessionReleaseCauseEnum value);
	
	BearerControlModeEnum getBearerControlMode();
	
	void setBearerControlMode(BearerControlModeEnum value);
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);
	
	public Date getRevalidationTime();
	
	void setRevalidationTime(Date value);
	
	IPCANTypeEnum getDefaultAccess();
	
	void setDefaultAccess(IPCANTypeEnum value);
	
	NBIFOMModeEnum getNBIFOMMode();
	
	void setNBIFOMMode(NBIFOMModeEnum value);	
	
	NBIFOMSupportEnum getNBIFOMSupport();
	
	void setNBIFOMSupport(NBIFOMSupportEnum value);	
	
	RANRuleSupportEnum getRANRuleSupport();
	
	void setRANRuleSupport(RANRuleSupportEnum value);
	
	List<RoutingRuleReport> getRoutingRuleReport();
	
	void setRoutingRuleReport(List<RoutingRuleReport> value);
	
	RemovalOfAccessEnum getRemovalOfAccess();
	
	void setRemovalOfAccess(RemovalOfAccessEnum value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	OnlineEnum getOnline();
	
	void setOnline(OnlineEnum value);	
	
	OfflineEnum getOffline();
	
	void setOffline(OfflineEnum value);	

	List<QoSInformation> getQoSInformation();
	
	void setQoSInformation(List<QoSInformation> value);	
}