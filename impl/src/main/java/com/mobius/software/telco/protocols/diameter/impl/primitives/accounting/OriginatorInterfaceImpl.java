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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterfaceId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterfacePort;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterfaceText;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterfaceType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterfaceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorInterface;

/**
*
* @author yulian oifa
*
*/
public class OriginatorInterfaceImpl extends DiameterAvpImpl implements OriginatorInterface
{
	private InterfaceId interfaceId;
	private InterfaceText interfaceText;
	private InterfacePort interfacePort;
	private InterfaceType interfaceType;
		
	public OriginatorInterfaceImpl()
	{
		
	}
	
	public String getInterfaceId()
	{
		if(interfaceId==null)
			return null;
		
		return interfaceId.getString();
	}
	
	public void setInterfaceId(String value)
	{
		if(value==null)
			this.interfaceId = null;
		else
			this.interfaceId = new InterfaceIdImpl(value, null, null);			
	}
	
	public String getInterfaceText()
	{
		if(interfaceText==null)
			return null;
		
		return interfaceText.getString();
	}
	
	public void setInterfaceText(String value)
	{
		if(value==null)
			this.interfaceText = null;
		else
			this.interfaceText = new InterfaceTextImpl(value, null, null);			
	}
	
	public String getInterfacePort()
	{
		if(interfacePort==null)
			return null;
		
		return interfacePort.getString();
	}
	
	public void setInterfacePort(String value)
	{
		if(value==null)
			this.interfacePort = null;
		else
			this.interfacePort = new InterfacePortImpl(value, null, null);			
	}
	
	public InterfaceTypeEnum getInterfaceType()
	{
		if(interfaceType==null)
			return null;
		
		return interfaceType.getEnumerated(InterfaceTypeEnum.class);
	}
	
	public void setInterfaceType(InterfaceTypeEnum value)
	{
		if(value==null)
			this.interfaceType = null;
		else
			this.interfaceType = new InterfaceTypeImpl(value, null, null);			
	}
}