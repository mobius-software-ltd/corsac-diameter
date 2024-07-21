package com.mobius.software.telco.protocols.diameter.impl.app.gi;
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
import com.mobius.software.telco.protocols.diameter.app.gi.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.gi.GiClientSession;
import com.mobius.software.telco.protocols.diameter.app.gi.GiServerSession;
import com.mobius.software.telco.protocols.diameter.app.gi.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.gi.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.gi.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
/**
*
* @author yulian oifa
*
*/
public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public GiClientSession createClientSession(AccountingRequest request) throws AvpNotSupportedException
	{
		return new GiClientSessionImpl(false, request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public GiServerSession createServerSession(AccountingRequest request) throws AvpNotSupportedException
	{
		return new GiServerSessionImpl(false, request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public GiClientSession createClientSession(AARequest request) throws AvpNotSupportedException
	{
		return new GiClientSessionImpl(true, request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public GiServerSession createServerSession(AARequest request) throws AvpNotSupportedException
	{
		return new GiServerSessionImpl(true, request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
}