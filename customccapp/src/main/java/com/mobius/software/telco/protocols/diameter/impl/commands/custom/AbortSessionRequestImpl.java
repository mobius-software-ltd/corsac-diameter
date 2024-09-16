package com.mobius.software.telco.protocols.diameter.impl.commands.custom;

import com.mobius.software.telco.protocols.diameter.commands.custom.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;

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


public class AbortSessionRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.AbortSessionRequestImpl implements AbortSessionRequest
{
	protected AbortSessionRequestImpl() 
	{
		super();
		
		setDestinationHostRequired(true);
	}
		
	public AbortSessionRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID);
		
		setDestinationHostRequired(true);
		setDestinationHost(destinationHost);
	}
}