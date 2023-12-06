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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AdditionalIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SuggestedNetworkConfiguration;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.3	Configuration Information Request (CIR) Command
	The Configuration Information Request (CIR) command, indicated by the Command-Code field set to 8388718 and the "R" bit set in the Command Flags field, is sent from the SCEF to the HSS.
	Message Format:
	
	< Configuration-Information-Request > ::=	< Diameter Header: 8388718, REQ, PXY, 16777345 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { User-Identifier }
				 [ OC-Supported-Features ]
				*[ Supported-Features ]
				*[ Monitoring-Event-Configuration ]
				 [ CIR-Flags ]
				*[ AESE-Communication-Pattern ]
				 [ Enhanced-Coverage-Restriction ]
				 [ Group-Reporting-Guard-Timer ]
				 [ AdditionalIdentifiers ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				 [ Suggested-Network-Configuration ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = 16777345, commandCode = 8388718, request = true, proxyable = true, name="Configuration-Information-Request")
public interface ConfigurationInformationRequest extends S6tRequest
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	 
	
	List<MonitoringEventConfiguration> getMonitoringEventConfiguration();
	
	void setMonitoringEventConfiguration(List<MonitoringEventConfiguration> value);
	
	Long getCIRFlags();
	
	void setCIRFlags(Long value);
	
	List<AESECommunicationPattern> getAESECommunicationPattern();
	
	void setAESECommunicationPattern(List<AESECommunicationPattern> value);	
	
	EnhancedCoverageRestriction getEnhancedCoverageRestriction();
	
	void setEnhancedCoverageRestriction(EnhancedCoverageRestriction value);	
	
	Long getGroupReportingGuardTimer();
	
	void setGroupReportingGuardTimer(Long value);	
	
	AdditionalIdentifiers getAdditionalIdentifiers();
	
	void setAdditionalIdentifiers(AdditionalIdentifiers value);	
	
	SuggestedNetworkConfiguration getSuggestedNetworkConfiguration();
	
	void setSuggestedNetworkConfiguration(SuggestedNetworkConfiguration value);
}