package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticationScheme;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticationSchemeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthorization;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPItemNumber;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 376L, vendorId = -1L)
public class SIPAuthDataItemImpl extends DiameterGroupedAvpImpl implements SIPAuthDataItem
{
	private SIPAuthenticationScheme sipAuthenticationScheme;
	
	private SIPItemNumber sipItemNumber;
	
	private SIPAuthenticate sipAuthenticate;
	
	private SIPAuthorization sipAuthorization;
	
	private SIPAuthenticationInfo sipAuthenticationInfo;
		
	protected SIPAuthDataItemImpl()
	{
		
	}
	
	public SIPAuthDataItemImpl(SIPAuthenticationSchemeEnum sipAuthenticationScheme)
	{
		if(sipAuthenticationScheme == null)
			throw new IllegalArgumentException("SIP-Authentication-Scheme is required");
		
		this.sipAuthenticationScheme = new SIPAuthenticationSchemeImpl(sipAuthenticationScheme, null, null);
	}
	
	public SIPAuthenticationSchemeEnum getSIPAuthenticationScheme()
	{
		if(sipAuthenticationScheme == null)
			return null;
		
		return sipAuthenticationScheme.getEnumerated(SIPAuthenticationSchemeEnum.class);
	}
	
	public void setSIPAuthenticationScheme(SIPAuthenticationSchemeEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("SIP-Authentication-Scheme is required");
		
		this.sipAuthenticationScheme = new SIPAuthenticationSchemeImpl(value, null, null);
	}	
	
	public Long getSIPItemNumber()
	{
		if(sipItemNumber==null)
			return null;
		
		return sipItemNumber.getUnsigned();
	}
	
	public void setSIPItemNumber(Long value)
	{
		if(value==null)
			this.sipItemNumber = null;
		else
			this.sipItemNumber = new SIPItemNumberImpl(value, null, null);
	}
	
	public SIPAuthenticate getSIPAuthenticate()
	{
		return sipAuthenticate;
	}
	
	public void setSIPAuthenticate(SIPAuthenticate value)
	{
		this.sipAuthenticate = value;
	}
	
	public SIPAuthorization getSIPAuthorization()
	{
		return sipAuthorization;
	}
	
	public void setSIPAuthorization(SIPAuthorization value)
	{
		this.sipAuthorization = value;
	}
	
	public SIPAuthenticationInfo getSIPAuthenticationInfo()
	{
		return sipAuthenticationInfo;
	}
	
	public void setSIPAuthenticationInfo(SIPAuthenticationInfo value)
	{
		this.sipAuthenticationInfo = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(sipAuthenticationScheme == null)
			return "SIP-Authentication-Scheme is required";
		
		return null;
	}	
}