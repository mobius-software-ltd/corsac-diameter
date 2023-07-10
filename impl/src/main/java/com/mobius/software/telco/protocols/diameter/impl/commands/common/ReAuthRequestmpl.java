package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterRequestBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginStateIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ReAuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginStateId;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
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
@DiameterCommandImplementation(applicationId = -1, commandCode = 258, request = true)
public class ReAuthRequestmpl extends DiameterRequestBase implements ReAuthRequest
{
	private AuthApplicationId authApplicationId;
	
	private ReAuthRequestType reAuthRequestType;
	
	private UserName username;
	
	private OriginStateId originStateId;
	
	private List<ProxyInfo> proxyInfo;
	
	public List<RouteRecord> routeRecords;
	
	protected ReAuthRequestmpl() 
	{
	}
		
	public ReAuthRequestmpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit)
	{
		super(originHost, originRealm,destinationHost,destinationRealm, isRetransmit);
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
	public List<String> getRouteRecords() 
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
	}

	@Override
	public Long getAuthApplicationId() 
	{
		if(authApplicationId==null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public void setAuthApplicationIds(Long value) 
	{
		if(value==null)
			this.authApplicationId = null;
		else
			this.authApplicationId = new AuthApplicationIdImpl(value, null, null);
	}

	@Override
	public ReAuthRequestTypeEnum getReAuthRequestType() 
	{
		if(reAuthRequestType==null)
			return null;
		
		return reAuthRequestType.getEnumerated(ReAuthRequestTypeEnum.class);
	}

	@Override
	public void setReAuthRequestType(ReAuthRequestTypeEnum value) 
	{
		if(value==null)
			this.reAuthRequestType = null;
		else
			this.reAuthRequestType = new ReAuthRequestTypeImpl(value, null, null);
	}
}