package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004;

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.HomeAgentMIPRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMSALifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPRegRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMSALifetime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMobileNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPOriginatingForeignAAA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPRegRequest;

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
@DiameterCommandImplementation(applicationId = 2, commandCode = 262, request = true)
public class HomeAgentMIPRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostBase implements HomeAgentMIPRequest
{
	private AuthorizationLifetime authorizationLifetime;
	
	private AuthSessionState authSessionState;
	
	private MIPRegRequest mipRegRequest;
	
	private MIPFeatureVector mipFeatureVector;
	
	private MIPMNtoHAMSA mipMNtoHAMSA;
	
	private MIPMNtoFAMSA mipMNtoFAMSA;
	
	private MIPHAtoMNMSA mipHAtoMNMSA;
	
	private MIPHAtoFAMSA mipHAtoFAMSA;
	
	private MIPMSALifetime mipMSALifetime;
	
	private MIPOriginatingForeignAAA mipOriginatingForeignAAA;
	
	private MIPHomeAgentAddress mipHomeAgentAddress;
	
	private MIPMobileNodeAddress mipMobileNodeAddress;
	
	private List<MIPFilterRule> mipFilterRule;
	
	protected HomeAgentMIPRequestImpl() 
	{
		super();
	}
	
	public HomeAgentMIPRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, Long authorizationLifetime, AuthSessionStateEnum authSessionState,ByteBuf mipRegRequest, Long mipFeatureVector)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setAuthorizationLifetime(authorizationLifetime);
		
		setAuthSessionState(authSessionState);
		
		setMIPRegRequest(mipRegRequest);
		
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
	public void setAuthorizationLifetime(Long value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Authorization-Lifetime is required");
		
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
	public void setAuthSessionState(AuthSessionStateEnum value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Auth-Session-State is required");
		
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMIPRegRequest() 
	{
		if(mipRegRequest == null)
			return null;
		
		return mipRegRequest.getValue();
	}
	
	@Override
	public void setMIPRegRequest(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("MIP-Reg-Request is required");
		
		this.mipRegRequest = new MIPRegRequestImpl(value, null, null);
	}
	
	@Override
	public Long getMIPFeatureVector() 
	{
		if(mipFeatureVector == null)
			return null;
		
		return mipFeatureVector.getUnsigned();
	}
	
	@Override
	public void setMIPFeatureVector(Long value)
	{
		if(value == null)
			this.mipFeatureVector = null;
		else
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
	public MIPOriginatingForeignAAA getMIPOriginatingForeignAAA() 
	{
		return mipOriginatingForeignAAA;
	}
	
	@Override
	public void setMIPOriginatingForeignAAA(MIPOriginatingForeignAAA value)
	{
		this.mipOriginatingForeignAAA = value;
	}
	

	@Override
	public InetAddress getMIPMobileNodeAddress() 
	{
		if(mipMobileNodeAddress == null)
			return null;
		
		return mipMobileNodeAddress.getAddress();
	}
	
	@Override
	public void setMIPMobileNodeAddress(InetAddress value)
	{
		if(value == null)
			this.mipMobileNodeAddress = null;
		else
			this.mipMobileNodeAddress = new MIPMobileNodeAddressImpl(value, null, null);
	}
	
	@Override
	public InetAddress getMIPHomeAgentAddress() 
	{
		if(mipHomeAgentAddress == null)
			return null;
		
		return mipHomeAgentAddress.getAddress();
	}
	
	@Override
	public void setMIPHomeAgentAddress(InetAddress value)
	{
		if(value == null)
			this.mipHomeAgentAddress = null;
		else
			this.mipHomeAgentAddress = new MIPHomeAgentAddressImpl(value, null, null);
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
	public String validate()
	{
		if(authorizationLifetime == null)
			throw new IllegalArgumentException("Authorization-Lifetime is required");
		
		if(authSessionState == null)
			throw new IllegalArgumentException("Auth-Session-State is required");
		
		if(mipRegRequest == null)
			throw new IllegalArgumentException("MIP-Reg-Request is required");
		
		if(mipFeatureVector == null)
			throw new IllegalArgumentException("MIP-Feature-Vector is required");
		
		return super.validate();
	}
}