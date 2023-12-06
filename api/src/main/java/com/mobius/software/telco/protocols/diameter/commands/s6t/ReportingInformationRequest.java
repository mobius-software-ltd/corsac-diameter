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
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UpdatedNetworkConfiguration;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.5	Reporting-Information-Request (RIR) Command
	The Reporting-Information-Request (RIR) command, indicated by the Command-Code field set to 8388719 and the "R" bit cleared in the Command Flags field, is sent from the HSS to the SCEF.
	Message Format:

	< Reporting-Information-Request > ::=	< Diameter Header: 8388719, PXY, 16777345 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Host }
				 { Destination-Realm }
				*[ Supported-Features ]
				 [ User-Identifier ]
				*[ Monitoring-Event-Report ]
				*[ Group-Report ]
				 [ Updated-Network-Configuration ]
				 [ RIR-Flags ]
				*[ Supported-Services ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP]
 */
@DiameterCommandDefinition(applicationId = 16777345, commandCode = 8388719, request = true, proxyable = true, name="Reporting-Information-Request")
public interface ReportingInformationRequest extends S6tRequest
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);
	
	List<MonitoringEventReport> getMonitoringEventReport();
	
	void setMonitoringEventReport(List<MonitoringEventReport> value);
	
	List<GroupReport> getGroupReport();
	
	void setGroupReport(List<GroupReport> value);
	
	UpdatedNetworkConfiguration getUpdatedNetworkConfiguration();
	
	void setUpdatedNetworkConfiguration(UpdatedNetworkConfiguration value);
	
	Long getRIRFlags();
	
	void setRIRFlags(Long value);
	
	List<SupportedServices> getSupportedServices();
	
	void setSupportedServices(List<SupportedServices> value);	
}