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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BaseTimeInterval;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaMechanism;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.228	Time-Quota-Mechanism
	The Time-Quota-Mechanism AVP (AVP code 1270) is of type Grouped.
	It has the following syntax:

	Time-Quota-Mechanism ::= < AVP Header: 1270>
		{ Time-Quota-Type }
		{ Base-Time-Interval }

	The OCS may include this AVP in a Multiple-Services-Credit-Control AVP, when granting time quota. 
 */
@DiameterAvpImplementation(code = 1270L, vendorId = KnownVendorIDs.TGPP_ID)
public class TimeQuotaMechanismImpl implements TimeQuotaMechanism
{
	private TimeQuotaType timeQuotaType;
	private BaseTimeInterval baseTimeInterval;
	
	protected TimeQuotaMechanismImpl() 
	{
	}
	
	public TimeQuotaMechanismImpl(TimeQuotaTypeEnum timeQuotaType,Long baseTimeInterval)
	{
		if(timeQuotaType==null)
			throw new IllegalArgumentException("Time-Quota-Type is required");
		
		if(baseTimeInterval==null)
			throw new IllegalArgumentException("Base-Time-Interval is required");
		
		this.timeQuotaType = new TimeQuotaTypeImpl(timeQuotaType, null, null);				
		
		this.baseTimeInterval = new BaseTimeIntervalImpl(baseTimeInterval, null, null);
	}
	
	public TimeQuotaTypeEnum getTimeQuotaType()
	{
		if(timeQuotaType==null)
			return null;
		
		return timeQuotaType.getEnumerated(TimeQuotaTypeEnum.class);
	}
	
	public void setTimeQuotaType(TimeQuotaTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Time-Quota-Type is required");
		
		this.timeQuotaType = new TimeQuotaTypeImpl(value, null, null);
	}
	
	public Long getBaseTimeInterval()
	{
		if(baseTimeInterval==null)
			return null;
		
		return baseTimeInterval.getUnsigned();
	}
	
	public void setBaseTimeInterval(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Base-Time-Interval is required");
		
		this.baseTimeInterval = new BaseTimeIntervalImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(timeQuotaType==null)
			return "Time-Quota-Type is required";
		
		if(baseTimeInterval==null)
			return "Base-Time-Interval is required";
		
		return null;
	}
}