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
import com.mobius.software.telco.protocols.diameter.primitives.slg.PeriodicLDRInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingAmount;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingInterval;

/**
*
* @author yulian oifa
*
*/
public class PeriodicLDRInfoImpl extends DiameterGroupedAvpImpl implements PeriodicLDRInfo
{
	private ReportingAmount reportingAmount;
	
	private ReportingInterval reportingInterval;
	
	protected PeriodicLDRInfoImpl() 
	{
	}
	
	public PeriodicLDRInfoImpl(Long reportingAmount,Long reportingInterval) throws MissingAvpException
	{
		setReportingAmount(reportingAmount);
		
		setReportingInterval(reportingInterval);
	}
	
	public Long getReportingAmount()
	{
		if(reportingAmount==null)
			return null;
		
		return reportingAmount.getUnsigned();
	}
	
	public void setReportingAmount(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Reporting-Amount is required", Arrays.asList(new DiameterAvp[] { new ReportingAmountImpl() }));
			
		this.reportingAmount = new ReportingAmountImpl(value, null, null);
	}
	
	public Long getReportingInterval()
	{
		if(reportingInterval==null)
			return null;
		
		return reportingInterval.getUnsigned();
	}
	
	public void setReportingInterval(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Reporting-Interval is required", Arrays.asList(new DiameterAvp[] { new ReportingIntervalImpl() }));
		
		this.reportingInterval = new ReportingIntervalImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(reportingAmount==null)
			return new MissingAvpException("Reporting-Amount is required", Arrays.asList(new DiameterAvp[] { new ReportingAmountImpl() }));
		
		if(reportingInterval==null)
			return new MissingAvpException("Reporting-Interval is required", Arrays.asList(new DiameterAvp[] { new ReportingIntervalImpl() }));
		
		return null;
	}
}