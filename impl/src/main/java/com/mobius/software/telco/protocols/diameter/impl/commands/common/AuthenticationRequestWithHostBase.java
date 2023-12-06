package com.mobius.software.telco.protocols.diameter.impl.commands.common;

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
public abstract class AuthenticationRequestWithHostBase extends AuthenticationRequestImpl
{
	protected AuthenticationRequestWithHostBase()
	{
		super();
		setDestinationHostAllowed(true);		
	}
	
	public AuthenticationRequestWithHostBase(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId)
	{	
		super(originHost, originRealm, destinationRealm, isRetransmit,sessionID, authApplicationId);
		setDestinationHostAllowed(true);
		try 
		{
			setDestinationHost(destinationHost);
		}
		catch(AvpNotSupportedException ex) 
		{
			
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getDestinationHost()==null)
				return "Destination-Host is required";
		}
		catch(AvpNotSupportedException ex)
		{
			return ex.getMessage();
		}
		
		return super.validate();
	}
}