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

import java.net.Inet4Address;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.PortNumber;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V4TransportAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;

/**
*
* @author yulian oifa
*
*/
public class V4TransportAddressImpl implements V4TransportAddress
{
	private FramedIPAddress framedIPAddress;
	
	private PortNumber portNumber;
	
	protected V4TransportAddressImpl()
	{
		
	}
	
	public V4TransportAddressImpl(Inet4Address framedIPAddress,Long portNumber) throws MissingAvpException
	{
		setFramedIPAddress(framedIPAddress);
		
		setPortNumber(portNumber);
	}
	
	public Inet4Address getFramedIPAddress()
	{
		if(framedIPAddress == null)
			return null;
		
		return framedIPAddress.getAddress();
	}
	
	public void setFramedIPAddress(Inet4Address value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Framed-IP-Address requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new FramedIPAddressImpl() }));
		
		this.framedIPAddress = new FramedIPAddressImpl(value);
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
		if(framedIPAddress==null)
			return new MissingAvpException("Framed-IP-Address requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new FramedIPAddressImpl() }));
		
		if(portNumber==null)
			return new MissingAvpException("Port-Number requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new PortNumberImpl() }));
		
		return null;
	}
}