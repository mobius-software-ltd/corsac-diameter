package com.mobius.software.telco.protocols.diameter.impl.primitives.gq;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInputList;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V4TransportAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gq.V6TransportAddress;

/**
*
* @author yulian oifa
*
*/
public class BindingInputListImpl extends DiameterAvpImpl implements BindingInputList 
{
	private List<V6TransportAddress> v6TransportAddress;
	
	private List<V4TransportAddress> v4TransportAddress;
	
	public BindingInputListImpl()
	{
		
	}
	
	public List<V6TransportAddress> getV6TransportAddress()
	{
		return v6TransportAddress;
	}
	
	public void setV6TransportAddress(List<V6TransportAddress> value)
	{
		this.v6TransportAddress = value;
	}
	
	public List<V4TransportAddress> getV4TransportAddress()
	{
		return v4TransportAddress;
	}
	
	public void setV4TransportAddress(List<V4TransportAddress> value)
	{
		this.v4TransportAddress = value;
	}
}