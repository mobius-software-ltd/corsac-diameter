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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHEtherType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHProtoType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHSAP;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 549L, vendorId = -1L)
public class ETHProtoTypeImpl extends DiameterGroupedAvpImpl implements ETHProtoType
{
	private List<ETHEtherType> ethEtherType;
	
	private List<ETHSAP> ethSAP;
	
	public ETHProtoTypeImpl() 
	{
	}
	
	public List<ByteBuf> getETHEtherType()
	{
		if(ethEtherType==null || ethEtherType.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ETHEtherType curr:ethEtherType)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setETHEtherType(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.ethEtherType = null;
		else
		{
			this.ethEtherType = new ArrayList<ETHEtherType>();
			for(ByteBuf curr:value)
				this.ethEtherType.add(new ETHEtherTypeImpl(curr, null, null));			
		}
	}
	
	public List<ByteBuf> getETHSAP()
	{
		if(ethSAP==null || ethSAP.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ETHSAP curr:ethSAP)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setETHSAP(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.ethSAP = null;
		else
		{
			this.ethSAP = new ArrayList<ETHSAP>();
			for(ByteBuf curr:value)
				this.ethSAP.add(new ETHSAPImpl(curr, null, null));			
		}
	}
}