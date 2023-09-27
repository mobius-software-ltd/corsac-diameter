package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
/*
 * Mobius Software LTD
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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DLBufferingSuggestedPacketCountImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SubscribedPeriodicRAUTAUTimerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ActiveTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DLBufferingSuggestedPacketCount;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscribedPeriodicRAUTAUTimer;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletionExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SuggestedNetworkConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ActiveTime;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3170L, vendorId = KnownVendorIDs.TGPP_ID)
public class SuggestedNetworkConfigurationImpl extends DiameterGroupedAvpImpl implements SuggestedNetworkConfiguration
{
	private SCEFReferenceID scefReferenceID;
	private SCEFReferenceIDExt scefReferenceIDExt;
	private SCEFID scefID;
	private SubscribedPeriodicRAUTAUTimer subscribedPeriodicRAUTAUTimer;
	private ActiveTime activeTime;
	private DLBufferingSuggestedPacketCount dlBufferingSuggestedPacketCount;
	private MTCProviderInfo mtcProviderInfo;
	private List<SCEFReferenceIDForDeletion> scefReferenceIDForDeletion;
	private List<SCEFReferenceIDForDeletionExt> scefReferenceIDForDeletionExt;
	
	protected SuggestedNetworkConfigurationImpl() 
	{
	}
	
	public SuggestedNetworkConfigurationImpl(Long scefReferenceID,String scefID)
	{
		if(scefReferenceID==null)
			throw new IllegalArgumentException("SCEF-Reference-ID is required");
				
		if(scefID==null)
			throw new IllegalArgumentException("SCEF-ID is required");
		
		this.scefReferenceID = new SCEFReferenceIDImpl(scefReferenceID, null, null);
		
		this.scefID = new SCEFIDImpl(scefID, null, null);									
	}
	
	
	public Long getSCEFReferenceID()
	{
		if(scefReferenceID == null)
			return null;
		
		return scefReferenceID.getUnsigned();
	}
	
	public void setSCEFReferenceID(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("SCEF-Reference-ID is required");
		
		this.scefReferenceID = new SCEFReferenceIDImpl(value, null, null);						
	}
	
	public Long getSCEFReferenceIDExt()
	{
		if(scefReferenceIDExt == null)
			return null;
		
		return scefReferenceIDExt.getLong();
	}
	
	public void setSCEFReferenceIDExt(Long value)
	{
		if(value == null)
			this.scefReferenceIDExt = null;
		else
			this.scefReferenceIDExt = new SCEFReferenceIDExtImpl(value, null, null);
	}
	
	public String getSCEFID()
	{
		if(scefID == null)
			return null;
		
		return scefID.getIdentity();
	}
	
	public void setSCEFID(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("SCEF-ID is required");
		
		this.scefID = new SCEFIDImpl(value, null, null);
	}		
	
	public Long getSubscribedPeriodicRAUTAUTimer()
	{
		if(subscribedPeriodicRAUTAUTimer == null)
			return null;
		
		return subscribedPeriodicRAUTAUTimer.getUnsigned();
	}
	
	public void setSubscribedPeriodicRAUTAUTimer(Long value)
	{
		if(value==null)
			this.subscribedPeriodicRAUTAUTimer = null;
		else
			this.subscribedPeriodicRAUTAUTimer = new SubscribedPeriodicRAUTAUTimerImpl(value, null, null);						
	}
	
	public Long getActiveTime()
	{
		if(activeTime == null)
			return null;
		
		return activeTime.getUnsigned();
	}
	
	public void setActiveTime(Long value)
	{
		if(value==null)
			this.activeTime = null;
		else
			this.activeTime = new ActiveTimeImpl(value, null, null);						
	}
	
	public Integer getDLBufferingSuggestedPacketCount()
	{
		if(dlBufferingSuggestedPacketCount == null)
			return null;
		
		return dlBufferingSuggestedPacketCount.getInteger();
	}
	
	public void setDLBufferingSuggestedPacketCount(Integer value)
	{
		if(value == null)
			this.dlBufferingSuggestedPacketCount = null;
		else
			this.dlBufferingSuggestedPacketCount = new DLBufferingSuggestedPacketCountImpl(value, null, null);
	}
	
	public MTCProviderInfo getMTCProviderInfo()
	{
		return mtcProviderInfo;
	}
	
	public void setMTCProviderInfo(MTCProviderInfo value)
	{
		this.mtcProviderInfo = value;
	}
	
	public List<Long> getSCEFReferenceIDForDeletion()
	{
		if(scefReferenceIDForDeletion == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletion curr:scefReferenceIDForDeletion)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletion(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletion = null;
		else
		{
			this.scefReferenceIDForDeletion = new ArrayList<SCEFReferenceIDForDeletion>();
			for(Long curr:value)
				this.scefReferenceIDForDeletion.add(new SCEFReferenceIDForDeletionImpl(curr, null, null));			
		}
	}
	
	public List<Long> getSCEFReferenceIDForDeletionExt()
	{
		if(scefReferenceIDForDeletionExt == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletionExt curr:scefReferenceIDForDeletionExt)
			result.add(curr.getLong());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletionExt(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletionExt = null;
		else
		{
			this.scefReferenceIDForDeletionExt = new ArrayList<SCEFReferenceIDForDeletionExt>();
			for(Long curr:value)
				this.scefReferenceIDForDeletionExt.add(new SCEFReferenceIDForDeletionExtImpl(curr, null, null));			
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		if(scefReferenceID==null)
			return "SCEF-Reference-ID is required";
		
		if(scefID==null)
			return "SCEF-ID is required";
		
		return null;
	}
}