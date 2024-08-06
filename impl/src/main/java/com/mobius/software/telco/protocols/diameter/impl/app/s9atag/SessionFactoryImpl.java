package com.mobius.software.telco.protocols.diameter.impl.app.s9atag;
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
import com.mobius.software.telco.protocols.diameter.app.ClientCCListener;
import com.mobius.software.telco.protocols.diameter.app.ServerCCListener;
import com.mobius.software.telco.protocols.diameter.app.s9atag.S9atagClientSession;
import com.mobius.software.telco.protocols.diameter.app.s9atag.S9atagServerSession;
import com.mobius.software.telco.protocols.diameter.app.s9atag.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<? extends ClientCCListener<CreditControlRequest,CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ? extends ServerCCListener<CreditControlRequest,CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientCCListener<CreditControlRequest,CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ? extends ServerCCListener<CreditControlRequest,CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public S9atagClientSession createClientSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new S9atagClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S9atagServerSession createServerSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new S9atagServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}