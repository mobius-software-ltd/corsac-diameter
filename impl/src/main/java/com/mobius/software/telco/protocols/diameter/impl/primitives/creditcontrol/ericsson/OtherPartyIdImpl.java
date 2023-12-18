package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ericsson;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyIdData;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyIdNature;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyIdNatureEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyIdType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyIdTypeEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1075L, vendorId = KnownVendorIDs.ERICSSON_ID)
public class OtherPartyIdImpl extends DiameterGroupedAvpImpl implements OtherPartyId
{
	private OtherPartyIdType otherPartyIdType;
	
	private OtherPartyIdData otherPartyIdData;
	
	private OtherPartyIdNature otherPartyIdNature;
	
	protected OtherPartyIdImpl()
	{
		
	}
	
	public OtherPartyIdImpl(OtherPartyIdTypeEnum otherPartyIdType,String otherPartyIdData)
	{
		setOtherPartyIdType(otherPartyIdType);
		
		setOtherPartyIdData(otherPartyIdData);
	}
	
	@Override
	public OtherPartyIdTypeEnum getOtherPartyIdType()
	{
		if(otherPartyIdType==null)
			return null;
		
		return otherPartyIdType.getEnumerated(OtherPartyIdTypeEnum.class);
	}
	
	@Override
	public void setOtherPartyIdType(OtherPartyIdTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Other-Party-Id-Type is required");
		
		this.otherPartyIdType = new OtherPartyIdTypeImpl(value, null, null);			
	}
	
	@Override
	public String getOtherPartyIdData()
	{
		if(otherPartyIdData==null)
			return null;
		
		return otherPartyIdData.getString();
	}
	
	@Override
	public void setOtherPartyIdData(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Other-Party-Id-Data is required");
		
		this.otherPartyIdData = new OtherPartyIdDataImpl(value, null, null);			
	}
	
	@Override
	public OtherPartyIdNatureEnum getOtherPartyIdNature()
	{
		if(otherPartyIdNature==null)
			return null;
		
		return otherPartyIdNature.getEnumerated(OtherPartyIdNatureEnum.class);
	}
	
	@Override
	public void setOtherPartyIdNature(OtherPartyIdNatureEnum value)
	{
		if(value==null)
			this.otherPartyIdNature = null;
		else
			this.otherPartyIdNature = new OtherPartyIdNatureImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(otherPartyIdType==null)
			return "Other-Party-Id-Type is required";
		
		if(otherPartyIdData==null)
			return "Other-Party-Id-Data is required";
		
		return null;
	}
}