package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LossOfConnectivityReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformationEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.3	Monitoring-Event-Report
	The Monitoring-Event-Report AVP is of type Grouped. It shall contain the Monitoring event report data. It is originally defined in 3GPP TS 29.336 [5].
	For the T6a/T6b interface, the Monitoring-Event-Report AVP format is specified as following:
	AVP format:

	Monitoring-Event-Report ::= <AVP header: 3123 10415>
			 { SCEF-Reference-ID }
			 [ SCEF-Reference-ID-Ext ]
			 [ SCEF-ID ]
			 [ Monitoring-Type ]
			 [ Reachability-Information ]
			 [ EPS-Location-Information ]
			 [ Communication-Failure-Information ]
			*[ Number-Of-UE-Per-Location-Report ]
			 [ Loss-Of-Connectivity-Reason ]
			 [ Visited-PLMN-Id ]
			 [ Idle-Status-Indication ]
			 [ Reporting-Time-Stamp ]
			 [ Maximum-UE-Availability-Time ]
			*[ PDN-Connectivity-Status-Report ]
			 [ Reachability-Cause ]
			*[AVP]

	The AVPs applicable for each Monitoring-Type reported by the MME/SGSN are specified under clause 5.2.2.
	When the "Extended Reference IDs" feature is supported by the SCEF and MME/SGSN, the SCEF-Reference-ID-Ext AVP shall be used insted of SCEF-Reference-ID; in such case, the required AVP "SCEF-Reference-ID" shall be included in the grouped AVP by the sender, but its content shall be discarded by the receiver.
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
	
	MonitoringTypeEnum getMonitoringType();
	
	void setMonitoringType(MonitoringTypeEnum value);	
	
	ReachabilityInformationEnum getReachabilityInformation();
	
	void setReachabilityInformation(ReachabilityInformationEnum value);
	
	EPSLocationInformation getEPSLocationInformation();
	
	void setEPSLocationInformation(EPSLocationInformation value);
	
	CommunicationFailureInformation getCommunicationFailureInformation();
	
	void setCommunicationFailureInformation(CommunicationFailureInformation value);
	
	List<NumberOfUEPerLocationReport> getNumberOfUEPerLocationReport();
	
	void setNumberOfUEPerLocationReport(List<NumberOfUEPerLocationReport> value);
	
	LossOfConnectivityReasonEnum getLossOfConnectivityReason();
	
	void setLossOfConnectivityReason(LossOfConnectivityReasonEnum value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	IdleStatusIndication getIdleStatusIndication();
	
	void setIdleStatusIndication(IdleStatusIndication value);
	
	Date getReportingTimeStamp();
	
	void setReportingTimeStamp(Date value);
	
	Date getMaximumUEAvailabilityTime();
	
	void setMaximumUEAvailabilityTime(Date value);
	
	List<PDNConnectivityStatusReport> getPDNConnectivityStatusReport();
	
	void setPDNConnectivityStatusReport(List<PDNConnectivityStatusReport> value);
	
	ReachabilityCauseEnum getReachabilityCause();
	
	void setReachabilityCause(ReachabilityCauseEnum value);		
}