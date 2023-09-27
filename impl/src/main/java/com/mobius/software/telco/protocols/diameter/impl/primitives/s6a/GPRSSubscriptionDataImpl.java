package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CompleteDataListIncludedIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CompleteDataListIncludedIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDPContext;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1467L, vendorId = KnownVendorIDs.TGPP_ID)
public class GPRSSubscriptionDataImpl extends DiameterGroupedAvpImpl
{
	private CompleteDataListIncludedIndicator completeDataListIncludedIndicator;
	
	private List<PDPContext> pdpContext;
	
	protected GPRSSubscriptionDataImpl()
	{
		
	}
	
	public GPRSSubscriptionDataImpl(CompleteDataListIncludedIndicatorEnum completeDataListIncludedIndicator,List<PDPContext> pdpContext)
	{
		if(completeDataListIncludedIndicator==null)
			throw new IllegalArgumentException("Complete-Data-List-Included-Indicator is required");
		
		if(pdpContext==null || pdpContext.size()==0 || pdpContext.size()>50)
			throw new IllegalArgumentException("PDP-Context is required ( 1 to 50 )");
		
		this.completeDataListIncludedIndicator = new CompleteDataListIncludedIndicatorImpl(completeDataListIncludedIndicator, null, null);
		
		this.pdpContext = pdpContext;
	}
	
	public CompleteDataListIncludedIndicatorEnum getCompleteDataListIncludedIndicator()
	{
		if(completeDataListIncludedIndicator == null)
			return null;
		
		return completeDataListIncludedIndicator.getEnumerated(CompleteDataListIncludedIndicatorEnum.class);
	}
	
	public void setCompleteDataListIncludedIndicator(CompleteDataListIncludedIndicatorEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Complete-Data-List-Included-Indicator is required");
		
		this.completeDataListIncludedIndicator = new CompleteDataListIncludedIndicatorImpl(value, null, null);
	}
	
	public List<PDPContext> getPDPContext()
	{
		return pdpContext;
	}
	
	public void setPDPContext(List<PDPContext> value)
	{
		if(value==null || value.size()==0 || value.size()>50)
			throw new IllegalArgumentException("PDP-Context is required ( 1 to 50 )");
		
		this.pdpContext = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(completeDataListIncludedIndicator==null)
			return "Complete-Data-List-Included-Indicator is required";
		
		if(pdpContext==null || pdpContext.size()==0 || pdpContext.size()>50)
			return "PDP-Context is required ( 1 to 50 )";
		
		return null;
	}
}