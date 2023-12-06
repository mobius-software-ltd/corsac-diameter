package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeDiscoveryRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.DiscoveryEntryIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryEntryID;

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
@DiameterCommandImplementation(applicationId = 16777340, commandCode = 8388669, request = true)
public class ProSeDiscoveryRequestImpl extends Pc6RequestImpl implements ProSeDiscoveryRequest
{
	private DiscoveryAuthRequest discoveryAuthRequest;
	
	private DiscoveryEntryID discoveryEntryID;
	
	protected ProSeDiscoveryRequestImpl() 
	{
		super();
	}
	
	public ProSeDiscoveryRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,DiscoveryAuthRequest discoveryAuthRequest)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setDiscoveryAuthRequest(discoveryAuthRequest);
	}
	
	@Override	
	public DiscoveryAuthRequest getDiscoveryAuthRequest()
	{
		return discoveryAuthRequest;
	}
	 
	@Override	
	public void setDiscoveryAuthRequest(DiscoveryAuthRequest value)
	{
		if(value == null)
			throw new IllegalArgumentException("Discovery-Auth-Request is required");
		
		this.discoveryAuthRequest = value;
	}
	
	@Override	
	public Long getDiscoveryEntryID()
	{
		if(discoveryEntryID == null)
			return null;
		
		return discoveryEntryID.getUnsigned();
	}
	
	@Override	
	public void setDiscoveryEntryID(Long value)
	{
		if(value == null)
			this.discoveryEntryID = null;
		else
			this.discoveryEntryID = new DiscoveryEntryIDImpl(value, null, null);
	}
		
	@DiameterValidate
	public String validate()
	{
		if(discoveryAuthRequest == null)
			return "Discovery-Auth-Request is required";
		
		return super.validate();
	}	
}