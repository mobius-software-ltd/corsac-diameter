package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerWithSessionBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectMaxCacheTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHostUsage;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHostUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectMaxCacheTime;

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
public abstract class AuthenticationAnswerImpl extends DiameterAnswerWithSessionBase implements AuthenticationAnswer
{
	protected AuthApplicationId authApplicationId;
	
	protected List<RedirectHost> redirectHost;
	
	protected RedirectHostUsage redirectHostUsage;
	
	protected RedirectMaxCacheTime redirectMaxCacheTime;
	
	private boolean authApplicationIdAllowed = true;
	
	protected AuthenticationAnswerImpl() 
	{
		super();
	}
	
	public AuthenticationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		authApplicationIdAllowed=false;
	}
	
	public AuthenticationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		try
		{
			setAuthApplicationId(authApplicationId);
		}
		catch(AvpNotSupportedException ex)
		{
			//should not happen
		}
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

	@Override
	public Long getAuthApplicationId() 
	{
		if(authApplicationId==null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public void setAuthApplicationId(Long value) throws AvpNotSupportedException 
	{
		if(!authApplicationIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(authApplicationId==null)
			throw new IllegalArgumentException("Auth-Application-Id is required");
		
		this.authApplicationId = new AuthApplicationIdImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(authApplicationIdAllowed && authApplicationId==null)
			return "Auth-Application-Id is required";
		
		return super.validate();
	}
}