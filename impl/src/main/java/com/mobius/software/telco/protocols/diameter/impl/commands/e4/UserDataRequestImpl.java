package com.mobius.software.telco.protocols.diameter.impl.commands.e4;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.e4.UserDataRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFApplicationIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFApplicationIdentifier;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777231, commandCode = 306, request = true)
public class UserDataRequestImpl extends E4RequestImpl implements UserDataRequest
{
	private GloballyUniqueAddress globallyUniqueAddress;
	
	private AFApplicationIdentifier afApplicationIdentifier;
	
	protected UserDataRequestImpl() 
	{
		super();
	}
	
	public UserDataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
	}
	
	public GloballyUniqueAddress getGloballyUniqueAddress()
	{
		return this.globallyUniqueAddress;
	}
	
	public void setGloballyUniqueAddress(GloballyUniqueAddress value)
	{
		this.globallyUniqueAddress = value;
	}
		
	public ByteBuf getAFApplicationIdentifier()
	{
		if(afApplicationIdentifier == null)
			return null;
		
		return afApplicationIdentifier.getValue();
	}
	
	public void setAFApplicationIdentifier(ByteBuf value)
	{
		if(value == null)
			this.afApplicationIdentifier = null;
		else
			this.afApplicationIdentifier = new AFApplicationIdentifierImpl(value, null, null);
	}
}