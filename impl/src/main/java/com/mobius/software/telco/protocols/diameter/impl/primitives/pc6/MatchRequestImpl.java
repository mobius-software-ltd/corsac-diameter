package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PC5Tech;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3856L, vendorId = KnownVendorIDs.TGPP_ID)
public class MatchRequestImpl extends DiameterGroupedAvpImpl implements MatchRequest
{
	private DiscoveryType discoveryType;
	private UserIdentity userIdentity;
	private VisitedPLMNId visitedPLMNID;
	private List<ProSeAppCodeInfo> proSeAppCodeInfo;
	private PC5Tech pc5Tech;
		
	protected MatchRequestImpl() 
	{
	}
	
	public MatchRequestImpl(DiscoveryTypeEnum discoveryType)
	{
		if(discoveryType==null)
			throw new IllegalArgumentException("Discovery-Type is required");
		
		this.discoveryType = new DiscoveryTypeImpl(discoveryType, null, null);						
	}
	
	public DiscoveryTypeEnum getDiscoveryType()
	{
		if(discoveryType==null)
			return null;
		
		return discoveryType.getEnumerated(DiscoveryTypeEnum.class);
	}
	
	public void setDiscoveryType(DiscoveryTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Discovery-Type is required");
		
		this.discoveryType = new DiscoveryTypeImpl(value, null, null);						
	}
	
	public UserIdentity getUserIdentity()
	{
		return userIdentity;
	}
	
	public void setUserIdentity(UserIdentity value)
	{
		this.userIdentity = value;
	}
	
	public ByteBuf getVisitedPLMNID()
	{
		if(visitedPLMNID==null)
			return null;
		
		return visitedPLMNID.getValue();
	}
	
	public void setVisitedPLMNID(ByteBuf value)
	{
		if(value==null)
			this.visitedPLMNID = null;
		else
			this.visitedPLMNID = new VisitedPLMNIdImpl(value, null, null);			
	}
	
	public List<ProSeAppCodeInfo> getProSeAppCodeInfo()
	{
		return proSeAppCodeInfo;
	}
	
	public void setProSeAppCodeInfo(List<ProSeAppCodeInfo> value)
	{
		this.proSeAppCodeInfo = value;
	}
	
	public ByteBuf getPC5Tech()
	{
		if(pc5Tech==null)
			return null;
		
		return pc5Tech.getValue();
	}
	
	public void setPC5Tech(ByteBuf value)
	{
		if(value==null)
			this.pc5Tech = null;
		else
			this.pc5Tech = new PC5TechImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(discoveryType==null)
			return "Discovery-Type is required";
		
		return null;
	}
}