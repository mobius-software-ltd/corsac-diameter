package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterMessageBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DisconnectCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCauseEnum;

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
@DiameterCommandImplementation(applicationId = 0, commandCode = 282, request = true)
public class DisconnectPeerRequestmpl extends DiameterMessageBase implements DisconnectPeerRequest
{
	private DisconnectCause disconnectCause;
	
	protected DisconnectPeerRequestmpl() 
	{
		super();
		setSessionIdAllowed(false);
		setProxyInfoAllowed(false);
		setUsernameAllowed(false);
		setOriginStateIdAllowedAllowed(false);
	}
		
	public DisconnectPeerRequestmpl(String originHost,String originRealm,Boolean isRetransmit, DisconnectCauseEnum disconnectCause)
	{
		super(originHost, originRealm, isRetransmit);
		setSessionIdAllowed(false);
		setProxyInfoAllowed(false);
		setUsernameAllowed(false);
		setOriginStateIdAllowedAllowed(false);
		
		if(disconnectCause==null)
			throw new IllegalArgumentException("Disconnect-Cause is required");
	
		this.disconnectCause = new DisconnectCauseImpl(disconnectCause, null, null);				
	}

	@Override
	public DisconnectCauseEnum getDisconnectCause() 
	{
		if(this.disconnectCause == null)			
			return null;
		
		return this.disconnectCause.getEnumerated(DisconnectCauseEnum.class);
	}

	@Override
	public void setDisconnectCause(DisconnectCauseEnum value) 
	{
		if(disconnectCause==null)
			throw new IllegalArgumentException("Disconnect-Cause is required");
	
		this.disconnectCause = new DisconnectCauseImpl(value, null, null);	
	}		
	
	@DiameterValidate
	public String validate()
	{
		if(disconnectCause==null)
			return "Disconnect-Cause is required";
	
		return super.validate();
	}
}