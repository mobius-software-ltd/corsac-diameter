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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumUnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumValueDigits;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 20856L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class CumUnitValueImpl implements CumUnitValue
{
	private CumValueDigits cumValueDigits;
	
	protected CumUnitValueImpl()
	{
		
	}
	
	public CumUnitValueImpl(Long cumValueDigits)
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
	public void setCumValueDigits(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Cum-Value-Digits is required");
		
		this.cumValueDigits = new CumValueDigitsImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(cumValueDigits==null)
			return "Cum-Value-Digits is required";
		
		return null;
	}
}