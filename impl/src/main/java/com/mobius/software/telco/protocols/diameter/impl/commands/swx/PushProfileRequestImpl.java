package com.mobius.software.telco.protocols.diameter.impl.commands.swx;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swx.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.PPRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPUserData;
import com.mobius.software.telco.protocols.diameter.primitives.swx.PPRFlags;

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
@DiameterCommandImplementation(applicationId = 16777265, commandCode = 305, request = true)
public class PushProfileRequestImpl extends SwxRequestImpl implements PushProfileRequest
{
	private Non3GPPUserData non3GPPUserData;
	
	private PPRFlags pprFlags;
	
	protected PushProfileRequestImpl() 
	{
		super();
	}
	
	public PushProfileRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, String username)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUsername(username);
	}
	
	@Override
	public void setUsername(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Username is required");
		
		try
		{
			super.setUsername(value);
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
	}
	
	@Override
	public Non3GPPUserData getNon3GPPUserData()
	{
		return this.non3GPPUserData;
	}
	
	@Override
	public void setNon3GPPUserData(Non3GPPUserData value)
	{
		this.non3GPPUserData = value;
	}
	 
	@Override
	public Long getPPRFlags()
	{
		if(pprFlags==null)
			return null;

		return pprFlags.getUnsigned();
	}

	@Override
	public void setPPRFlags(Long value)
	{
		if(value == null)
			this.pprFlags = null;
		else
			this.pprFlags = new PPRFlagsImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getUsername() == null)
				return "Username is required";
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
		
		return super.validate();
	}
}