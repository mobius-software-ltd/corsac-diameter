package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorId;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResult;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResultCode;

/**
*
* @author yulian oifa
*
*/
public class ServiceResultImpl extends DiameterGroupedAvpImpl implements ServiceResult
{
	private VendorId vendorId;
	
	private ServiceResultCode serviceResultCode;
	
	public ServiceResultImpl()
	{
		
	}
	
	public Long getVendorId()
	{
		if(vendorId == null)
			return null;
		
		return vendorId.getUnsigned();
	}
	
	public void setVendorId(Long value)
	{
		if(value==null)
			this.vendorId = null;
		else
			this.vendorId = new VendorIdImpl(value, null, null);
	}
	
	public Long getServiceResultCode()
	{
		if(serviceResultCode == null)
			return null;
		
		return serviceResultCode.getUnsigned();
	}
	
	public void setServiceResultCode(Long value)
	{
		if(value==null)
			this.serviceResultCode = null;
		else
			this.serviceResultCode = new ServiceResultCodeImpl(value, null, null);
	}
}