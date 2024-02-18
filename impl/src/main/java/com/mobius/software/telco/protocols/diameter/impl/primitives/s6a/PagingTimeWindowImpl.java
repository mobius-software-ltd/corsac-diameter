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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class PagingTimeWindowImpl extends DiameterGroupedAvpImpl implements PagingTimeWindow
{
	private OperationMode operationMode;
	
	private PagingTimeWindowLength pagingTimeWindowLength;
	
	protected PagingTimeWindowImpl()
	{
		
	}
	
	public PagingTimeWindowImpl(OperationModeEnum operationMode,ByteBuf pagingTimeWindowLength) throws MissingAvpException
	{
		setOperationMode(operationMode);
		
		setPagingTimeWindowLength(pagingTimeWindowLength);
	}
	
	public OperationModeEnum getOperationMode()
	{
		if(operationMode==null)
			return null;
		
		return operationMode.getEnumerated(OperationModeEnum.class);
	}
	
	public void setOperationMode(OperationModeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Operation-Mode is required", Arrays.asList(new DiameterAvp[] { new OperationModeImpl() }));
			
		this.operationMode = new OperationModeImpl(value, null, null);	
	}
	
	public ByteBuf getPagingTimeWindowLength()
	{
		if(pagingTimeWindowLength==null)
			return null;
		
		return pagingTimeWindowLength.getValue();
	}
	
	public void setPagingTimeWindowLength(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Paging-Time-Window-Length is required", Arrays.asList(new DiameterAvp[] { new PagingTimeWindowLengthImpl() }));
			
		this.pagingTimeWindowLength = new PagingTimeWindowLengthImpl(value, null, null);	
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(operationMode==null)
			return new MissingAvpException("Operation-Mode is required", Arrays.asList(new DiameterAvp[] { new OperationModeImpl() }));
		
		if(pagingTimeWindowLength==null)
			return new MissingAvpException("Paging-Time-Window-Length is required", Arrays.asList(new DiameterAvp[] { new PagingTimeWindowLengthImpl() }));
		
		return null;
	}
}