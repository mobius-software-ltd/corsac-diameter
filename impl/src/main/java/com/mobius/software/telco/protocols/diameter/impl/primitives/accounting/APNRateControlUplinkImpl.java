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

import com.mobius.software.telco.protocols.diameter.primitives.accounting.APNRateControlUplink;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AdditionalExceptionReports;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AdditionalExceptionReportsEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RateControlMaxRate;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RateControlTimeUnit;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RateControlTimeUnitEnum;

/**
*
* @author yulian oifa
*
*/
public class APNRateControlUplinkImpl implements APNRateControlUplink
{
	private AdditionalExceptionReports additionalExceptionReports;
	private RateControlTimeUnit rateControlTimeUnit;
	private RateControlMaxRate rateControlMaxRate;
		
	public APNRateControlUplinkImpl()
	{
		
	}
	
	public AdditionalExceptionReportsEnum getAdditionalExceptionReports()
	{
		if(additionalExceptionReports==null)
			return null;
		
		return additionalExceptionReports.getEnumerated(AdditionalExceptionReportsEnum.class);
	}
	
	public void setAdditionalExceptionReports(AdditionalExceptionReportsEnum value)
	{
		if(value==null)
			this.additionalExceptionReports = null;
		else
			this.additionalExceptionReports = new AdditionalExceptionReportsImpl(value, null, null);			
	}
	
	public RateControlTimeUnitEnum getRateControlTimeUnit()
	{
		if(rateControlTimeUnit==null)
			return null;
		
		return rateControlTimeUnit.getEnumerated(RateControlTimeUnitEnum.class);
	}
	
	public void setRateControlTimeUnit(RateControlTimeUnitEnum value)
	{
		if(value==null)
			this.rateControlTimeUnit = null;
		else
			this.rateControlTimeUnit = new RateControlTimeUnitImpl(value, null, null);			
	}
	
	public Long getRateControlMaxRate()
	{
		if(rateControlMaxRate==null)
			return null;
		
		return rateControlMaxRate.getUnsigned();
	}
	
	public void setRateControlMaxRate(Long value)
	{
		if(value==null)
			this.rateControlMaxRate = null;
		else
			this.rateControlMaxRate = new RateControlMaxRateImpl(value, null, null);			
	}
}