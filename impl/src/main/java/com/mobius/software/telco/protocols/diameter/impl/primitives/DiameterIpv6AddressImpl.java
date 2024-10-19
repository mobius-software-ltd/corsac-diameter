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

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterPrint;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpv6Address;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
*
* @author yulian oifa
*
*/
public class DiameterIpv6AddressImpl extends DiameterOctetStringImpl implements DiameterIpv6Address
{
	private Inet6Address value;
	
	//required for parser
	protected DiameterIpv6AddressImpl() 
	{
		super(16,16);
	}
	
	public DiameterIpv6AddressImpl(Inet6Address value) 
	{
		super(Unpooled.wrappedBuffer(getBytes(value)),16,16);	
		this.value = value;
	}
	
	public Inet6Address getAddress() 
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
			byte[] data = new byte[16];
			value.readBytes(data);
			
			try
			{
				this.value = (Inet6Address)InetAddress.getByAddress(data);
			}
			catch(UnknownHostException ex)
			{
				return new InvalidAvpValueException("Value can not be Diameter Address", Arrays.asList(new DiameterAvp[] { this }));
			}
		}
		
		return null;
	}
	
	@DiameterPrint
	public void print(StringBuilder sb) 
	{
		if(value==null)
			DiameterParser.printMesage(sb, "");
		else			
			DiameterParser.printMesage(sb, value.getHostAddress());		 		
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
		
		DiameterIpv6AddressImpl other = (DiameterIpv6AddressImpl) obj;
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
		
		ByteBuf result=Unpooled.buffer(16);
		result.writeBytes(address.getAddress());
		return result;
	}
}