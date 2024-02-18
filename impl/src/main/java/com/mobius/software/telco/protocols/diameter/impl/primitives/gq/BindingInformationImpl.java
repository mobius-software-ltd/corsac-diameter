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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInputList;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingOutputList;

/**
*
* @author yulian oifa
*
*/
public class BindingInformationImpl implements BindingInformation
{
	private BindingInputList bindingInputList;
	
	private BindingOutputList bindingOutputList;
	
	protected BindingInformationImpl()
	{
		
	}
	
	public BindingInformationImpl(BindingInputList bindingInputList) throws MissingAvpException
	{
		setBindingInputList(bindingInputList);
	}
	
	public BindingInputList getBindingInputList()
	{
		return this.bindingInputList;
	}
	
	public void setBindingInputList(BindingInputList value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Binding-Input-List is required", Arrays.asList(new DiameterAvp[] { new BindingInputListImpl() }));
			
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
	public DiameterException validate()
	{
		if(bindingInputList==null)
			return new MissingAvpException("Binding-Input-List is required", Arrays.asList(new DiameterAvp[] { new BindingInputListImpl() }));
		
		return null;
	}
}