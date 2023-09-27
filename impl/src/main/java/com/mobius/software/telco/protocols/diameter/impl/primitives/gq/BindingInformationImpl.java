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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInputList;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingOutputList;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 450L, vendorId = KnownVendorIDs.TGPP_ID)
public class BindingInformationImpl implements BindingInformation
{
	private BindingInputList bindingInputList;
	
	private BindingOutputList bindingOutputList;
	
	protected BindingInformationImpl()
	{
		
	}
	
	public BindingInformationImpl(BindingInputList bindingInputList)
	{
		if(bindingInputList == null)
			throw new IllegalArgumentException("Binding-Input-List is required");
		
		this.bindingInputList = bindingInputList;
	}
	
	public BindingInputList getBindingInputList()
	{
		return this.bindingInputList;
	}
	
	public void setBindingInputList(BindingInputList value)
	{
		if(value == null)
			throw new IllegalArgumentException("Binding-Input-List is required");
		
		this.bindingInputList = value;
	}
	
	public BindingOutputList getBindingOutputList()
	{
		return this.bindingOutputList;
	}
	
	public void setBindingOutputList(BindingOutputList value)
	{
		this.bindingOutputList = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(bindingInputList==null)
			return "Binding-Input-List is required";
		
		return null;
	}
}