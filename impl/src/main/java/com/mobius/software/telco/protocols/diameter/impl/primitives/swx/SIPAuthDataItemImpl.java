package com.mobius.software.telco.protocols.diameter.impl.primitives.swx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ConfidentialityKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.IntegrityKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPAuthenticateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPAuthenticationSchemeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPAuthorizationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPItemNumberImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ConfidentialityKey;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.IntegrityKey;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthenticationScheme;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthorization;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPItemNumber;
import com.mobius.software.telco.protocols.diameter.primitives.swx.SIPAuthDataItem;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class SIPAuthDataItemImpl extends DiameterGroupedAvpImpl implements SIPAuthDataItem
{
	private SIPItemNumber sipItemNumber;
	
	private SIPAuthenticationScheme sipAuthenticationScheme;
	
	private SIPAuthenticate sipAuthenticate;
	
	private SIPAuthorization sipAuthorization;
	
	private ConfidentialityKey confidentialityKey;
	
	private IntegrityKey integrityKey;
	
	public SIPAuthDataItemImpl()
	{
		
	}
	
	public Long getSIPItemNumber()
	{
		if(sipItemNumber==null)
			return null;
		
		return sipItemNumber.getUnsigned();
	}
	
	public void setSIPItemNumber(Long value)
	{
		if(value == null)
			this.sipItemNumber = null;
		else
			this.sipItemNumber = new SIPItemNumberImpl(value, null, null);
	}
	
	public String getSIPAuthenticationScheme()
	{
		if(sipAuthenticationScheme==null)
			return null;
		
		return sipAuthenticationScheme.getString();
	}
	
	public void setSIPAuthenticationScheme(String value)
	{
		if(value == null)
			this.sipAuthenticationScheme = null;
		else
			this.sipAuthenticationScheme = new SIPAuthenticationSchemeImpl(value, null, null);
	}
	
	public ByteBuf getSIPAuthenticate()
	{
		if(sipAuthenticate==null)
			return null;
		
		return sipAuthenticate.getValue();
	}
	
	public void setSIPAuthenticate(ByteBuf value)
	{
		if(value == null)
			this.sipAuthenticate = null;
		else
			this.sipAuthenticate = new SIPAuthenticateImpl(value, null, null);
	}
	
	public ByteBuf getSIPAuthorization()
	{
		if(sipAuthorization==null)
			return null;
		
		return sipAuthorization.getValue();
	}
	
	public void setSIPAuthorization(ByteBuf value)
	{
		if(value == null)
			this.sipAuthorization = null;
		else
			this.sipAuthorization = new SIPAuthorizationImpl(value, null, null);
	}
	
	public ByteBuf getConfidentialityKey()
	{
		if(confidentialityKey==null)
			return null;
		
		return confidentialityKey.getValue();
	}
	
	public void setConfidentialityKey(ByteBuf value)
	{
		if(value == null)
			this.confidentialityKey = null;
		else
			this.confidentialityKey = new ConfidentialityKeyImpl(value, null, null);
	}
	
	public ByteBuf getIntegrityKey()
	{
		if(integrityKey==null)
			return null;
		
		return integrityKey.getValue();
	}
	
	public void setIntegrityKey(ByteBuf value)
	{
		if(value == null)
			this.integrityKey = null;
		else
			this.integrityKey = new IntegrityKeyImpl(value, null, null);
	}
}