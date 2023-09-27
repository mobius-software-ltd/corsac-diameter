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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchReportInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppId;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3857L, vendorId = KnownVendorIDs.TGPP_ID)
public class MatchReportInfoImpl extends DiameterGroupedAvpImpl implements MatchReportInfo
{
	private DiscoveryType discoveryType;
	private UserIdentity userIdentity;
	private List<ProSeAppId> proSeAppID;
		
	protected MatchReportInfoImpl() 
	{
	}
	
	public MatchReportInfoImpl(DiscoveryTypeEnum discoveryType)
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
	
	public List<String> getProSeAppId()
	{
		if(proSeAppID==null || proSeAppID.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ProSeAppId curr:proSeAppID)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setProSeAppId(List<String> value)
	{
		if(value==null || value.size()==0)
			this.proSeAppID = null;
		else
		{
			this.proSeAppID = new ArrayList<ProSeAppId>();
			for(String curr:value)
				this.proSeAppID.add(new ProSeAppIdImpl(curr, null, null));
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		if(discoveryType==null)
			return "Discovery-Type is required";
		
		return null;
	}
}