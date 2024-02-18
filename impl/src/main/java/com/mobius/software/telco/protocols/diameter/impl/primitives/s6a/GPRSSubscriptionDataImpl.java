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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CompleteDataListIncludedIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CompleteDataListIncludedIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GPRSSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDPContext;

/**
*
* @author yulian oifa
*
*/
public class GPRSSubscriptionDataImpl extends DiameterGroupedAvpImpl implements GPRSSubscriptionData
{
	private CompleteDataListIncludedIndicator completeDataListIncludedIndicator;
	
	private List<PDPContext> pdpContext;
	
	protected GPRSSubscriptionDataImpl()
	{
		
	}
	
	public GPRSSubscriptionDataImpl(CompleteDataListIncludedIndicatorEnum completeDataListIncludedIndicator,List<PDPContext> pdpContext) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		setCompleteDataListIncludedIndicator(completeDataListIncludedIndicator);
		
		setPDPContext(pdpContext);
	}
	
	public CompleteDataListIncludedIndicatorEnum getCompleteDataListIncludedIndicator()
	{
		if(completeDataListIncludedIndicator == null)
			return null;
		
		return completeDataListIncludedIndicator.getEnumerated(CompleteDataListIncludedIndicatorEnum.class);
	}
	
	public void setCompleteDataListIncludedIndicator(CompleteDataListIncludedIndicatorEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Complete-Data-List-Included-Indicator is required", Arrays.asList(new DiameterAvp[] { new CompleteDataListIncludedIndicatorImpl() }));
			
		this.completeDataListIncludedIndicator = new CompleteDataListIncludedIndicatorImpl(value, null, null);
	}
	
	public List<PDPContext> getPDPContext()
	{
		return pdpContext;
	}
	
	public void setPDPContext(List<PDPContext> value) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		if(value==null || value.size()==0)
			throw new MissingAvpException("PDP-Context is required", Arrays.asList(new DiameterAvp[] { new PDPContextImpl() }));
			
		if(value.size()>50)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(value);
			throw new AvpOccursTooManyTimesException("PDP-Context is required ( 1 to 50 )", failedAvps);
		}
		
		this.pdpContext = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(completeDataListIncludedIndicator==null)
			return new MissingAvpException("Complete-Data-List-Included-Indicator is required", Arrays.asList(new DiameterAvp[] { new CompleteDataListIncludedIndicatorImpl() }));
		
		if(pdpContext==null || pdpContext.size()==0)
			return new MissingAvpException("PDP-Context is required", Arrays.asList(new DiameterAvp[] { new PDPContextImpl() }));
		
		if(pdpContext!=null && pdpContext.size()>50)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(pdpContext);
			return new AvpOccursTooManyTimesException("Up to 50 PDP-Context are allowed", failedAvps);
		}
		
		return null;
	}
}