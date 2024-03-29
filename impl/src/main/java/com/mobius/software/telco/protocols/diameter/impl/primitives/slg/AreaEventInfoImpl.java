package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaEventInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.IntervalTime;
import com.mobius.software.telco.protocols.diameter.primitives.slg.MaximumInterval;
import com.mobius.software.telco.protocols.diameter.primitives.slg.OccurrenceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.OccurrenceInfoEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingDuration;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingLocationRequirements;
import com.mobius.software.telco.protocols.diameter.primitives.slg.SamplingInterval;

/**
*
* @author yulian oifa
*
*/
public class AreaEventInfoImpl extends DiameterGroupedAvpImpl implements AreaEventInfo
{
	private AreaDefinition areaDefinition;
	
	private OccurrenceInfo occurrenceInfo;
	
	private IntervalTime intervalTime;
	
	private MaximumInterval maximumInterval;
	
	private SamplingInterval samplingInterval;
	
	private ReportingDuration reportingDuration;
	
	private ReportingLocationRequirements reportingLocationRequirements;
	
	protected AreaEventInfoImpl() 
	{
	}
	
	public AreaEventInfoImpl(AreaDefinition areaDefinition) throws MissingAvpException
	{
		setAreaDefinition(areaDefinition);
	}
	
	public AreaDefinition getAreaDefinition()
	{
		return areaDefinition;
	}
	
	public void setAreaDefinition(AreaDefinition value) throws MissingAvpException
	{		
		if(value==null)
			throw new MissingAvpException("Area-Definition is required", Arrays.asList(new DiameterAvp[] { new AreaDefinitionImpl() }));
		
		this.areaDefinition = value;
	}
	
	public OccurrenceInfoEnum getOccurrenceInfo()
	{
		if(occurrenceInfo==null)
			return null;
		
		return occurrenceInfo.getEnumerated(OccurrenceInfoEnum.class);
	}
	
	public void setOccurrenceInfo(OccurrenceInfoEnum value)
	{
		if(value==null)
			this.occurrenceInfo = null;
		else
			this.occurrenceInfo = new OccurrenceInfoImpl(value, null, null);			
	}
	
	public Long getIntervalTime()
	{
		if(intervalTime==null)
			return null;
		
		return intervalTime.getUnsigned();
	}
	
	public void setIntervalTime(Long value)
	{
		if(value==null)
			this.intervalTime = null;
		else
			this.intervalTime = new IntervalTimeImpl(value, null, null);			
	}
	
	public Long getMaximumInterval()
	{
		if(maximumInterval==null)
			return null;
		
		return maximumInterval.getUnsigned();
	}
	
	public void setMaximumInterval(Long value)
	{
		if(value==null)
			this.maximumInterval = null;
		else
			this.maximumInterval = new MaximumIntervalImpl(value, null, null);			
	}
	
	public Long getSamplingInterval()
	{
		if(samplingInterval==null)
			return null;
		
		return samplingInterval.getUnsigned();
	}
	
	public void setSamplingInterval(Long value)
	{
		if(value==null)
			this.samplingInterval = null;
		else
			this.samplingInterval = new SamplingIntervalImpl(value, null, null);			
	}
	
	public Long getReportingDuration()
	{
		if(reportingDuration==null)
			return null;
		
		return reportingDuration.getUnsigned();
	}
	
	public void setReportingDuration(Long value)
	{
		if(value==null)
			this.reportingDuration = null;
		else
			this.reportingDuration = new ReportingDurationImpl(value, null, null);			
	}
	
	public Long getReportingLocationRequirements()
	{
		if(reportingLocationRequirements==null)
			return null;
		
		return reportingLocationRequirements.getUnsigned();
	}
	
	public void setReportingLocationRequirements(Long value)
	{
		if(value==null)
			this.reportingLocationRequirements = null;
		else
			this.reportingLocationRequirements = new ReportingLocationRequirementsImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(areaDefinition==null)
			return new MissingAvpException("Area-Definition is required", Arrays.asList(new DiameterAvp[] { new AreaDefinitionImpl() }));
		
		return null;
	}
}