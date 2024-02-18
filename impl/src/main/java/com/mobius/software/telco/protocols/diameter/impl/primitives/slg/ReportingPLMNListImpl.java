package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLMNIDList;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PrioritizedListIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PrioritizedListIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingPLMNList;

/**
*
* @author yulian oifa
*
*/
public class ReportingPLMNListImpl extends DiameterGroupedAvpImpl implements ReportingPLMNList
{
	private List<PLMNIDList> plmnIDList;
	
	private PrioritizedListIndicator prioritizedListIndicator;
	
	protected ReportingPLMNListImpl() 
	{
	}
	
	public ReportingPLMNListImpl(List<PLMNIDList> plmnIDList) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		setPLMNIDList(plmnIDList);
	}
	
	public List<PLMNIDList> getPLMNIDList()
	{
		return plmnIDList;
	}
	
	public void setPLMNIDList(List<PLMNIDList> value) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		if(value==null || value.size()==0)
			throw new MissingAvpException("PLMN-ID-List is required is required", Arrays.asList(new DiameterAvp[] { new PLMNIDListImpl() }));
			
		if(value.size()>20)
		{ 
			List<DiameterAvp> failedAvps = new ArrayList<DiameterAvp>();
			failedAvps.addAll(value);
			throw new AvpOccursTooManyTimesException("Up to 20 PLMN-ID-List allowed", failedAvps);
		}
		
		this.plmnIDList = value;
	}
	
	public PrioritizedListIndicatorEnum getPrioritizedListIndicator()
	{
		if(prioritizedListIndicator==null)
			return null;
		
		return prioritizedListIndicator.getEnumerated(PrioritizedListIndicatorEnum.class);
	}
	
	public void setPrioritizedListIndicator(PrioritizedListIndicatorEnum value)
	{
		if(value==null)
			this.prioritizedListIndicator = null;
		else
			this.prioritizedListIndicator = new PrioritizedListIndicatorImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(plmnIDList==null || plmnIDList.size()==0)
			return new MissingAvpException("PLMN-ID-List is required is required", Arrays.asList(new DiameterAvp[] { new PLMNIDListImpl() }));
		
		if(plmnIDList.size()>20)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(plmnIDList);
			return new AvpOccursTooManyTimesException("Up to 20 PLMN-ID-List allowed", failedAvps);
		}
		
		return null;
	}
}