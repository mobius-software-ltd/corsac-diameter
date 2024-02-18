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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPGroup;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPValue;

/**
*
* @author yulian oifa
*
*/
public class NGAPCauseImpl implements NGAPCause
{
	private NGAPGroup ngapGroup;
	
	private NGAPValue ngapValue;
	
	protected NGAPCauseImpl()
	{
		
	}
	
	public NGAPCauseImpl(Long ngapGroup,Long ngapValue) throws MissingAvpException
	{
		setNGAPGroup(ngapGroup);
		
		setNGAPValue(ngapValue);
	}
	
	public Long getNGAPGroup()
	{
		if(ngapGroup == null)
			return null;
		
		return ngapGroup.getUnsigned();
	}
	
	public void setNGAPGroup(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("NGAP-Group is required", Arrays.asList(new DiameterAvp[] { new NGAPGroupImpl() }));
		
		this.ngapGroup = new NGAPGroupImpl(value, null, null);	
	}
	
	public Long getNGAPValue()
	{
		if(ngapValue == null)
			return null;
		
		return ngapValue.getUnsigned();
	}
	
	public void setNGAPValue(Long value) throws MissingAvpException		
	{
		if(value==null)
			throw new MissingAvpException("NGAP-Value is required", Arrays.asList(new DiameterAvp[] { new NGAPValueImpl() }));
		
		this.ngapValue = new NGAPValueImpl(value, null, null);
	}				
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ngapGroup==null)
			return new MissingAvpException("NGAP-Group is required", Arrays.asList(new DiameterAvp[] { new NGAPGroupImpl() }));
		
		if(ngapValue==null)
			return new MissingAvpException("NGAP-Value is required", Arrays.asList(new DiameterAvp[] { new NGAPValueImpl() }));
		
		return null;
	}	
}