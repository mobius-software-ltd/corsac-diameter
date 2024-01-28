package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.PortEnd;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.PortRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.PortStart;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 531L, vendorId = -1L)
public class PortRangeImpl extends DiameterGroupedAvpImpl implements PortRange
{
private PortStart portStart;
	
	private PortEnd portEnd;
	
	protected PortRangeImpl() 
	{
	}
	
	public PortRangeImpl(Integer portStart,Integer portEnd)
	{
		if(portStart!=null)
			this.portStart = new PortStartImpl(portStart, null, null);
		
		if(portEnd!=null)
			this.portEnd = new PortEndImpl(portEnd, null, null);
	}
	
	public Integer getPortStart()
	{
		if(this.portStart==null)
			return null;
		
		return this.portStart.getInteger();
	}
	
	public void setPortStart(Integer value)
	{
		if(value==null)
			this.portStart = null;
		else
			this.portStart = new PortStartImpl(value, null, null);		
	}
	
	public Integer getPortEnd()
	{
		if(this.portEnd==null)
			return null;
		else
			return this.portEnd.getInteger();
	}
	
	public void setPortEnd(Integer value)
	{
		if(value==null)
			this.portEnd = null;
		else
			this.portEnd = new PortEndImpl(value, null, null);
	}
}