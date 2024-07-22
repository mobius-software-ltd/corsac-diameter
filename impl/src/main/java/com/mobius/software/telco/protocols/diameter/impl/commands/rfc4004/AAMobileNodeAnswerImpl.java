package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.AAMobileNodeAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ReAuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMSALifetimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMSALifetime;

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
public class AAMobileNodeAnswerImpl extends Rfc4004AnswerImpl implements AAMobileNodeAnswer
{
	private AuthorizationLifetime authorizationLifetime;
	
	private AuthSessionState authSessionState;
	
	private ReAuthRequestType reAuthRequestType;
	
	private MIPFeatureVector mipFeatureVector;
	
	private MIPMNtoFAMSA mipMNtoFAMSA;
	
	private MIPMNtoHAMSA mipMNtoHAMSA;
	
	private MIPFAtoMNMSA mipFAtoMNMSA;
	
	private MIPFAtoHAMSA mipFAtoHAMSA;
	
	private MIPHAtoMNMSA mipHAtoMNMSA;
	
	private MIPMSALifetime mipMSALifetime;
	
	private List<MIPFilterRule> mipFilterRule;
	
	protected AAMobileNodeAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AAMobileNodeAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
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
	public ReAuthRequestTypeEnum getReAuthRequestType() 
	{
		if(reAuthRequestType == null)
			return null;
		
		return reAuthRequestType.getEnumerated(ReAuthRequestTypeEnum.class);
	}
	
	@Override
	public void setReAuthRequestType(ReAuthRequestTypeEnum value)
	{
		if(value == null)
			this.reAuthRequestType = null;
		else
			this.reAuthRequestType = new ReAuthRequestTypeImpl(value, null, null);
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
	public MIPFAtoMNMSA getMIPFAtoMNMSA()
	{
		return mipFAtoMNMSA;
	}
	
	@Override
	public void setMIPFAtoMNMSA(MIPFAtoMNMSA value)
	{
		this.mipFAtoMNMSA = value;
	}
	
	@Override
	public MIPFAtoHAMSA getMIPFAtoHAMSA()
	{
		return mipFAtoHAMSA;
	}
	
	@Override
	public void setMIPFAtoHAMSA(MIPFAtoHAMSA value)
	{
		this.mipFAtoHAMSA = value;
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
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(acctMultiSessionId);
		result.add(username);
		result.add(authorizationLifetime);
		result.add(authSessionState);
		result.add(errorReportingHost);
        result.add(errorMessage);
        result.add(reAuthRequestType);
        result.add(mipFeatureVector);
		result.add(mipRegReply);
		result.add(mipMNtoFAMSA);
      	result.add(mipMNtoHAMSA);
      	result.add(mipFAtoMNMSA);
      	result.add(mipFAtoHAMSA);
      	result.add(mipHAtoMNMSA);
      	result.add(mipMSALifetime);
      	result.add(mipHomeAgentAddress);
		result.add(mipMobileNodeAddress);
		
		if(mipFilterRule!=null)
			result.addAll(mipFilterRule);

		result.add(originStateId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);

        if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
        
        return result;
	}
}