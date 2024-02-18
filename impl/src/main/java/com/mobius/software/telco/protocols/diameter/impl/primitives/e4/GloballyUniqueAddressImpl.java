package com.mobius.software.telco.protocols.diameter.impl.primitives.e4;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.primitives.e4.AddressRealm;
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class GloballyUniqueAddressImpl implements GloballyUniqueAddress
{
	private FramedIPAddress frameIPAddress;
	
	private FramedIPv6Prefix frameIPv6Prefix;
	
	private AddressRealm addressRealm;
	
	public GloballyUniqueAddressImpl()
	{
		
	}
	
	public Inet4Address getFrameIPAddress()
	{
		if(frameIPAddress==null)
			return null;
		
		return frameIPAddress.getAddress();
	}
	
	public void setFrameIPAddress(Inet4Address value)
	{
		if(value == null)
			this.frameIPAddress = null;
		else
			this.frameIPAddress = new FramedIPAddressImpl(value);
	}
	
	public ByteBuf getFrameIPv6Prefix()
	{
		if(frameIPv6Prefix==null)
			return null;
		
		return frameIPv6Prefix.getValue();
	}
	
	public void setFrameIPv6Prefix(ByteBuf value)
	{
		if(value == null)
			this.frameIPv6Prefix = null;
		else
			this.frameIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);
	}
	
	public ByteBuf getAddressRealm()
	{
		if(addressRealm==null)
			return null;
		
		return addressRealm.getValue();
	}
	
	public void setAddressRealm(ByteBuf value)
	{
		if(value == null)
			this.addressRealm = null;
		else
			this.addressRealm = new AddressRealmImpl(value, null, null);
	}
}