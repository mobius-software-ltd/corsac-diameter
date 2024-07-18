package com.mobius.software.telco.protocols.diameter.impl.commands.sy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingLimitRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LogicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PhysicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sy.PolicyCounterIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sy.SLRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PhysicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sy.SLRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.sy.SLRequestTypeEnum;

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
public class SpendingLimitRequestImpl extends SyRequestImpl implements SpendingLimitRequest
{
	private List<SupportedFeatures> supportedFeatures;
	
	private SLRequestType slRequestType;
	
	private List<SubscriptionId> subscriptionId;
	
	private List<PolicyCounterIdentifier> policyCounterIdentifier;
	
	private LogicalAccessID logicalAccessID;
	
	private PhysicalAccessID physicalAccessID;
	
	protected SpendingLimitRequestImpl() 
	{
		super();
	}
	
	public SpendingLimitRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm, Boolean isRetransmit, String sessionID, Long authApplicationId, SLRequestTypeEnum slRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setSLRequestType(slRequestType);
	}				
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	 
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public SLRequestTypeEnum getSLRequestType()
	{
		if(slRequestType==null)
			return null;
		
		return slRequestType.getEnumerated(SLRequestTypeEnum.class);
	}
	
	@Override
	public void setSLRequestType(SLRequestTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SL-Request-Type is required is required", Arrays.asList(new DiameterAvp[] { new SLRequestTypeImpl() }));
		
		this.slRequestType = new SLRequestTypeImpl(value, null, null);
	}
	
	@Override
	public List<SubscriptionId> getSubscriptionId()
	{
		return this.subscriptionId;
	}
	
	@Override
	public void setSubscriptionId(List<SubscriptionId> value)
	{
		this.subscriptionId = value;
	}

	@Override
	public List<String> getPolicyCounterIdentifier()
	{
		if(subscriptionId==null || subscriptionId.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(PolicyCounterIdentifier curr:this.policyCounterIdentifier)
			result.add(curr.getString());
		
		return result;
	}
	
	@Override
	public void setPolicyCounterIdentifier(List<String> value)
	{
		if(value==null || value.size()==0)
			this.policyCounterIdentifier = null;
		else
		{
			this.policyCounterIdentifier = new ArrayList<PolicyCounterIdentifier>();
			for(String curr:value)
				this.policyCounterIdentifier.add(new PolicyCounterIdentifierImpl(curr, null, null));
		}
	}
	
	@Override
	public ByteBuf getLogicalAccessID()
	{
		if(logicalAccessID==null)
			return null;
		
		return logicalAccessID.getValue();
	}
	
	@Override
	public void setLogicalAccessID(ByteBuf value)
	{
		if(value==null)
			this.logicalAccessID = null;
		else
			this.logicalAccessID = new LogicalAccessIDImpl(value, null, null);			
	}
	
	@Override
	public String getPhysicalAccessID()
	{
		if(physicalAccessID==null)
			return null;
		
		return physicalAccessID.getString();
	}
	
	@Override
	public void setPhysicalAccessID(String value)
	{
		if(value==null)
			this.physicalAccessID = null;
		else
			this.physicalAccessID = new PhysicalAccessIDImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(slRequestType==null)
			return new MissingAvpException("SL-Request-Type is required is required", Arrays.asList(new DiameterAvp[] { new SLRequestTypeImpl() }));
		
		return super.validate();
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(originStateId);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(slRequestType);
		
		if(subscriptionId!=null)
			result.addAll(subscriptionId);
		
		if(policyCounterIdentifier!=null)
			result.addAll(policyCounterIdentifier);
		
		result.add(logicalAccessID);
		result.add(physicalAccessID);
		
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