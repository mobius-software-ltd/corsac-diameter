package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerAnswer;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerBase;

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
@DiameterCommandImplementation(applicationId = -1, commandCode = 282, request = false)
public class DisconnectPeerAnswerImpl extends DiameterAnswerBase implements DisconnectPeerAnswer
{
	protected DisconnectPeerAnswerImpl() 
	{
	}
	
	public DisconnectPeerAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode)
	{
		super(originHost, originRealm, isRetransmit, resultCode);
	}
	
	public DisconnectPeerAnswerImpl(String originHost,String originRealm,Boolean isError,Boolean isRetransmit, Long resultCode)
	{
		super(originHost, originRealm, isError, isRetransmit, resultCode);
	}	
}