package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ResetIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UserIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ResetID;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionDataDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UserId;

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
public class ResetRequestImpl extends S6aRequestImpl implements ResetRequest
{
	private List<UserId> userId;
	
	private List<ResetID> resetID;
	
	private SubscriptionData subscriptionData;
	
	private SubscriptionDataDeletion subscriptionDataDeletion;		
	
	protected ResetRequestImpl() 
	{
		super();
	}
	
	public ResetRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
	}
	
	@Override
	public List<String> getUserId()
	{
		if(userId==null || userId.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(UserId curr: userId)
			result.add(curr.getString());
		
		return result;
	}
	
	@Override
	public void setUserId(List<String> value)
	{
		if(value==null || value.size()==0)
			this.userId = null;
		else
		{	
			this.userId = new ArrayList<UserId>();
			for(String curr:value)
				this.userId.add(new UserIdImpl(curr, null, null));
		}
	}
	
	@Override
	public List<ByteBuf> getResetID()
	{
		if(resetID==null || resetID.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ResetID curr: resetID)
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
	
	@Override
	public SubscriptionData getSubscriptionData()
	{
		return this.subscriptionData;
	}
	 
	@Override
	public void setSubscriptionData(SubscriptionData value)
	{
		this.subscriptionData = value;
	}
	
	@Override
	public SubscriptionDataDeletion getSubscriptionDataDeletion()
	{
		return this.subscriptionDataDeletion;
	}
	 
	@Override
	public void setSubscriptionDataDeletion(SubscriptionDataDeletion value)
	{
		this.subscriptionDataDeletion = value;
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
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(userId!=null)
			result.addAll(userId);
		
		if(resetID!=null)
			result.addAll(resetID);
		
		result.add(subscriptionData);
		result.add(subscriptionDataDeletion);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}	
}