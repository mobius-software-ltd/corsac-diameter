package com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx;
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
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedInterfaceIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ConfidentialityKey;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.IntegrityKey;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.LineIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthenticationContext;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthenticationScheme;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthorization;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPDigestAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPItemNumber;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedInterfaceId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 612L, vendorId = KnownVendorIDs.TGPP_ID)
public class SIPAuthDataItemImpl extends DiameterGroupedAvpImpl implements SIPAuthDataItem
{
	private SIPItemNumber sipItemNumber;
	
	private SIPAuthenticationScheme sipAuthenticationScheme;
	
	private SIPAuthenticate sipAuthenticate;
	
	private SIPAuthorization sipAuthorization;
	
	private SIPAuthenticationContext sipAuthenticationContext;
	
	private ConfidentialityKey confidentialityKey;
	
	private IntegrityKey integrityKey;
	
	private SIPDigestAuthenticate sipDigestAuthenticate;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private FramedInterfaceId framedInterfaceId;
	
	private List<LineIdentifier> lineIdentifier;
	
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
	
	public ByteBuf getSIPAuthenticationContext()
	{
		if(sipAuthenticationContext==null)
			return null;
		
		return sipAuthenticationContext.getValue();
	}
	
	public void setSIPAuthenticationContext(ByteBuf value)
	{
		if(value == null)
			this.sipAuthenticationContext = null;
		else
			this.sipAuthenticationContext = new SIPAuthenticationContextImpl(value, null, null);
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
	
	public SIPDigestAuthenticate getSIPDigestAuthenticate()
	{
		return sipDigestAuthenticate;
	}
	
	public void setSIPDigestAuthenticate(SIPDigestAuthenticate value)
	{
		this.sipDigestAuthenticate = value;
	}
	
	public Inet4Address getFramedIPAddress()
	{
		if(framedIPAddress==null)
			return null;
		
		return framedIPAddress.getAddress();
	}
	
	public void setFramedIPAddress(Inet4Address value)
	{
		if(value == null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(value);
	}
	
	public ByteBuf getFramedIPv6Prefix()
	{
		if(framedIPv6Prefix==null)
			return null;
		
		return framedIPv6Prefix.getValue();
	}
	
	public void setFramedIPv6Prefix(ByteBuf value)
	{
		if(value == null)
			this.framedIPv6Prefix = null;
		else
			this.framedIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);
	}
	
	public Long getFramedInterfaceId()
	{
		if(framedInterfaceId==null)
			return null;
		
		return framedInterfaceId.getLong();
	}
	
	public void setFramedInterfaceId(Long value)
	{
		if(value == null)
			this.framedInterfaceId = null;
		else
			this.framedInterfaceId = new FramedInterfaceIdImpl(value, null, null);
	}
	
	public List<ByteBuf> getLineIdentifier()
	{
		if(lineIdentifier==null || lineIdentifier.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(LineIdentifier curr:lineIdentifier)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setLineIdentifier(List<ByteBuf> value)
	{
		if(value == null)
			this.lineIdentifier = null;
		else
		{
			this.lineIdentifier = new ArrayList<LineIdentifier>();
			for(ByteBuf curr: value)
				this.lineIdentifier.add(new LineIdentifierImpl(curr, null, null));					
		}
	}
}