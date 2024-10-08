package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

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
public abstract class AuthenticationRequestWithHostImpl extends AuthenticationRequestImpl
{
	protected AuthenticationRequestWithHostImpl()
	{
		super();	
	}
	
	public AuthenticationRequestWithHostImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{	
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit,sessionID);			
	}
	
	public AuthenticationRequestWithHostImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException
	{	
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit,sessionID, authApplicationId);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(destinationHost==null)
			return new MissingAvpException("Destination-Host is required", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl() }));
		
		return super.validate();
	}
}