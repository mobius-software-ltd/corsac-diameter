package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.8.15.  ETH-Proto-Type AVP

   The Eth-Proto-Type AVP (AVP Code 549) is of type Grouped and
   specifies the encapsulated protocol type.  ETH-Ether-Type and ETH-SAP
   are mutually exclusive.

   ETH-Proto-Type ::= < AVP Header: 549 >
                    * [ ETH-Ether-Type ]
                    * [ ETH-SAP ]
                    * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.ETH_PROTO_TYPE, vendorId = -1L, name = "ETH-Proto-Type")
public interface ETHProtoType extends DiameterGroupedAvp
{
	List<ByteBuf> getETHEtherType();
	
	void setETHEtherType(List<ByteBuf> value);	
	
	List<ByteBuf> getETHSAP();
	
	void setETHSAP(List<ByteBuf> value);
}