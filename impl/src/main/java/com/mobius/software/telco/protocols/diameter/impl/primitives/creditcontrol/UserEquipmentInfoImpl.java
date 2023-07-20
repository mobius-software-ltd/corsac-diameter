package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoValue;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 458L, vendorId = -1)
public class UserEquipmentInfoImpl implements UserEquipmentInfo 
{
	private UserEquipmentInfoType userEquipmentInfoType;
	
	private UserEquipmentInfoValue userEquipmentInfoValue;
	
	protected UserEquipmentInfoImpl()
	{
		
	}
	
	public UserEquipmentInfoImpl(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue)
	{
		if(userEquipmentInfoType==null)
			throw new IllegalArgumentException("User-Equipment-Info-Type is required");
		
		if(userEquipmentInfoValue==null)
			throw new IllegalArgumentException("User-Equipment-Info-Value is required");
		
		this.userEquipmentInfoType = new UserEquipmentInfoTypeImpl(userEquipmentInfoType, null, null);
		
		this.userEquipmentInfoValue = new UserEquipmentInfoValueImpl(userEquipmentInfoValue, null, null);
	}
	
	public UserEquipmentInfoTypeEnum getUserEquipmentInfoType()
	{
		if(userEquipmentInfoType == null)
			return null;
		
		return userEquipmentInfoType.getEnumerated(UserEquipmentInfoTypeEnum.class);
	}
	
	public void setUserEquipmentInfoType(UserEquipmentInfoTypeEnum userEquipmentInfoType)
	{
		if(userEquipmentInfoType==null)
			throw new IllegalArgumentException("User-Equipment-Info-Type is required");
		
		this.userEquipmentInfoType = new UserEquipmentInfoTypeImpl(userEquipmentInfoType, null, null);
		
	}
	
	public ByteBuf getUserEquipmentInfoValue()
	{
		if(userEquipmentInfoValue == null)
			return null;
		
		return userEquipmentInfoValue.getValue();
	}
	
	public void setUserEquipmentInfoValue(ByteBuf userEquipmentInfoValue)
	{
		if(userEquipmentInfoValue==null)
			throw new IllegalArgumentException("User-Equipment-Info-Value is required");
		
		this.userEquipmentInfoValue = new UserEquipmentInfoValueImpl(userEquipmentInfoValue, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(userEquipmentInfoType==null)
			return "User-Equipment-Info-Type is required";
		
		if(userEquipmentInfoValue==null)
			return "User-Equipment-Info-Value is required";
		
		return null;
	}
}