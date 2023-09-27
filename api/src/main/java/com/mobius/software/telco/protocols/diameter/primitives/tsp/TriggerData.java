package com.mobius.software.telco.protocols.diameter.primitives.tsp;
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
 * 	6.4.4	Trigger-Data AVP
	The Trigger-Data AVP (AVP code 3003) is of type Grouped. It is used by the SCS to supply all data required for a device trigger request.
	AVP Format:
	Trigger-Data ::=                    < AVP Header: 3003 >
			 { Payload }
			 [ Priority-Indication ]
			 [ Application-Port-Identifier ]
 			*[ AVP ]
 */
@DiameterAvpDefinition(code = 3003L, vendorId = KnownVendorIDs.TGPP_ID, name = "Trigger-Data")
public interface TriggerData extends DiameterGroupedAvp
{
	ByteBuf getPayload();
	
	void setPayload(ByteBuf value);	
	
	PriorityIndicationEnum getPriorityIndication();
	
	void setPriorityIndication(PriorityIndicationEnum value);
	
	Long getApplicationPortIdentifier();
	
	void setApplicationPortIdentifier(Long value);
}