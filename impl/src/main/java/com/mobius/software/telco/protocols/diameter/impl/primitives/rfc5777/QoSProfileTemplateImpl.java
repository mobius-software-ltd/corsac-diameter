package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileTemplate;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 574L, vendorId = -1L)
public class QoSProfileTemplateImpl extends DiameterGroupedAvpImpl implements QoSProfileTemplate
{
	private VendorId vendorId;
	
	private QoSProfileId qoSProfileId;
	
	protected QoSProfileTemplateImpl() 
	{
	}
	
	public QoSProfileTemplateImpl(Long vendorId,Long qoSProfileId)
	{
		if(vendorId==null)
			throw new IllegalArgumentException("Vendor-Id is required");
		
		if(qoSProfileId==null)
			throw new IllegalArgumentException("QoS-Profile-Id is required");
		
		this.vendorId = new VendorIdImpl(vendorId, null, null);				
		
		this.qoSProfileId = new QoSProfileIdImpl(qoSProfileId, null, null);
	}
	
	public Long getVendorId()
	{
		if(this.vendorId==null)
			return null;
		
		return this.vendorId.getUnsigned();
	}
	
	public void setVendorId(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Vendor-Id is required");
		
		this.vendorId = new VendorIdImpl(value, null, null);						
	}
	
	public Long getQoSProfileId()
	{
		if(this.qoSProfileId==null)
			return null;
		
		return this.qoSProfileId.getUnsigned();
	}
	
	public void setQoSProfileId(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("QoS-Profile-Id is required");
		
		this.qoSProfileId = new QoSProfileIdImpl(value, null, null);						
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(vendorId==null)
			return "Vendor-Id is required";
		
		if(qoSProfileId==null)
			return "QoS-Profile-Id is required";
		
		return null;
	}
}