package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeDiscoveryAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.DiscoveryEntryIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthResponse;
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
@DiameterCommandImplementation(applicationId = 16777340, commandCode = 8388669, request = false)
public class ProSeDiscoveryAnswerImpl extends Pc6AnswerImpl implements ProSeDiscoveryAnswer
{
	private DiscoveryAuthResponse discoveryAuthResponse;
	 
	private DiscoveryEntryID discoveryEntryID;
	 
	protected ProSeDiscoveryAnswerImpl() 
	{
		super();
	}
	
	public ProSeDiscoveryAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
	}
	
	@Override
	public DiscoveryAuthResponse getDiscoveryAuthResponse()
	{
		return this.discoveryAuthResponse;
	}
	 
	@Override
	public void setDiscoveryAuthResponse(DiscoveryAuthResponse value)
	{
		this.discoveryAuthResponse = value;
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
		if(value==null)
			this.discoveryEntryID = null;
		else
			this.discoveryEntryID = new DiscoveryEntryIDImpl(value, null, null);
	}
}