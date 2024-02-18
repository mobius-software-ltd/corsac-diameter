package com.mobius.software.telco.protocols.diameter.primitives.rfc6734;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 3.1.  Key AVP

   The Key AVP (AVP Code 581) is of type Grouped.  It contains the type
   and keying material and, optionally, an indication of the usable
   lifetime of the key, the name of the key and a Security Parameter
   Index (SPI) with which the key is associated.

   Key ::= < AVP Header: 581 >
             < Key-Type >
             { Keying-Material }
             [ Key-Lifetime ]
             [ Key-Name ]
             [ Key-SPI ]
           * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.KEY, vendorId = -1L, must = false, name = "Key")
public interface Key extends DiameterGroupedAvp
{
	KeyTypeEnum getKeyType();
	
	void setKeyType(KeyTypeEnum value) throws MissingAvpException;	
	
	ByteBuf getKeyingMaterial();
	
	void setKeyingMaterial(ByteBuf value) throws MissingAvpException;
	
	Long getKeyLifetime();
	
	void setKeyLifetime(Long value);	
	
	ByteBuf getKeyName();
	
	void setKeyName(ByteBuf value);
	
	Long getKeySPI();
	
	void setKeySPI(Long value);
}