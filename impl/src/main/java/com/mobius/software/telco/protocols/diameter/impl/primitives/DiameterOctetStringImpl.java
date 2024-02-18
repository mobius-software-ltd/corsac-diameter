package com.mobius.software.telco.protocols.diameter.impl.primitives;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterEncode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterLength;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpLengthException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

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

/**
*
* @author yulian oifa
*
*/

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
*
* @author yulian oifa
*
*/
public class DiameterOctetStringImpl implements DiameterOctetString
{
	public static ByteBuf PADDING_0=Unpooled.EMPTY_BUFFER;
	public static ByteBuf PADDING_1=Unpooled.wrappedBuffer(new byte[] { 0x00, 0x00, 0x00 });
	public static ByteBuf PADDING_2=Unpooled.wrappedBuffer(new byte[] { 0x00, 0x00 });
	public static ByteBuf PADDING_3=Unpooled.wrappedBuffer(new byte[] { 0x00 });
	
	public static ByteBuf[] PADDINGS = { PADDING_0, PADDING_1, PADDING_2, PADDING_3 };
	
	private ByteBuf value;
	private ByteBuf padding;
	private Integer minLength;
	private Integer maxLength;
	
	//required for parser
	protected DiameterOctetStringImpl() 
	{
		
	}
	
	protected DiameterOctetStringImpl(Integer minLength,Integer maxLength) 
	{
		this.minLength = minLength;
		this.maxLength = maxLength;
	}
	
	public DiameterOctetStringImpl(ByteBuf value,Integer minLength,Integer maxLength) 
	{
		this.value=Unpooled.wrappedBuffer(value);
		this.padding = Unpooled.wrappedBuffer(PADDINGS[value.readableBytes()%4]);
		this.minLength = minLength;
		this.maxLength = maxLength;
	}
	
	public ByteBuf getValue() 
	{
		if(value==null)
			return Unpooled.EMPTY_BUFFER;
		
		return Unpooled.wrappedBuffer(value);
	}

	@DiameterLength
	public Integer getLength() 
	{
		if(value==null)
			return 0;
		
		return value.readableBytes() + padding.readableBytes();
	}
	
	@DiameterEncode
	public void encode(ByteBuf buffer) 
	{
		if(value==null)
			return;
		
		buffer.writeBytes(value);
		if(padding.readableBytes()>0)
			buffer.writeBytes(padding);
	}
	
	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) 
	{
		if(buffer.readableBytes()<length)
			return new InvalidAvpLengthException("AVP Length is bigger then available data", Arrays.asList(new DiameterAvp[] { this }));
		
		value =  buffer.readBytes(length);		
		this.padding = PADDINGS[value.readableBytes()%4];	
		return null;
	}
	
	@DiameterValidate
	public String validateElement() 
	{
		if(((minLength!=null && minLength>0) || (maxLength!=null && maxLength>0)) && value==null) 
			return "Avp value not set";
		else if(minLength!=null && value!=null && value.readableBytes()<minLength)
			return " value should be at least " + minLength + " bytes length";
		else if(maxLength!=null && value!=null && value.readableBytes()>maxLength)
			return "value should be at most " + maxLength + " bytes length";
		
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
		
		DiameterOctetStringImpl other = (DiameterOctetStringImpl) obj;
		if (value == null) 
		{
			if (other.value != null)
				return false;
		} 
		else if (!value.equals(other.value))
			return false;
		
		return true;
	}
}