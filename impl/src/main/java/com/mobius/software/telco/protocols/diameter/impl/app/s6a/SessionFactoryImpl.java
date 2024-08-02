package com.mobius.software.telco.protocols.diameter.impl.app.s6a;
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
import com.mobius.software.telco.protocols.diameter.app.s6a.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.s6a.S6aClientSession;
import com.mobius.software.telco.protocols.diameter.app.s6a.S6aServerSession;
import com.mobius.software.telco.protocols.diameter.app.s6a.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.s6a.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.s6a.AuthenticationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.CancelLocationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.DeleteSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.InsertSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.NotifyRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.PurgeUERequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.UpdateLocationRequest;
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
	public S6aClientSession createClientSession(AuthenticationInformationRequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(AuthenticationInformationRequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S6aClientSession createClientSession(CancelLocationRequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(CancelLocationRequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S6aClientSession createClientSession(DeleteSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(DeleteSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S6aClientSession createClientSession(InsertSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(InsertSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S6aClientSession createClientSession(NotifyRequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(NotifyRequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S6aClientSession createClientSession(PurgeUERequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(PurgeUERequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S6aClientSession createClientSession(ResetRequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(ResetRequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S6aClientSession createClientSession(UpdateLocationRequest request) throws AvpNotSupportedException
	{
		return new S6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S6aServerSession createServerSession(UpdateLocationRequest request) throws AvpNotSupportedException
	{
		return new S6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}