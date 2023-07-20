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
import java.text.ParseException;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
/**
*
* @author yulian oifa
*
*/
public class DiameterRuleAddressImpl implements DiameterRuleAddress
{
	private String value;
	
	private InetAddress address;
	private Integer bits;
	private Boolean isInverse;
	private Boolean isAssigned;
	private Boolean isAny;
	
	//required for parser
	protected DiameterRuleAddressImpl()
	{
		
	}
	
	public DiameterRuleAddressImpl(String value) throws ParseException
	{
		this.value = value;
		parseAddress();
	}
		
	public DiameterRuleAddressImpl(Boolean isAssigned,Boolean isAny,Boolean isInverse) throws IllegalArgumentException 
	{
		this.address = null;
		this.bits = null;
		this.isAssigned = isAssigned;
		this.isInverse = isInverse;
		this.isAny = isAny;
		
		if(isAssigned!=null && isAssigned && isAny!=null && isAny)
			throw new IllegalArgumentException("both assigned and any can not be true");
		
		if((isAssigned==null || !isAssigned) && (isAny==null || !isAny))
			throw new IllegalArgumentException("neither assigned nor any are not true");
		
		if(isAssigned!=null && isAssigned)
		{
			if(isInverse!=null && isInverse)
				value="!assigned";
			else
				value="assigned";
		}
		else
		{
			if(isInverse!=null && isInverse)
				value="!any";
			else
				value="any";
		}
	}
		
	public DiameterRuleAddressImpl(InetAddress address,Integer bits,Boolean isInverse) throws IllegalArgumentException 
	{
		this.address = address;
		this.bits = bits;
		this.isAny = false;
		this.isAssigned = false;
		this.isInverse = false;
		
		if(bits!=null)
		{
			if(bits<0)
				throw new IllegalArgumentException("bits can not be negative");
			
			if(isAssigned!=null && isAssigned && isAny!=null && isAny)
				throw new IllegalArgumentException("both assigned and any can not be true");
			
			if(address instanceof Inet4Address && bits>32)
				throw new IllegalArgumentException("bits for ipv4 can not exceed /32");
			
			if(address instanceof Inet6Address && bits>128)
				throw new IllegalArgumentException("bits for ipv6 can not exceed /128");
			
			if(isInverse!=null && isInverse)
				value = "!" + this.address.getHostAddress() + "/" + bits;
			else
				value = this.address.getHostAddress() + "/" + bits;
		}
		else
		{
			if(isInverse!=null && isInverse)
				value = "!" + this.address.getHostAddress();
			else
				value = this.address.getHostAddress();
		}
	}

	public String getAddressAsString() 
	{
		return value;
	}

	public InetAddress getAddress() 
	{
		return address;
	}

	public Integer getBits() 
	{
		return bits;
	}

	public Boolean getIsInverse() 
	{
		return isInverse;
	}

	public Boolean getIsAssigned() 
	{
		return isAssigned;
	}

	public Boolean getIsAny() 
	{
		return isAny;
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
			
		DiameterRuleAddressImpl other = (DiameterRuleAddressImpl) obj;
		if (value == null) 
		{
			if (other.value != null)
				return false;
		} 
		else if (!value.equals(other.value))
			return false;
			
		return true;
	}
	
	private void parseAddress() throws ParseException
	{
		String remaining=getAddressAsString();
		this.isInverse=false;
		Integer errorOffset=0;
		if(remaining.startsWith("!"))
		{
			remaining=remaining.substring(1);
			this.isInverse=true;
			errorOffset=1;
		}
		
		if(remaining.indexOf("/")>0)
		{
			String[] segments=remaining.split("/");
			if(segments.length!=2)
				throw new ParseException("Invalid address",errorOffset);
			
			try 
			{
				bits = Integer.parseInt(segments[1]);
			}
			catch(NumberFormatException ex)
			{
				throw new ParseException("Invalid number of bits " + segments[1], errorOffset);					
			}
			
			if(bits<=0 || bits>128)
				throw new ParseException("Invalid number of bits " + segments[1], errorOffset);
			
			remaining=segments[0];
		}
		
		isAny=false;
		isAssigned=false;
		if(remaining.equalsIgnoreCase("any"))
			isAny=true;
		else if(remaining.equalsIgnoreCase("assigned"))
			isAssigned=true;
		else
		{
			try
			{
				this.address = InetAddress.getByName(remaining);
			}
			catch(UnknownHostException ex)
			{
				throw new ParseException("Invalid address " + remaining, errorOffset);				
			}
			
			if(this.address instanceof Inet4Address && bits!=null && bits>32)
				throw new ParseException("Invalid number of bits " + bits, errorOffset);
			
		}
	}
}
