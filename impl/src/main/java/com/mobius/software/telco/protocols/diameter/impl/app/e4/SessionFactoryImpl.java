package com.mobius.software.telco.protocols.diameter.impl.app.e4;
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
import com.mobius.software.telco.protocols.diameter.app.ClientAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.e4.E4ClientSession;
import com.mobius.software.telco.protocols.diameter.app.e4.E4ServerSession;
import com.mobius.software.telco.protocols.diameter.app.e4.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.e4.E4Answer;
import com.mobius.software.telco.protocols.diameter.commands.e4.E4Request;
import com.mobius.software.telco.protocols.diameter.commands.e4.PushNotificationRequest;
import com.mobius.software.telco.protocols.diameter.commands.e4.UserDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	//since we have multiple requests/
	private DiameterProvider<? extends ClientAuthStatelessListener<E4Request,E4Answer>, ? extends ServerAuthStatelessListener<E4Request,E4Answer>,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthStatelessListener<E4Request,E4Answer>, ? extends ServerAuthStatelessListener<E4Request,E4Answer>,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public E4ClientSession createClientSession(PushNotificationRequest request) throws AvpNotSupportedException
	{
		return new E4ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public E4ServerSession createServerSession(PushNotificationRequest request) throws AvpNotSupportedException
	{
		return new E4ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public E4ClientSession createClientSession(UserDataRequest request) throws AvpNotSupportedException
	{
		return new E4ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public E4ServerSession createServerSession(UserDataRequest request) throws AvpNotSupportedException
	{
		return new E4ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}
