package com.mobius.software.telco.protocols.diameter.commands.np;
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
import com.mobius.software.telco.protocols.diameter.primitives.np.AggregatedRUCIReport;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.3	Aggregated-RUCI-Report-Request (ARR) command
	The ARR command, indicated by the Command-Code field set to 8388721 and the 'R' bit set in the Command Flags field, is sent by the RCAF to the PCRF as part of the Aggregated RUCI report procedure.
	Message Format:

	<AR-Request> ::= <Diameter Header: 8388721, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Vendor-Specific-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 [ Destination-Host ]
                 [ Origin-State-Id ]
                *[ Aggregated-RUCI-Report ]
                 [ OC-Supported-Features ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ Supported-Features ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NP, commandCode = CommandCodes.AGGREGATED_RUCI_REPORT, request = true, proxyable = true, name="Aggregated-RUCI-Report-Request")
public interface AggregatedRUCIReportRequest extends NpRequest
{
	List<AggregatedRUCIReport> getAggregatedRUCIReport();
	
	void setAggregatedRUCIReport(List<AggregatedRUCIReport> value);
	
	public List<SupportedFeatures> getSupportedFeatures();

	public void setSupportedFeatures(List<SupportedFeatures> value);
}