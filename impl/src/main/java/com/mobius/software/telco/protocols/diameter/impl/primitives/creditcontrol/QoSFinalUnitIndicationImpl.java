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
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FilterIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.QoSFinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServerExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RestrictionFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FilterId;

/**
*
* @author yulian oifa
*
*/
public class QoSFinalUnitIndicationImpl extends DiameterGroupedAvpImpl implements QoSFinalUnitIndication
{
	private FinalUnitAction finalUnitAction;
	
	private List<RestrictionFilterRule> restrictionFilterRule;
	
	private List<FilterId> filterId;
	
	private RedirectServerExtension redirectServerExtension;
	
	public QoSFinalUnitIndicationImpl()
	{
		
	}
	
	public QoSFinalUnitIndicationImpl(FinalUnitActionEnum finalUnitAction) throws MissingAvpException
	{
		setFinalUnitAction(finalUnitAction);
	}
	
	public FinalUnitActionEnum getFinalUnitAction()
	{
		if(finalUnitAction==null)
			return null;
		
		return finalUnitAction.getEnumerated(FinalUnitActionEnum.class);
	}
	
	public void setFinalUnitAction(FinalUnitActionEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Final-Unit-Action is required is required", Arrays.asList(new DiameterAvp[] { new FinalUnitActionImpl() }));
		
		this.finalUnitAction = new FinalUnitActionImpl(value, null, null);
	}
	
	public List<RestrictionFilterRule> getRestrictionFilterRule()
	{
		return this.restrictionFilterRule;
	}
	
	public void setRestrictionFilterRule(List<RestrictionFilterRule> value)
	{
		this.restrictionFilterRule = value;
	}
	
	public	List<String> getFilterId()
	{
		if(this.filterId == null || this.filterId.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>(this.filterId.size());
		for(FilterId curr:filterId)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setFilterId(List<String> value)
	{
		if(value==null || value.size()==0)
			this.filterId = null;
		else
		{
			this.filterId = new ArrayList<FilterId>(filterId.size());
			for(String curr:value)
				this.filterId.add(new FilterIdImpl(curr, null, null));			
		}
	}
	
	public RedirectServerExtension getRedirectServerExtension()
	{
		return redirectServerExtension;
	}
	
	public void setRedirectServerExtension(RedirectServerExtension value)
	{
		this.redirectServerExtension = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(finalUnitAction==null)
			return new MissingAvpException("Final-Unit-Action is required is required", Arrays.asList(new DiameterAvp[] { new FinalUnitActionImpl() }));
		
		return null;
	}
}