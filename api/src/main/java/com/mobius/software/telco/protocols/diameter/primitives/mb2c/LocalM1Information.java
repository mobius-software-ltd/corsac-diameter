package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.20	Local-M1-Information AVP
	The Local-M1-Information AVP (AVP code 3518) is of type Grouped. It is used to indicates the M1 interface information between the eNB and MBMS GW for local MBMS based MBMS data delivery.
	AVP Format:
	
	Local-M1-Information::=          < AVP Header: 3518 >
                                 [ MBMS-eNB-IP-Multicast-Address ]
                                 [ MBMS-eNB-IPv6-Multicast-Address ]
                                 [ MBMS-GW-SSM-IP-Address ]
                                 [ MBMS-GW-SSM-IPv6-Address ]
                                 [ Common-Tunnel-Endpoint-Identifier ]
 */
@DiameterAvpDefinition(code = 3518L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Local-M1-Information")
public interface LocalM1Information extends DiameterAvp
{
	InetAddress getMBMSENBIPMulticastAddress();
	
	void setMBMSENBIPMulticastAddress(InetAddress value);	
	
	InetAddress getMBMSENBIPv6MulticastAddress();
	
	void setMBMSENBIPv6MulticastAddress(InetAddress value);	
	
	InetAddress getMBMSGWSSMIPAddress();
	
	void setMBMSGWSSMIPAddress(InetAddress value);	
	
	InetAddress getMBMSGWSSMIPv6Address();
	
	void setMBMSGWSSMIPv6Address(InetAddress value);	
	
	ByteBuf getCommonTunnelEndpointIdentifier();
	
	void setCommonTunnelEndpointIdentifier(ByteBuf value);
}