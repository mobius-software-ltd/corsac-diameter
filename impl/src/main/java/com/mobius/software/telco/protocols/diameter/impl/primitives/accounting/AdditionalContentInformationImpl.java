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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AdditionalContentInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AdditionalTypeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ContentSize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TypeNumber;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TypeNumberEnum;

/**
*
* @author yulian oifa
*
*/
public class AdditionalContentInformationImpl extends DiameterAvpImpl implements AdditionalContentInformation
{
	private TypeNumber typeNumber;
	private AdditionalTypeInformation additionalTypeInformation;
	private ContentSize contentSize;
		
	public AdditionalContentInformationImpl()
	{
		
	}
	
	public TypeNumberEnum getTypeNumber()
	{
		if(typeNumber==null)
			return null;
		
		return typeNumber.getEnumerated(TypeNumberEnum.class);
	}
	
	public void setTypeNumber(TypeNumberEnum value)
	{
		if(value==null)
			this.typeNumber = null;
		else
			this.typeNumber = new TypeNumberImpl(value, null, null);			
	}
	
	public String getAdditionalTypeInformation()
	{
		if(additionalTypeInformation==null)
			return null;
		
		return additionalTypeInformation.getString();
	}
	
	public void setAdditionalTypeInformation(String value)
	{
		if(value==null)
			this.additionalTypeInformation = null;
		else
			this.additionalTypeInformation = new AdditionalTypeInformationImpl(value, null, null);			
	}
	
	public Long getContentSize()
	{
		if(contentSize==null)
			return null;
		
		return contentSize.getUnsigned();
	}
	
	public void setContentSize(Long value)
	{
		if(value==null)
			this.contentSize = null;
		else
			this.contentSize = new ContentSizeImpl(value, null, null);			
	}
}