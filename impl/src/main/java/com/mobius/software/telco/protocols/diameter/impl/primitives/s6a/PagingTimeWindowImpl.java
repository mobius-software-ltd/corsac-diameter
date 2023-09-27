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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.OperationMode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.OperationModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PagingTimeWindow;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PagingTimeWindowLength;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1701L, vendorId = KnownVendorIDs.TGPP_ID)
public class PagingTimeWindowImpl extends DiameterGroupedAvpImpl implements PagingTimeWindow
{
	private OperationMode operationMode;
	
	private PagingTimeWindowLength pagingTimeWindowLength;
	
	protected PagingTimeWindowImpl()
	{
		
	}
	
	public PagingTimeWindowImpl(OperationModeEnum operationMode,ByteBuf pagingTimeWindowLength)
	{
		if(operationMode==null)
			throw new IllegalArgumentException("Operation-Mode is required");
		
		if(pagingTimeWindowLength==null)
			throw new IllegalArgumentException("Paging-Time-Window-Length is required");
		
		this.operationMode = new OperationModeImpl(operationMode, null, null);				
		
		this.pagingTimeWindowLength = new PagingTimeWindowLengthImpl(pagingTimeWindowLength, null, null);
	}
	
	public OperationModeEnum getOperationMode()
	{
		if(operationMode==null)
			return null;
		
		return operationMode.getEnumerated(OperationModeEnum.class);
	}
	
	public void setOperationMode(OperationModeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Operation-Mode is required");
		
		this.operationMode = new OperationModeImpl(value, null, null);	
	}
	
	public ByteBuf getPagingTimeWindowLength()
	{
		if(pagingTimeWindowLength==null)
			return null;
		
		return pagingTimeWindowLength.getValue();
	}
	
	public void setPagingTimeWindowLength(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Paging-Time-Window-Length is required");
		
		this.pagingTimeWindowLength = new PagingTimeWindowLengthImpl(value, null, null);	
	}
	
	@DiameterValidate
	public String validate()
	{
		if(operationMode==null)
			return "Operation-Mode is required";
		
		if(pagingTimeWindowLength==null)
			return "Paging-Time-Window-Length is required";
		
		return null;
	}
}