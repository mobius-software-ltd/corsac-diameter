package com.mobius.software.telco.protocols.diameter.impl.primitives.common;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyState;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public class ProxyInfoImpl extends DiameterGroupedAvpImpl implements ProxyInfo
{
	private ProxyHost proxyHost;
	
	private ProxyState proxyState;
	
	public ProxyInfoImpl() 
	{
	}
	
	public ProxyInfoImpl(String proxyHost,ByteBuf proxyState) throws MissingAvpException
	{
		setProxyHost(proxyHost);
		
		setProxyState(proxyState);
	}

	@Override
	public String getProxyHost() 
	{
		if(proxyHost == null)
			return null;
		
		return proxyHost.getIdentity();
	}

	@Override
	public void setProxyHost(String value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Proxy-Host is required", Arrays.asList(new DiameterAvp[] { new ProxyHostImpl() }));

		this.proxyHost = new ProxyHostImpl(value, null, null);
	}

	@Override
	public ByteBuf getProxyState() 
	{
		if(proxyState == null)
			return null;
		
		return proxyState.getValue();
	}

	@Override
	public void setProxyState(ByteBuf value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Proxy-State is required", Arrays.asList(new DiameterAvp[] { new ProxyHostImpl() }));

		this.proxyState = new ProxyStateImpl(value, null, null);
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proxyHost == null) ? 0 : proxyHost.hashCode());
		result = prime * result + ((proxyState == null) ? 0 : proxyState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		ProxyInfoImpl other = (ProxyInfoImpl) obj;
		if (proxyHost == null) 
		{
			if (other.proxyHost != null)
				return false;
		} 
		else if (!proxyHost.equals(other.proxyHost))
			return false;
		
		if (proxyState == null) 
		{
			if (other.proxyState != null)
				return false;
		} 
		else if (!proxyState.equals(other.proxyState))
			return false;
		
		return true;
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(proxyHost==null)
			return new MissingAvpException("Proxy-Host is required", Arrays.asList(new DiameterAvp[] { new ProxyHostImpl() }));

		if(proxyState==null)
			return new MissingAvpException("Proxy-State is required", Arrays.asList(new DiameterAvp[] { new ProxyHostImpl() }));
		
		return null;
	}
}