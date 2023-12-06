package com.mobius.software.telco.protocols.diameter.impl.commands.rx;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rx.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AbortCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;

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
@DiameterCommandImplementation(applicationId = 16777236, commandCode = 274, request = true)
public class AbortSessionRequestImpl extends RxRequestImpl implements AbortSessionRequest
{
	private AbortCause abortCause;
	
	protected AbortSessionRequestImpl() 
	{
		super();
		setUsernameAllowed(false);
	}
		
	public AbortSessionRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID,AbortCauseEnum abortCause)
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID);
		setUsernameAllowed(false);
		
		setAbortCause(abortCause);
	}

	@Override
	public AbortCauseEnum getAbortCause() 
	{
		if(abortCause == null)
			return null;
		
		return abortCause.getEnumerated(AbortCauseEnum.class);
	}

	@Override
	public void setAbortCause(AbortCauseEnum value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Abort-Cause is required");	
		
		this.abortCause = new AbortCauseImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(abortCause==null)
			return "Abort-Cause is required";
		
		return super.validate();
	}
}