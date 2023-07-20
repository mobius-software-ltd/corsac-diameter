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

import java.text.ParseException;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
/**
*
* @author yulian oifa
*
*/
public class DiameterRulePortsImpl implements DiameterRulePorts
{
	private String value;
	
	private Integer min;
	private Integer max;
	
	//required for parser
	protected DiameterRulePortsImpl()
	{
		
	}
	
	public DiameterRulePortsImpl(String value) throws ParseException
	{
		this.value = value;
		parsePorts();
	}
		
	public DiameterRulePortsImpl(Integer port) throws IllegalArgumentException 
	{
		if(port<1 || port>65535)
			throw new IllegalArgumentException("port has invalid value");
		
		this.min = port;
		this.max = port;
		value = port.toString();		
	}
	
	public DiameterRulePortsImpl(Integer min,Integer max) throws IllegalArgumentException 
	{
		if(min<1 || min>65535)
			throw new IllegalArgumentException("min port has invalid value");
		
		if(max<1 || max>65535)
			throw new IllegalArgumentException("max port has invalid value");
		
		this.min = min;
		this.max = max;
		value = min.toString() + "-" + max.toString();		
	}

	public String getPortsAsString() 
	{
		return value;
	}

	public Integer getMin() 
	{
		return min;
	}

	public Integer getMax() 
	{
		return max;
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
			
		DiameterRulePortsImpl other = (DiameterRulePortsImpl) obj;
		if (value == null) 
		{
			if (other.value != null)
				return false;
		} 
		else if (!value.equals(other.value))
			return false;
			
		return true;
	}
	
	private void parsePorts() throws ParseException
	{
		String remaining=getPortsAsString();
		if(remaining.indexOf("-")>0)
		{
			String[] segments=remaining.split("-");
			if(segments.length!=2)
				throw new ParseException("Invalid ports",0);
			
			try 
			{
				min = Integer.parseInt(segments[0]);
			}
			catch(NumberFormatException ex)
			{
				throw new ParseException("Invalid port " + segments[0], 0);					
			}
			
			if(min<1 || min>65535)
				throw new ParseException("Invalid port " + segments[0], 0);
			
			try 
			{
				max = Integer.parseInt(segments[1]);
			}
			catch(NumberFormatException ex)
			{
				throw new ParseException("Invalid port " + segments[0], 0);					
			}
			
			if(max<1 || max>65535)
				throw new ParseException("Invalid port " + segments[0], 0);
		}
		else
		{
			try 
			{
				min = Integer.parseInt(remaining);
			}
			catch(NumberFormatException ex)
			{
				throw new ParseException("Invalid port " + remaining, 0);					
			}
			
			if(min<1 || min>65535)
				throw new ParseException("Invalid port " + remaining, 0);
			
			max = min;
		}
	}
}
