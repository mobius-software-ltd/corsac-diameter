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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.70	Routing-Rule-Definition AVP
	The Routing-Rule-Definition AVP (AVP code 1076) is of type Grouped, and it defines the IP flow mobility routing rule or NBIFOM routing rule sent by the PCEF to the PCRF.
	The Routing-Rule-Identifier AVP uniquely identifies the IP flow mobility routing rule or NBIFOM routing rule. It is used to reference to a IP flow mobility routing rule or NBIFOM routing rule in communication between the PCEF and the PCRF within one IP CAN session. 
	The Routing-IP-Address AVP identifies the IP address to be used for transporting for service data flows matching the IP flow mobility routing rule. The IP address may be a care-of-address or the home address.
	The IP-CAN-Type AVP identifies the access to be used for transporting service data flows matching the NBIFOM routing rule. The IP-CAN type can be 3GPP-EPS or Non-3GPP-EPS in this release.
	The Routing-Filter AVP(s) contains detailed description of routing filter(s) for determining the service data flows that belong to the IP flow mobility routing rule or NBIFOM routing rule.
	AVP Format:

	Routing-Rule-Definition ::= < AVP Header: 1076 >
		 { Routing-Rule-Identifier }
		*[ Routing-Filter ]
 		 [ Precedence ]
		 [ Routing-IP-Address ]
		 [ IP-CAN-Type ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 1076L, vendorId = KnownVendorIDs.TGPP_ID, must=false, name = "Routing-Rule-Definition")
public interface RoutingRuleDefinition extends DiameterGroupedAvp
{
	ByteBuf getRoutingRuleIdentifier();
	
	void setRoutingRuleIdentifier(ByteBuf value);	
	
	List<RoutingFilter> getRoutingFilter();
	
	void setRoutingFilter(List<RoutingFilter> value);	
	
	Long getPrecedence();
	
	void setPrecedence(Long value);	
	
	InetAddress getRoutingIPAddress();
	
	void setRoutingIPAddress(InetAddress value);
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
}