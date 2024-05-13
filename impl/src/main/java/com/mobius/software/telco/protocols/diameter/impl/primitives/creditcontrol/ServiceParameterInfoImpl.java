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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterValue;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ServiceParameterInfoImpl extends DiameterAvpImpl implements ServiceParameterInfo
{
	private ServiceParameterType serviceParameterType;
	
	private ServiceParameterValue serviceParameterValue;
	
	public ServiceParameterInfoImpl()
	{
		
	}
	
	public ServiceParameterInfoImpl(Long serviceParameterType,ByteBuf serviceParameterValue) throws MissingAvpException
	{
		setServiceParameterType(serviceParameterType);
		
		setServiceParameterValue(serviceParameterValue);
	}
	
	public Long getServiceParameterType()
	{
		if(serviceParameterType == null)
			return null;
		
		return serviceParameterType.getUnsigned();
	}
	
	public void setServiceParameterType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Parameter-Type is required is required", Arrays.asList(new DiameterAvp[] { new ServiceParameterTypeImpl() }));
			
		this.serviceParameterType = new ServiceParameterTypeImpl(value, null, null);		
	}
	
	public ByteBuf getServiceParameterValue()
	{
		if(serviceParameterValue == null)
			return null;
		
		return serviceParameterValue.getValue();
	}
	
	public void setServiceParameterValue(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Parameter-Value is required is required", Arrays.asList(new DiameterAvp[] { new ServiceParameterValueImpl() }));
			
		this.serviceParameterValue = new ServiceParameterValueImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(serviceParameterType==null)
			return new MissingAvpException("Service-Parameter-Type is required is required", Arrays.asList(new DiameterAvp[] { new ServiceParameterTypeImpl() }));
		
		if(serviceParameterValue==null)
			return new MissingAvpException("Service-Parameter-Value is required is required", Arrays.asList(new DiameterAvp[] { new ServiceParameterValueImpl() }));
		
		return null;
	}
}