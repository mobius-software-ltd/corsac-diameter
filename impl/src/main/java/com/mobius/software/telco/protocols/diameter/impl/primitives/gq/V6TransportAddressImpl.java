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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.PortNumber;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V6TransportAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class V6TransportAddressImpl implements V6TransportAddress
{
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private PortNumber portNumber;
	
	protected V6TransportAddressImpl()
	{
		
	}
	
	public V6TransportAddressImpl(ByteBuf framedIPv6Prefix,Long portNumber) throws MissingAvpException
	{
		setFramedIPv6Prefix(framedIPv6Prefix);
		
		setPortNumber(portNumber);
	}
	
	public ByteBuf getFramedIPv6Prefix()
	{
		if(framedIPv6Prefix == null)
			return null;
		
		return framedIPv6Prefix.getValue();
	}
	
	public void setFramedIPv6Prefix(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Framed-IPv6-Prefix requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new FramedIPv6PrefixImpl() }));
			
		this.framedIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);
	}
	
	public Long getPortNumber()
	{
		if(portNumber == null)
			return null;
		
		return portNumber.getUnsigned();
	}
	
	public void setPortNumber(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Port-Number requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new PortNumberImpl() }));
		
		this.portNumber = new PortNumberImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(framedIPv6Prefix==null)
			return new MissingAvpException("Framed-IPv6-Prefix requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new FramedIPv6PrefixImpl() }));
		
		if(portNumber==null)
			return new MissingAvpException("Port-Number requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new PortNumberImpl() }));
		
		return null;
	}
}