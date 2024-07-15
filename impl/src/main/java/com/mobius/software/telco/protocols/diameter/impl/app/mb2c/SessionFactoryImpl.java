package com.mobius.software.telco.protocols.diameter.impl.app.mb2c;
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
import com.mobius.software.telco.protocols.diameter.app.mb2c.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.mb2c.GCSActionClientSession;
import com.mobius.software.telco.protocols.diameter.app.mb2c.GCSActionServerSession;
import com.mobius.software.telco.protocols.diameter.app.mb2c.GCSNotificationClientSession;
import com.mobius.software.telco.protocols.diameter.app.mb2c.GCSNotificationServerSession;
import com.mobius.software.telco.protocols.diameter.app.mb2c.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.mb2c.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSActionRequest;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSNotificationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public GCSActionClientSession createClientSession(GCSActionRequest request) throws AvpNotSupportedException
	{
		return new GCSActionClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public GCSActionServerSession createServerSession(GCSActionRequest request) throws AvpNotSupportedException
	{
		return new GCSActionServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public GCSNotificationClientSession createClientSession(GCSNotificationRequest request) throws AvpNotSupportedException
	{
		return new GCSNotificationClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public GCSNotificationServerSession createServerSession(GCSNotificationRequest request) throws AvpNotSupportedException
	{
		return new GCSNotificationServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}