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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.62	Group-Report-Item
	The Group-Report-Item AVP is of type Grouped, and it contains the information to be reported as requested by Monitoring-Event-Configuration or Suggested-Network-Configuration for a specific UE as part of group processing.
	AVP format:

	Group-Report-Item::=	<AVP header: 3166 10415>
			 { User-Identifier }
			 [ Visited-PLMN-Id ]
			 [ Roaming-Information ]
			 [ IMEI-Change ]
			 [ Reachability-Information ]
			 [ Maximum-UE-Availability-Time ]
			 [ EPS-Location-Information ]
			 [ Monitoring-Type ]
			*[ Service-Report ]
			 [ S6t-HSS-Cause ]
			 [ Idle-Status-Indication ]
			 [ Reporting-Time-Stamp ]
			 [ Updated-Network-Configuration ]
			*[ SCEF-Reference-ID-for-Deletion ]
			*[ SCEF-Reference-ID-for-Deletion-Ext ]
			 [ Event-Handling ]
			 [ Loss-Of-Connectivity-Reason ]
			*[ PDN-Connectivity-Status-Report ]
			*[AVP]

	When the "Extended Reference IDs" feature is supported by the HSS and SCEF, the SCEF-Reference-ID-for-Deletion-Ext AVP shall be used insted of SCEF-Reference-ID-for-Deletion.
 */
@DiameterAvpDefinition(code = 3166L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Group-Report-Item")
public interface GroupReportItem extends DiameterGroupedAvp
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	RoamingInformationEnum getRoamingInformation();
	
	void setRoamingInformation(RoamingInformationEnum value);
	
	Long getIMEIChange();
	
	void setIMEIChange(Long value);
	
	ReachabilityInformationEnum getReachabilityInformation();
	
	void setReachabilityInformation(ReachabilityInformationEnum value);
	
	Date getMaximumUEAvailabilityTime();
	
	void setMaximumUEAvailabilityTime(Date value);
	
	EPSLocationInformation getEPSLocationInformation();
	
	void setEPSLocationInformation(EPSLocationInformation value);
	
	MonitoringTypeEnum getMonitoringType();
	
	void setMonitoringType(MonitoringTypeEnum value);
	
	List<ServiceReport> getServiceReport();
	
	void setServiceReport(List<ServiceReport> value);
	
	Long getS6tHSSCause();
	
	void setS6tHSSCause(Long value);
	
	IdleStatusIndication getIdleStatusIndication();
	
	void setIdleStatusIndication(IdleStatusIndication value);
	
	Date getReportingTimeStamp();
	
	void setReportingTimeStamp(Date value);
	
	UpdatedNetworkConfiguration getUpdatedNetworkConfiguration();
	
	void setUpdatedNetworkConfiguration(UpdatedNetworkConfiguration value);
	
	List<Long> getSCEFReferenceIDForDeletion();
	
	void setSCEFReferenceIDForDeletion(List<Long> value);
	
	List<Long> getSCEFReferenceIDForDeletionExt();
	
	void setSCEFReferenceIDForDeletionExt(List<Long> value);
	
	EventHandlingEnum getEventHandling();
	
	void setEventHandling(EventHandlingEnum value);
	
	LossOfConnectivityReasonEnum getLossOfConnectivityReason();
	
	void setLossOfConnectivityReason(LossOfConnectivityReasonEnum value);
	
	List<PDNConnectivityStatusReport> getPDNConnectivityStatusReport();
	
	void setPDNConnectivityStatusReport(List<PDNConnectivityStatusReport> value);
}