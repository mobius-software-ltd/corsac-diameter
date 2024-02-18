package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.36	Tunnel-Information AVP (All access types)
	The Tunnel-Information AVP (AVP code 1038) is of type Grouped, and it contains the tunnel (outer) header information from a single IP flow. The Tunnel-Information AVP is sent from the PCEF to the PCRF and from the PCRF to the BBERF.
	The Tunnel-Information AVP may include only the Tunnel-Header-Length AVP, only the Tunnel-Header-Filter AVP, or both.
	The Tunnel-Header-Length AVP provides the length of the tunnel header and identifies the offset where the tunnelled payload starts. The BBERF uses the length value provided in Tunnel-Header-Length AVP to locate the inner IP header and perform service data flow detection and related QoS control.
	The Tunnel-Header-Filter AVP identifies the tunnel (outer) header information in the downlink and uplink directions.
	AVP Format:

	Tunnel-Information ::= < AVP Header: 1038 >
		  [ Tunnel-Header-Length ]
		2 [ Tunnel-Header-Filter ]
		* [ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TUNNEL_INFORMATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "Tunnel-Information")
public interface TunnelInformation extends DiameterGroupedAvp
{
	Long getTunnelHeaderLength();
	
	void setTunnelHeaderLength(Long value);		
	
	List<TunnelHeaderFilter> getTunnelHeaderFilter();
	
	void setTunnelHeaderFilter(List<TunnelHeaderFilter> value) throws AvpOccursTooManyTimesException;		  
}