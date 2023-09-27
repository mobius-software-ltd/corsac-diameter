package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CommunicationFailureInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfUEPerLocationReport;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.111AaD	Monitoring-Event-Report-Data AVP
	The Monitoring-Event-Report-Data AVP (AVP code 3920) is of type Grouped. Its purpose is to allow the transmission of charging information associated with an individual Monitoring Event report. 
	It has the following ABNF grammar:

	Monitoring-Event-Report-Data :: = 	< AVP Header: 3920>
			[ Event-Timestamp ]
			[ SCEF-Reference-ID ]
			[ SCEF-ID ]
			[ Monitoring-Event-Report-Number ]
			[ Charged-Party ]
			[ Subscription-Id ]
			[ Monitoring-Type ]
			[ Reachability-Information ]
			[ EPS-Location-Information ]
			[ Communication-Failure-Information ]
		* 	[ Number-Of-UE-Per-Location-Report ]
 */
@DiameterAvpDefinition(code = 3920L, vendorId = KnownVendorIDs.TGPP_ID, name = "Monitoring-Event-Report-Data")
public interface MonitoringEventReportData extends DiameterAvp
{
	Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);
	
	Long getMonitoringEventReportNumber();
	
	void setMonitoringEventReportNumber(Long value);		

	String getChargedParty();
	
	void setChargedParty(String value);
	
	SubscriptionId getSubscriptionId();
	
	void setSubscriptionId(SubscriptionId value);
	
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
}