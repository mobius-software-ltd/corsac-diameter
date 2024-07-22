package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.HomeAgentMIPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMSALifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPRegRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMSALifetime;

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
public class HomeAgentMIPRequestImpl extends Rfc4004RequestImpl implements HomeAgentMIPRequest
{
	protected AuthorizationLifetime authorizationLifetime;
	
	protected AuthSessionState authSessionState;
	
	private MIPFeatureVector mipFeatureVector;
	
	private MIPMNtoHAMSA mipMNtoHAMSA;
	
	private MIPMNtoFAMSA mipMNtoFAMSA;
	
	private MIPHAtoMNMSA mipHAtoMNMSA;
	
	private MIPHAtoFAMSA mipHAtoFAMSA;
	
	private MIPMSALifetime mipMSALifetime;
	
	private List<MIPFilterRule> mipFilterRule;
	
	protected HomeAgentMIPRequestImpl() 
	{
		super();
	}
	
	public HomeAgentMIPRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, Long authorizationLifetime, AuthSessionStateEnum authSessionState,ByteBuf mipRegRequest, Long mipFeatureVector) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, mipRegRequest);
		
		setAuthorizationLifetime(authorizationLifetime);
		
		setAuthSessionState(authSessionState);
		
		setMIPFeatureVector(mipFeatureVector);
	}
	
	@Override
	public Long getAuthorizationLifetime() 
	{
		if(authorizationLifetime == null)
			return null;
		
		return authorizationLifetime.getUnsigned();
	}

	@Override
	public void setAuthorizationLifetime(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Authorization-Lifetime is required", Arrays.asList(new DiameterAvp[] { new AuthorizationLifetimeImpl() }));
			
		this.authorizationLifetime = new AuthorizationLifetimeImpl(value, null, null);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState == null)
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
	
	@Override
	public Long getMIPFeatureVector() 
	{
		if(mipFeatureVector == null)
			return null;
		
		return mipFeatureVector.getUnsigned();
	}
	
	@Override
	public void setMIPFeatureVector(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("MIP-Feature-Vector is required", Arrays.asList(new DiameterAvp[] { new MIPFeatureVectorImpl() }));
			
		this.mipFeatureVector = new MIPFeatureVectorImpl(value, null, null);
	}
	
	@Override
	public MIPMNtoFAMSA getMIPMNtoFAMSA() 
	{
		return mipMNtoFAMSA;
	}
	
	@Override
	public void setMIPMNtoFAMSA(MIPMNtoFAMSA value)
	{
		this.mipMNtoFAMSA = value;
	}
	
	@Override
	public MIPMNtoHAMSA getMIPMNtoHAMSA()
	{
		return mipMNtoHAMSA;
	}
	
	@Override
	public void setMIPMNtoHAMSA(MIPMNtoHAMSA value)
	{
		this.mipMNtoHAMSA = value;
	}
	
	@Override
	public MIPHAtoMNMSA getMIPHAtoMNMSA()
	{
		return mipHAtoMNMSA;
	}
	
	@Override
	public void setMIPHAtoMNMSA(MIPHAtoMNMSA value)
	{
		this.mipHAtoMNMSA = value;
	}
	
	@Override
	public MIPHAtoFAMSA getMIPHAtoFAMSA()
	{
		return mipHAtoFAMSA;
	}
	
	@Override
	public void setMIPHAtoFAMSA(MIPHAtoFAMSA value)
	{
		this.mipHAtoFAMSA = value;
	}
	
	@Override
	public Long getMIPMSALifetime()
	{
		if(mipMSALifetime == null)
			return null;
		
		return mipMSALifetime.getUnsigned();
	}
	
	@Override
	public void setMIPMSALifetime(Long value)
	{
		if(value == null)
			this.mipMSALifetime = null;
		else
			this.mipMSALifetime = new MIPMSALifetimeImpl(value, null, null);
	}
	
	@Override
	public List<MIPFilterRule> getMIPFilterRule()
	{
		return mipFilterRule;
	}
	
	@Override
	public void setMIPFilterRule(List<MIPFilterRule> value)
	{
		this.mipFilterRule = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authorizationLifetime == null)
			return new MissingAvpException("Authorization-Lifetime is required", Arrays.asList(new DiameterAvp[] { new AuthorizationLifetimeImpl() }));
		
		if(authSessionState == null)
			return new MissingAvpException("Auth-Session-State is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		if(mipRegRequest == null)
			return new MissingAvpException("MIP-Reg-Request is required", Arrays.asList(new DiameterAvp[] { new MIPRegRequestImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(authorizationLifetime);
		result.add(authSessionState);
		result.add(mipRegRequest);
		result.add(originHost);
      	result.add(originRealm);
      	result.add(username);
      	result.add(destinationRealm);
      	result.add(mipFeatureVector);
      	result.add(destinationHost);
      	result.add(mipMNtoHAMSA);
      	result.add(mipMNtoFAMSA);
      	result.add(mipHAtoMNMSA);
      	result.add(mipHAtoFAMSA);
      	result.add(mipMSALifetime);
      	result.add(mipOriginatingForeignAAA);
      	result.add(mipMobileNodeAddress);
      	result.add(mipHomeAgentAddress);
      	
      	if(mipFilterRule!=null)
      		result.addAll(mipFilterRule);
      	
      	result.add(originStateId);
      	
      	if(proxyInfo!=null)
      		result.addAll(proxyInfo);
      		
      	if(routeRecords!=null)
      		result.addAll(routeRecords);
      		
      	if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
      	
      	return result;
	}
}