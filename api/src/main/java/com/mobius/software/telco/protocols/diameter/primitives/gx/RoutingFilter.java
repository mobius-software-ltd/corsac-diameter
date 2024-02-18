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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.72	Routing-Filter AVP
	The Routing-Filter AVP (AVP code 1078) is of type Grouped and is sent from the PCEF to the PCRF. This AVP contains the information for a single routing filter . 
	The Routing-Filter AVP shall include the Flow-Direction AVP with value set to "BIDIRECTIONAL". The direction information contained in the Flow-Description AVP shall be "out".
	The routing filter may be wild carded by omitting ToS-Traffic-Class AVP, Security-Parameter-Index AVP, and Flow-Label AVP, setting Flow-Direction AVP to the value "BIDIRECTIONAL", setting Flow-Description AVP to the value "permit out ip from any to any".
	The Routing-Filter AVP may also include the Type-of-Service/Traffic Class, the IPSec SPI, and the Flow Label. The values of these AVPs are obtained from the routing information provided to the PCEF.
	AVP Format:

	Routing-Filter ::= < AVP Header: 1078 >
		 { Flow-Description }
		 { Flow-Direction }
		 [ ToS-Traffic-Class ]
		 [ Security-Parameter-Index ]
		 [ Flow-Label ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROUTING_FILTER, vendorId = VendorIDs.TGPP_ID, must=false, name = "Routing-Filter")
public interface RoutingFilter extends DiameterGroupedAvp
{
	FlowDescription getFlowDescription();
	
	void setFlowDescription(FlowDescription value) throws MissingAvpException;	
	
	FlowDirectionEnum getFlowDirection();
	
	void setFlowDirection(FlowDirectionEnum value) throws MissingAvpException;	
	
	ByteBuf getToSTrafficClass();
	
	void setToSTrafficClass(ByteBuf value);	
	
	ByteBuf getSecurityParameterIndex();
	
	void setSecurityParameterIndex(ByteBuf value);
	
	ByteBuf getFlowLabel();
	
	void setFlowLabel(ByteBuf value);
}