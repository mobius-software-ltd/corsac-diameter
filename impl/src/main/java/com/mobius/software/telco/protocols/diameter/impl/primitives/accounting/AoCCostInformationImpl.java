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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccumulatedCost;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCCostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IncrementalCost;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;

/**
*
* @author yulian oifa
*
*/
public class AoCCostInformationImpl implements AoCCostInformation
{
	private AccumulatedCost accumulatedCost;
	private List<IncrementalCost> incrementalCost;
	private CurrencyCode currencyCode;
		
	public AoCCostInformationImpl()
	{
		
	}
	
	public AccumulatedCost getAccumulatedCost()
	{
		return accumulatedCost;
	}
	
	public void setAccumulatedCost(AccumulatedCost value)
	{
		this.accumulatedCost = value;
	}
	
	public List<IncrementalCost> getIncrementalCost()
	{
		return incrementalCost;
	}
	
	public void setIncrementalCost(List<IncrementalCost> value)
	{
		this.incrementalCost = value;
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
}