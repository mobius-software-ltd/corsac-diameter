package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gx.APNAggregateMaxBitrateDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.APNAggregateMaxBitrateUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalPolicyInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExecutionTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedAPNAMBRDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedAPNAMBRUL;

/**
*
* @author yulian oifa
*
*/
public class ConditionalPolicyInformationImpl extends DiameterGroupedAvpImpl implements ConditionalPolicyInformation
{
	private ExecutionTime executionTime;
	private DefaultEPSBearerQoS defaultEPSBearerQoS;
	private APNAggregateMaxBitrateUL apnAggregateMaxBitrateUL;
	private APNAggregateMaxBitrateDL apnAggregateMaxBitrateDL;
	private ExtendedAPNAMBRUL extendedAPNAMBRUL;
	private ExtendedAPNAMBRDL extendedAPNAMBRDL;
	private List<ConditionalAPNAggregateMaxBitrate> conditionalAPNAggregateMaxBitrate;

	public ConditionalPolicyInformationImpl()
	{
		
	}
	
	public Date getExecutionTime()
	{
		if(executionTime==null)
			return null;
		
		return executionTime.getDateTime();
	}
	
	public void setExecutionTime(Date value)
	{
		if(value==null)
			this.executionTime = null;
		else
			this.executionTime = new ExecutionTimeImpl(value, null, null);			
	}
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS()
	{
		return defaultEPSBearerQoS;
	}
	
	public void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value)
	{
		this.defaultEPSBearerQoS = value;
	}
	
	public Long getAPNAggregateMaxBitrateUL()
	{
		if(apnAggregateMaxBitrateUL==null)
			return null;
		
		return apnAggregateMaxBitrateUL.getUnsigned();
	}
	
	public void setAPNAggregateMaxBitrateUL(Long value)
	{
		if(value==null)
			this.apnAggregateMaxBitrateUL = null;
		else
			this.apnAggregateMaxBitrateUL = new APNAggregateMaxBitrateULImpl(value, null, null);			
	}
	
	public Long getAPNAggregateMaxBitrateDL()
	{
		if(apnAggregateMaxBitrateDL==null)
			return null;
		
		return apnAggregateMaxBitrateDL.getUnsigned();
	}
	
	public void setAPNAggregateMaxBitrateDL(Long value)
	{
		if(value==null)
			this.apnAggregateMaxBitrateDL = null;
		else
			this.apnAggregateMaxBitrateDL = new APNAggregateMaxBitrateDLImpl(value, null, null);			
	}
	
	public Long getExtendedAPNAMBRUL()
	{
		if(extendedAPNAMBRUL==null)
			return null;
		
		return extendedAPNAMBRUL.getUnsigned();
	}
	
	public void setExtendedAPNAMBRUL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRUL = null;
		else
			this.extendedAPNAMBRUL = new ExtendedAPNAMBRULImpl(value, null, null);			
	}
	
	public Long getExtendedAPNAMBRDL()
	{
		if(extendedAPNAMBRDL==null)
			return null;
		
		return extendedAPNAMBRDL.getUnsigned();
	}
	
	public void setExtendedAPNAMBRDL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRDL = null;
		else
			this.extendedAPNAMBRDL = new ExtendedAPNAMBRDLImpl(value, null, null);			
	}
	
	public List<ConditionalAPNAggregateMaxBitrate> getConditionalAPNAggregateMaxBitrate()
	{
		return conditionalAPNAggregateMaxBitrate;
	}
	
	public void setConditionalAPNAggregateMaxBitrate(List<ConditionalAPNAggregateMaxBitrate> value)
	{
		this.conditionalAPNAggregateMaxBitrate = value;
	}
}