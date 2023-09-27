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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MOLR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSStatus;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1485L, vendorId = KnownVendorIDs.TGPP_ID)
public class MOLRImpl extends DiameterGroupedAvpImpl implements MOLR
{
	private SSCode ssCode;
	
	private SSStatus ssStatus;
	
	protected MOLRImpl()
	{
		
	}
	
	public MOLRImpl(ByteBuf ssCode,ByteBuf ssStatus)
	{
		if(ssCode==null)
			throw new IllegalArgumentException("SS-Code is required");
		
		if(ssStatus==null)
			throw new IllegalArgumentException("SS-Status is required");
		
		this.ssCode = new SSCodeImpl(ssCode, null, null);				
		
		this.ssStatus = new SSStatusImpl(ssStatus, null, null);
	}
	
	public ByteBuf getSSCode()
	{
		if(ssCode==null)
			return null;
		
		return ssCode.getValue();
	}
	
	public void setSSCode(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("SS-Code is required");
		
		this.ssCode = new SSCodeImpl(value, null, null);	
	}
	
	public ByteBuf getSSStatus()
	{
		if(ssStatus==null)
			return null;
		
		return ssStatus.getValue();
	}
	
	public void setSSStatus(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("SS-Status is required");
		
		this.ssStatus = new SSStatusImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(ssCode==null)
			return "SS-Code is required";
		
		if(ssStatus==null)
			return "SS-Status is required";
		
		return null;
	}
}