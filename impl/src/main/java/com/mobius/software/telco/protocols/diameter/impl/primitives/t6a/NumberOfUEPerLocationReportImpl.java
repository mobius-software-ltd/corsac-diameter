package com.mobius.software.telco.protocols.diameter.impl.primitives.t6a;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EPSLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfUEPerLocationReport;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.UECount;

/**
*
* @author yulian oifa
*
*/
public class NumberOfUEPerLocationReportImpl extends DiameterGroupedAvpImpl implements NumberOfUEPerLocationReport
{
	private EPSLocationInformation epsLocationInformation;
	
	private UECount ueCount;
	
	private IMSIGroupId imsiGroupId;
	
	protected NumberOfUEPerLocationReportImpl() 
	{
	}
	
	public NumberOfUEPerLocationReportImpl(EPSLocationInformation epsLocationInformation,Long ueCount) throws MissingAvpException
	{
		setEPSLocationInformation(epsLocationInformation);
		
		setUECount(ueCount);
	}
	
	public EPSLocationInformation getEPSLocationInformation()
	{
		return epsLocationInformation;
	}
	
	public void setEPSLocationInformation(EPSLocationInformation value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("EPS-Location-Information is required", Arrays.asList(new DiameterAvp[] { new EPSLocationInformationImpl() }));
		
		this.epsLocationInformation = value;		
	}
	
	public Long getUECount()
	{
		if(ueCount == null)
			return null;
		
		return ueCount.getUnsigned();
	}
	
	public void setUECount(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("UE-Count is required", Arrays.asList(new DiameterAvp[] { new UECountImpl() }));
		
		this.ueCount = new UECountImpl(value, null, null);		
	}
	
	public IMSIGroupId getIMSIGroupId()
	{
		return imsiGroupId;
	}
	
	public void setIMSIGroupId(IMSIGroupId value)
	{
		this.imsiGroupId = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(epsLocationInformation==null)
			return new MissingAvpException("EPS-Location-Information is required", Arrays.asList(new DiameterAvp[] { new EPSLocationInformationImpl() }));
		
		if(ueCount==null)
			return new MissingAvpException("UE-Count is required", Arrays.asList(new DiameterAvp[] { new UECountImpl() }));
		
		return null;
	}
}