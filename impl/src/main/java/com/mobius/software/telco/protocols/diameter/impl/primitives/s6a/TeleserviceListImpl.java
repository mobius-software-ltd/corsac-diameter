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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TeleserviceList;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TeleserviceListImpl extends DiameterGroupedAvpImpl implements TeleserviceList
{
	private List<TSCode> tsCode;
	
	protected TeleserviceListImpl()
	{
		
	}
	
	public TeleserviceListImpl(List<ByteBuf> tsCode) throws MissingAvpException
	{
		setTSCode(tsCode);
	}
	
	public List<ByteBuf> getTSCode()
	{
		if(tsCode==null || tsCode.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TSCode curr:tsCode)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setTSCode(List<ByteBuf> value) throws MissingAvpException
	{
		if(value == null || value.size()==0)
			throw new MissingAvpException("TS-Code is required is required", Arrays.asList(new DiameterAvp[] { new TSCodeImpl() }));
		
		this.tsCode = new ArrayList<TSCode>();
		for(ByteBuf curr:value)
			this.tsCode.add(new TSCodeImpl(curr, null, null));		
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tsCode==null || tsCode.size()==0)
			return new MissingAvpException("TS-Code is required is required", Arrays.asList(new DiameterAvp[] { new TSCodeImpl() }));
		
		return null;
	}
}