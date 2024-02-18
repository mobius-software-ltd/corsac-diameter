package com.mobius.software.telco.protocols.diameter.impl.commands;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionIdImpl;
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
public abstract class DiameterRequestWithSessionAndRealmBase extends DiameterRequestBase
{
	protected DiameterRequestWithSessionAndRealmBase()
	{
		super();
	}
	
	public DiameterRequestWithSessionAndRealmBase(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID) throws AvpNotSupportedException, MissingAvpException
	{	
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit);
		
		setSessionId(sessionID);
		
		setDestinationRealm(destinationRealm);		
	}

	@Override
	public void setSessionId(String value) throws AvpNotSupportedException, MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Session-ID is required", Arrays.asList(new DiameterAvp[] { new SessionIdImpl() }));
		
		super.setSessionId(value);
	}	

	@Override
	public void setDestinationRealm(String value) throws AvpNotSupportedException, MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Destination-Realm is required", Arrays.asList(new DiameterAvp[] { new DestinationRealmImpl() }));
		
		super.setDestinationRealm(value);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(sessionId==null)
			return new MissingAvpException("Session-ID is required", Arrays.asList(new DiameterAvp[] { new SessionIdImpl() }));
		
		if(destinationRealm==null)
			return new MissingAvpException("Destination-Realm is required", Arrays.asList(new DiameterAvp[] { new DestinationRealmImpl() }));
		
		return super.validate();
	}
}