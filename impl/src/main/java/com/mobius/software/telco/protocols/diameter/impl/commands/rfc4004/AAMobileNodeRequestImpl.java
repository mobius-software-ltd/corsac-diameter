package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.AAMobileNodeRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPCandidateHomeAgentHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFAChallengeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHAtoFASPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPRegRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPCandidateHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAChallenge;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoFASPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAAAuth;

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
public class AAMobileNodeRequestImpl extends Rfc4004RequestImpl implements AAMobileNodeRequest
{
	protected AuthorizationLifetime authorizationLifetime;
	
	protected AuthSessionState authSessionState;
	
	private MIPFeatureVector mipFeatureVector;
	
	private MIPMNAAAAuth mipMNAAAAuth;
	
	private AcctMultiSessionId acctMultiSessionId;
	
	private MIPFAChallenge mipFAChallenge;
	
	private MIPCandidateHomeAgentHost mipCandidateHomeAgentHost;
	
	private MIPHomeAgentHost mipHomeAgentHost;
	
	private MIPHAtoFASPI mipHAtoFASPI;
	
	protected AAMobileNodeRequestImpl() 
	{
		super();
	}
	
	public AAMobileNodeRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, ByteBuf mipRegRequest, MIPMNAAAAuth mipMNAAAAuth) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, mipRegRequest);
		
		setMIPMNAAAAuth(mipMNAAAAuth);
	}
	
	@Override
	public MIPMNAAAAuth getMIPMNAAAAuth() 
	{
		return mipMNAAAAuth;
	}
	
	@Override
	public void setMIPMNAAAAuth(MIPMNAAAAuth value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("MIP-MN-AAA-Auth is required", Arrays.asList(new DiameterAvp[] { new MIPRegRequestImpl() }));
			
		this.mipMNAAAAuth = value;
	}
	
	@Override
	public String getAcctMultiSessionId() 
	{
		if(acctMultiSessionId == null)
			return null;
		
		return acctMultiSessionId.getString();
	}
	
	@Override
	public void setAcctMultiSessionId(String value)
	{
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);
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
			this.authorizationLifetime = null;
		else
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
			this.authSessionState = null;
		else
			this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMIPFAChallenge() 
	{
		if(mipFAChallenge == null)
			return null;
		
		return mipFAChallenge.getValue();
	}
	
	@Override
	public void setMIPFAChallenge(ByteBuf value)
	{
		if(value == null)
			this.mipFAChallenge = null;
		else
			this.mipFAChallenge = new MIPFAChallengeImpl(value, null, null);
	}	
	
	@Override
	public String getMIPCandidateHomeAgentHost() 
	{
		if(mipCandidateHomeAgentHost == null)
			return null;
		
		return mipCandidateHomeAgentHost.getIdentity();
	}
	
	@Override
	public void setMIPCandidateHomeAgentHost(String value)
	{
		if(value == null)
			this.mipCandidateHomeAgentHost = null;
		else
			this.mipCandidateHomeAgentHost = new MIPCandidateHomeAgentHostImpl(value, null, null);
	}
	
	@Override
	public MIPHomeAgentHost getMIPHomeAgentHost() 
	{
		return mipHomeAgentHost;
	}
	
	@Override
	public void setMIPHomeAgentHost(MIPHomeAgentHost value)
	{
		this.mipHomeAgentHost = value;
	}	
	
	@Override
	public Long getMIPHAtoFASPI() 
	{
		if(mipHAtoFASPI == null)
			return null;
		
		return mipHAtoFASPI.getUnsigned();
	}
	
	@Override
	public void setMIPHAtoFASPI(Long value)
	{
		if(value == null)
			this.mipHAtoFASPI = null;
		else
			this.mipHAtoFASPI = new MIPHAtoFASPIImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mipMNAAAAuth == null)
			return new MissingAvpException("MIP-MN-AAA-Auth is required", Arrays.asList(new DiameterAvp[] { new MIPRegRequestImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(username);
      	result.add(destinationRealm);
      	result.add(originHost);
      	result.add(originRealm);
      	result.add(mipRegRequest);
      	result.add(mipMNAAAAuth);
      	result.add(acctMultiSessionId);
      	result.add(destinationHost);
      	result.add(originStateId);
      	result.add(mipMobileNodeAddress);
      	result.add(mipHomeAgentAddress);
      	result.add(mipFeatureVector);
      	result.add(mipOriginatingForeignAAA);
      	result.add(authorizationLifetime);
		result.add(authSessionState);
		result.add(mipFAChallenge);
      	result.add(mipCandidateHomeAgentHost);
      	result.add(mipCandidateHomeAgentHost);
      	result.add(mipHomeAgentHost);
      	result.add(mipHAtoFASPI);
      	
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