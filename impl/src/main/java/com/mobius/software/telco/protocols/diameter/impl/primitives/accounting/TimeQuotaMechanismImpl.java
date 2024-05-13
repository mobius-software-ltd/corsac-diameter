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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BaseTimeInterval;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaMechanism;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaTypeEnum;

/**
*
* @author yulian oifa
*
*/
public class TimeQuotaMechanismImpl extends DiameterAvpImpl implements TimeQuotaMechanism
{
	private TimeQuotaType timeQuotaType;
	private BaseTimeInterval baseTimeInterval;
	
	protected TimeQuotaMechanismImpl() 
	{
	}
	
	public TimeQuotaMechanismImpl(TimeQuotaTypeEnum timeQuotaType,Long baseTimeInterval) throws MissingAvpException
	{
		setTimeQuotaType(timeQuotaType);
		
		setBaseTimeInterval(baseTimeInterval);
	}
	
	public TimeQuotaTypeEnum getTimeQuotaType()
	{
		if(timeQuotaType==null)
			return null;
		
		return timeQuotaType.getEnumerated(TimeQuotaTypeEnum.class);
	}
	
	public void setTimeQuotaType(TimeQuotaTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Time-Quota-Type is required is required", Arrays.asList(new DiameterAvp[] { new TimeQuotaTypeImpl() }));
		
		this.timeQuotaType = new TimeQuotaTypeImpl(value, null, null);
	}
	
	public Long getBaseTimeInterval()
	{
		if(baseTimeInterval==null)
			return null;
		
		return baseTimeInterval.getUnsigned();
	}
	
	public void setBaseTimeInterval(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Base-Time-Interval is required is required", Arrays.asList(new DiameterAvp[] { new BaseTimeIntervalImpl() }));
		
		this.baseTimeInterval = new BaseTimeIntervalImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(timeQuotaType==null)
			return new MissingAvpException("Time-Quota-Type is required is required", Arrays.asList(new DiameterAvp[] { new TimeQuotaTypeImpl() }));
		
		if(baseTimeInterval==null)
			return new MissingAvpException("Base-Time-Interval is required is required", Arrays.asList(new DiameterAvp[] { new BaseTimeIntervalImpl() }));
		
		return null;
	}
}