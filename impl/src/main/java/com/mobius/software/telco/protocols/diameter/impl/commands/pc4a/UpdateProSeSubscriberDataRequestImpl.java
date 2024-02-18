package com.mobius.software.telco.protocols.diameter.impl.commands.pc4a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.UpdateProSeSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ResetIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.UPRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ResetID;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

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
public class UpdateProSeSubscriberDataRequestImpl extends Pc4aRequestImpl implements UpdateProSeSubscriberDataRequest
{
	protected AuthSessionState authSessionState;
	
	private ProSeSubscriptionData proSeSubscriptionData;
	 
	private VisitedPLMNId visitedPLMNId;
	
	private UPRFlags uprFlags;
	
	private List<ResetID> resetID;
	
	protected UpdateProSeSubscriberDataRequestImpl() 
	{
		super();
	}
	
	public UpdateProSeSubscriberDataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID);
		
		setAuthSessionState(authSessionState);
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
			throw new MissingAvpException("Auth-Session-State is required is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
			
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	@Override
	public ProSeSubscriptionData getProSeSubscriptionData()
	{
		return proSeSubscriptionData;
	}
	 
	@Override
	public void setProSeSubscriptionData(ProSeSubscriptionData value)
	{
		this.proSeSubscriptionData = value;
	}
	
	@Override	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	@Override	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value == null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);	
	}
	
	@Override
	public UPRFlags getUPRFlags()
	{
		return uprFlags;
	}
	
	@Override
	public void setUPRFlags(UPRFlags value)
	{
		this.uprFlags = value;	
	}
	
	@Override
	public List<ByteBuf> getResetID()
	{
		if(this.resetID==null || this.resetID.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ResetID curr:resetID)
			result.add(curr.getValue());
		
		return result;
	}
	 
	@Override
	public void setResetID(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.resetID = null;
		else
		{
			this.resetID = new ArrayList<ResetID>();
			for(ByteBuf curr:value)
				this.resetID.add(new ResetIDImpl(curr, null, null));
		}		
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authSessionState == null)
			return new MissingAvpException("Auth-Session-State is required is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(username);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(proSeSubscriptionData);
		result.add(visitedPLMNId);
		result.add(uprFlags);
		
		if(resetID!=null)
			result.addAll(resetID);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}