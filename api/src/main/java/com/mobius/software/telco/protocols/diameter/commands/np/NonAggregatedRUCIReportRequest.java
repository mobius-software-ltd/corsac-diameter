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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLocationId;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.1	Non-Aggregated-RUCI-Report-Request (NRR) command
	The NRR command, indicated by the Command-Code field set to 8388720 and the 'R' bit set in the Command Flags field, is sent by the RCAF to the PCRF as part of the Non-aggregated RUCI report procedure.
	Message Format:

	<NR-Request> ::= <Diameter Header: 8388720, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Vendor-Specific-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 [ Destination-Host ]
                 [ Origin-State-Id ]
                 [ Subscription-Id ]
                 [ Called-Station-Id ]
                 [ Congestion-Level-Value ]
                 [ Congestion-Level-Set-Id ]
                 [ Congestion-Location-Id ]
                 [ OC-Supported-Features ]
                 [ RCAF-Id ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ Supported-Features ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777342, commandCode = 8388720, request = true, proxyable = true, name="Non-Aggregated-RUCI-Report-Request")
public interface NonAggregatedRUCIReportRequest extends NpRequest
{
	SubscriptionId getSubscriptionId();
	
	void setSubscriptionId(SubscriptionId value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);
	
	Long getCongestionLevelValue();
	
	void setCongestionLevelValue(Long value);	
	
	Long getCongestionLevelSetId();
	
	void setCongestionLevelSetId(Long value);	
	
	CongestionLocationId getCongestionLocationId();
	
	void setCongestionLocationId(CongestionLocationId value);	
	
	String getRCAFId();
	
	void setRCAFId(String value);		
}