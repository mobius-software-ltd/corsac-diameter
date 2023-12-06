package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.s6a.DeleteSubscriberDataAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DSAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSAFlags;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 320, request = false)
public class DeleteSubscriberDataAnswerImpl extends S6aAnswerImpl implements DeleteSubscriberDataAnswer
{
	private DSAFlags dsaFlags;
	
	protected DeleteSubscriberDataAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public DeleteSubscriberDataAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	@Override
	public Long getDSAFlags()
	{
		if(dsaFlags==null)
			return null;
		
		return dsaFlags.getUnsigned();
	}
	
	@Override
	public void setDSAFlags(Long value)
	{
		if(value==null)
			this.dsaFlags = null;
		else
			this.dsaFlags = new DSAFlagsImpl(value, null, null);
	}
}