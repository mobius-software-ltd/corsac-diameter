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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePart;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePartOrder;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePartType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePartValue;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.242aA	Variable-Part AVP
	The Variable-Part AVP (AVP code 3907) is of type Grouped and specifies the order, type, and value of a variable to be played back within the announcement.
	It has the following ABNF grammar:

	Variable-Part :: =  < AVP Header: 3907 >
		[ Variable-Part-Order ]
		{ Variable-Part-Type }
		{ Variable-Part-Value }
 */
@DiameterAvpImplementation(code = 3907L, vendorId = KnownVendorIDs.TGPP_ID)
public class VariablePartImpl implements VariablePart
{
	private VariablePartOrder variablePartOrder;
	private VariablePartType variablePartType;
	private VariablePartValue variablePartValue;
	
	protected VariablePartImpl() 
	{
	}
	
	public VariablePartImpl(Long variablePartOrder,Long variablePartType)
	{
		if(variablePartOrder==null)
			throw new IllegalArgumentException("Variable-Part-Order is required");
		
		if(variablePartType==null)
			throw new IllegalArgumentException("Variable-Part-Type is required");
		
		this.variablePartOrder = new VariablePartOrderImpl(variablePartOrder, null, null);				
		
		this.variablePartType = new VariablePartTypeImpl(variablePartType, null, null);
	}
			
	public Long getVariablePartOrder()
	{
		if(variablePartOrder==null)
			return null;
		
		return variablePartOrder.getUnsigned();
	}
	
	public void setVariablePartOrder(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Variable-Part-Order is required");
		
		this.variablePartOrder = new VariablePartOrderImpl(value, null, null);				
	}
	
	public Long getVariablePartType()
	{
		if(variablePartType==null)
			return null;
		
		return variablePartType.getUnsigned();
	}
	
	public void setVariablePartType(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Variable-Part-Type is required");
		
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
	public String validate()
	{
		if(variablePartOrder==null)
			return "Variable-Part-Order is required";
		
		if(variablePartType==null)
			return "Variable-Part-Type is required";
		
		return null;
	}
}