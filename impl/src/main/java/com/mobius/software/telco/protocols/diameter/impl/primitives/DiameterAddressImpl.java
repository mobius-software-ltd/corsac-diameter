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

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
*
* @author yulian oifa
*
*/
public class DiameterAddressImpl extends DiameterOctetStringImpl implements DiameterAddress
{
	private InetAddress value;
	private String e164;
	private DiameterAddressTypeEnum addressType;
	
	//required for parser
	public DiameterAddressImpl() 
	{
		super();
	}
	
	protected DiameterAddressImpl(Integer minLength,Integer maxLength) 
	{
		super(minLength,maxLength);		
	}
	
	public DiameterAddressImpl(InetAddress value,Integer minLength,Integer maxLength) 
	{
		super(Unpooled.wrappedBuffer(getBytes(value)),minLength,maxLength);	
		this.value = value;
		
		if(value!=null && value instanceof Inet4Address)
			addressType=DiameterAddressTypeEnum.IPV4;
		
		if(value!=null && value instanceof Inet6Address)
			addressType=DiameterAddressTypeEnum.IPV6;
	}
	
	public DiameterAddressImpl(String e164Value,Integer minLength,Integer maxLength) 
	{
		super(Unpooled.wrappedBuffer(getBytes(e164Value)),minLength,maxLength);	
		this.e164 = e164Value;
		addressType=DiameterAddressTypeEnum.E164;
	}
	
	public DiameterAddressImpl(DiameterAddressTypeEnum addressType,ByteBuf value,Integer minLength,Integer maxLength) 
	{
		super(getBytes(addressType,value),minLength,maxLength);	
		this.addressType = addressType;
	}
	
	public InetAddress getAddress() 
	{
		return value;
	}

	public String getE164()
	{
		return e164;
	}
		
	public DiameterAddressTypeEnum getType()
	{
		return addressType;
	}
	
	public ByteBuf getAddressValue()
	{
		ByteBuf fullValue=getValue();
		fullValue.readByte();
		fullValue.readByte();
		return fullValue;
	}
	
	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) 
	{
		super.decode(buffer, length);
		ByteBuf value = getValue();
		if(value!=null)
		{
			addressType = DiameterAddressTypeEnum.fromInt(value.readUnsignedShort());
			byte[] data = null;
			if(addressType==DiameterAddressTypeEnum.IPV4)
				data = new byte[4];
			else if(addressType==DiameterAddressTypeEnum.IPV6)
				data = new byte[16];
			
			if(data!=null)
			{
				value.readBytes(data);
			
				try
				{
					this.value = InetAddress.getByAddress(data);
				}
				catch(UnknownHostException ex)
				{
					return new InvalidAvpValueException("Value can not be Diameter Address", Arrays.asList(new DiameterAvp[] { this }));
				}
			}
			
			if(addressType == DiameterAddressTypeEnum.E164)
			{
				StringBuilder digits = new StringBuilder();

				int b;
		        while (buffer.readableBytes() > 0) {
		            b = buffer.readByte() & 0xff;

		            digits.append(Integer.toHexString(b & 0x0f));
		            digits.append(Integer.toHexString((b & 0xf0) >> 4));
		        }

		        if (digits.charAt(digits.length() - 1)=='F') {
		            digits.deleteCharAt(digits.length() - 1);
		        }

		        e164 = digits.toString();
			}
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
		
		DiameterAddressImpl other = (DiameterAddressImpl) obj;
		if (value == null) 
		{
			if (other.value != null)
				return false;
		} 
		else if (!value.equals(other.value))
			return false;
		
		return true;
	}
	
	public static ByteBuf getBytes(InetAddress address)
	{
		if(address==null)
			return Unpooled.EMPTY_BUFFER;
		
		byte[] addressBytes = address.getAddress();
		ByteBuf result=Unpooled.buffer(addressBytes.length+2);
		if(addressBytes.length==4)
			result.writeShort(DiameterAddressTypeEnum.IPV4.getValue());
		else
			result.writeShort(DiameterAddressTypeEnum.IPV6.getValue());
		
		result.writeBytes(addressBytes);
		return result;
	}
	
	public static ByteBuf getBytes(String e164)
	{
		if(e164==null)
			return Unpooled.EMPTY_BUFFER;
			
		ByteBuf buffer = Unpooled.buffer();
		buffer.writeShort(DiameterAddressTypeEnum.E164.getValue());
		
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
            buffer.writeByte(b);
        }
        
        return buffer;
	}
	
	public static ByteBuf getBytes(DiameterAddressTypeEnum addressType,ByteBuf innerValue)
	{
		ByteBuf fullBuffer=Unpooled.buffer();
		fullBuffer.writeShort(addressType.getValue());
		fullBuffer.writeBytes(innerValue);
		return fullBuffer;
	}
}