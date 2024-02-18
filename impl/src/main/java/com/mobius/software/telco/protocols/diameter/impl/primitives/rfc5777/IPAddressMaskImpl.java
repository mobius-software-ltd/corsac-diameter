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
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPBitMaskWidth;

/**
*
* @author yulian oifa
*
*/

public class IPAddressMaskImpl extends DiameterGroupedAvpImpl implements IPAddressMask
{
	private IPAddress ipAddress;
	
	private IPBitMaskWidth ipBitMaskWidth;
	
	protected IPAddressMaskImpl() 
	{
	}
	
	public IPAddressMaskImpl(InetAddress ipAddress,Long ipBitMaskWidth) throws MissingAvpException
	{
		setIPAddress(ipAddress);
		
		setIPBitMaskWidth(ipBitMaskWidth);
	}
	
	public InetAddress getIPAddress()
	{
		if(this.ipAddress==null)
			return null;
		
		return this.ipAddress.getAddress();
	}
	
	public void setIPAddress(InetAddress value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("IP-Address is required", Arrays.asList(new DiameterAvp[] { new IPAddressImpl() }));
			
		this.ipAddress = new IPAddressImpl(value, null, null);		
	}
	
	public Long getIPBitMaskWidth()
	{
		if(this.ipBitMaskWidth==null)
			return null;
		
		return this.ipBitMaskWidth.getUnsigned();
	}
	
	public void setIPBitMaskWidth(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("IP-Bit-Mask-Width is required", Arrays.asList(new DiameterAvp[] { new IPBitMaskWidthImpl() }));
			
		this.ipBitMaskWidth = new IPBitMaskWidthImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ipAddress==null)
			return new MissingAvpException("IP-Address is required", Arrays.asList(new DiameterAvp[] { new IPAddressImpl() }));
		
		if(ipBitMaskWidth==null)
			return new MissingAvpException("IP-Bit-Mask-Width is required", Arrays.asList(new DiameterAvp[] { new IPBitMaskWidthImpl() }));
		
		return null;
	}
}