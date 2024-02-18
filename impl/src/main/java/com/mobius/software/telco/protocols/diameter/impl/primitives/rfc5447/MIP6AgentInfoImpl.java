package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6HomeLinkPrefix;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MIP6AgentInfoImpl extends DiameterGroupedAvpImpl implements MIP6AgentInfo
{
	private List<MIPHomeAgentAddress> mipHomeAgentAddress;
	
	private MIPHomeAgentHost mipHomeAgentHost;
	
	private MIP6HomeLinkPrefix mip6HomeLinkPrefix;
	
	public MIP6AgentInfoImpl()
	{
		super();
	}
	
	public List<InetAddress> getMIPHomeAgentAddress()
	{
		if(mipHomeAgentAddress==null || mipHomeAgentAddress.size()==0)
			return null;
		
		List<InetAddress> result=new ArrayList<InetAddress>();
		for(MIPHomeAgentAddress curr:this.mipHomeAgentAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setMIPHomeAgentAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException	
	{
		if(value!=null && value.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(InetAddress curr:value)
				failedAvps.add(new MIPHomeAgentAddressImpl(curr, null, null));
			
			throw new AvpOccursTooManyTimesException("Up to 2 MIP-Home-Agent-Address are allowed", failedAvps);
		}
		
		if(value == null)
			this.mipHomeAgentAddress = null;
		else
		{
			this.mipHomeAgentAddress = new ArrayList<MIPHomeAgentAddress>();
			for(InetAddress curr:value)
				this.mipHomeAgentAddress.add(new MIPHomeAgentAddressImpl(curr, null, null));
		}
	}
	
	public MIPHomeAgentHost getMIPHomeAgentHost()
	{
		return mipHomeAgentHost;
	}
	
	public void setMIPHomeAgentHost(MIPHomeAgentHost value)
	{
		this.mipHomeAgentHost = value;
	}
	
	public ByteBuf getMIP6HomeLinkPrefix()
	{
		if(mip6HomeLinkPrefix==null)
			return null;
		
		return this.mip6HomeLinkPrefix.getValue();
	}
	
	public void setMIP6HomeLinkPrefix(ByteBuf value)
	{
		if(value == null)
			this.mip6HomeLinkPrefix = null;
		else
			this.mip6HomeLinkPrefix = new MIP6HomeLinkPrefixImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mipHomeAgentAddress!=null && mipHomeAgentAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(mipHomeAgentAddress);
			return new AvpOccursTooManyTimesException("Up to 2 MIP-Home-Agent-Address are allowed", failedAvps);
		}
		
		return null;
	}
}