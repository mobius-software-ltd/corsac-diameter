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
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CurrencyCodeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CCCredit;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 473L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class CCCreditImpl implements CCCredit 
{
	private UnitValue unitValue;
	
	private CurrencyCode currencyCode;
	
	protected CCCreditImpl()
	{
		
	}
	
	public CCCreditImpl(UnitValue unitValue)
	{
		setUnitValue(unitValue);
	}
	
	@Override
	public UnitValue getUnitValue()
	{
		return this.unitValue;
	}
	
	@Override
	public void setUnitValue(UnitValue value)
	{
		if(value==null)
			throw new IllegalArgumentException("Unit-Value is required");
		
		this.unitValue = value;
	}
	
	@Override
	public Long getCurrencyCode()
	{
		if(currencyCode==null)
			return null;
		
		return currencyCode.getUnsigned();
	}
	
	@Override
	public void setCurrencyCode(Long value)
	{
		if(value==null)
			this.currencyCode = null;
		else
			this.currencyCode = new CurrencyCodeImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(unitValue==null)
			return "Unit-Value is required";
		
		return null;
	}	
}