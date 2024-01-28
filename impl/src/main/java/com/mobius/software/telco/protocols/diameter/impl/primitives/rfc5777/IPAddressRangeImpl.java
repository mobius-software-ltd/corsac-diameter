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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressEnd;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressStart;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 519L, vendorId = -1L)
public class IPAddressRangeImpl extends DiameterGroupedAvpImpl implements IPAddressRange
{
	private IPAddressStart ipAddressStart;
	
	private IPAddressEnd ipAddressEnd;
	
	protected IPAddressRangeImpl() 
	{
	}
	
	public IPAddressRangeImpl(InetAddress ipAddressStart,InetAddress ipAddressEnd)
	{
		if(ipAddressStart!=null)
			this.ipAddressStart = new IPAddressStartImpl(ipAddressStart, null, null);
		
		if(ipAddressEnd!=null)
			this.ipAddressEnd = new IPAddressEndImpl(ipAddressEnd, null, null);
	}
	
	public InetAddress getIPAddressStart()
	{
		if(this.ipAddressStart==null)
			return null;
		
		return this.ipAddressStart.getAddress();
	}
	
	public void setIPAddressStart(InetAddress value)
	{
		if(value==null)
			this.ipAddressStart = null;
		else
			this.ipAddressStart = new IPAddressStartImpl(value, null, null);		
	}
	
	public InetAddress getIPAddressEnd()
	{
		if(this.ipAddressEnd==null)
			return null;
		else
			return this.ipAddressEnd.getAddress();
	}
	
	public void setIPAddressEnd(InetAddress value)
	{
		if(value==null)
			this.ipAddressEnd = null;
		else
			this.ipAddressEnd = new IPAddressEndImpl(value, null, null);
	}
}