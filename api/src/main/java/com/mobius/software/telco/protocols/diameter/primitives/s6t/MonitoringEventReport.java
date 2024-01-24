package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ReachabilityCauseEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.3	Monitoring-Event-Report
	The Monitoring-Event-Report AVP is of type Grouped, and it contains the information to be reported as requested by Monitoring-Event-Configuration.
	AVP format:

	Monitoring-Event-Report::=	<AVP header: 3123 10415>
			 { SCEF-Reference-ID }
			 [ SCEF-Reference-ID-Ext ]
			 [ SCEF-ID ]
			 [ SCEF-Reference-ID-for-Deletion ]
			 [ SCEF-Reference-ID-for-Deletion-Ext ]
			 [ Visited-PLMN-Id ]
			 [ Roaming-Information ]
			 [ IMEI-Change ]
			 [ Terminal-Information ]
			 [ Reachability-Information ]
			 [ Reachability-Cause ]
			 [ Maximum-UE-Availability-Time ]
			 [ EPS-Location-Information ]
			 [ Monitoring-Type ]
			 [ Event-Handling ]
			*[ Service-Report ]
			 [ Loss-Of-Connectivity-Reason ]
			 [ Idle-Status-Indication ]
			*[ PDN-Connectivity-Status-Report ]
			*[AVP]

	When the "Extended Reference IDs" feature is supported by the HSS and SCEF, the SCEF-Reference-ID-Ext and SCEF-Reference-ID-for-Deletion-Ext AVPs shall be used insted of SCEF-Reference-ID and SCEF-Reference-ID-for-Deletion respectively; in such case, the required AVP "SCEF-Reference-ID" shall be included in the grouped AVP by the sender, but its content shall be discarded by the receiver.
 */
@DiameterAvpDefinition(code = 3123L, vendorId = KnownVendorIDs.TGPP_ID, name = "Monitoring-Event-Report")
public interface MonitoringEventReport extends DiameterGroupedAvp
{
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	Long getSCEFReferenceIDExt();
	
	void setSCEFReferenceIDExt(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);
	
	List<Long> getSCEFReferenceIDForDeletion();
	
	void setSCEFReferenceIDForDeletion(List<Long> value);
	
	List<Long> getSCEFReferenceIDForDeletionExt();
	
	void setSCEFReferenceIDForDeletionExt(List<Long> value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	RoamingInformationEnum getRoamingInformation();
	
	void setRoamingInformation(RoamingInformationEnum value);
	
	IMEIChange getIMEIChange();
	
	void setIMEIChange(IMEIChange value);
	
	TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);
	
	ReachabilityInformationEnum getReachabilityInformation();
	
	void setReachabilityInformation(ReachabilityInformationEnum value);
	
	ReachabilityCauseEnum getReachabilityCause();
	
	void setReachabilityCause(ReachabilityCauseEnum value);
	
	Date getMaximumUEAvailabilityTime();
	
	void setMaximumUEAvailabilityTime(Date value);
	
	EPSLocationInformation getEPSLocationInformation();
	
	void setEPSLocationInformation(EPSLocationInformation value);
	
	MonitoringTypeEnum getMonitoringType();
	
	void setMonitoringType(MonitoringTypeEnum value);	
	
	EventHandlingEnum getEventHandling();
	
	void setEventHandling(EventHandlingEnum value);
	
	List<ServiceReport> getServiceReport();
	
	void setServiceReport(List<ServiceReport> value);
	
	LossOfConnectivityReasonEnum getLossOfConnectivityReason();
	
	void setLossOfConnectivityReason(LossOfConnectivityReasonEnum value);
	
	IdleStatusIndication getIdleStatusIndication();
	
	void setIdleStatusIndication(IdleStatusIndication value);
	
	List<PDNConnectivityStatusReport> getPDNConnectivityStatusReport();
	
	void setPDNConnectivityStatusReport(List<PDNConnectivityStatusReport> value);
}