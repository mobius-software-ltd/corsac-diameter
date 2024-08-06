package com.mobius.software.telco.protocols.diameter.impl.app.swa;
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
import com.mobius.software.telco.protocols.diameter.app.swa.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.swa.SwaClientSession;
import com.mobius.software.telco.protocols.diameter.app.swa.SwaServerSession;
import com.mobius.software.telco.protocols.diameter.app.swa.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.swa.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.swa.EAPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public SwaClientSession createClientSession(EAPRequest request) throws AvpNotSupportedException
	{
		return new SwaClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}
	
	@Override
	public SwaServerSession createServerSession(EAPRequest request) throws AvpNotSupportedException
	{
		return new SwaServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}

}