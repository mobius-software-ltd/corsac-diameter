package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectAddressTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServerAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectSupportEnum;

/**
*
* @author yulian oifa
*
*/
public class RedirectInformationImpl extends DiameterGroupedAvpImpl implements RedirectInformation
{
	private RedirectSupport redirectSupport;
	private RedirectAddressType redirectAddressType;
	private RedirectServerAddress redirectServerAddress;
		
	public RedirectInformationImpl()
	{
		
	}
	
	public RedirectSupportEnum getRedirectSupport()
	{
		if(redirectSupport==null)
			return null;
		
		return redirectSupport.getEnumerated(RedirectSupportEnum.class);
	}
	
	public void setRedirectSupport(RedirectSupportEnum value)
	{
		if(value==null)
			this.redirectSupport = null;
		else
			this.redirectSupport = new RedirectSupportImpl(value, null, null);			
	}
	
	public RedirectAddressTypeEnum getRedirectAddressType()
	{
		if(redirectAddressType==null)
			return null;
		
		return redirectAddressType.getEnumerated(RedirectAddressTypeEnum.class);
	}
	
	public void setRedirectAddressType(RedirectAddressTypeEnum value)
	{
		if(value==null)
			this.redirectAddressType = null;
		else
			this.redirectAddressType = new RedirectAddressTypeImpl(value, null, null);			
	}
	
	public String getRedirectServerAddress()
	{
		if(redirectServerAddress==null)
			return null;
		
		return redirectServerAddress.getString();
	}
	
	public void setRedirectServerAddress(String value)
	{
		if(value==null)
			this.redirectServerAddress = null;
		else
			this.redirectServerAddress = new RedirectServerAddressImpl(value, null, null);			
	}
}