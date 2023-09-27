package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificData;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificType;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1249L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServiceSpecificInfoImpl implements ServiceSpecificInfo
{
	private ServiceSpecificData serviceSpecificData;
	private ServiceSpecificType serviceSpecificType;
	   
	public ServiceSpecificInfoImpl()
	{
		
	}
	
	public String getServiceSpecificData()
	{
		if(serviceSpecificData==null)
			return null;
		
		return serviceSpecificData.getString();
	}
	
	public void setServiceSpecificData(String value)
	{
		if(value==null)
			this.serviceSpecificData = null;
		else
			this.serviceSpecificData = new ServiceSpecificDataImpl(value, null, null);			
	}
	
	public Long getServiceSpecificType()
	{
		if(serviceSpecificType==null)
			return null;
		
		return serviceSpecificType.getUnsigned();
	}
	
	public void setServiceSpecificType(Long value)
	{
		if(value==null)
			this.serviceSpecificType = null;
		else
			this.serviceSpecificType = new ServiceSpecificTypeImpl(value, null, null);			
	}
}