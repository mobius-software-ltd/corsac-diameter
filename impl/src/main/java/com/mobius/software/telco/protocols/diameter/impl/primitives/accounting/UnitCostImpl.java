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
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ExponentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValueDigitsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitCost;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.Exponent;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValueDigits;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.239	Unit-Cost AVP
	The Unit-Cost AVP (AVP code 2061) is of type Grouped and holds monetary value. It has the same format of Unit-Value AVP.
	It has the following ABNF grammar:

	Unit-Cost :: = < AVP Header: 2061 >
		 	{ Value-Digits }
		  	[ Exponent ]
 */
@DiameterAvpImplementation(code = 2061L, vendorId = KnownVendorIDs.TGPP_ID)
public class UnitCostImpl implements UnitCost
{
	private ValueDigits valueDigits;
	private Exponent exponent;
	
	protected UnitCostImpl() 
	{
	}
	
	public UnitCostImpl(Long valueDigits)
	{
		if(valueDigits==null)
			throw new IllegalArgumentException("Value-Digits is required");
		
		this.valueDigits = new ValueDigitsImpl(valueDigits, null, null);
	}
		
	public Long getValueDigits()
	{
		if(valueDigits==null)
			return null;
		
		return valueDigits.getLong();
	}
	
	public void setValueDigits(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Value-Digits is required");
		
		this.valueDigits = new ValueDigitsImpl(value, null, null);		
	}
	
	public Long getExponent()
	{
		if(exponent==null)
			return null;
		
		return exponent.getUnsigned();
	}
	
	public void setExponent(Long value)
	{
		if(value==null)
			this.exponent = null;
		else
			this.exponent = new ExponentImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(valueDigits==null)
			return "Value-Digits is required";
		
		return null;
	}
}