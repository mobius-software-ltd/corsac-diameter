package com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.CommonTunnelEndpointIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalM1Information;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSENBIPMulticastAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSENBIPv6MulticastAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSGWSSMIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSGWSSMIPv6Address;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class LocalM1InformationImpl extends DiameterAvpImpl implements LocalM1Information
{
	private MBMSENBIPMulticastAddress mbmsENBIPMulticastAddress;
	
	private MBMSENBIPv6MulticastAddress mbmsENBIPv6MulticastAddress;
	
	private MBMSGWSSMIPAddress mbmsGWSSMIPAddress;
	
	private MBMSGWSSMIPv6Address mbmsGWSSMIPv6Address;
	
	private CommonTunnelEndpointIdentifier commonTunnelEndpointIdentifier;
	
	public LocalM1InformationImpl()
	{
		
	}
	
	public InetAddress getMBMSENBIPMulticastAddress()
	{
		if(mbmsENBIPMulticastAddress==null)
			return null;
		
		return mbmsENBIPMulticastAddress.getAddress();
	}
	
	public void setMBMSENBIPMulticastAddress(InetAddress value)
	{
		if(value==null)
			this.mbmsENBIPMulticastAddress = null;
		else
			this.mbmsENBIPMulticastAddress = new MBMSENBIPMulticastAddressImpl(value, null, null);			
	}
	
	public InetAddress getMBMSENBIPv6MulticastAddress()
	{
		if(mbmsENBIPv6MulticastAddress==null)
			return null;
		
		return mbmsENBIPv6MulticastAddress.getAddress();
	}
	
	public void setMBMSENBIPv6MulticastAddress(InetAddress value)
	{
		if(value==null)
			this.mbmsENBIPv6MulticastAddress = null;
		else
			this.mbmsENBIPv6MulticastAddress = new MBMSENBIPv6MulticastAddressImpl(value, null, null);			
	}
	
	public InetAddress getMBMSGWSSMIPAddress()
	{
		if(mbmsGWSSMIPAddress==null)
			return null;
		
		return mbmsGWSSMIPAddress.getAddress();
	}
	
	public void setMBMSGWSSMIPAddress(InetAddress value)
	{
		if(value==null)
			this.mbmsGWSSMIPAddress = null;
		else
			this.mbmsGWSSMIPAddress = new MBMSGWSSMIPAddressImpl(value, null, null);			
	}
	
	public InetAddress getMBMSGWSSMIPv6Address()
	{
		if(mbmsGWSSMIPv6Address==null)
			return null;
		
		return mbmsGWSSMIPv6Address.getAddress();
	}
	
	public void setMBMSGWSSMIPv6Address(InetAddress value)
	{
		if(value==null)
			this.mbmsGWSSMIPv6Address = null;
		else
			this.mbmsGWSSMIPv6Address = new MBMSGWSSMIPv6AddressImpl(value, null, null);			
	}
	
	public ByteBuf getCommonTunnelEndpointIdentifier()
	{
		if(commonTunnelEndpointIdentifier==null)
			return null;
		
		return commonTunnelEndpointIdentifier.getValue();
	}
	
	public void setCommonTunnelEndpointIdentifier(ByteBuf value)
	{
		if(value==null)
			this.commonTunnelEndpointIdentifier = null;
		else
			this.commonTunnelEndpointIdentifier = new CommonTunnelEndpointIdentifierImpl(value, null, null);			
	}
}