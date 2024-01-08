package com.mobius.software.telco.protocols.diameter.impl.commands.t6a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MTDataRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.MaximumRetransmissionTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.NonIPDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.SCEFWaitTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.MaximumRetransmissionTime;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NonIPData;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.SCEFWaitTime;

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
@DiameterCommandImplementation(applicationId = 16777346, commandCode = 8388734, request = true)
public class MTDataRequestImpl extends T6aRequestImpl implements MTDataRequest
{
	private UserIdentifier userIdentifier;
	
	private BearerIdentifier bearerIdentifier;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private NonIPData nonIPData;
	
	private SCEFWaitTime scefWaitTime;
	
	private MaximumRetransmissionTime maximumRetransmissionTime;
	
	protected MTDataRequestImpl() 
	{
		super();
	}
	
	public MTDataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,ByteBuf bearerIdentifier)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
		
		setBearerIdentifier(bearerIdentifier);
	}
	
	@Override
	public UserIdentifier getUserIdentifier()
	{
		if(userIdentifier == null)
			return null;
		
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			throw new IllegalArgumentException("User-Identifier is required");
		
		this.userIdentifier = value;
	}		
	
	@Override
	public ByteBuf getBearerIdentifier()
	{
		if(bearerIdentifier == null)
			return null;
		
		return bearerIdentifier.getValue();
	}
	
	@Override
	public void setBearerIdentifier(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Bearer-Identifier is required");
		
		this.bearerIdentifier = new BearerIdentifierImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public ByteBuf getNonIPData()
	{
		if(nonIPData == null)
			return null;
		
		return nonIPData.getValue();
	}
	
	@Override
	public void setNonIPData(ByteBuf value)
	{
		if(value == null)
			this.nonIPData = null;
		else
			this.nonIPData = new NonIPDataImpl(value, null, null);
	}	
	
	@Override
	public Date getSCEFWaitTime()
	{
		if(scefWaitTime==null)
			return null;
		
		return this.scefWaitTime.getDateTime();
	}
	
	@Override
	public void setSCEFWaitTime(Date value)
	{
		if(value==null)
			this.scefWaitTime = null;
		else
			this.scefWaitTime = new SCEFWaitTimeImpl(value, null, null);
	}	
	
	@Override
	public Date getMaximumRetransmissionTime()
	{
		if(maximumRetransmissionTime==null)
			return null;
		
		return this.maximumRetransmissionTime.getDateTime();
	}
	
	@Override
	public void setMaximumRetransmissionTime(Date value)
	{
		if(value==null)
			this.maximumRetransmissionTime = null;
		else
			this.maximumRetransmissionTime = new MaximumRetransmissionTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(bearerIdentifier == null)
			return "Bearer-Identifier is required";
		
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		return super.validate();
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(userIdentifier);
		result.add(bearerIdentifier);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(nonIPData);
		result.add(scefWaitTime);
		result.add(maximumRetransmissionTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}	
}