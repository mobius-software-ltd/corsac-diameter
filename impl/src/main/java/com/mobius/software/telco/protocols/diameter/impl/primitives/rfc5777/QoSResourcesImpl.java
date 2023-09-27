package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;

/**
*
* @author yulian oifa
*
*/

/*
 * 3.1.  QoS-Resources AVP

   The QoS-Resources AVP (AVP Code 508) is of type Grouped and contains
   a list of filter policy rules.

   QoS-Resources ::= < AVP Header: 508 >
                   1*{ Filter-Rule }
                   * [ AVP ]
 */
@DiameterAvpImplementation(code = 508L, vendorId = -1L)
public class QoSResourcesImpl extends DiameterGroupedAvpImpl implements QoSResources
{
	private List<FilterRule> filterRule;
	
	protected QoSResourcesImpl()
	{
		
	}
	
	public QoSResourcesImpl(List<FilterRule> filterRule)
	{
		if(filterRule == null || filterRule.size()==0)
			throw new IllegalArgumentException("Filter-Rule is required");
		
		this.filterRule = filterRule;
	}
	
	public List<FilterRule> getFilterRule()
	{
		return filterRule;
	}
	
	public void setFilterRule(List<FilterRule> value)
	{
		if(filterRule == null || filterRule.size()==0)
			throw new IllegalArgumentException("Filter-Rule is required");
		
		this.filterRule = value;
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(filterRule == null || filterRule.size()==0)
			return "Filter-Rule	 is required";
		
		return null;
	}
}