package com.mobius.software.telco.protocols.diameter.impl.commands.np;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.np.NpAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.VendorSpecificAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectHostUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RedirectMaxCacheTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHostUsage;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHostUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectMaxCacheTime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

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
public abstract class NpAnswerImpl extends VendorSpecificAnswerImpl implements NpAnswer
{
	protected DRMP drmp;
	
	protected AuthSessionState authSessionState;
	
	protected OCSupportedFeatures ocSupportedFeatures;
	
	protected OCOLR ocOLR;
	
	protected List<RedirectHost> redirectHost;
	
	protected RedirectHostUsage redirectHostUsage;
	
	protected RedirectMaxCacheTime redirectMaxCacheTime;
	
	protected NpAnswerImpl() 
	{
		super();
	}
	
	public NpAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);		
		
		setAuthSessionState(authSessionState);
	}

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState==null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException 
	{
		if(value == null)
			throw new MissingAvpException("Auth-Session-State is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	 		
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	 
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
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
	public void setRedirectHost(List<String> value) throws InvalidAvpValueException 
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authSessionState == null)
			return new MissingAvpException("Auth-Session-State is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		return super.validate();
	}
}