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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CurrencyCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UnitValueImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RemainingBalance;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;

/**
*
* @author yulian oifa
*
*/
public class RemainingBalanceImpl implements RemainingBalance
{
	private UnitValue unitValue;
	private CurrencyCode currencyCode;
	
	protected RemainingBalanceImpl() 
	{
	}

	public RemainingBalanceImpl(UnitValue unitValue,Long currencyCode) throws MissingAvpException
	{
		setUnitValue(unitValue);
		
		setCurrencyCode(currencyCode);
	}

	public UnitValue getUnitValue()
	{
		return unitValue;
	}
	
	public void setUnitValue(UnitValue value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Unit-Value is required is required", Arrays.asList(new DiameterAvp[] { new UnitValueImpl() }));
		
		this.unitValue = value;		
	}
	
	public Long getCurrencyCode()
	{
		if(currencyCode==null)
			return null;
		
		return currencyCode.getUnsigned();
	}
	
	public void setCurrencyCode(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Currency-Code is required is required", Arrays.asList(new DiameterAvp[] { new CurrencyCodeImpl() }));
		
		this.currencyCode = new CurrencyCodeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(unitValue==null)
			return new MissingAvpException("Unit-Value is required is required", Arrays.asList(new DiameterAvp[] { new UnitValueImpl() }));
		
		if(currencyCode==null)
			return new MissingAvpException("Currency-Code is required is required", Arrays.asList(new DiameterAvp[] { new CurrencyCodeImpl() }));
		
		return null;
	}
}