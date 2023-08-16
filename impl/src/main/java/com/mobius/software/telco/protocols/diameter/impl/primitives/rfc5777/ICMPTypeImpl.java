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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPCode;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPTypeNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPTypeNumberEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Negated;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.NegatedEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 545L, vendorId = -1L)
public class ICMPTypeImpl extends DiameterGroupedAvpImpl implements ICMPType
{
	private ICMPTypeNumber icmpTypeNumber;
	
	private List<ICMPCode> icmpCode;
	
	private Negated negated;
	
	protected ICMPTypeImpl() 
	{
	}
	
	public ICMPTypeImpl(ICMPTypeNumberEnum icmpTypeNumber)
	{
		if(icmpTypeNumber==null)
			throw new IllegalArgumentException("ICMP-Type-Number is required");
		
		this.icmpTypeNumber = new ICMPTypeNumberImpl(icmpTypeNumber, null, null);				
	}
	
	public ICMPTypeNumberEnum getICMPTypeNumber()
	{
		if(this.icmpTypeNumber==null)
			return null;
		
		return this.icmpTypeNumber.getEnumerated(ICMPTypeNumberEnum.class);
	}
	
	public void setICMPTypeNumber(ICMPTypeNumberEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("ICMP-Type-Number is required");
		
		this.icmpTypeNumber = new ICMPTypeNumberImpl(value, null, null);	
	}
	
	public List<ICMPCodeEnum> getICMPCode()
	{
		if(icmpCode==null || icmpCode.size()==0)
			return null;
		
		List<ICMPCodeEnum> result = new ArrayList<ICMPCodeEnum>();
		for(ICMPCode curr:icmpCode)
			result.add(curr.getEnumerated(ICMPCodeEnum.class));
		
		return result;
	}
	
	public void setICMPCode(List<ICMPCodeEnum> value)
	{
		if(value==null || value.size()==0)
			this.icmpCode = null;
		else
		{
			this.icmpCode = new ArrayList<ICMPCode>();
			for(ICMPCodeEnum curr:value)
				this.icmpCode.add(new ICMPCodeImpl(curr, null, null));			
		}
	}
	
	public NegatedEnum getNegated()
	{
		if(negated==null)
			return null;
		
		return this.negated.getEnumerated(NegatedEnum.class);
	}
	
	public void setNegated(NegatedEnum value)
	{
		if(value==null)
			this.negated = null;
		else
			this.negated = new NegatedImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(icmpTypeNumber==null)
			return "ICMP-Type-Number is required";
		
		return null;
	}			
}