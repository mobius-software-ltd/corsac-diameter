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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;

/**
*
* @author yulian oifa
*
*/
public class CCMoneyImpl implements CCMoney
{
	private UnitValue unitValue;
	
	private CurrencyCode currencyCode;
	
	protected CCMoneyImpl()
	{
		
	}
	
	public CCMoneyImpl(UnitValue unitValue) throws MissingAvpException
	{
		setUnitValue(unitValue);		
	}
	
	public UnitValue getUnitValue()
	{
		return this.unitValue;
	}
	
	public void setUnitValue(UnitValue value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Unit-Value is required", Arrays.asList(new DiameterAvp[] { new UnitValueImpl() }));
		
		this.unitValue = value;
	}
	
	public Long getCurrencyCode()
	{
		if(this.currencyCode==null)
			return null;
		
		return this.currencyCode.getUnsigned();
	}
	
	public void setCurrencyCode(Long value) throws MissingAvpException
	{
		if(value!=null)
			this.currencyCode = new CurrencyCodeImpl(value, null, null);
		else
			this.currencyCode = null;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(unitValue==null)
			return new MissingAvpException("Unit-Value is required", Arrays.asList(new DiameterAvp[] { new UnitValueImpl() }));
		
		return null;
	}
}