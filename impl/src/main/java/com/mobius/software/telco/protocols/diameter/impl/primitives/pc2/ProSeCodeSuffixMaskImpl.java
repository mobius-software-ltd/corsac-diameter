package com.mobius.software.telco.protocols.diameter.impl.primitives.pc2;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeCodeSuffixMask;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.SuffixCode;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.SuffixMask;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ProSeCodeSuffixMaskImpl extends DiameterGroupedAvpImpl implements ProSeCodeSuffixMask
{
	private SuffixCode suffixCode;
	private List<SuffixMask> suffixMask;
	
	protected ProSeCodeSuffixMaskImpl() 
	{
	}
	
	public ProSeCodeSuffixMaskImpl(ByteBuf suffixCode,List<ByteBuf> suffixMask) throws MissingAvpException
	{
		setSuffixCode(suffixCode);
		
		setSuffixMask(suffixMask);
	}
	
	public ByteBuf getSuffixCode()
	{
		if(suffixCode==null)
			return null;
		
		return suffixCode.getValue();
	}
	
	public void setSuffixCode(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Suffix-Code is required is required", Arrays.asList(new DiameterAvp[] { new SuffixCodeImpl() }));
			
		this.suffixCode = new SuffixCodeImpl(value, null, null);
	}
	
	public List<ByteBuf> getSuffixMask()
	{
		if(suffixMask==null || suffixMask.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(SuffixMask curr:suffixMask)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setSuffixMask(List<ByteBuf> value) throws MissingAvpException
	{
		if(value==null || value.size()==0)
			throw new MissingAvpException("Suffix-Mask is required is required", Arrays.asList(new DiameterAvp[] { new SuffixMaskImpl() }));
		
		this.suffixMask =  new ArrayList<SuffixMask>();
		for(ByteBuf curr:value)
			this.suffixMask.add(new SuffixMaskImpl(curr, null, null));
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(suffixCode==null)
			return new MissingAvpException("Suffix-Code is required is required", Arrays.asList(new DiameterAvp[] { new SuffixCodeImpl() }));
		
		if(suffixMask==null || suffixMask.size()==0)
			return new MissingAvpException("Suffix-Mask is required is required", Arrays.asList(new DiameterAvp[] { new SuffixMaskImpl() }));
		
		return null;
	}
}