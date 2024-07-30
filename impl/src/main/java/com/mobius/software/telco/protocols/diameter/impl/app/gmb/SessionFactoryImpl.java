package com.mobius.software.telco.protocols.diameter.impl.app.gmb;
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
import com.mobius.software.telco.protocols.diameter.app.gmb.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.gmb.GMBAuthClientSession;
import com.mobius.software.telco.protocols.diameter.app.gmb.GMBAuthServerSession;
import com.mobius.software.telco.protocols.diameter.app.gmb.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.gmb.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.gmb.AARequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public GMBAuthClientSession createClientSession(AARequest request) throws AvpNotSupportedException
	{
		return new GMBAuthClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public GMBAuthServerSession createServerSession(AARequest request) throws AvpNotSupportedException
	{
		return new GMBAuthServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
}