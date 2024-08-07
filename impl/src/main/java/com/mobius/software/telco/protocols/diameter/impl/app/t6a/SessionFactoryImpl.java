package com.mobius.software.telco.protocols.diameter.impl.app.t6a;
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
import com.mobius.software.telco.protocols.diameter.app.t6a.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.t6a.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.t6a.SessionFactory;
import com.mobius.software.telco.protocols.diameter.app.t6a.T6aClientSession;
import com.mobius.software.telco.protocols.diameter.app.t6a.T6aServerSession;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConfigurationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConnectionManagementRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MODataRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MTDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ReportingInformationRequest;
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
	public T6aClientSession createClientSession(ConfigurationInformationRequest request) throws AvpNotSupportedException
	{
		return new T6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public T6aServerSession createServerSession(ConfigurationInformationRequest request) throws AvpNotSupportedException
	{
		return new T6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public T6aClientSession createClientSession(ConnectionManagementRequest request) throws AvpNotSupportedException
	{
		return new T6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public T6aServerSession createServerSession(ConnectionManagementRequest request) throws AvpNotSupportedException
	{
		return new T6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public T6aClientSession createClientSession(MODataRequest request) throws AvpNotSupportedException
	{
		return new T6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public T6aServerSession createServerSession(MODataRequest request) throws AvpNotSupportedException
	{
		return new T6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public T6aClientSession createClientSession(MTDataRequest request) throws AvpNotSupportedException
	{
		return new T6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public T6aServerSession createServerSession(MTDataRequest request) throws AvpNotSupportedException
	{
		return new T6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public T6aClientSession createClientSession(ReportingInformationRequest request) throws AvpNotSupportedException
	{
		return new T6aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public T6aServerSession createServerSession(ReportingInformationRequest request) throws AvpNotSupportedException
	{
		return new T6aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
}