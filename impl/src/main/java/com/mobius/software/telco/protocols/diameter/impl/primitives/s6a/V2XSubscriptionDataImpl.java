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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEPC5AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XSubscriptionData;

/**
*
* @author yulian oifa
*
*/
public class V2XSubscriptionDataImpl extends DiameterGroupedAvpImpl implements V2XSubscriptionData
{
	private V2XPermission v2xPermission;
	
	private UEPC5AMBR uePC5AMBR;
	
	public V2XSubscriptionDataImpl()
	{
		
	}
	
	public V2XPermission getV2XPermission()
	{
		return v2xPermission;
	}
	
	public void setV2XPermission(V2XPermission value)
	{
		this.v2xPermission = value;
	}
	
	public Long getUEPC5AMBR()
	{
		if(uePC5AMBR==null)
			return null;
		
		return uePC5AMBR.getUnsigned();
	}
	
	public void setUEPC5AMBR(Long value)
	{
		if(value == null)
			this.uePC5AMBR = null;
		else
			this.uePC5AMBR = new UEPC5AMBRImpl(value, null, null);
	}
}