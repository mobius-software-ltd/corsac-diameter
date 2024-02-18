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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationReportIntervalTime;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PeriodicLocationType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TotalNumberOfReports;

/**
*
* @author yulian oifa
*
*/
public class PeriodicLocationTypeImpl extends DiameterGroupedAvpImpl implements PeriodicLocationType
{
	private LocationReportIntervalTime locationReportIntervalTime;
	private TotalNumberOfReports totalNumberOfReports;
	 
	protected PeriodicLocationTypeImpl() 
	{
	}
	
	public PeriodicLocationTypeImpl(Long locationReportIntervalTime,Long totalNumberOfReports) throws MissingAvpException
	{
		setLocationReportIntervalTime(locationReportIntervalTime);
		
		setTotalNumberOfReports(totalNumberOfReports);
	}
	
	public Long getLocationReportIntervalTime()
	{
		if(locationReportIntervalTime==null)
			return null;
		
		return locationReportIntervalTime.getUnsigned();
	}
	
	public void setLocationReportIntervalTime(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Location-Report-Interval-Time is required", Arrays.asList(new DiameterAvp[] { new LocationReportIntervalTimeImpl() }));
		
		this.locationReportIntervalTime = new LocationReportIntervalTimeImpl(value, null, null);								
	}
	
	public Long getTotalNumberOfReports()
	{
		if(totalNumberOfReports==null)
			return null;
		
		return totalNumberOfReports.getUnsigned();
	}
	
	public void setTotalNumberOfReports(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Total-Number-Of-Reports is required is required", Arrays.asList(new DiameterAvp[] { new TotalNumberOfReportsImpl() }));
		
		this.totalNumberOfReports = new TotalNumberOfReportsImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(locationReportIntervalTime==null)
			return new MissingAvpException("Location-Report-Interval-Time is required", Arrays.asList(new DiameterAvp[] { new LocationReportIntervalTimeImpl() }));
		
		if(totalNumberOfReports==null)
			return new MissingAvpException("Total-Number-Of-Reports is required is required", Arrays.asList(new DiameterAvp[] { new TotalNumberOfReportsImpl() }));
		
		return null;
	}
}