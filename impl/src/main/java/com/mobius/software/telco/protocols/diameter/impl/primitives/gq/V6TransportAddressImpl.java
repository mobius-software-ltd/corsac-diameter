package com.mobius.software.telco.protocols.diameter.impl.primitives.gq;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gq.PortNumber;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V6TransportAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 453L, vendorId = KnownVendorIDs.TGPP_ID)
public class V6TransportAddressImpl implements V6TransportAddress
{
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private PortNumber portNumber;
	
	protected V6TransportAddressImpl()
	{
		
	}
	
	public V6TransportAddressImpl(ByteBuf framedIPv6Prefix,Long portNumber)
	{
		if(framedIPv6Prefix==null)
			throw new IllegalArgumentException("Framed-IPv6-Prefix is required");
		
		if(portNumber==null)
			throw new IllegalArgumentException("Port-Number is required");
		
		this.framedIPv6Prefix = new FramedIPv6PrefixImpl(framedIPv6Prefix, null, null);	
		
		this.portNumber = new PortNumberImpl(portNumber, null, null);
	}
	
	public ByteBuf getFramedIPv6Prefix()
	{
		if(framedIPv6Prefix == null)
			return null;
		
		return framedIPv6Prefix.getValue();
	}
	
	public void setFramedIPv6Prefix(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Framed-IPv6-Prefix is required");
		
		this.framedIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);
	}
	
	public Long getPortNumber()
	{
		if(portNumber == null)
			return null;
		
		return portNumber.getUnsigned();
	}
	
	public void setPortNumber(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Port-Number is required");
		
		this.portNumber = new PortNumberImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(framedIPv6Prefix==null)
			return "Framed-IPv6-Prefix is required";
		
		if(portNumber==null)
			return "Port-Number is required";
		
		return null;
	}
}