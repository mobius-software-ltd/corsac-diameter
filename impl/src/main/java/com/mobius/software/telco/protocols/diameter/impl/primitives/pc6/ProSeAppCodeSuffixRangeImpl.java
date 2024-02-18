package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.BeginningSuffix;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.EndingSuffix;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeSuffixRange;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ProSeAppCodeSuffixRangeImpl extends DiameterGroupedAvpImpl implements ProSeAppCodeSuffixRange
{
	private BeginningSuffix beginningSuffix;
	private EndingSuffix endingSuffix;
			
	protected ProSeAppCodeSuffixRangeImpl() 
	{
	}
	
	public ProSeAppCodeSuffixRangeImpl(ByteBuf beginningSuffix) throws MissingAvpException
	{
		setBeginningSuffix(beginningSuffix);
	}
	
	public ByteBuf getBeginningSuffix()
	{
		if(beginningSuffix==null)
			return null;
		
		return beginningSuffix.getValue();
	}
	
	public void setBeginningSuffix(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Beginning-Suffix is required is required", Arrays.asList(new DiameterAvp[] { new BeginningSuffixImpl() }));
		
		this.beginningSuffix = new BeginningSuffixImpl(value, null, null);
	}
	
	public ByteBuf getEndingSuffix()
	{
		if(endingSuffix==null)
			return null;
		
		return endingSuffix.getValue();
	}
	
	public void setEndingSuffix(ByteBuf value)
	{
		if(value==null)
			this.endingSuffix = null;
		else
			this.endingSuffix = new EndingSuffixImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(beginningSuffix==null)
			return new MissingAvpException("Beginning-Suffix is required is required", Arrays.asList(new DiameterAvp[] { new BeginningSuffixImpl() }));
		
		return null;
	}
}