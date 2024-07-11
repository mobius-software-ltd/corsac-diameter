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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnvelopeReporting;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnvelopeReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OfflineCharging;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.QuotaConsumptionTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPMultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaMechanism;

/**
*
* @author yulian oifa
*
*/
public class OfflineChargingImpl extends DiameterGroupedAvpImpl implements OfflineCharging
{
	private QuotaConsumptionTime quotaConsumptionTime;
	private TimeQuotaMechanism timeQuotaMechanism;
	private EnvelopeReporting envelopeReporting;
	private List<TGPPMultipleServicesCreditControl> multipleServicesCreditControl;	
		
	public OfflineChargingImpl()
	{
		
	}
	
	public Long getQuotaConsumptionTime()
	{
		if(quotaConsumptionTime==null)
			return null;
		
		return quotaConsumptionTime.getUnsigned();
	}
	
	public void setQuotaConsumptionTime(Long value)
	{
		if(value==null)
			this.quotaConsumptionTime = null;
		else
			this.quotaConsumptionTime = new QuotaConsumptionTimeImpl(value, null, null);			
	}
	
	public TimeQuotaMechanism getTimeQuotaMechanism()
	{
		return timeQuotaMechanism;
	}
	
	public void setTimeQuotaMechanism(TimeQuotaMechanism value)
	{
		this.timeQuotaMechanism = value;
	}
	
	public EnvelopeReportingEnum getEnvelopeReporting()
	{
		if(envelopeReporting==null)
			return null;
		
		return envelopeReporting.getEnumerated(EnvelopeReportingEnum.class);
	}
	
	public void setEnvelopeReporting(EnvelopeReportingEnum value)
	{
		if(value==null)
			this.envelopeReporting = null;
		else
			this.envelopeReporting = new EnvelopeReportingImpl(value, null, null);			
	}
	
	public List<TGPPMultipleServicesCreditControl> getMultipleServicesCreditControl()
	{
		return multipleServicesCreditControl;
	}
	
	public void setMultipleServicesCreditControl(List<TGPPMultipleServicesCreditControl> value)
	{
		this.multipleServicesCreditControl = value;
	}
}