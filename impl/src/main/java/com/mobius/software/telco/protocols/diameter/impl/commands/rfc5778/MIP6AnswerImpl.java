package com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778.MIP6Answer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ReAuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ChargeableUserIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMobileNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ChargeableUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPMNHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;

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
public class MIP6AnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements MIP6Answer
{
	private AuthRequestType authRequestType;
	
	private AuthorizationLifetime authorizationLifetime;
	
	private AuthSessionState authSessionState;
	
	private ReAuthRequestType reAuthRequestType;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private List<MIPMobileNodeAddress> mipMobileNodeAddress;
    
	private MIPMNHAMSA mipMNHAMSA;
	
	private List<QoSResources> qosResources;
	
	private ChargeableUserIdentity chargeableUserIdentity;
	
	private ServiceSelection serviceSelection;
            		
	protected MIP6AnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public MIP6AnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
		setAuthRequestType(authRequestType);
	}
	
	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Auth-Request-Type is required", Arrays.asList(new DiameterAvp[] { new AuthRequestTypeImpl() }));
			
		this.authRequestType = new AuthRequestTypeImpl(value, null, null);
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
	public Long getMIP6FeatureVector() 
	{
		if(mip6FeatureVector==null)
			return null;
		
		return mip6FeatureVector.getLong();
	}

	@Override
	public void setMIP6FeatureVector(Long value) 
	{
		if(value == null)
			this.mip6FeatureVector = null;
		else
			this.mip6FeatureVector = new MIP6FeatureVectorImpl(value, null, null);
	}

	@Override
	public MIP6AgentInfo getMIP6AgentInfo() 
	{
		return mip6AgentInfo;
	}

	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value) 
	{
		this.mip6AgentInfo = value;
	}

	@Override
	public List<InetAddress> getMIPMobileNodeAddress() 
	{
		if(mipMobileNodeAddress==null || mipMobileNodeAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(MIPMobileNodeAddress curr:mipMobileNodeAddress)
			result.add(curr.getAddress());
		
		return result;
	}

	@Override
	public void setMIPMobileNodeAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException 
	{
		if(value == null || value.size()==0)
			this.mipMobileNodeAddress = null;
		else if(mipMobileNodeAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(InetAddress curr:value)
				failedAvps.add(new MIPMobileNodeAddressImpl(curr, null, null));
				
			throw new AvpOccursTooManyTimesException("Up to 2 MIP Mobile Node Address allowed", failedAvps);
		}	
		else
		{
			this.mipMobileNodeAddress = new ArrayList<MIPMobileNodeAddress>();
			for(InetAddress curr:value)
				this.mipMobileNodeAddress.add(new MIPMobileNodeAddressImpl(curr, null, null));
		}
	}

	@Override
	public MIPMNHAMSA getMIPMNHAMSA()
	{
		return this.mipMNHAMSA;
	}
	
	@Override
	public void setMIPMNHAMSA(MIPMNHAMSA value)
	{
		this.mipMNHAMSA = value;
	}
	
	@Override
	public List<QoSResources> getQoSResources() 
	{
		return qosResources;
	}

	@Override
	public void setQoSResources(List<QoSResources> value) 
	{
		this.qosResources = value;
	}

	@Override
	public ByteBuf getChargeableUserIdentity() 
	{
		if(chargeableUserIdentity == null)
			return null;
		
		return chargeableUserIdentity.getValue();
	}

	@Override
	public void setChargeableUserIdentity(ByteBuf value) 
	{
		if(value == null)
			this.chargeableUserIdentity = null;
		else
			this.chargeableUserIdentity = new ChargeableUserIdentityImpl(value, null, null);
	}

	@Override
	public String getServiceSelection() 
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}

	@Override
	public void setServiceSelection(String value) 
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}

	@DiameterValidate
	public DiameterException validate()
	{
		if(authRequestType==null)
			return new MissingAvpException("Auth-Request-Type is required", Arrays.asList(new DiameterAvp[] { new AuthRequestTypeImpl() }));
		
		if(mipMobileNodeAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(mipMobileNodeAddress);
			
			return new AvpOccursTooManyTimesException("Up to 2 MIP Mobile Node Address allowed", failedAvps);
		}
		
		return super.validate();
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
        result.add(authRequestType);
        result.add(username);
        result.add(authorizationLifetime);
        result.add(authSessionState);
        result.add(errorMessage);
        result.add(errorReportingHost);
        result.add(reAuthRequestType);
        result.add(mip6FeatureVector);
        result.add(mip6AgentInfo);
        
        if(mipMobileNodeAddress!=null)
        	result.addAll(mipMobileNodeAddress);
        
        result.add(mipMNHAMSA);
        
        if(qosResources!=null)
        	result.addAll(qosResources);
        
        result.add(chargeableUserIdentity);
        result.add(serviceSelection);
        result.add(originStateId);
        
        if(proxyInfo!=null)
			result.addAll(proxyInfo);

		if(redirectHost!=null)
        	result.addAll(redirectHost);
        
        result.add(redirectHostUsage);
        result.add(redirectMaxCacheTime);
        
		result.add(failedAvp);
        
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		return result;
	}
}