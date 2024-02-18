package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;

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

import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceParameterType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceParameterValue;

/**
*
* @author yulian oifa
*
*/
public class ServiceParameterInfoImpl implements ServiceParameterInfo
{
	private ServiceParameterType serviceParameterType;
	
	private ServiceParameterValue serviceParameterValue;
	
	public ServiceParameterInfoImpl(Long serviceParameterType, Long serviceParameterValue) throws MissingAvpException
	{
		setServiceParameterType(serviceParameterType);
		
		setServiceParameterValue(serviceParameterValue);
	}
	
	@Override
	public Long getServiceParameterType()
	{
		if(serviceParameterType==null)
			return null;
		
		return serviceParameterType.getUnsigned();
	}
	
	@Override
	public void setServiceParameterType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Parameter-Type is required is required", Arrays.asList(new DiameterAvp[] { new ServiceParameterTypeImpl() }));
		
		this.serviceParameterType = new ServiceParameterTypeImpl(value, null, null);
	}
	
	@Override
	public Long getServiceParameterValue()
	{
		if(serviceParameterValue==null)
			return null;
		
		return serviceParameterValue.getLong();
	}
	
	@Override
	public void setServiceParameterValue(Long value) throws MissingAvpException
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