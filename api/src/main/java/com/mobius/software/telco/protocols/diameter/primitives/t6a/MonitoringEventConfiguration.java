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
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.2	Monitoring-Event-Configuration
	The Monitoring-Event-Configuration AVP is of type Grouped. It shall contain the Monitoring event configuration related data. It is originally defined in 3GPP TS 29.336 [5].
	For the T6a/T6b interface, the Monitoring-Event-Configuration AVP format is specified as following:
	AVP format:

	Monitoring-Event-Configuration ::= <AVP header: 3122 10415>
			 [ SCEF-Reference-ID ]
			 [ SCEF-Reference-ID-Ext ]
			 { SCEF-ID }
			 { Monitoring-Type }
			*[ SCEF-Reference-ID-for-Deletion ]
			*[ SCEF-Reference-ID-for-Deletion-Ext ]
			 [ Maximum-Number-of-Reports ]
			 [ Monitoring-Duration ]
			 [ Charged-Party ]
			 [ UE-Reachability-Configuration ]
			 [ Location-Information-Configuration ]
			*[ Number-Of-UE-Per-Location-Configuration ]
			*[AVP]

	When the "Extended Reference IDs" feature is supported by the SCEF and MME/SGSN, the SCEF-Reference-ID-Ext and SCEF-Reference-ID-for-Deletion-Ext AVPs shall be used insted of SCEF-Reference-ID and SCEF-Reference-ID-for-Deletion respectively.
 */
@DiameterAvpDefinition(code = 3122L, vendorId = KnownVendorIDs.TGPP_ID, name = "Monitoring-Event-Configuration")
public interface MonitoringEventConfiguration extends DiameterGroupedAvp
{
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	Long getSCEFReferenceIDExt();
	
	void setSCEFReferenceIDExt(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);	
	
	MonitoringTypeEnum getMonitoringType();
	
	void setMonitoringType(MonitoringTypeEnum value);
	
	List<Long> getSCEFReferenceIDForDeletion();
	
	void setSCEFReferenceIDForDeletion(List<Long> value);
	
	List<Long> getSCEFReferenceIDForDeletionExt();
	
	void setSCEFReferenceIDForDeletionExt(List<Long> value);
	
	Long getMaximumNumberOfReports();
	
	void setMaximumNumberOfReports(Long value);
	
	Date getMonitoringDuration();
	
	void setMonitoringDuration(Date value);
	
	String getChargedParty();
	
	void setChargedParty(String value);
	
	UEReachabilityConfiguration getUEReachabilityConfiguration();
	
	void setUEReachabilityConfiguration(UEReachabilityConfiguration value);
	
	LocationInformationConfiguration getLocationInformationConfiguration();
	
	void setLocationInformationConfiguration(LocationInformationConfiguration value);
	
	List<NumberOfUEPerLocationConfiguration> getNumberOfUEPerLocationConfiguration();
	
	void setNumberOfUEPerLocationConfiguration(List<NumberOfUEPerLocationConfiguration> value);
}