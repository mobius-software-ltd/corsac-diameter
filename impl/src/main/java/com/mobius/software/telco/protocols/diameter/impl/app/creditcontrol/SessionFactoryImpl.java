package com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.app.creditcontrol.CreditControlClientSession;
import com.mobius.software.telco.protocols.diameter.app.creditcontrol.CreditControlServerSession;
import com.mobius.software.telco.protocols.diameter.app.creditcontrol.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<? extends ClientAuthListener<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>, ? extends ServerAuthListener<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthListener<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>, ? extends ServerAuthListener<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public CreditControlClientSession createClientSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new CreditControlClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CreditControlServerSession createServerSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new CreditControlServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}