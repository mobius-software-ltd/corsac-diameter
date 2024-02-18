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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MOLR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSStatus;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MOLRImpl extends DiameterGroupedAvpImpl implements MOLR
{
	private SSCode ssCode;
	
	private SSStatus ssStatus;
	
	protected MOLRImpl()
	{
		
	}
	
	public MOLRImpl(ByteBuf ssCode,ByteBuf ssStatus) throws MissingAvpException
	{
		setSSCode(ssCode);
		
		setSSStatus(ssStatus);
	}
	
	public ByteBuf getSSCode()
	{
		if(ssCode==null)
			return null;
		
		return ssCode.getValue();
	}
	
	public void setSSCode(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SS-Code is required", Arrays.asList(new DiameterAvp[] { new SSCodeImpl() }));
			
		this.ssCode = new SSCodeImpl(value, null, null);	
	}
	
	public ByteBuf getSSStatus()
	{
		if(ssStatus==null)
			return null;
		
		return ssStatus.getValue();
	}
	
	public void setSSStatus(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SS-Status is required", Arrays.asList(new DiameterAvp[] { new SSStatusImpl() }));
			
		this.ssStatus = new SSStatusImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ssCode==null)
			return new MissingAvpException("SS-Code is required", Arrays.asList(new DiameterAvp[] { new SSCodeImpl() }));
		
		if(ssStatus==null)
			return new MissingAvpException("SS-Status is required", Arrays.asList(new DiameterAvp[] { new SSStatusImpl() }));
		
		return null;
	}
}