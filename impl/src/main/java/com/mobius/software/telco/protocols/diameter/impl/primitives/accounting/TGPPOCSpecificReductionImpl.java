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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCReductionPercentageImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCRatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCSpecificReduction;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReductionPercentage;

/**
*
* @author yulian oifa
*
*/
public class TGPPOCSpecificReductionImpl extends DiameterGroupedAvpImpl implements TGPPOCSpecificReduction
{
	private List<TGPPOCRatingGroup> tgppOCRatingGroup;
	private List<TGPPOCRequestType> tgppOCRequestType;
	private OCReductionPercentage ocReductionPercentage;
					
	public TGPPOCSpecificReductionImpl()
	{
	}
	
	public List<Long> get3GPPOCRatingGroup()
	{
		if(tgppOCRatingGroup==null || tgppOCRatingGroup.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(TGPPOCRatingGroup curr:tgppOCRatingGroup)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void set3GPPOCRatingGroup(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.tgppOCRatingGroup = null;
		else
		{
			this.tgppOCRatingGroup = new ArrayList<TGPPOCRatingGroup>();
			for(Long curr:value)
				this.tgppOCRatingGroup.add(new TGPPOCRatingGroupImpl(curr, null, null));
		}
	}
	
	public List<TGPPOCRequestTypeEnum> get3GPPOCRequestType()
	{
		if(tgppOCRequestType==null || tgppOCRequestType.size()==0)
			return null;
		
		List<TGPPOCRequestTypeEnum> result = new ArrayList<TGPPOCRequestTypeEnum>();
		for(TGPPOCRequestType curr:tgppOCRequestType)
			result.add(curr.getEnumerated(TGPPOCRequestTypeEnum.class));
		
		return result;
	}
	
	public void set3GPPOCRequestType(List<TGPPOCRequestTypeEnum> value)
	{
		if(value==null || value.size()==0)
			this.tgppOCRequestType = null;
		else
		{
			this.tgppOCRequestType = new ArrayList<TGPPOCRequestType>();
			for(TGPPOCRequestTypeEnum curr:value)
				this.tgppOCRequestType.add(new TGPPOCRequestTypeImpl(curr, null, null));
		}
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
}