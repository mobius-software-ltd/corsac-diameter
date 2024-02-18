package com.mobius.software.telco.protocols.diameter.commands.s6t;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPatternConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SuggestedNetworkConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.4	Configuration-Information-Answer (CIA) Command
	The Configuration-Information-Answer (CIA) command, indicated by the Command-Code field set to 8388718 and the "R" bit cleared in the Command Flags field, is sent from the HSS to the SCEF.
	Message Format:

	< Configuration-Information-Answer > ::=	< Diameter Header: 8388718, PXY, 16777345 >
				 < Session-Id >
				 [ DRMP ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Load ]
				*[ Supported-Features ]
				 [ User-Identifier ]
				 [ Number-of-UEs ]
				*[ Monitoring-Event-Report ]
				*[ Monitoring-Event-Config-Status ]
				*[ AESE-Communication-Pattern-Config-Status ]
				*[ Supported-Services ]
				 [ S6t-HSS-Cause ]
				 [ Enhanced-Coverage-Restriction-Data ]
				 [ CIA-Flags ]
				*[ IMSI-Group-Id]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				 [ Suggested-Network-Configuration ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6T, commandCode = CommandCodes.CONFIGURATION_INFORMATION, request = false, proxyable = true, name="Configuration-Information-Answer")
public interface ConfigurationInformationAnswer extends S6tAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 		
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value);
	
	ServiceData getServiceData();
	 
	void setServiceData(ServiceData value);	
	
	Long getNumberOfUEs();
	
	void setNumberOfUEs(Long value);	
	
	List<MonitoringEventReport> getMonitoringEventReport();
	
	void setMonitoringEventReport(List<MonitoringEventReport> value);	
	
	List<MonitoringEventConfigStatus> getMonitoringEventConfigStatus();
	
	void setMonitoringEventConfigStatus(List<MonitoringEventConfigStatus> value);	
	
	List<AESECommunicationPatternConfigStatus> getAESECommunicationPatternConfigStatus();
	
	void setAESECommunicationPatternConfigStatus(List<AESECommunicationPatternConfigStatus> value);	
	
	List<SupportedServices> getSupportedServices();
	
	void setSupportedServices(List<SupportedServices> value);	
	
	Long getS6tHSSCause();
	
	void setS6tHSSCause(Long value);	
	
	EnhancedCoverageRestriction getEnhancedCoverageRestriction();
	
	void setEnhancedCoverageRestriction(EnhancedCoverageRestriction value);	
	
	CIAFlags getCIAFlags();
	
	void setCIAFlags(CIAFlags value);
	
	List<IMSIGroupId> getIMSIGroupId();
	
	void setIMSIGroupId(List<IMSIGroupId> value);
	
	SuggestedNetworkConfiguration getSuggestedNetworkConfiguration();
	
	void setSuggestedNetworkConfiguration(SuggestedNetworkConfiguration value);
}