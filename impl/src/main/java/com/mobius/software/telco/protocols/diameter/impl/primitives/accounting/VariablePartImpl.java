package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePart;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePartOrder;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePartType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePartValue;

/**
*
* @author yulian oifa
*
*/
public class VariablePartImpl extends DiameterAvpImpl implements VariablePart
{
	private VariablePartOrder variablePartOrder;
	private VariablePartType variablePartType;
	private VariablePartValue variablePartValue;
	
	protected VariablePartImpl() 
	{
	}
	
	public VariablePartImpl(Long variablePartOrder,Long variablePartType) throws MissingAvpException
	{
		setVariablePartOrder(variablePartOrder);
		
		setVariablePartType(variablePartType);
	}
			
	public Long getVariablePartOrder()
	{
		if(variablePartOrder==null)
			return null;
		
		return variablePartOrder.getUnsigned();
	}
	
	public void setVariablePartOrder(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Variable-Part-Order requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new VariablePartOrderImpl() }));
			
		this.variablePartOrder = new VariablePartOrderImpl(value, null, null);				
	}
	
	public Long getVariablePartType()
	{
		if(variablePartType==null)
			return null;
		
		return variablePartType.getUnsigned();
	}
	
	public void setVariablePartType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Variable-Part-Type requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new VariablePartTypeImpl() }));
		
		this.variablePartType = new VariablePartTypeImpl(value, null, null);
	}
	
	public String getVariablePartValue()
	{
		if(variablePartValue==null)
			return null;
		
		return variablePartValue.getString();
	}
	
	public void setVariablePartValue(String value)
	{
		if(value==null)
			this.variablePartValue = null;
		else
			this.variablePartValue = new VariablePartValueImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(variablePartOrder==null)
			return new MissingAvpException("Variable-Part-Order requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new VariablePartOrderImpl() }));
		
		if(variablePartType==null)
			return new MissingAvpException("Variable-Part-Type requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { new VariablePartTypeImpl() }));
		
		return null;
	}
}