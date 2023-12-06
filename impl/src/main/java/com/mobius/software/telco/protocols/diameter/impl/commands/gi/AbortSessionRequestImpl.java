package com.mobius.software.telco.protocols.diameter.impl.commands.gi;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPNSAPIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPNSAPI;

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
@DiameterCommandImplementation(applicationId = 1, commandCode = 274, request = true)
public class AbortSessionRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AbortSessionRequestmpl implements AbortSessionRequest
{
	private TGPPNSAPI tgppNSAPI;
	
	protected AbortSessionRequestImpl() 
	{
		super();
		setUsernameAllowed(false);
	}
		
	public AbortSessionRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID)
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID);
		setUsernameAllowed(false);
	}

	@Override
	public ByteBuf getTGPPNSAPI() 
	{
		if(tgppNSAPI == null)
			return null;
		
		return tgppNSAPI.getValue();
	}

	@Override
	public void setTGPPNSAPI(ByteBuf value) 
	{
		if(value == null)
			this.tgppNSAPI = null;
		else
			this.tgppNSAPI = new TGPPNSAPIImpl(value, null, null);
	}
}