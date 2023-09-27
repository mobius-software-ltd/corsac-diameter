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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageStatus;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationInfo;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3459L, vendorId = KnownVendorIDs.TGPP_ID)
public class CoverageInfoImpl implements CoverageInfo
{
	private CoverageStatus coverageStatus;
	private ChangeTime changeTime;
	private List<LocationInfo> locationInfo;
 	
	public CoverageInfoImpl()
	{
		
	}
	
	public CoverageStatusEnum getCoverageStatus()
	{
		if(coverageStatus==null)
			return null;
		
		return coverageStatus.getEnumerated(CoverageStatusEnum.class);
	}
	
	public void setCoverageStatus(CoverageStatusEnum value)
	{
		if(value==null)
			this.coverageStatus = null;
		else
			this.coverageStatus = new CoverageStatusImpl(value, null, null);			
	}
	
	public Date getChangeTime()
	{
		if(changeTime==null)
			return null;
		
		return changeTime.getDateTime();
	}
	
	public void setChangeTime(Date value)
	{
		if(value==null)
			this.changeTime = null;
		else
			this.changeTime = new ChangeTimeImpl(value, null, null);			
	}
	
	public List<LocationInfo> getLocationInfo()
	{
		return locationInfo;
	}
	
	public void setLocationInfo(List<LocationInfo> value)
	{
		this.locationInfo = value;
	}
}