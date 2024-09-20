package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerWithSessionBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectMaxCacheTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
	
	private boolean redirectHostAllowed = true;
	
	private boolean redirectHostUsageAllowed = true;
	
	private boolean redirectMaxCacheTimeAllowed = true;
	
	protected AuthenticationAnswerImpl() 
	{
		super();
	}
	
	public AuthenticationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		authApplicationIdAllowed=false;
	}
	
	public AuthenticationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		
		setAuthApplicationId(authApplicationId);		
	}

	protected void setRedirectHostAllowed(boolean allowed) 
	{
		this.redirectHostAllowed = allowed;
	}
	
	protected void setRedirectHostUsageAllowed(boolean allowed) 
	{
		this.redirectHostUsageAllowed = allowed;
	}
	
	protected void setRedirectMaxCacheTimeAllowed(boolean allowed) 
	{
		this.redirectMaxCacheTimeAllowed = allowed;
	}
	
	@Override
	public List<String> getRedirectHost() throws AvpNotSupportedException 
	{

		if(!redirectHostAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RouteRecordImpl() } ));
		
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
	public void setRedirectHost(List<String> value) throws AvpNotSupportedException , InvalidAvpValueException 
	{
		if(!redirectHostAllowed && value!=null && value.size()>0)
		{
			List<DiameterAvp> routeRecords = new ArrayList<DiameterAvp>();
			for(String curr:value)
				routeRecords.add(new RouteRecordImpl(curr, null, null));
				
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", routeRecords );
		}
		
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
	public RedirectHostUsageEnum getRedirectHostUsage() throws AvpNotSupportedException
	{
		if(!redirectHostUsageAllowed)
		throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RedirectHostUsageImpl() } ));
		
		if(this.redirectHost == null)
			return null;
		
		return this.redirectHostUsage.getEnumerated(RedirectHostUsageEnum.class);
	}

	@Override
	public void setRedirectHostUsage(RedirectHostUsageEnum value) throws AvpNotSupportedException
	{
		if(!redirectHostUsageAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RedirectHostUsageImpl( value, null, null) } ));
		
		if(value==null)
			this.redirectHostUsage = null;
		else 
			this.redirectHostUsage = new RedirectHostUsageImpl(value, null, null);
	}

	@Override
	public Long getRedirectMaxCacheTime() throws AvpNotSupportedException
	{
		if(!redirectMaxCacheTimeAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RedirectMaxCacheTimeImpl() } ));
			
		if(this.redirectMaxCacheTime==null)
			return null;
		
		return this.redirectMaxCacheTime.getUnsigned();
	}

	@Override
	public void setRedirectMaxCacheTime(Long value) throws AvpNotSupportedException 
	{
		if(!redirectMaxCacheTimeAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RedirectMaxCacheTimeImpl(value, null, null) } ));
			
		if(value==null)
			this.redirectMaxCacheTime = null;
		else 
			this.redirectMaxCacheTime = new RedirectMaxCacheTimeImpl(value, null, null);
	}

	@Override
	public Long getAuthApplicationId() throws AvpNotSupportedException 
	{
		if(!authApplicationIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl() } ));
			
		if(authApplicationId==null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public void setAuthApplicationId(Long value) throws AvpNotSupportedException, MissingAvpException 
	{
		if(!authApplicationIdAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl( value, null, null) }));
		
		if(value==null)
			throw new MissingAvpException("Auth-Application-Id is required", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl() }));
		
		this.authApplicationId = new AuthApplicationIdImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(!redirectHostAllowed && redirectHost!=null && redirectHost.size()>0)
		{
			List<DiameterAvp> avps=new ArrayList<DiameterAvp>();
			for(RedirectHost curr:redirectHost)
				avps.add(curr);
			
			return new AvpNotSupportedException("This AVP is not supported for select command/application", avps );
		}
		
		if(!redirectHostUsageAllowed && redirectHostUsage!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { redirectHostUsage }));
		
		if(!redirectMaxCacheTimeAllowed && redirectMaxCacheTime!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { redirectMaxCacheTime }));
		
		
		if(!authApplicationIdAllowed && authApplicationId!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { authApplicationId }));
		
		if(authApplicationIdAllowed && authApplicationId==null)
			return new MissingAvpException("Auth-Application-Id is required", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl() }));
		
		return super.validate();
	}
}