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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class APNRateControlStatusImpl extends DiameterGroupedAvpImpl implements APNRateControlStatus
{
	private ServiceSelection apn;
	
	private UplinkNumberOfPacketsAllowed uplinkNumberOfPacketsAllowed;
	
	private NumberOfAdditionalExceptionReports numberOfAdditionalExceptionReports;
	
	private DownlinkNumberOfPacketsAllowed downlinkNumberOfPacketsAllowed;
	
	private APNRateControlStatusValidityTime apnRateControlStatusValidityTime;
	
	public APNRateControlStatusImpl(String apn,Long uplinkNumberOfPacketsAllowed,Long numberOfAdditionalExceptionReports,Long downlinkNumberOfPacketsAllowed,Long apnRateControlStatusValidityTime) throws MissingAvpException
	{
		setAPN(apn);
		
		setUplinkNumberOfPacketsAllowed(uplinkNumberOfPacketsAllowed);
		
		setNumberOfAdditionalExceptionReports(numberOfAdditionalExceptionReports);
		
		setDownlinkNumberOfPacketsAllowed(downlinkNumberOfPacketsAllowed);
		
		setAPNRateControlStatusValidityTime(apnRateControlStatusValidityTime);		
	}
	
	public String getAPN()
	{
		if(apn == null)
			return null;
		
		return apn.getString();
	}
	
	public void setAPN(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Selection is required", Arrays.asList(new DiameterAvp[] { new ServiceSelectionImpl() }));
			
		this.apn = new ServiceSelectionImpl(value, null, null);	
	}
	
	public Long getUplinkNumberOfPacketsAllowed()
	{
		if(uplinkNumberOfPacketsAllowed == null)
			return null;
		
		return uplinkNumberOfPacketsAllowed.getUnsigned();
	}
	
	public void setUplinkNumberOfPacketsAllowed(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Uplink-Number-Of-Packets-Allowed is required", Arrays.asList(new DiameterAvp[] { new UplinkNumberOfPacketsAllowedImpl() }));
			
		this.uplinkNumberOfPacketsAllowed = new UplinkNumberOfPacketsAllowedImpl(value, null, null);			
	}
	
	public Long getNumberOfAdditionalExceptionReports()
	{
		if(numberOfAdditionalExceptionReports == null)
			return null;
		
		return numberOfAdditionalExceptionReports.getUnsigned();
	}
	
	public void setNumberOfAdditionalExceptionReports(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Number-Of-Additional-Exception-Reports is required", Arrays.asList(new DiameterAvp[] { new NumberOfAdditionalExceptionReportsImpl() }));
			
		this.numberOfAdditionalExceptionReports = new NumberOfAdditionalExceptionReportsImpl(value, null, null);			
	}
	
	public Long getDownlinkNumberOfPacketsAllowed()
	{
		if(downlinkNumberOfPacketsAllowed == null)
			return null;
		
		return downlinkNumberOfPacketsAllowed.getUnsigned();
	}
	
	public void setDownlinkNumberOfPacketsAllowed(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Downlink-Number-Of-Packets-Allowed is required", Arrays.asList(new DiameterAvp[] { new DownlinkNumberOfPacketsAllowedImpl() }));
			
		this.downlinkNumberOfPacketsAllowed = new DownlinkNumberOfPacketsAllowedImpl(value, null, null);			
	}
	
	public Long getAPNRateControlStatusValidityTime()
	{
		if(apnRateControlStatusValidityTime == null)
			return null;
		
		return apnRateControlStatusValidityTime.getLong();
	}
	
	public void setAPNRateControlStatusValidityTime(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("APN-Rate-Control-Status-Validity-Time is required", Arrays.asList(new DiameterAvp[] { new APNRateControlStatusValidityTimeImpl() }));
			
		this.apnRateControlStatusValidityTime = new APNRateControlStatusValidityTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(apn==null)
			return new MissingAvpException("Service-Selection is required", Arrays.asList(new DiameterAvp[] { new ServiceSelectionImpl() }));
		
		if(uplinkNumberOfPacketsAllowed==null)
			return new MissingAvpException("Uplink-Number-Of-Packets-Allowed is required", Arrays.asList(new DiameterAvp[] { new UplinkNumberOfPacketsAllowedImpl() }));
		
		if(numberOfAdditionalExceptionReports==null)
			return new MissingAvpException("Number-Of-Additional-Exception-Reports is required", Arrays.asList(new DiameterAvp[] { new NumberOfAdditionalExceptionReportsImpl() }));
		
		if(downlinkNumberOfPacketsAllowed==null)
			return new MissingAvpException("Downlink-Number-Of-Packets-Allowed is required", Arrays.asList(new DiameterAvp[] { new DownlinkNumberOfPacketsAllowedImpl() }));
		
		if(apnRateControlStatusValidityTime==null)
			return new MissingAvpException("APN-Rate-Control-Status-Validity-Time is required", Arrays.asList(new DiameterAvp[] { new APNRateControlStatusValidityTimeImpl() }));
		
		return null;
	}
}