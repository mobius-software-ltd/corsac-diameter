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
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.EUI64Address;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.EUI64AddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.EUI64AddressMaskPattern;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

public class EUI64AddressMaskImpl extends DiameterGroupedAvpImpl implements EUI64AddressMask
{
	private EUI64Address eui64Address;
	
	private EUI64AddressMaskPattern eui64AddressMaskPattern;
	
	protected EUI64AddressMaskImpl() 
	{
	}
	
	public EUI64AddressMaskImpl(ByteBuf eui64Address,ByteBuf eui64AddressMaskPattern) throws MissingAvpException
	{
		setEUI64Address(eui64Address);
		
		setEUI64AddressMaskPattern(eui64AddressMaskPattern);
	}
	
	public ByteBuf getEUI64Address()
	{
		if(this.eui64Address==null)
			return null;
		
		return this.eui64Address.getValue();
	}
	
	public void setEUI64Address(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("EUI64-Address is required", Arrays.asList(new DiameterAvp[] { new EUI64AddressImpl() }));
			
		this.eui64Address = new EUI64AddressImpl(value, null, null);		
	}
	
	public ByteBuf getEUI64AddressMaskPattern()
	{
		if(this.eui64AddressMaskPattern==null)
			return null;
		
		return this.eui64AddressMaskPattern.getValue();
	}
	
	public void setEUI64AddressMaskPattern(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("EUI64-Address-Mask-Pattern is required", Arrays.asList(new DiameterAvp[] { new EUI64AddressMaskPatternImpl() }));
			
		this.eui64AddressMaskPattern = new EUI64AddressMaskPatternImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(eui64Address==null)
			return new MissingAvpException("EUI64-Address is required", Arrays.asList(new DiameterAvp[] { new EUI64AddressImpl() }));
		
		if(eui64AddressMaskPattern==null)
			return new MissingAvpException("EUI64-Address-Mask-Pattern is required", Arrays.asList(new DiameterAvp[] { new EUI64AddressMaskPatternImpl() }));
		
		return null;
	}
}