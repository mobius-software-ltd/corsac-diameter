package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ChangeOfAreaType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateEventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateEventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MinimumIntervalTime;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ReportCardinality;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ReportCardinalityEnum;

/**
*
* @author yulian oifa
*
*/
public class ChangeOfAreaTypeImpl extends DiameterGroupedAvpImpl implements ChangeOfAreaType
{
	private LocationUpdateEventTrigger locationUpdateEventTrigger;
	private ReportCardinality reportCardinality;
	private MinimumIntervalTime minimumIntervalTime;
		
	protected ChangeOfAreaTypeImpl() 
	{
	}
	
	public ChangeOfAreaTypeImpl(LocationUpdateEventTriggerEnum locationUpdateEventTrigger,ReportCardinalityEnum reportCardinality) throws MissingAvpException
	{
		setLocationUpdateEventTrigger(locationUpdateEventTrigger);
		
		setReportCardinality(reportCardinality);
	}
	
	public LocationUpdateEventTriggerEnum getLocationUpdateEventTrigger()
	{
		if(locationUpdateEventTrigger==null)
			return null;
		
		return locationUpdateEventTrigger.getEnumerated(LocationUpdateEventTriggerEnum.class);
	}
	
	public void setLocationUpdateEventTrigger(LocationUpdateEventTriggerEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Location-Update-Event-Trigger is required", Arrays.asList(new DiameterAvp[] { new LocationUpdateEventTriggerImpl() }));
			
		this.locationUpdateEventTrigger = new LocationUpdateEventTriggerImpl(value, null, null);						
	}
	
	public ReportCardinalityEnum getReportCardinality()
	{
		if(reportCardinality==null)
			return null;
		
		return reportCardinality.getEnumerated(ReportCardinalityEnum.class);
	}
	
	public void setReportCardinality(ReportCardinalityEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Report-Cardinality is required", Arrays.asList(new DiameterAvp[] { new ReportCardinalityImpl() }));
			
		this.reportCardinality = new ReportCardinalityImpl(value, null, null);
	}
	
	public Long getMinimumIntervalTime()
	{
		if(minimumIntervalTime==null)
			return null;
		
		return minimumIntervalTime.getUnsigned();
	}
	
	public void setMinimumIntervalTime(Long value)
	{
		if(value==null)
			this.minimumIntervalTime = null;
		else
			this.minimumIntervalTime = new MinimumIntervalTimeImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(locationUpdateEventTrigger==null)
			return new MissingAvpException("Location-Update-Event-Trigger is required", Arrays.asList(new DiameterAvp[] { new LocationUpdateEventTriggerImpl() }));
		
		if(reportCardinality==null)
			return new MissingAvpException("Report-Cardinality is required", Arrays.asList(new DiameterAvp[] { new ReportCardinalityImpl() }));
		
		return null;
	}
}