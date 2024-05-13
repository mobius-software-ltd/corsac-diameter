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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class UserEquipmentInfoImpl extends DiameterAvpImpl implements UserEquipmentInfo 
{
	private UserEquipmentInfoType userEquipmentInfoType;
	
	private UserEquipmentInfoValue userEquipmentInfoValue;
	
	protected UserEquipmentInfoImpl()
	{
		
	}
	
	public UserEquipmentInfoImpl(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException
	{
		setUserEquipmentInfoType(userEquipmentInfoType);
		
		setUserEquipmentInfoValue(userEquipmentInfoValue);
	}
	
	public UserEquipmentInfoTypeEnum getUserEquipmentInfoType()
	{
		if(userEquipmentInfoType == null)
			return null;
		
		return userEquipmentInfoType.getEnumerated(UserEquipmentInfoTypeEnum.class);
	}
	
	public void setUserEquipmentInfoType(UserEquipmentInfoTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Equipment-Info-Type requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new UserEquipmentInfoTypeImpl() }));
		
		this.userEquipmentInfoType = new UserEquipmentInfoTypeImpl(value, null, null);
		
	}
	
	public ByteBuf getUserEquipmentInfoValue()
	{
		if(userEquipmentInfoValue == null)
			return null;
		
		return userEquipmentInfoValue.getValue();
	}
	
	public void setUserEquipmentInfoValue(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Equipment-Info-Value requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new UserEquipmentInfoValueImpl() }));
			
		this.userEquipmentInfoValue = new UserEquipmentInfoValueImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(userEquipmentInfoType==null)
			return new MissingAvpException("User-Equipment-Info-Type requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new UserEquipmentInfoTypeImpl() }));
		
		if(userEquipmentInfoValue==null)
			return new MissingAvpException("User-Equipment-Info-Value requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new UserEquipmentInfoValueImpl() }));
		
		return null;
	}
}