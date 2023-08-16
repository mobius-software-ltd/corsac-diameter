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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressSIPURI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressURL;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServerExtension;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 665L, vendorId = -1)
public class RedirectServerExtensionImpl extends DiameterGroupedAvpImpl implements RedirectServerExtension
{
	private RedirectAddressIPAddress ipAddress;
	
	private RedirectAddressURL url;
	
	private RedirectAddressSIPURI sipURI;
	
	protected RedirectServerExtensionImpl()
	{
		
	}
	
	public RedirectServerExtensionImpl(InetAddress ipAddress, String url, String sipURI)	
	{	
		if(ipAddress != null)
			this.ipAddress = new RedirectAddressIPAddressImpl(ipAddress, null, null);
		
		if(url != null)
			this.url = new RedirectAddressURLImpl(url, null, null);
		
		if(sipURI != null)
			this.sipURI = new RedirectAddressSIPURIImpl(sipURI, null, null);
	}		
	
	public InetAddress getIPAddress()
	{
		if(this.ipAddress == null)
			return null;
		
		return this.ipAddress.getAddress();
	}
	
	public void setIPAddress(InetAddress value)
	{
		if(value == null)
			this.ipAddress = null;
		else
			this.ipAddress = new RedirectAddressIPAddressImpl(value, null, null);
	}
	
	public String getURL()
	{
		if(this.url == null)
			return null;
		
		return this.url.getString();
	}
	
	public void setURL(String value)
	{
		if(value != null)
			this.url = new RedirectAddressURLImpl(value, null, null);
		else
			this.url = null;
	}
	
	public String getSIPURI()
	{
		if(this.sipURI == null)
			return null;
		
		return this.sipURI.getString();
	}
	
	public void setSIPURI(String value)
	{
		if(value != null)
			this.sipURI = new RedirectAddressSIPURIImpl(value, null, null);
		else
			this.sipURI = null;
	}
}