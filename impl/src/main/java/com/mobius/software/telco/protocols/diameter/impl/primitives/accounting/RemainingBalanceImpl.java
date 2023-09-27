package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RemainingBalance;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.172	Remaining-Balance AVP
	The Remaining-Balance AVP (AVP code 2021) is of type Grouped and provides information about the remaining account balance of the subscriber.
	It has the following ABNF grammar:
	
	Remaining-Balance :: = < AVP Header: 2021 >
		{ Unit-Value }
		{ Currency-Code }
 */
@DiameterAvpImplementation(code = 2021L, vendorId = KnownVendorIDs.TGPP_ID)
public class RemainingBalanceImpl implements RemainingBalance
{
	private UnitValue unitValue;
	private CurrencyCode currencyCode;
	
	protected RemainingBalanceImpl() 
	{
	}

	public RemainingBalanceImpl(UnitValue unitValue,Long currencyCode)
	{
		if(unitValue==null)
			throw new IllegalArgumentException("Unit-Value is required");
		
		if(currencyCode==null)
			throw new IllegalArgumentException("Currency-Code is required");
		
		this.unitValue = unitValue;
		
		this.currencyCode = new CurrencyCodeImpl(currencyCode, null, null);
	}

	public UnitValue getUnitValue()
	{
		return unitValue;
	}
	
	public void setUnitValue(UnitValue value)
	{
		if(value==null)
			throw new IllegalArgumentException("Unit-Value is required");
		
		this.unitValue = value;		
	}
	
	public Long getCurrencyCode()
	{
		if(currencyCode==null)
			return null;
		
		return currencyCode.getUnsigned();
	}
	
	public void setCurrencyCode(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Currency-Code is required");
		
		this.currencyCode = new CurrencyCodeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(unitValue==null)
			return "Unit-Value is required";
		
		if(currencyCode==null)
			return "Currency-Code is required is required";
		
		return null;
	}
}