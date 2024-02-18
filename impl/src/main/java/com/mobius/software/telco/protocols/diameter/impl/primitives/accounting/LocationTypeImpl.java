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

import com.mobius.software.telco.protocols.diameter.primitives.accounting.DeferredLocationEventType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimateType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimateTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationType;

/**
*
* @author yulian oifa
*
*/
public class LocationTypeImpl implements LocationType
{
	private LocationEstimateType locationEstimateType;
	private DeferredLocationEventType deferredLocationEventType;
		
	public LocationTypeImpl()
	{
		
	}
	
	public LocationEstimateTypeEnum getLocationEstimateType()
	{
		if(locationEstimateType==null)
			return null;
		
		return locationEstimateType.getEnumerated(LocationEstimateTypeEnum.class);
	}
	
	public void setLocationEstimateType(LocationEstimateTypeEnum value)
	{
		if(value==null)
			this.locationEstimateType = null;
		else
			this.locationEstimateType = new LocationEstimateTypeImpl(value, null, null);			
	}
	
	public String getDeferredLocationEventType()
	{
		if(deferredLocationEventType==null)
			return null;
		
		return deferredLocationEventType.getString();
	}
	
	public void setDeferredLocationEventType(String value)
	{
		if(value==null)
			this.deferredLocationEventType = null;
		else
			this.deferredLocationEventType = new DeferredLocationEventTypeImpl(value, null, null);			
	}
}