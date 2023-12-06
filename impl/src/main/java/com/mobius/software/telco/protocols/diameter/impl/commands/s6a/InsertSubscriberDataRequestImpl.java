package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6a.InsertSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IDRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ResetIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IDRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ResetID;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;

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
@DiameterCommandImplementation(applicationId = 16777251, commandCode = 319, request = true)
public class InsertSubscriberDataRequestImpl extends S6aRequestImpl implements InsertSubscriberDataRequest
{
	private SubscriptionData subscriptionData;
	
	private IDRFlags idrFlags;
	
	private List<ResetID> resetID;
	
	protected InsertSubscriberDataRequestImpl() 
	{
		super();
	}
	
	public InsertSubscriberDataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,SubscriptionData subscriptionData)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setSubscriptionData(subscriptionData);
	}
	
	@Override
	public SubscriptionData getSubscriptionData()
	{
		return this.subscriptionData;
	}
	
	@Override
	public void setSubscriptionData(SubscriptionData value)
	{
		if(value == null)
			throw new IllegalArgumentException("Subscription-Data is required");
		
		this.subscriptionData = value;
	}
	
	@Override
	public Long getIDRFlags()
	{
		if(idrFlags == null)
			return null;
		
		return idrFlags.getUnsigned();
	}
	
	@Override
	public void setIDRFlags(Long value)
	{
		if(value == null)
			this.idrFlags = null;
		else
			this.idrFlags = new IDRFlagsImpl(value, null, null);
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
	
	@DiameterValidate
	public String validate()
	{
		if(subscriptionData == null)
			return "Subscription-Data is required";
		
		return super.validate();
	}	
}