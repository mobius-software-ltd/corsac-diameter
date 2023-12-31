package com.mobius.software.telco.protocols.diameter.impl.commands;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public abstract class DiameterAnswerWithSessionBase extends DiameterAnswerBase
{
	protected DiameterAnswerWithSessionBase() 
	{
		super();
	}
	
	public DiameterAnswerWithSessionBase(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID)
	{
		super(originHost, originRealm, isRetransmit, resultCode);
		
		if(sessionID==null)
			throw new IllegalArgumentException("Session-ID is required");
		
		try
		{
			setSessionId(sessionID);
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
	}

	@Override
	public void setSessionId(String value) throws AvpNotSupportedException
	{
		if(value==null)
			throw new IllegalArgumentException("Session-ID is required");
		
		super.setSessionId(value);
	}	
	
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getSessionId()==null)
				return "Session-ID is required";
		}
		catch(AvpNotSupportedException ex)
		{
			return ex.getMessage();
		}
		
		return super.validate();
	}
}