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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReportStatus;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.6	Reporting-Information-Answer (RIA) Command
	The Reporting-Information-Answer (RIA) command, indicated by the Command-Code field set to 8388719 and the "R" bit cleared in the Command Flags field, is sent from:
			-	the SCEF to the MME/SGSN;
			-	the SCEF to the IWK-SCEF and
			-	the IWK-SCEF to the MME/SGSN.

	This command is originally defined in 3GPP TS 29.336 [5].
	For the T6a/T6b interface, the Reporting-Information-Answer command format is specified as following:
	Message Format:

	< Reporting-Information-Answer > ::=	< Diameter Header: 8388719, PXY, 16777346 >
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
			*[ Monitoring-Event-Report-Status ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
			*[AVP]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.T6A, commandCode = CommandCodes.REPORTING_INFORMATION, request = false, proxyable = true, name="Reporting-Information-Answer")
public interface ReportingInformationAnswer extends T6aAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	
	List<MonitoringEventReportStatus> getMonitoringEventReportStatus();
	
	void setMonitoringEventReportStatus	(List<MonitoringEventReportStatus> value);	
}