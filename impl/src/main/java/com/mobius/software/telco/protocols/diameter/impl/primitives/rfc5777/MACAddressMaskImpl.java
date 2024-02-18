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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddressMaskPattern;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

public class MACAddressMaskImpl extends DiameterGroupedAvpImpl implements MACAddressMask
{
	private MACAddress macAddress;
	
	private MACAddressMaskPattern macAddressMaskPattern;
	
	protected MACAddressMaskImpl() 
	{
	}
	
	public MACAddressMaskImpl(ByteBuf macAddress,ByteBuf macAddressMaskPattern) throws MissingAvpException
	{
		setMACAddress(macAddress);
		
		setMACAddressMaskPattern(macAddressMaskPattern);
	}
	
	public ByteBuf getMACAddress()
	{
		if(this.macAddress==null)
			return null;
		
		return this.macAddress.getValue();
	}
	
	public void setMACAddress(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MAC-Address is required", Arrays.asList(new DiameterAvp[] { new MACAddressImpl() }));
		
		this.macAddress = new MACAddressImpl(value, null, null);		
	}
	
	public ByteBuf getMACAddressMaskPattern()
	{
		if(this.macAddressMaskPattern==null)
			return null;
		
		return this.macAddressMaskPattern.getValue();
	}
	
	public void setMACAddressMaskPattern(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MAC-Address-Mask-Pattern is required", Arrays.asList(new DiameterAvp[] { new MACAddressMaskPatternImpl() }));
			
		this.macAddressMaskPattern = new MACAddressMaskPatternImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(macAddress==null)
			return new MissingAvpException("MAC-Address is required", Arrays.asList(new DiameterAvp[] { new MACAddressImpl() }));
		
		if(macAddressMaskPattern==null)
			return new MissingAvpException("MAC-Address-Mask-Pattern is required", Arrays.asList(new DiameterAvp[] { new MACAddressMaskPatternImpl() }));
		
		return null;
	}
}