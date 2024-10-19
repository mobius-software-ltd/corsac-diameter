package com.mobius.software.telco.protocols.diameter.impl.primitives;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterEncode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterLength;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterPrint;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpLengthException;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

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
/**
*
* @author yulian oifa
*
*/
public class DiameterUnsigned32Impl extends DiameterAvpImpl implements DiameterUnsigned32
{
	private Long value;
	private Long minValue;
	private Long maxValue;
	
	//required for parser
	public DiameterUnsigned32Impl() 
	{
		
	}
	
	protected DiameterUnsigned32Impl(Long minValue,Long maxValue) 
	{
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	public DiameterUnsigned32Impl(Long value,Long minValue,Long maxValue) 
	{
		this.value=value;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	public Long getUnsigned() 
	{
		return value;
	}

	@DiameterLength
	public Integer getLength() 
	{
		if(value==null)
			return 0;
		
		return 4;
	}
	
	@DiameterEncode
	public void encode(ByteBuf buffer) 
	{
		if(value==null)
			return;
		
		buffer.writeInt(value.intValue());	 		
	}
	
	@DiameterPrint
	public void print(StringBuilder sb) 
	{
		if(value==null)
			DiameterParser.printMesage(sb, "");
		else			
			DiameterParser.printMesage(sb, value.toString());		 		
	}
	
	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) 
	{
		if(buffer.readableBytes()<4)
			new InvalidAvpLengthException("AVP Length should be 4 bytes", Arrays.asList(new DiameterAvp[] { this }));
		
		value = buffer.readUnsignedInt();
		return null;
	}
	
	@DiameterValidate
	public String validateElement() 
	{
		if((minValue!=null || maxValue!=null) && value==null) 
			return "Avp value not set";
		else if(minValue!=null && value!=null && value<minValue)
			return " value should be at least " + minValue;
		else if(maxValue!=null && value!=null && value>maxValue)
			return "value should be at most " + maxValue;
		
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
		
		DiameterUnsigned32Impl other = (DiameterUnsigned32Impl) obj;
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