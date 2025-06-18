package com.mobius.software.telco.protocols.diameter.impl.app.rx;
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
import com.mobius.software.telco.protocols.diameter.app.rx.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.rx.SessionFactory;
import com.mobius.software.telco.protocols.diameter.app.rx.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.rx.RxClientSession;
import com.mobius.software.telco.protocols.diameter.app.rx.RxServerSession;
import com.mobius.software.telco.protocols.diameter.commands.rx.AARequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public RxClientSession createClientSession(AARequest request) throws AvpNotSupportedException
	{
		return new RxClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public RxServerSession createServerSession(AARequest request) throws AvpNotSupportedException
	{
		return new RxServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
}