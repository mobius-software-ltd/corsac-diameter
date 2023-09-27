package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPGroup;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPValue;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 575L, vendorId = KnownVendorIDs.TGPP_ID)
public class NGAPCauseImpl implements NGAPCause
{
	private NGAPGroup ngapGroup;
	
	private NGAPValue ngapValue;
	
	protected NGAPCauseImpl()
	{
		
	}
	
	public NGAPCauseImpl(Long ngapGroup,Long ngapValue)
	{
		if(ngapGroup==null)
			throw new IllegalArgumentException("NGAP-Group is required");
		
		if(ngapValue==null)
			throw new IllegalArgumentException("NGAP-Value is required");
		
		this.ngapGroup = new NGAPGroupImpl(ngapGroup, null, null);	
		
		this.ngapValue = new NGAPValueImpl(ngapValue, null, null);
	}
	
	public Long getNGAPGroup()
	{
		if(ngapGroup == null)
			return null;
		
		return ngapGroup.getUnsigned();
	}
	
	public void setNGAPGroup(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("NGAP-Group is required");
		
		this.ngapGroup = new NGAPGroupImpl(value, null, null);	
	}
	
	public Long getNGAPValue()
	{
		if(ngapValue == null)
			return null;
		
		return ngapValue.getUnsigned();
	}
	
	public void setNGAPValue(Long value)		
	{
		if(value==null)
			throw new IllegalArgumentException("NGAP-Value is required");
		
		this.ngapValue = new NGAPValueImpl(value, null, null);
	}				
	
	@DiameterValidate
	public String validate()
	{
		if(ngapGroup==null)
			return "NGAP-Group is required";
		
		if(ngapValue==null)
			return "NGAP-Value is required";
		
		return null;
	}	
}