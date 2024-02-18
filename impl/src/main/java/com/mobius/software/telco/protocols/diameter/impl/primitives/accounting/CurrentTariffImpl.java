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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CurrencyCodeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CurrentTariff;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RateElement;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ScaleFactor;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;

/**
*
* @author yulian oifa
*
*/
public class CurrentTariffImpl implements CurrentTariff
{
	private CurrencyCode currencyCode;
	private ScaleFactor scaleFactor;
	private List<RateElement> rateElement;
		
	public CurrentTariffImpl()
	{
		
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
			this.currencyCode = null;
		else
			this.currencyCode = new CurrencyCodeImpl(value, null, null);			
	}
	
	public ScaleFactor getScaleFactor()
	{
		return scaleFactor;
	}
	
	public void setScaleFactor(ScaleFactor value)
	{
		this.scaleFactor = value;
	}
	
	public List<RateElement> getRateElement()
	{
		return rateElement;
	}
	
	public void setRateElement(List<RateElement> value)
	{
		this.rateElement = value;
	}
}