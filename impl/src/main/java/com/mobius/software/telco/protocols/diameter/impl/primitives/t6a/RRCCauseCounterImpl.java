package com.mobius.software.telco.protocols.diameter.impl.primitives.t6a;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CounterValue;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RRCCauseCounter;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RRCCounterTimestamp;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 4318L, vendorId = KnownVendorIDs.TGPP_ID)
public class RRCCauseCounterImpl extends DiameterGroupedAvpImpl implements RRCCauseCounter
{
	private CounterValue counterValue;
	
	private RRCCounterTimestamp rrcCounterTimestamp;
	
	public RRCCauseCounterImpl()
	{
		
	}
	
	public Long getCounterValue()
	{
		if(counterValue == null)
			return null;
		
		return counterValue.getUnsigned();
	}
	
	public void setCounterValue(Long value)
	{
		if(value == null)
			this.counterValue = null;
		else
			this.counterValue = new CounterValueImpl(value, null, null);
	}
	
	public Date getRRCCounterTimestamp()
	{
		if(rrcCounterTimestamp == null)
			return null;
		
		return rrcCounterTimestamp.getDateTime();
	}
	
	public void setRRCCounterTimestamp(Date value)
	{
		if(value == null)
			this.rrcCounterTimestamp = null;
		else
			this.rrcCounterTimestamp = new RRCCounterTimestampImpl(value, null, null);
	}
}