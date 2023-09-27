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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationReportIntervalTime;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PeriodicLocationType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TotalNumberOfReports;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3829L, vendorId = KnownVendorIDs.TGPP_ID)
public class PeriodicLocationTypeImpl extends DiameterGroupedAvpImpl implements PeriodicLocationType
{
	private LocationReportIntervalTime locationReportIntervalTime;
	private TotalNumberOfReports totalNumberOfReports;
	 
	protected PeriodicLocationTypeImpl() 
	{
	}
	
	public PeriodicLocationTypeImpl(Long locationReportIntervalTime,Long totalNumberOfReports)
	{
		if(locationReportIntervalTime==null)
			throw new IllegalArgumentException("Location-Report-Interval-Time is required");
		
		if(totalNumberOfReports==null)
			throw new IllegalArgumentException("Total-Number-Of-Reports is required");
		
		this.locationReportIntervalTime = new LocationReportIntervalTimeImpl(locationReportIntervalTime, null, null);						
		
		this.totalNumberOfReports = new TotalNumberOfReportsImpl(totalNumberOfReports, null, null);
	}
	
	public Long getLocationReportIntervalTime()
	{
		if(locationReportIntervalTime==null)
			return null;
		
		return locationReportIntervalTime.getUnsigned();
	}
	
	public void setLocationReportIntervalTime(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Location-Report-Interval-Time is required");
		
		this.locationReportIntervalTime = new LocationReportIntervalTimeImpl(value, null, null);								
	}
	
	public Long getTotalNumberOfReports()
	{
		if(totalNumberOfReports==null)
			return null;
		
		return totalNumberOfReports.getUnsigned();
	}
	
	public void setTotalNumberOfReports(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Total-Number-Of-Reports is required");
		
		this.totalNumberOfReports = new TotalNumberOfReportsImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(locationReportIntervalTime==null)
			return "Location-Report-Interval-Time is required";
		
		if(totalNumberOfReports==null)
			return "Total-Number-Of-Reports is required";
		
		return null;
	}
}