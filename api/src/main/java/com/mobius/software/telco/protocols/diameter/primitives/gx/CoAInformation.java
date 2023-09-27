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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.37	CoA-Information AVP (All access types)
	The CoA-Information AVP (AVP code 1039) is of type Grouped, and it contains care-of-address and the tunnel information related to the care of address. The CoA-Information AVP is sent from the PCEF to the PCRF.
	When used, the CoA-Information AVP shall include a CoA-IP-Address AVP. The CoA-Information AVP shall also include a Tunnel-Information AVP, which provides the tunnel header length and tunnel header filter information related to the specific care-of-address.
	AVP Format:
	
	CoA-Information ::= < AVP Header: 1039>
		 { Tunnel-Information }
		 { CoA-IP-Address }
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 1039L, vendorId = KnownVendorIDs.TGPP_ID, must=false, name = "CoA-Information")
public interface CoAInformation extends DiameterGroupedAvp
{
	TunnelInformation getTunnelInformation();
	
	void setTunnelInformation(TunnelInformation value);		
	
	InetAddress getCoAIPAddress();
	
	void setCoAIPAddress(InetAddress value);		  
}