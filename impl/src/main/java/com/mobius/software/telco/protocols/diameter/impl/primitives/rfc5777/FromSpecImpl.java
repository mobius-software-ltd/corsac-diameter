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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.EUI64Address;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.EUI64AddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FromSpec;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPAddressRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.MACAddressMask;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Negated;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.NegatedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Port;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.PortRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.UseAssignedAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.UseAssignedAddressEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

public class FromSpecImpl extends DiameterGroupedAvpImpl implements FromSpec
{
	private List<IPAddress> ipAddress;
	
	private List<IPAddressRange> ipAddressRange;
	
	private List<IPAddressMask> ipAddressMask;
	
	private List<MACAddress> macAddress;
	
	private List<MACAddressMask> macAddressMask;
	
	private List<EUI64Address> eui64Address;
	
	private List<EUI64AddressMask> eui64AddressMask;
	
	private List<Port> port;
	
	private List<PortRange> portRange;
	
	private Negated negated;
	
	private UseAssignedAddress useAssignedAddress;
	
	public FromSpecImpl()
	{
		
	}
	
	public List<InetAddress> getIPAddress()
	{
		if(ipAddress == null)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(IPAddress curr:ipAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setIPAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.ipAddress = null;
		else
		{
			this.ipAddress = new ArrayList<IPAddress>();
			for(InetAddress curr:value)
				this.ipAddress.add(new IPAddressImpl(curr, null, null));
		}
	}
	
	public List<IPAddressRange> getIPAddressRange()
	{
		return ipAddressRange;
	}
	
	public void setIPAddressRange(List<IPAddressRange> value)
	{
		
	}
	
	public List<IPAddressMask> getIPAddressMask()
	{
		return ipAddressMask;
	}
	
	public void setIPAddressMask(List<IPAddressMask> value)
	{
		
	}
	
	public List<ByteBuf> getMACAddress()
	{
		if(macAddress == null)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(MACAddress curr:macAddress)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setMACAddress(List<ByteBuf> value)
	{
		
	}
	
	public List<MACAddressMask> getMACAddressMask()
	{
		return macAddressMask;
	}
	
	public void setMACAddressMask(List<MACAddressMask> value)
	{
		
	}
	
	public List<ByteBuf> getEUI64Address()
	{
		if(eui64Address == null)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(EUI64Address curr:eui64Address)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setEUI64Address(List<ByteBuf> value)
	{
		
	}
	
	public List<EUI64AddressMask> getEUI64AddressMask()
	{
		return eui64AddressMask;
	}
	
	public void setEUI64AddressMask(List<EUI64AddressMask> value)
	{
		
	}
	
	public List<Integer> getPort()
	{
		if(port == null)
			return null;
		
		List<Integer> result = new ArrayList<Integer>();
		for(Port curr:port)
			result.add(curr.getInteger());
		
		return result;
	}
	
	public void setPort(List<Integer> value)
	{
		
	}

	public List<PortRange> getPortRange()
	{
		return portRange;
	}
	
	public void setPortRange(List<PortRange> value)
	{
		
	}
	
	public NegatedEnum getNegated()
	{
		if(negated==null)
			return null;
		
		return negated.getEnumerated(NegatedEnum.class);
	}
	
	public void setNegated(NegatedEnum value)
	{
		
	}
	
	public UseAssignedAddressEnum getUseAssignedAddress()
	{
		return useAssignedAddress.getEnumerated(UseAssignedAddressEnum.class);
	}
	
	public void setUseAssignedAddress(UseAssignedAddressEnum value)
	{
		
	}
}