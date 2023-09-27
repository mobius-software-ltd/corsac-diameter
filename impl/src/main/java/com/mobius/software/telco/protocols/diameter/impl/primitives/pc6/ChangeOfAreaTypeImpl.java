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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
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
@DiameterAvpImplementation(code = 33825L, vendorId = KnownVendorIDs.TGPP_ID)
public class ChangeOfAreaTypeImpl extends DiameterGroupedAvpImpl implements ChangeOfAreaType
{
	private LocationUpdateEventTrigger locationUpdateEventTrigger;
	private ReportCardinality reportCardinality;
	private MinimumIntervalTime minimumIntervalTime;
		
	protected ChangeOfAreaTypeImpl() 
	{
	}
	
	public ChangeOfAreaTypeImpl(LocationUpdateEventTriggerEnum locationUpdateEventTrigger,ReportCardinalityEnum reportCardinality)
	{
		if(locationUpdateEventTrigger==null)
			throw new IllegalArgumentException("Location-Update-Event-Trigger is required");
		
		if(reportCardinality==null)
			throw new IllegalArgumentException("Report-Cardinality is required");
		
		this.locationUpdateEventTrigger = new LocationUpdateEventTriggerImpl(locationUpdateEventTrigger, null, null);				
		
		this.reportCardinality = new ReportCardinalityImpl(reportCardinality, null, null);
	}
	
	public LocationUpdateEventTriggerEnum getLocationUpdateEventTrigger()
	{
		if(locationUpdateEventTrigger==null)
			return null;
		
		return locationUpdateEventTrigger.getEnumerated(LocationUpdateEventTriggerEnum.class);
	}
	
	public void setLocationUpdateEventTrigger(LocationUpdateEventTriggerEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Location-Update-Event-Trigger is required");
		
		this.locationUpdateEventTrigger = new LocationUpdateEventTriggerImpl(value, null, null);						
	}
	
	public ReportCardinalityEnum getReportCardinality()
	{
		if(reportCardinality==null)
			return null;
		
		return reportCardinality.getEnumerated(ReportCardinalityEnum.class);
	}
	
	public void setReportCardinality(ReportCardinalityEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Report-Cardinality is required");
		
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
	public String validate()
	{
		if(locationUpdateEventTrigger==null)
			return "Location-Update-Event-Trigger is required";
		
		if(reportCardinality==null)
			return "Report-Cardinality is required";
		
		return null;
	}
}