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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PeriodicLDRInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingAmount;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingInterval;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2540L, vendorId = KnownVendorIDs.TGPP_ID)
public class PeriodicLDRInfoImpl extends DiameterGroupedAvpImpl implements PeriodicLDRInfo
{
	private ReportingAmount reportingAmount;
	
	private ReportingInterval reportingInterval;
	
	protected PeriodicLDRInfoImpl() 
	{
	}
	
	public PeriodicLDRInfoImpl(Long reportingAmount,Long reportingInterval)
	{
		if(reportingAmount==null)
			throw new IllegalArgumentException("Reporting-Amount is required");
		
		if(reportingInterval==null)
			throw new IllegalArgumentException("Reporting-Interval is required");
		
		this.reportingAmount = new ReportingAmountImpl(reportingAmount, null, null);
		
		this.reportingInterval = new ReportingIntervalImpl(reportingInterval, null, null);
	}
	
	public Long getReportingAmount()
	{
		if(reportingAmount==null)
			return null;
		
		return reportingAmount.getUnsigned();
	}
	
	public void setReportingAmount(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Reporting-Amount is required");
		
		this.reportingAmount = new ReportingAmountImpl(value, null, null);
	}
	
	public Long getReportingInterval()
	{
		if(reportingInterval==null)
			return null;
		
		return reportingInterval.getUnsigned();
	}
	
	public void setReportingInterval(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Reporting-Interval is required");
		
		this.reportingInterval = new ReportingIntervalImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(reportingAmount==null)
			return "Reporting-Amount is required";
		
		if(reportingInterval==null)
			return "Reporting-Interval is required";
		
		return null;
	}
}