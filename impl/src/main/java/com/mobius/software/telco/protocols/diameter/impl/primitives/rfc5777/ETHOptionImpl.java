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
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHOption;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHProtoType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.UserPriorityRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.VLANIDRange;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 548L, vendorId = -1L)
public class ETHOptionImpl extends DiameterGroupedAvpImpl implements ETHOption 
{
	ETHProtoType ethProtoType;
	
	List<VLANIDRange> vlanIDRange;
	
	List<UserPriorityRange> userPriorityRange;
	
	protected ETHOptionImpl() 
	{
	}
	
	public ETHOptionImpl(ETHProtoType ethProtoType)
	{
		if(ethProtoType==null)
			throw new IllegalArgumentException("ETH-Proto-Type is required");
		
		this.ethProtoType = ethProtoType;		
	}
	
	public ETHProtoType getETHProtoType()
	{
		return this.ethProtoType;
	}
	
	public void setETHProtoType(ETHProtoType value)
	{
		this.ethProtoType = value;
	}
	
	public List<VLANIDRange> getVLANIDRange()
	{
		return vlanIDRange;
	}
	
	public void setVLANIDRange(List<VLANIDRange> value)
	{
		this.vlanIDRange = value;
	}
	
	public List<UserPriorityRange> getUserPriorityRange()
	{
		return this.userPriorityRange;
	}
	
	public void setUserPriorityRange(List<UserPriorityRange> value)
	{
		this.userPriorityRange = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(ethProtoType==null)
			return "ETH-Proto-Type is required";
		
		return null;
	}
}