package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FilterIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RestrictionFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FilterId;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 430L, vendorId = -1)
public class FinalUnitIndicationImpl implements FinalUnitIndication
{
	private FinalUnitAction finalUnitAction;
	
	private List<RestrictionFilterRule> restrictionFilterRule;
	
	private List<FilterId> filterId;
	
	private RedirectServer redirectServer;
	
	protected FinalUnitIndicationImpl()
	{
		
	}
	
	public FinalUnitIndicationImpl(FinalUnitActionEnum finalUnitAction, List<RestrictionFilterRule> restrictionFilterRule, List<String> filterId, RedirectServer redirectServer)
	{
		if(finalUnitAction==null)
			throw new IllegalArgumentException("Final-Unit-Action is required");		

		this.finalUnitAction = new FinalUnitActionImpl(finalUnitAction, null, null);
	}
	
	public FinalUnitActionEnum getFinalUnitAction()
	{
		if(finalUnitAction==null)
			return null;
		
		return finalUnitAction.getEnumerated(FinalUnitActionEnum.class);
	}
	
	public void setFinalUnitAction(FinalUnitActionEnum finalUnitAction)
	{
		if(finalUnitAction==null)
			throw new IllegalArgumentException("Final-Unit-Action is required");		
		
		this.finalUnitAction = new FinalUnitActionImpl(finalUnitAction, null, null);
	}
	
	public List<RestrictionFilterRule> getRestrictionFilterRule()
	{
		return this.restrictionFilterRule;
	}
	
	public void setRestrictionFilterRule(List<RestrictionFilterRule> restrictionFilterRule)
	{
		this.restrictionFilterRule = restrictionFilterRule;
	}
	
	public List<String> getFilterId()
	{
		if(this.filterId == null || this.filterId.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>(this.filterId.size());
		for(FilterId curr:filterId)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setFilterId(List<String> filterId)
	{
		if(filterId==null || filterId.size()==0)
			this.filterId = null;
		else
		{
			this.filterId = new ArrayList<FilterId>(filterId.size());
			for(String curr:filterId)
				this.filterId.add(new FilterIdImpl(curr, null, null));			
		}
	}
	
	public RedirectServer getRedirectServer()
	{
		return redirectServer;
	}
	
	public void setRedirectServer(RedirectServer redirectServer)
	{
		this.redirectServer = redirectServer;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(finalUnitAction==null)
			return "Final-Unit-Action is required";
		
		return null;
	}
}