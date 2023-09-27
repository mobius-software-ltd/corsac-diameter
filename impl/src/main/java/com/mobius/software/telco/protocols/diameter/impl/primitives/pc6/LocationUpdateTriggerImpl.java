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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateEventType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateEventTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PeriodicLocationType;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3823L, vendorId = KnownVendorIDs.TGPP_ID)
public class LocationUpdateTriggerImpl extends DiameterGroupedAvpImpl implements LocationUpdateTrigger
{
	private LocationUpdateEventType locationUpdateEventType;
	private ChangeOfAreaType changeOfAreaType;
	private PeriodicLocationType periodicLocationType;
		
	protected LocationUpdateTriggerImpl() 
	{
	}
	
	public LocationUpdateTriggerImpl(LocationUpdateEventTypeEnum locationUpdateEventType)
	{
		if(locationUpdateEventType==null)
			throw new IllegalArgumentException("Location-Update-Event-Type is required");
		
		this.locationUpdateEventType = new LocationUpdateEventTypeImpl(locationUpdateEventType, null, null);						
	}
	
	public LocationUpdateEventTypeEnum getLocationUpdateEventType()
	{
		if(locationUpdateEventType==null)
			return null;
		
		return locationUpdateEventType.getEnumerated(LocationUpdateEventTypeEnum.class);
	}
	
	public void setLocationUpdateEventType(LocationUpdateEventTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Location-Update-Event-Type is required");
		
		this.locationUpdateEventType = new LocationUpdateEventTypeImpl(value, null, null);						
	}
	
	public ChangeOfAreaType getChangeOfAreaType()
	{
		return changeOfAreaType;
	}
	
	public void setChangeOfAreaType(ChangeOfAreaType value)
	{
		this.changeOfAreaType = value;
	}
	
	public PeriodicLocationType getPeriodicLocationType()
	{
		return this.periodicLocationType;
	}
	
	public void setPeriodicLocationType(PeriodicLocationType value)
	{
		this.periodicLocationType = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(locationUpdateEventType==null)
			return "Location-Update-Event-Type is required";
		
		return null;
	}
}