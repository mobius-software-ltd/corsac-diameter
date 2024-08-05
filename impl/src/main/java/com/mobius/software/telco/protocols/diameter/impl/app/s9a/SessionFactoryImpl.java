package com.mobius.software.telco.protocols.diameter.impl.app.s9a;
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
import com.mobius.software.telco.protocols.diameter.app.s9a.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.s9a.S9aClientSession;
import com.mobius.software.telco.protocols.diameter.app.s9a.S9aServerSession;
import com.mobius.software.telco.protocols.diameter.app.s9a.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.s9a.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.s9a.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9a.TriggerEstablishmentRequest;
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
	public S9aClientSession createClientSession(TriggerEstablishmentRequest request) throws AvpNotSupportedException
	{
		return new S9aClientSessionImpl(false, request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S9aServerSession createServerSession(TriggerEstablishmentRequest request) throws AvpNotSupportedException
	{
		return new S9aServerSessionImpl(false, request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public S9aClientSession createClientSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new S9aClientSessionImpl(true, request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public S9aServerSession createServerSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new S9aServerSessionImpl(true, request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
}