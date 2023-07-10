package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginStateIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectMaxCacheTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginStateId;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHostUsage;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHostUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectMaxCacheTime;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;

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
@DiameterCommandImplementation(applicationId = -1, commandCode = 274, request = false)
public class AbortSessionAnswerImpl extends DiameterAnswerBase implements AbortSessionAnswer
{
	private UserName username;
	
	private List<RedirectHost> redirectHost;
	
	private RedirectHostUsage redirectHostUsage;
	
	private RedirectMaxCacheTime redirectMaxCacheTime;
	
	private OriginStateId originStateId;
	
	private List<ProxyInfo> proxyInfo;
	
	protected AbortSessionAnswerImpl() 
	{
	}
	
	public AbortSessionAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode)
	{
		super(originHost, originRealm, isRetransmit, resultCode);
	}
	
	public AbortSessionAnswerImpl(String originHost,String originRealm,Boolean isError,Boolean isRetransmit, Long resultCode)
	{
		super(originHost, originRealm, isError, isRetransmit, resultCode);
	}

	@Override
	public String getUsername() 
	{
		if(this.username==null)
			return null;
		
		return this.username.getString();
	}

	@Override
	public void setUsername(String value) 
	{
		if(value==null)
			this.username = null;
		else
			this.username = new UserNameImpl(value, null, null);
	}

	@Override
	public Long getOriginStateId() 
	{
		if(this.originStateId == null)
			return null;
		
		return this.originStateId.getUnsigned();
	}

	@Override
	public void setOriginStateId(Long value) 
	{
		if(value == null)
			this.originStateId = null;
		else
			this.originStateId = new OriginStateIdImpl(value, null, null);
	}

	@Override
	public List<ProxyInfo> getProxyInfo() 
	{
		return this.proxyInfo;
	}

	@Override
	public void setProxyInfo(List<ProxyInfo> value) 
	{
		this.proxyInfo = value;
	}

	@Override
	public List<String> getRedirectHost() 
	{
		if(this.redirectHost==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RedirectHost curr:redirectHost)
				result.add(curr.getUri());
			
			return result;
		}
	}

	@Override
	public void setRedirectHost(List<String> value) throws ParseException 
	{
		if(value == null || value.size()==0)
			this.redirectHost = null;
		else
		{
			this.redirectHost = new ArrayList<RedirectHost>();
			for(String curr:value)
				this.redirectHost.add(new RedirectHostImpl(curr, null, null));
		}
	}

	@Override
	public RedirectHostUsageEnum getRedirectHostUsage() 
	{
		if(this.redirectHost == null)
			return null;
		
		return this.redirectHostUsage.getEnumerated(RedirectHostUsageEnum.class);
	}

	@Override
	public void setRedirectHostUsage(RedirectHostUsageEnum value) 
	{
		if(value==null)
			this.redirectHostUsage = null;
		else 
			this.redirectHostUsage = new RedirectHostUsageImpl(value, null, null);
	}

	@Override
	public Long getRedirectMaxCacheTime() 
	{
		if(this.redirectMaxCacheTime==null)
			return null;
		
		return this.redirectMaxCacheTime.getUnsigned();
	}

	@Override
	public void setRedirectMaxCacheTime(Long value) 
	{
		if(value==null)
			this.redirectMaxCacheTime = null;
		else 
			this.redirectMaxCacheTime = new RedirectMaxCacheTimeImpl(value, null, null);
	}
}