package com.mobius.software.telco.protocols.diameter.commands.t6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.3	Configuration Information Request (CIR) Command
	The Configuration Information Request (CIR) command, indicated by the Command-Code field set to 8388718 and the "R" bit set in the Command Flags field, is sent from:
		-	the SCEF to the MME/SGSN;
		-	the SCEF to the IWK-SCEF and
		-	the MME/SGSN to the IWK-SCEF

	This command is originally defined in 3GPP TS 29.336 [5].
	For the T6a/T6b interface, the Configuration-Information-Request command format is specified as following:
	Message Format:

	< Configuration-Information-Request > ::=	< Diameter Header: 8388718, REQ, PXY, 16777346 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				*[ Supported-Features ]
				*[ Monitoring-Event-Configuration ]
				*[ Monitoring-Event-Report ]
				 [ User-Identifier ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = 16777346, commandCode = 8388718, request = true, proxyable = true, name="Configuration-Information-Request")
public interface ConfigurationInformationRequest extends T6aRequest
{
	List<MonitoringEventConfiguration> getMonitoringEventConfiguration();
	
	void setMonitoringEventConfiguration(List<MonitoringEventConfiguration> value);
	
	List<MonitoringEventReport> getMonitoringEventReport();
	
	void setMonitoringEventReport(List<MonitoringEventReport> value);	
	
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);		
}