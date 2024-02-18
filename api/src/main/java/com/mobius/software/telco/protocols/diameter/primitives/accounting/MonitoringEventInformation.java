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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AccuracyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MONTELocationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfUEPerLocationConfiguration;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.111AaC	Monitoring-Event-Information AVP
	The Monitoring-Event-Information AVP (AVP code 3921) is of type Grouped. Its purpose is to allow the transmission of additional Monitoring Event specific information elements. 
	It has the following ABNF grammar:

	Monitoring-Event-Information :: = 	< AVP Header: 3921>
			[ Monitoring-Event-Functionality ]
			[ Event-Timestamp ]
			[ Monitoring-Event-Configuration-Activity ]
			[ SCEF-Reference-ID ]
			[ SCEF-ID ]
			[ Monitoring-Type ]
			[ Maximum-Number-of-Reports ]
			[ Monitoring-Duration ]
			[ Charged-Party ]
			[ Maximum-Detection-Time] 
			[ UE-Reachability-Configuration ]
			[ MONTE-Location-Type ]
			[ Accuracy ]
		* 	[ Number-Of-UE-Per-Location-Configuration ]
		* 	[ Monitoring-Event-Report ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MONITORING_EVENT_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Monitoring-Event-Information")
public interface MonitoringEventInformation extends DiameterAvp
{
	MonitoringEventFunctionalityEnum getMonitoringEventFunctionality();
	
	void setMonitoringEventFunctionality(MonitoringEventFunctionalityEnum value);
	
	Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	MonitoringEventConfigurationActivityEnum getMonitoringEventConfigurationActivity();
	
	void setMonitoringEventConfigurationActivity(MonitoringEventConfigurationActivityEnum value);
	
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);
	
	MonitoringTypeEnum getMonitoringType();
	
	void setMonitoringType(MonitoringTypeEnum value);		

	Long getMaximumNumberOfReports();
	
	void setMaximumNumberOfReports(Long value);
	
	Date getMonitoringDuration();
	
	void setMonitoringDuration(Date value);
	
	String getChargedParty();
	
	void setChargedParty(String value);
	
	Long getMaximumDetectionTime();
	
	void setMaximumDetectionTime(Long value);
	
	UEReachabilityConfiguration getUEReachabilityConfiguration();
	
	void setUEReachabilityConfiguration(UEReachabilityConfiguration value);
	
	MONTELocationTypeEnum getMONTELocationType();
	
	void setMONTELocationType(MONTELocationTypeEnum value);
	
	AccuracyEnum getAccuracy();
	
	void setAccuracy(AccuracyEnum value);
	
	List<NumberOfUEPerLocationConfiguration> getNumberOfUEPerLocationConfiguration();
	
	void setNumberOfUEPerLocationConfiguration(List<NumberOfUEPerLocationConfiguration> value);
	
	List<MonitoringEventReport> getMonitoringEventReport();
	
	void setMonitoringEventReport(List<MonitoringEventReport> value);
}