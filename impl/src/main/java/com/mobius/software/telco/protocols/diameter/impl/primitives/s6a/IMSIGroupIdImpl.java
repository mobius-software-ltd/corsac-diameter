package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GroupPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GroupServiceId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalGroupId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1675L, vendorId = KnownVendorIDs.TGPP_ID)
public class IMSIGroupIdImpl extends DiameterGroupedAvpImpl implements IMSIGroupId
{
	private GroupServiceId groupServiceId;
	
	private GroupPLMNId groupPLMNId;
	
	private LocalGroupId localGroupId;
	
	protected IMSIGroupIdImpl()
	{
		
	}
	
	public IMSIGroupIdImpl(Long groupServiceId,ByteBuf groupPLMNId,ByteBuf localGroupId)
	{
		if(groupServiceId==null)
			throw new IllegalArgumentException("Group-Service-Id is required");
		
		if(groupPLMNId==null)
			throw new IllegalArgumentException("Group-PLMN-Id is required");
		
		if(localGroupId==null)
			throw new IllegalArgumentException("Local-Group-Id is required");
		
		this.groupServiceId = new GroupServiceIdImpl(groupServiceId, null, null);				
		
		this.groupPLMNId = new GroupPLMNIdImpl(groupPLMNId, null, null);
		
		this.localGroupId = new LocalGroupIdImpl(localGroupId, null, null);	
	}
	
	public Long getGroupServiceId()
	{
		if(groupServiceId==null)
			return null;
		
		return groupServiceId.getUnsigned();
	}
	
	public void setGroupServiceId(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Group-Service-Id is required");
		
		this.groupServiceId = new GroupServiceIdImpl(value, null, null);	
	}
	
	public ByteBuf getGroupPLMNId()
	{
		if(groupPLMNId==null)
			return null;
		
		return groupPLMNId.getValue();
	}
	
	public void setGroupPLMNId(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Group-PLMN-Id is required");
		
		this.groupPLMNId = new GroupPLMNIdImpl(value, null, null);	
	}
	
	public ByteBuf getLocalGroupId()
	{
		if(localGroupId==null)
			return null;
		
		return localGroupId.getValue();
	}
	
	public void setLocalGroupId(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Local-Group-Id is required");
		
		this.localGroupId = new LocalGroupIdImpl(value, null, null);	
	}
	
	@DiameterValidate
	public String validate()
	{
		if(groupServiceId==null)
			return "Group-Service-Id is required";
		
		if(groupPLMNId==null)
			return "Group-PLMN-Id is required";
		
		if(localGroupId==null)
			return "Local-Group-Id is required";
		
		return null;
	}
}