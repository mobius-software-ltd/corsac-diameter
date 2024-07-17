package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationHostImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public abstract class CxDxRequestWithHostBase extends CxDxRequestImpl
{
	protected CxDxRequestWithHostBase()
	{
		super();
	}
	
	public CxDxRequestWithHostBase(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{	
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit,sessionID,authSessionState);
		
		setDestinationHost(destinationHost);		
	}
	
	@Override
	public void setDestinationHost(String value) throws AvpNotSupportedException, MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Destination-Host is required", Arrays.asList(new DiameterAvp[] { new DestinationHostImpl()}));;
		
		this.destinationHost = new DestinationHostImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(destinationHost==null)
			return new MissingAvpException("Destination-Host is required", Arrays.asList(new DiameterAvp[] { new DestinationHostImpl()}));
					
		return super.validate();
	}
}