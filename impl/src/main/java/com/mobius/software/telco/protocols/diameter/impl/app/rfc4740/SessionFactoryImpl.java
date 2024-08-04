package com.mobius.software.telco.protocols.diameter.impl.app.rfc4740;
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
import com.mobius.software.telco.protocols.diameter.app.rfc4740.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.rfc4740.Rfc4740ClientSession;
import com.mobius.software.telco.protocols.diameter.app.rfc4740.Rfc4740ServerSession;
import com.mobius.software.telco.protocols.diameter.app.rfc4740.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.rfc4740.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public Rfc4740ClientSession createClientSession(LocationInfoRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public Rfc4740ServerSession createServerSession(LocationInfoRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
	
	@Override
	public Rfc4740ClientSession createClientSession(MultimediaAuthRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public Rfc4740ServerSession createServerSession(MultimediaAuthRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
	
	@Override
	public Rfc4740ClientSession createClientSession(PushProfileRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public Rfc4740ServerSession createServerSession(PushProfileRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
	
	@Override
	public Rfc4740ClientSession createClientSession(RegistrationTerminationRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public Rfc4740ServerSession createServerSession(RegistrationTerminationRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
	
	@Override
	public Rfc4740ClientSession createClientSession(ServerAssignmentRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public Rfc4740ServerSession createServerSession(ServerAssignmentRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
	
	@Override
	public Rfc4740ClientSession createClientSession(UserAuthorizationRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public Rfc4740ServerSession createServerSession(UserAuthorizationRequest request) throws AvpNotSupportedException
	{
		return new Rfc4740ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}

}