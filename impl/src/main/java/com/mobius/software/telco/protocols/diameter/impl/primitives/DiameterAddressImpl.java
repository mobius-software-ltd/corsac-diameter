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

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

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
	
	//required for parser
	protected DiameterAddressImpl() 
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
	}
	
	public InetAddress getAddress() 
	{
		return value;
	}

	@DiameterDecode
	public String decode(ByteBuf buffer,Integer length) 
	{
		super.decode(buffer, length);
		ByteBuf value = getValue();
		if(value!=null)
		{
			value.readByte();
			int type=value.readByte();			
			byte[] data;
			
			if(type==1)
				data = new byte[4];
			else
				data = new byte[16];
			
			value.readBytes(data);
			
			try
			{
				this.value = InetAddress.getByAddress(data);
			}
			catch(UnknownHostException ex)
			{
				return "AVP is having invalid format";
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
		result.writeByte(0);
		if(addressBytes.length==4)
			result.writeByte(1);
		else
			result.writeByte(2);
		
		result.writeBytes(addressBytes);
		return result;
	}
}