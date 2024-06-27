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

import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCReductionPercentageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCReportTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSequenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCValidityDurationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCSpecificReduction;
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
public class OCOLRImpl extends DiameterGroupedAvpImpl implements OCOLR
{
	private OCSequenceNumber ocSequenceNumber;
	
	private OCReportType ocReportType;
	
	private OCReductionPercentage ocReductionPercentage;
	
	private OCValidityDuration ocValidityDuration;
	
	private List<TGPPOCSpecificReduction> tgppOCSpecificReduction;
	
	public OCOLRImpl() 
	{
		super();
	}
	
	public OCOLRImpl(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException
	{
		setOCSequenceNumber(ocSequenceNumber);
		
		setOCReportType(ocReportType);
	}
	
	public Long getOCSequenceNumber()
	{
		if(ocSequenceNumber == null)
			return null;
		
		return ocSequenceNumber.getLong();
	}
	
	public void setOCSequenceNumber(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("OC-Sequence-Number is required", Arrays.asList(new DiameterAvp[] { new OCSequenceNumberImpl() }));
		
		this.ocSequenceNumber = new OCSequenceNumberImpl(value, null, null);
	}
	
	public OCReportTypeEnum getOCReportType() 
	{
		if(ocReportType == null)
			return null;
		
		return ocReportType.getEnumerated(OCReportTypeEnum.class);
	}
	
	public void setOCReportType(OCReportTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("OC-Report-Type is required", Arrays.asList(new DiameterAvp[] { new OCReportTypeImpl() }));
		
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
	
	public List<TGPPOCSpecificReduction> getTGPPOCSpecificReduction()
	{
		return this.tgppOCSpecificReduction;
	}
	
	public void setTGPPOCSpecificReduction(List<TGPPOCSpecificReduction> value)
	{
		this.tgppOCSpecificReduction = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ocSequenceNumber == null)
			return new MissingAvpException("OC-Sequence-Number is required", Arrays.asList(new DiameterAvp[] { new OCSequenceNumberImpl() }));
		
		if(ocReportType == null)
			return new MissingAvpException("OC-Report-Type is required", Arrays.asList(new DiameterAvp[] { new OCReportTypeImpl() }));
		
		return null;
	}
}