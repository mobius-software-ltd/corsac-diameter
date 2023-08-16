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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddressMaskPattern;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 525L, vendorId = -1L)
public class MACAddressMaskImpl extends DiameterGroupedAvpImpl implements MACAddressMask
{
	private MACAddress macAddress;
	
	private MACAddressMaskPattern macAddressMaskPattern;
	
	protected MACAddressMaskImpl() 
	{
	}
	
	public MACAddressMaskImpl(ByteBuf macAddress,ByteBuf macAddressMaskPattern)
	{
		if(macAddress==null)
			throw new IllegalArgumentException("MAC-Address is required");
		
		if(macAddressMaskPattern==null)
			throw new IllegalArgumentException("MAC-Address-Mask-Pattern is required");
		
		this.macAddress = new MACAddressImpl(macAddress, null, null);
		
		this.macAddressMaskPattern = new MACAddressMaskPatternImpl(macAddressMaskPattern, null, null);
	}
	
	public ByteBuf getMACAddress()
	{
		if(this.macAddress==null)
			return null;
		
		return this.macAddress.getValue();
	}
	
	public void setMACAddress(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("MAC-Address is required");
		
		this.macAddress = new MACAddressImpl(value, null, null);		
	}
	
	public ByteBuf getMACAddressMaskPattern()
	{
		if(this.macAddressMaskPattern==null)
			return null;
		
		return this.macAddressMaskPattern.getValue();
	}
	
	public void setMACAddressMaskPattern(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("MAC-Address-Mask-Pattern is required");
		
		this.macAddressMaskPattern = new MACAddressMaskPatternImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(macAddress==null)
			return "MAC-Address is required";
		
		if(macAddressMaskPattern==null)
			return "MAC-Address-Mask-Pattern is required";
		
		return null;
	}
}