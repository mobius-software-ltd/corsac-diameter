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

import java.nio.charset.Charset;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterPrint;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
*
* @author yulian oifa
*
*/
public class DiameterUTF8StringImpl extends DiameterOctetStringImpl implements DiameterUTF8String
{
	public static final Charset ENCODING=Charset.forName("UTF-8");
	private String value;
	
	//required for parser
	public DiameterUTF8StringImpl() 
	{
		super();
	}
	
	protected DiameterUTF8StringImpl(Integer minLength,Integer maxLength) 
	{
		super(minLength,maxLength);		
	}
	
	public DiameterUTF8StringImpl(String value,Integer minLength,Integer maxLength) 
	{
		super(Unpooled.wrappedBuffer(value.getBytes()),minLength,maxLength);	
		this.value = value;
	}
	
	public String getString() 
	{
		return value;
	}

	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) 
	{
		super.decode(buffer, length);
		ByteBuf value = getValue();
		if(value!=null)
			this.value = value.toString(ENCODING);
		
		return null;
	}
	
	@DiameterPrint
	public void print(StringBuilder sb) 
	{
		if(value==null)
			DiameterParser.printMesage(sb, "");
		else			
			DiameterParser.printMesage(sb, value);		 		
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
		
		DiameterUTF8StringImpl other = (DiameterUTF8StringImpl) obj;
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