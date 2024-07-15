package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServerAddress;

/**
*
* @author yulian oifa
*
*/
public class RedirectServerImpl extends DiameterAvpImpl implements RedirectServer
{
	private RedirectAddressType redirectAddressType;
	
	private RedirectServerAddress redirectServerAddress;
	
	public RedirectServerImpl()
	{
		
	}
	
	public RedirectServerImpl(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress) throws MissingAvpException
	{
		setRedirectAddressType(redirectAddressType);
		
		setRedirectServerAddress(redirectServerAddress);
	}
	
	public RedirectAddressTypeEnum getRedirectAddressType()
	{
		if(redirectAddressType == null)
			return null;
		
		return redirectAddressType.getEnumerated(RedirectAddressTypeEnum.class);
	}
	
	public void setRedirectAddressType(RedirectAddressTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Redirect-Address-Type is required is required", Arrays.asList(new DiameterAvp[] { new RedirectAddressTypeImpl() }));
		
		this.redirectAddressType = new RedirectAddressTypeImpl(value, null, null);		
	}
	
	public String getRedirectServerAddress()
	{
		if(redirectServerAddress == null)
			return null;
		
		return redirectServerAddress.getString();
	}
	
	public void setRedirectServerAddress(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Redirect-Server-Address is required is required", Arrays.asList(new DiameterAvp[] { new RedirectServerAddressImpl() }));
			
		this.redirectServerAddress = new RedirectServerAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(redirectAddressType==null)
			return new MissingAvpException("Redirect-Address-Type is required is required", Arrays.asList(new DiameterAvp[] { new RedirectAddressTypeImpl() }));
		
		if(redirectServerAddress==null)
			return new MissingAvpException("Redirect-Server-Address is required is required", Arrays.asList(new DiameterAvp[] { new RedirectServerAddressImpl() }));
		
		return null;
	}
}