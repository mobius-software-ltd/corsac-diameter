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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfUEPerLocationConfiguration;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 4306L, vendorId = KnownVendorIDs.TGPP_ID)
public class NumberOfUEPerLocationConfigurationImpl extends DiameterGroupedAvpImpl implements NumberOfUEPerLocationConfiguration
{
	private EPSLocationInformation epsLocationInformation;
	
	private IMSIGroupId imsiGroupId;
	
	protected NumberOfUEPerLocationConfigurationImpl() 
	{
	}
	
	public NumberOfUEPerLocationConfigurationImpl(EPSLocationInformation epsLocationInformation)
	{
		if(epsLocationInformation==null)
			throw new IllegalArgumentException("EPS-Location-Information is required");
		
		this.epsLocationInformation = epsLocationInformation;						
	}
	
	public EPSLocationInformation getEPSLocationInformation()
	{
		return epsLocationInformation;
	}
	
	public void setEPSLocationInformation(EPSLocationInformation value)
	{
		if(value==null)
			throw new IllegalArgumentException("EPS-Location-Information is required");
		
		this.epsLocationInformation = value;		
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
	public String validate()
	{
		if(epsLocationInformation==null)
			return "EPS-Location-Information is required";
		
		return null;
	}
}