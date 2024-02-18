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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class IMSIGroupIdImpl extends DiameterGroupedAvpImpl implements IMSIGroupId
{
	private GroupServiceId groupServiceId;
	
	private GroupPLMNId groupPLMNId;
	
	private LocalGroupId localGroupId;
	
	protected IMSIGroupIdImpl()
	{
		
	}
	
	public IMSIGroupIdImpl(Long groupServiceId,ByteBuf groupPLMNId,ByteBuf localGroupId) throws MissingAvpException
	{
		setGroupServiceId(groupServiceId);
		
		setGroupPLMNId(groupPLMNId);
		
		setLocalGroupId(localGroupId);
	}
	
	public Long getGroupServiceId()
	{
		if(groupServiceId==null)
			return null;
		
		return groupServiceId.getUnsigned();
	}
	
	public void setGroupServiceId(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Group-Service-Id is required", Arrays.asList(new DiameterAvp[] { new GroupServiceIdImpl() }));
			
		this.groupServiceId = new GroupServiceIdImpl(value, null, null);	
	}
	
	public ByteBuf getGroupPLMNId()
	{
		if(groupPLMNId==null)
			return null;
		
		return groupPLMNId.getValue();
	}
	
	public void setGroupPLMNId(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Group-PLMN-Id is required", Arrays.asList(new DiameterAvp[] { new GroupPLMNIdImpl() }));
			
		this.groupPLMNId = new GroupPLMNIdImpl(value, null, null);	
	}
	
	public ByteBuf getLocalGroupId()
	{
		if(localGroupId==null)
			return null;
		
		return localGroupId.getValue();
	}
	
	public void setLocalGroupId(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Local-Group-Id is required", Arrays.asList(new DiameterAvp[] { new LocalGroupIdImpl() }));
		
		this.localGroupId = new LocalGroupIdImpl(value, null, null);	
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(groupServiceId==null)
			return new MissingAvpException("Group-Service-Id is required", Arrays.asList(new DiameterAvp[] { new GroupServiceIdImpl() }));
		
		if(groupPLMNId==null)
			return new MissingAvpException("Group-PLMN-Id is required", Arrays.asList(new DiameterAvp[] { new GroupPLMNIdImpl() }));
		
		if(localGroupId==null)
			return new MissingAvpException("Local-Group-Id is required", Arrays.asList(new DiameterAvp[] { new LocalGroupIdImpl() }));
		
		return null;
	}
}