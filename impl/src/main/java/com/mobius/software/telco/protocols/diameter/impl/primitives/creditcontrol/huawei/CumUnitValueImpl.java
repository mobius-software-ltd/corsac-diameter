package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumUnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumValueDigits;

/**
*
* @author yulian oifa
*
*/
public class CumUnitValueImpl implements CumUnitValue
{
	private CumValueDigits cumValueDigits;
	
	protected CumUnitValueImpl()
	{
		
	}
	
	public CumUnitValueImpl(Long cumValueDigits) throws MissingAvpException
	{
		setCumValueDigits(cumValueDigits);
	}
	
	@DiameterValidate
	public Long getCumValueDigits()
	{
		if(cumValueDigits == null)
			return null;
		
		return cumValueDigits.getLong();
	}
	
	@DiameterValidate
	public void setCumValueDigits(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Cum-Value-Digits is required", Arrays.asList(new DiameterAvp[] { new CumValueDigitsImpl() }));
			
		this.cumValueDigits = new CumValueDigitsImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(cumValueDigits==null)
			return new MissingAvpException("Cum-Value-Digits is required", Arrays.asList(new DiameterAvp[] { new CumValueDigitsImpl() }));
		
		return null;
	}
}