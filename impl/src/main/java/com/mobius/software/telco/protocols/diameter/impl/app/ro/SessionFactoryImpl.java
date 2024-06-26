package com.mobius.software.telco.protocols.diameter.impl.app.ro;
/*
 * Mobius Software LTD
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

import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthListener;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthListener;
import com.mobius.software.telco.protocols.diameter.app.ro.RoClientSession;
import com.mobius.software.telco.protocols.diameter.app.ro.RoServerSession;
import com.mobius.software.telco.protocols.diameter.app.ro.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.ro.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.ro.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.ro.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.ro.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.ro.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
/**
*
* @author yulian oifa
*
*/
public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<? extends ClientAuthListener<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>, ? extends ServerAuthListener<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthListener<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>, ? extends ServerAuthListener<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public RoClientSession createClientSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new RoClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public RoServerSession createServerSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new RoServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}