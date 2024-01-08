package com.mobius.software.telco.protocols.diameter.impl.commands.e4;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.e4.E4Request;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.VendorSpecificRequestmpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

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
public abstract class E4RequestImpl extends VendorSpecificRequestmpl implements E4Request
{
	protected AuthSessionState authSessionState;
	
	protected E4RequestImpl() 
	{
		super();
		setDestinationHostAllowed(true);
	}
		
	public E4RequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessonID, AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm,destinationRealm, isRetransmit, sessonID);
		setDestinationHostAllowed(true);
		try 
		{
			setDestinationHost(destinationHost);
		}
		catch(AvpNotSupportedException ex) 
		{
			
		}
		
		setAuthSessionState(authSessionState);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState==null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Auth-Session-State is required");
		
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authSessionState == null)
			return "Auth-Session-State is required";
		
		return super.validate();
	}
}