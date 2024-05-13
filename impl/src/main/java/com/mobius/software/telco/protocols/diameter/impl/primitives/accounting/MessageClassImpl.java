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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ClassIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageClass;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TokenText;

/**
*
* @author yulian oifa
*
*/
public class MessageClassImpl extends DiameterAvpImpl implements MessageClass
{
	private ClassIdentifier classIdentifier;
	private TokenText tokenText;
		
	public MessageClassImpl()
	{
		
	}
	
	public ClassIdentifierEnum getClassIdentifier()
	{
		if(classIdentifier==null)
			return null;
		
		return classIdentifier.getEnumerated(ClassIdentifierEnum.class);
	}
	
	public void setClassIdentifier(ClassIdentifierEnum value)
	{
		if(value==null)
			this.classIdentifier = null;
		else
			this.classIdentifier = new ClassIdentifierImpl(value, null, null);			
	}
	
	public String getTokenText()
	{
		if(tokenText==null)
			return null;
		
		return tokenText.getString();
	}
	
	public void setTokenText(String value)
	{
		if(value==null)
			this.tokenText = null;
		else
			this.tokenText = new TokenTextImpl(value, null, null);			
	}
}