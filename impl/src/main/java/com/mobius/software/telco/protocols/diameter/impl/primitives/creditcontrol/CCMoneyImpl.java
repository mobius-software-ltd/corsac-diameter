package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 413L, vendorId = -1)
public class CCMoneyImpl implements CCMoney
{
	private UnitValue unitValue;
	
	private CurrencyCode currencyCode;
	
	protected CCMoneyImpl()
	{
		
	}
	
	public CCMoneyImpl(UnitValue unitValue,Long currencyCode)
	{
		if(unitValue==null)
			throw new IllegalArgumentException("Unit-Value is required");
		
		this.unitValue = unitValue;
		
		if(currencyCode!=null)
			this.currencyCode=new CurrencyCodeImpl(currencyCode, null, null);		
	}
	
	public UnitValue getUnitValue()
	{
		return this.unitValue;
	}
	
	public void setUnitValue(UnitValue unitValue)
	{
		this.unitValue = unitValue;
	}
	
	public Long getCurrencyCode()
	{
		if(this.currencyCode==null)
			return null;
		
		return this.currencyCode.getUnsigned();
	}
	
	public void setCurrencyCode(Long currencyCode)
	{
		if(currencyCode!=null)
			this.currencyCode = new CurrencyCodeImpl(currencyCode, null, null);
		else
			this.currencyCode = null;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(unitValue==null)
			return "Unit-Value is required";
		
		return null;
	}
}