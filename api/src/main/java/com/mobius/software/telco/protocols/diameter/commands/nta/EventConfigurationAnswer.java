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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfigurationStatus;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventReports;

/* A.6.6.3	Event-Configuration-Answer (ECA) command
 The ECA command, indicated by the Command-Code field set to 8388735 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the SCEF as part of event monitoring configuration procedure.
 Message Format:
 <EC-Answer> ::= <Diameter Header: 8388735, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm}
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                 [ Failed-AVP ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                 [ OC-Supported-Features ]
                 [ OC-OLR ]
                 [ Event-Reports ]
                 [ Event-Configuration-Status ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ Supported-Features ]
                *[ Load ]
                *[ AVP ]
*/

@DiameterCommandDefinition(applicationId = ApplicationIDs.NTA, commandCode = CommandCodes.EVENT_CONFIGURATION, request = false, proxyable = true, name="Event-Configuration-Answer")
public interface EventConfigurationAnswer extends NtaAnswer
{
	EventReports getEventReports();
	
	void setEventReports(EventReports value);
	
	EventConfigurationStatus getEventConfigurationStatus();
	
	void setEventConfigurationStatus(EventConfigurationStatus value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
}
