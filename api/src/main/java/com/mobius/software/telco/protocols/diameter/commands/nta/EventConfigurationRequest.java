package com.mobius.software.telco.protocols.diameter.commands.nta;

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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfiguration;

/* 
    A.6.6.2	Event-Configuration-Request (ECR) command
 The ECR command, indicated by the Command-Code field set to 8388735 and the 'R' bit set in the Command Flags field, is sent by the SCEF to the PCRF as part of event monitoring configuration procedure.
 Message Format:
 <EC-Request> ::= <Diameter Header: 8388735, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 [ Destination-Host ]
                 [ OC-Supported-Features ]
                 { External-Group-Identifier }
                 [ Event-Configuration ]
                 [ Group-Reporting-Guard-Timer ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ Supported-Features ]
                *[ AVP ]
                
                * External-Group-Identifier AVP was not found, references to it are in s6m/s6t
*/

@DiameterCommandDefinition(applicationId = ApplicationIDs.NTA, commandCode = CommandCodes.EVENT_CONFIGURATION, request = true, proxyable = true, name="Event-Configuration-Request")
public interface EventConfigurationRequest extends NtaRequest
{
	List<String> getExternalIdentifier();
	
	void setExternalIdentifier(List<String> value) throws MissingAvpException;
	
	EventConfiguration getEventConfiguration();
	
	void setEventConfiguration(EventConfiguration value);
	
	Long getGroupReportingGuardTimer();
	
	void setGroupReportingGuardTimer(Long value);	
	
	public List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);
	
}
