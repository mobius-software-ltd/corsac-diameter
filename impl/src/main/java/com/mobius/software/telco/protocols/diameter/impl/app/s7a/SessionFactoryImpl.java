package com.mobius.software.telco.protocols.diameter.impl.app.s7a;
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
import com.mobius.software.telco.protocols.diameter.app.s7a.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.s7a.S7aClientSession;
import com.mobius.software.telco.protocols.diameter.app.s7a.S7aServerSession;
import com.mobius.software.telco.protocols.diameter.app.s7a.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.s7a.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.s7a.CancelVCSGLocationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.DeleteSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.InsertSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.UpdateVCSGLocationRequest;
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
	public S7aClientSession createClientSession(CancelVCSGLocationRequest request) throws AvpNotSupportedException
	{
		return new S7aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S7aServerSession createServerSession(CancelVCSGLocationRequest request) throws AvpNotSupportedException
	{
		return new S7aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S7aClientSession createClientSession(DeleteSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S7aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S7aServerSession createServerSession(DeleteSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S7aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S7aClientSession createClientSession(InsertSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S7aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S7aServerSession createServerSession(InsertSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new S7aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S7aClientSession createClientSession(UpdateVCSGLocationRequest request) throws AvpNotSupportedException
	{
		return new S7aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S7aServerSession createServerSession(UpdateVCSGLocationRequest request) throws AvpNotSupportedException
	{
		return new S7aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public S7aClientSession createClientSession(ResetRequest request) throws AvpNotSupportedException
	{
		return new S7aClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public S7aServerSession createServerSession(ResetRequest request) throws AvpNotSupportedException
	{
		return new S7aServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

}