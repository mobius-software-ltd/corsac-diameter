package com.mobius.software.telco.protocols.diameter.impl.primitives.s6m;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.HSSCause;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.T4Data;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3108L, vendorId = KnownVendorIDs.TGPP_ID)
public class T4DataImpl extends DiameterGroupedAvpImpl implements T4Data
{
	private HSSCause hssCause;
	
	private ServingNode servingNode;
	
	private List<AdditionalServingNode> additionalServingNode;
	
	public T4DataImpl()
	{
		
	}
	
	public Long getHSSCause()
	{
		if(hssCause==null)
			return null;
		
		return hssCause.getUnsigned();
	}
	
	public void setHSSCause(Long value)
	{
		if(value == null)
			this.hssCause = null;
		else
			this.hssCause = new HSSCauseImpl(value, null, null);
		
	}
	
	public ServingNode getServingNode()
	{
		return this.servingNode;
	}
	
	public void setServingNode(ServingNode value)
	{
		this.servingNode = value;
	}
	
	public List<AdditionalServingNode> getAdditionalServingNode()
	{
		return additionalServingNode;
	}
	
	public void setAdditionalServingNode(List<AdditionalServingNode> value)
	{
		this.additionalServingNode = value;
	}
}