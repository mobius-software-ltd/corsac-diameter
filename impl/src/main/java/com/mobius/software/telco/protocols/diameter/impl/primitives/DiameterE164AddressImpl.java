package com.mobius.software.telco.protocols.diameter.impl.primitives;
/*
 * Mobius Software LTD, Open Source Cloud Communications
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterE164Address;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
*
* @author yulian oifa
*
*/
public class DiameterE164AddressImpl extends DiameterOctetStringImpl implements DiameterE164Address
{
	private String value;
	
	//required for parser
	protected DiameterE164AddressImpl() 
	{
		super(4,4);
	}
	
	public DiameterE164AddressImpl(String value) 
	{
		super(Unpooled.wrappedBuffer(getBytes(value)),4,4);	
		this.value = value;
	}
	
	public String getAddress() 
	{
		return value;
	}

	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) 
	{
		super.decode(buffer, length);
		ByteBuf value = getValue();
		if(value!=null)
		{
			StringBuilder digits = new StringBuilder();

			int b;
	        while (value.readableBytes() > 0) {
	            b = value.readByte() & 0xff;

	            digits.append(Integer.toHexString(b & 0x0f));
	            digits.append(Integer.toHexString((b & 0xf0) >> 4));
	        }

	        if (digits.charAt(digits.length() - 1)=='F' || digits.charAt(digits.length() - 1)=='f') {
	            digits.deleteCharAt(digits.length() - 1);
	        }

	        this.value = digits.toString();
		}
		
		return null;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		DiameterE164AddressImpl other = (DiameterE164AddressImpl) obj;
		if (value == null) 
		{
			if (other.value != null)
				return false;
		} 
		else if (!value.equals(other.value))
			return false;
		
		return true;
	}
	
	public static ByteBuf getBytes(String e164)
	{
		if(e164==null)
			return Unpooled.EMPTY_BUFFER;
			
		ByteBuf buffer = Unpooled.buffer();
		
		boolean odd= e164.length() % 2 != 0;
        
        int b = 0;

        int count = odd ? e164.length() - 1 : e164.length();
        
        for (int i = 0; i < count - 1; i += 2) {
            String ds1 = e164.substring(i, i + 1);
            String ds2 = e164.substring(i + 1, i + 2);

            int d1 = Integer.parseInt(ds1, 16);
            int d2 = Integer.parseInt(ds2, 16);

            b = (byte) (d2 << 4 | d1);
            buffer.writeByte(b);
        }

        if (odd) {
            String ds1 = e164.substring(count, count + 1);
            int d = Integer.parseInt(ds1, 16);

            b = (byte) (d & 0x0f);
            b += 0xf0;
            buffer.writeByte(b);
        }
        
        return buffer;
	}
}