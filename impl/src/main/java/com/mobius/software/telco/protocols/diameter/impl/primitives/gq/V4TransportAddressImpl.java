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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gq.PortNumber;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V4TransportAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 454L, vendorId = KnownVendorIDs.TGPP_ID)
public class V4TransportAddressImpl implements V4TransportAddress
{
	private FramedIPAddress framedIPAddress;
	
	private PortNumber portNumber;
	
	protected V4TransportAddressImpl()
	{
		
	}
	
	public V4TransportAddressImpl(Inet4Address framedIPAddress,Long portNumber)
	{
		if(framedIPAddress==null)
			throw new IllegalArgumentException("Framed-IP-Address is required");
		
		if(portNumber==null)
			throw new IllegalArgumentException("Port-Number is required");
		
		this.framedIPAddress = new FramedIPAddressImpl(framedIPAddress);	
		
		this.portNumber = new PortNumberImpl(portNumber, null, null);
	}
	
	public Inet4Address getFramedIPAddress()
	{
		if(framedIPAddress == null)
			return null;
		
		return framedIPAddress.getAddress();
	}
	
	public void setFramedIPAddress(Inet4Address value)
	{
		if(value==null)
			throw new IllegalArgumentException("Framed-IP-Address is required");
		
		this.framedIPAddress = new FramedIPAddressImpl(value);
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
		if(framedIPAddress==null)
			return "Framed-IP-Address is required";
		
		if(portNumber==null)
			return "Port-Number is required";
		
		return null;
	}
}