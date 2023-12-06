package com.mobius.software.telco.protocols.diameter.impl.commands.pc4a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.UpdateProSeSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.UPRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ResetIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
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
@DiameterCommandImplementation(applicationId = 16777336, commandCode = 8388665, request = true)
public class UpdateProSeSubscriberDataRequestImpl extends Pc4aRequestImpl implements UpdateProSeSubscriberDataRequest
{
	private ProSeSubscriptionData proSeSubscriptionData;
	 
	private VisitedPLMNId visitedPLMNId;
	
	private UPRFlags uprFlags;
	
	private List<ResetID> resetID;
	
	protected UpdateProSeSubscriberDataRequestImpl() 
	{
		super();
	}
	
	public UpdateProSeSubscriberDataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
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
	public Long getUPRFlags()
	{
		if(uprFlags == null)
			return null;
		
		return uprFlags.getUnsigned();
	}
	
	@Override
	public void setUPRFlags(Long value)
	{
		if(value == null)
			this.uprFlags = null;
		else
			this.uprFlags = new UPRFlagsImpl(value, null, null);	
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
}