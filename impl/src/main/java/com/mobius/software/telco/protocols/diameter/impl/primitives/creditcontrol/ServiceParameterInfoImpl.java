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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterValue;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 440L, vendorId = -1)
public class ServiceParameterInfoImpl implements ServiceParameterInfo
{
	private ServiceParameterType serviceParameterType;
	
	private ServiceParameterValue serviceParameterValue;
	
	protected ServiceParameterInfoImpl()
	{
		
	}
	
	public ServiceParameterInfoImpl(Long serviceParameterType,ByteBuf serviceParameterValue)
	{
		if(serviceParameterType==null)
			throw new IllegalArgumentException("Service-Parameter-Type is required");
		
		if(serviceParameterValue==null)
			throw new IllegalArgumentException("Service-Parameter-Value is required");
		
		this.serviceParameterType = new ServiceParameterTypeImpl(serviceParameterType, null, null);
		
		this.serviceParameterValue = new ServiceParameterValueImpl(serviceParameterValue, null, null);
	}
	
	public Long getServiceParameterType()
	{
		if(serviceParameterType == null)
			return null;
		
		return serviceParameterType.getUnsigned();
	}
	
	public void setServiceParameterType(Long serviceParameterType)
	{
		if(serviceParameterType==null)
			throw new IllegalArgumentException("Service-Parameter-Type is required");
		
		this.serviceParameterType = new ServiceParameterTypeImpl(serviceParameterType, null, null);		
	}
	
	public ByteBuf getServiceParameterValue()
	{
		if(serviceParameterValue == null)
			return null;
		
		return serviceParameterValue.getValue();
	}
	
	public void setServiceParameterValue(ByteBuf serviceParameterValue)
	{
		if(serviceParameterValue==null)
			throw new IllegalArgumentException("Service-Parameter-Value is required");
		
		this.serviceParameterValue = new ServiceParameterValueImpl(serviceParameterValue, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(serviceParameterType==null)
			return "Service-Parameter-Type is required";
		
		if(serviceParameterValue==null)
			return "Service-Parameter-Value is required";
		
		return null;
	}
}