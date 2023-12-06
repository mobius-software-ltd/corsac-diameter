package com.mobius.software.telco.protocols.diameter.impl.commands.swx;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.swx.PushProfileAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;

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
@DiameterCommandImplementation(applicationId = 16777265, commandCode = 305, request = false)
public class PushProfileAnswerImpl extends SwxAnswerImpl implements PushProfileAnswer
{
	private AccessNetworkInfo accessNetworkInfo;
	
	private LocalTimeZone localTimeZone;
	
	protected PushProfileAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public PushProfileAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
    
	@Override
	public AccessNetworkInfo getAccessNetworkInfo()
	{
		return this.accessNetworkInfo;
	}
	
	@Override
	public void setAccessNetworkInfo(AccessNetworkInfo value)
	{
		this.accessNetworkInfo = value;
	}
	
	@Override
	public LocalTimeZone getLocalTimeZone()
	{
		return this.localTimeZone;
	}
	
	@Override
	public void setLocalTimeZone(LocalTimeZone value)
	{
		this.localTimeZone = value;
	}
}