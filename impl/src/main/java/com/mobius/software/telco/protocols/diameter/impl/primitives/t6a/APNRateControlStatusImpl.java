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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.APNRateControlStatus;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.APNRateControlStatusValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.DownlinkNumberOfPacketsAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfAdditionalExceptionReports;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.UplinkNumberOfPacketsAllowed;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 4326L, vendorId = KnownVendorIDs.TGPP_ID)
public class APNRateControlStatusImpl extends DiameterGroupedAvpImpl implements APNRateControlStatus
{
	private ServiceSelection apn;
	
	private UplinkNumberOfPacketsAllowed uplinkNumberOfPacketsAllowed;
	
	private NumberOfAdditionalExceptionReports numberOfAdditionalExceptionReports;
	
	private DownlinkNumberOfPacketsAllowed downlinkNumberOfPacketsAllowed;
	
	private APNRateControlStatusValidityTime apnRateControlStatusValidityTime;
	
	protected APNRateControlStatusImpl(String apn,Long uplinkNumberOfPacketsAllowed,Long numberOfAdditionalExceptionReports,Long downlinkNumberOfPacketsAllowed,Long apnRateControlStatusValidityTime)
	{
		if(apn==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		if(uplinkNumberOfPacketsAllowed==null)
			throw new IllegalArgumentException("Uplink-Number-Of-Packets-Allowed is required");
		
		if(numberOfAdditionalExceptionReports==null)
			throw new IllegalArgumentException("Number-Of-Additional-Exception-Reports is required");
		
		if(downlinkNumberOfPacketsAllowed==null)
			throw new IllegalArgumentException("Downlink-Number-Of-Packets-Allowed is required");
		
		if(apnRateControlStatusValidityTime==null)
			throw new IllegalArgumentException("APN-Rate-Control-Status-Validity-Time is required");
		
		this.apn = new ServiceSelectionImpl(apn, null, null);	
		
		this.uplinkNumberOfPacketsAllowed = new UplinkNumberOfPacketsAllowedImpl(uplinkNumberOfPacketsAllowed, null, null);	
		
		this.numberOfAdditionalExceptionReports = new NumberOfAdditionalExceptionReportsImpl(numberOfAdditionalExceptionReports, null, null);	
		
		this.downlinkNumberOfPacketsAllowed = new DownlinkNumberOfPacketsAllowedImpl(downlinkNumberOfPacketsAllowed, null, null);	
		
		this.apnRateControlStatusValidityTime = new APNRateControlStatusValidityTimeImpl(apnRateControlStatusValidityTime, null, null);	
	}
	
	public String getAPN()
	{
		if(apn == null)
			return null;
		
		return apn.getString();
	}
	
	public void setAPN(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		this.apn = new ServiceSelectionImpl(value, null, null);	
	}
	
	public Long getUplinkNumberOfPacketsAllowed()
	{
		if(uplinkNumberOfPacketsAllowed == null)
			return null;
		
		return uplinkNumberOfPacketsAllowed.getUnsigned();
	}
	
	public void setUplinkNumberOfPacketsAllowed(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Uplink-Number-Of-Packets-Allowed is required");
		
		this.uplinkNumberOfPacketsAllowed = new UplinkNumberOfPacketsAllowedImpl(value, null, null);			
	}
	
	public Long getNumberOfAdditionalExceptionReports()
	{
		if(numberOfAdditionalExceptionReports == null)
			return null;
		
		return numberOfAdditionalExceptionReports.getUnsigned();
	}
	
	public void setNumberOfAdditionalExceptionReports(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Number-Of-Additional-Exception-Reports is required");
		
		this.numberOfAdditionalExceptionReports = new NumberOfAdditionalExceptionReportsImpl(value, null, null);			
	}
	
	public Long getDownlinkNumberOfPacketsAllowed()
	{
		if(downlinkNumberOfPacketsAllowed == null)
			return null;
		
		return downlinkNumberOfPacketsAllowed.getUnsigned();
	}
	
	public void setDownlinkNumberOfPacketsAllowed(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Downlink-Number-Of-Packets-Allowed is required");
		
		this.downlinkNumberOfPacketsAllowed = new DownlinkNumberOfPacketsAllowedImpl(value, null, null);			
	}
	
	public Long getAPNRateControlStatusValidityTime()
	{
		if(apnRateControlStatusValidityTime == null)
			return null;
		
		return apnRateControlStatusValidityTime.getLong();
	}
	
	public void setAPNRateControlStatusValidityTime(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("APN-Rate-Control-Status-Validity-Time is required");
		
		this.apnRateControlStatusValidityTime = new APNRateControlStatusValidityTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(apn==null)
			return "Service-Selection is required";
		
		if(uplinkNumberOfPacketsAllowed==null)
			return "Uplink-Number-Of-Packets-Allowed is required";
		
		if(numberOfAdditionalExceptionReports==null)
			return "Number-Of-Additional-Exception-Reports is required";
		
		if(downlinkNumberOfPacketsAllowed==null)
			return "Downlink-Number-Of-Packets-Allowed is required";
		
		if(apnRateControlStatusValidityTime==null)
			return "APN-Rate-Control-Status-Validity-Time is required";
		
		return null;
	}
}