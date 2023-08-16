package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.LoadType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.LoadTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.LoadValue;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.SourceID;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 650L, vendorId = -1L)
public class LoadImpl extends DiameterGroupedAvpImpl implements Load
{
	private LoadType loadType;
	
	private LoadValue loadValue;
	
	private SourceID sourceID;
	
	public LoadImpl() 
	{
		super();
	}
	
	public LoadTypeEnum getLoadType() 
	{
		if(loadType == null)
			return null;
		
		return loadType.getEnumerated(LoadTypeEnum.class);
	}
	
	public void setLoadType(LoadTypeEnum value)
	{
		if(value==null)
			this.loadType = null;
		else
			this.loadType = new LoadTypeImpl(value, null, null);		
	}
	
	public Long getLoadValue()
	{
		if(loadValue == null)
			return null;
		
		return loadValue.getLong();
	}
	
	public void setLoadValue(Long value)
	{
		if(value==null)
			this.loadValue = null;
		else
			this.loadValue = new LoadValueImpl(value, null, null);
	}
	
	public String getSourceID()
	{
		if(sourceID == null)
			return null;
		
		return sourceID.getIdentity();
	}
	
	public void setSourceID(String value)
	{
		if(value!=null)
			this.sourceID = new SourceIDImpl(value, null, null);	
		else
			this.sourceID = null;
	}
}