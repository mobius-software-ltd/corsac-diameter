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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServerAddress;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 434L, vendorId = -1)
public class RedirectServerImpl implements RedirectServer
{
	private RedirectAddressType redirectAddressType;
	
	private RedirectServerAddress redirectServerAddress;
	
	protected RedirectServerImpl()
	{
		
	}
	
	public RedirectServerImpl(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress)
	{
		if(redirectAddressType==null)
			throw new IllegalArgumentException("Redirect-Address-Type is required");
		
		if(redirectServerAddress==null)
			throw new IllegalArgumentException("Redirect-Server-Address is required");
		
		this.redirectAddressType = new RedirectAddressTypeImpl(redirectAddressType, null, null);
		
		this.redirectServerAddress = new RedirectServerAddressImpl(redirectServerAddress, null, null);
	}
	
	public RedirectAddressTypeEnum getRedirectAddressType()
	{
		if(redirectAddressType == null)
			return null;
		
		return redirectAddressType.getEnumerated(RedirectAddressTypeEnum.class);
	}
	
	public void setRedirectAddressType(RedirectAddressTypeEnum redirectAddressType)
	{
		if(redirectAddressType==null)
			throw new IllegalArgumentException("Redirect-Address-Type is required");
		
		this.redirectAddressType = new RedirectAddressTypeImpl(redirectAddressType, null, null);		
	}
	
	public String getRedirectServerAddress()
	{
		if(redirectServerAddress == null)
			return null;
		
		return redirectServerAddress.getString();
	}
	
	public void setRedirectServerAddress(String redirectServerAddress)
	{
		if(redirectServerAddress==null)
			throw new IllegalArgumentException("Redirect-Server-Address is required");
		
		this.redirectServerAddress = new RedirectServerAddressImpl(redirectServerAddress, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(redirectAddressType==null)
			return "Redirect-Address-Type is required";
		
		if(redirectServerAddress==null)
			return "Redirect-Server-Address is required";
		
		return null;
	}
}