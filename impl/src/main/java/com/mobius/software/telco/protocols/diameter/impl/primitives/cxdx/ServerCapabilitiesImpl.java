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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.MandatoryCapability;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.OptionalCapability;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerName;

/**
*
* @author yulian oifa
*
*/
public class ServerCapabilitiesImpl extends DiameterGroupedAvpImpl implements ServerCapabilities
{
	private List<MandatoryCapability> mandatoryCapability;
	
	private List<OptionalCapability> optionalCapability;
	
	private List<ServerName> serverName;
	
	public ServerCapabilitiesImpl()
	{
		
	}
	
	public List<Long> getMandatoryCapability()
	{
		if(mandatoryCapability==null || mandatoryCapability.size()==0)
			return null;
		
		List<Long> result = new  ArrayList<Long>();
		for(MandatoryCapability curr:mandatoryCapability)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setMandatoryCapability(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.mandatoryCapability = null;
		else
		{
			this.mandatoryCapability = new ArrayList<MandatoryCapability>();
			for(Long curr:value)
				this.mandatoryCapability.add(new MandatoryCapabilityImpl(curr, null, null));
		}
	}
	
	public List<Long> getOptionalCapability()
	{
		if(mandatoryCapability==null || mandatoryCapability.size()==0)
			return null;
		
		List<Long> result = new  ArrayList<Long>();
		for(MandatoryCapability curr:mandatoryCapability)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setOptionalCapability(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.optionalCapability = null;
		else
		{
			this.optionalCapability = new ArrayList<OptionalCapability>();
			for(Long curr:value)
				this.optionalCapability.add(new OptionalCapabilityImpl(curr, null, null));
		}
	}
	
	public List<String> getServerName()
	{
		if(serverName==null || serverName.size()==0)
			return null;
		
		List<String> result = new  ArrayList<String>();
		for(ServerName curr:serverName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setServerName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.serverName = null;
		else
		{
			this.serverName = new ArrayList<ServerName>();
			for(String curr:value)
				this.serverName.add(new ServerNameImpl(curr, null, null));
		}
	}
}