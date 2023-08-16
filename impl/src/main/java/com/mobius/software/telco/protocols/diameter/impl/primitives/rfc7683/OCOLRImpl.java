package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReductionPercentage;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCValidityDuration;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 623L, vendorId = -1L)
public class OCOLRImpl extends DiameterGroupedAvpImpl implements OCOLR
{
	private OCSequenceNumber ocSequenceNumber;
	
	private OCReportType ocReportType;
	
	private OCReductionPercentage ocReductionPercentage;
	
	private OCValidityDuration ocValidityDuration;
	
	protected OCOLRImpl() 
	{
		super();
	}
	
	public OCOLRImpl(Long ocSequenceNumber, OCReportTypeEnum ocReportType)
	{
		if(ocSequenceNumber == null)
			throw new IllegalArgumentException("OC-Sequence-Number is required");
		
		if(ocReportType == null)
			throw new IllegalArgumentException("OC-Report-Type is required");
		
		this.ocSequenceNumber = new OCSequenceNumberImpl(ocSequenceNumber, null, null);
		
		this.ocReportType = new OCReportTypeImpl(ocReportType, null, null);
	}
	
	public Long getOCSequenceNumber()
	{
		if(ocSequenceNumber == null)
			return null;
		
		return ocSequenceNumber.getLong();
	}
	
	public void setOCSequenceNumber(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("OC-Sequence-Number is required");
		
		this.ocSequenceNumber = new OCSequenceNumberImpl(value, null, null);
	}
	
	public OCReportTypeEnum getOCReportType() 
	{
		if(ocReportType == null)
			return null;
		
		return ocReportType.getEnumerated(OCReportTypeEnum.class);
	}
	
	public void setOCReportType(OCReportTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("OC-Report-Type is required");
		
		this.ocReportType = new OCReportTypeImpl(value, null, null);		
	}
	
	public Long getOCReductionPercentage()
	{
		if(ocReductionPercentage == null)
			return null;
		
		return ocReductionPercentage.getUnsigned();
	}
	
	public void setOCReductionPercentage(Long value)
	{
		if(value==null)
			this.ocReductionPercentage = null;
		else
			this.ocReductionPercentage = new OCReductionPercentageImpl(value, null, null);
	}
	
	public Long getOCValidityDuration()
	{
		if(ocValidityDuration == null)
			return null;
		
		return ocValidityDuration.getUnsigned();
	}
	
	public void setOCValidityDuration(Long value)
	{
		if(value==null)
			this.ocValidityDuration = null;
		else
			this.ocValidityDuration = new OCValidityDurationImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(ocSequenceNumber == null)
			return "OC-Sequence-Number is required";
		
		if(ocReportType == null)
			return "OC-Report-Type is required";
		
		return null;
	}
}