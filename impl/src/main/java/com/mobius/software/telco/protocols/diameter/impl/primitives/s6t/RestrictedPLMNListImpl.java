package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RestrictedPLMNList;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class RestrictedPLMNListImpl extends DiameterGroupedAvpImpl implements RestrictedPLMNList
{
	private List<VisitedPLMNId> visitedPLMNId;
	
	public RestrictedPLMNListImpl()
	{
		
	}
	
	public List<ByteBuf> getVisitedPLMNId()
	{
		if(visitedPLMNId==null || visitedPLMNId.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(VisitedPLMNId curr:visitedPLMNId)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setVisitedPLMNId(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.visitedPLMNId = null;
		else
		{
			this.visitedPLMNId = new ArrayList<VisitedPLMNId>();
			for(ByteBuf curr:value)
				this.visitedPLMNId.add(new VisitedPLMNIdImpl(curr, null, null));
		}
	}
}