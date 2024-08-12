package com.mobius.software.telco.protocols.diameter.impl.app.cxdx;
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
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxServerSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.CxDxAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.CxDxRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
/**
*
* @author yulian oifa
*
*/
public class SessionFactoryImpl implements SessionFactory
{
	//since we have multiple requests/
	private DiameterProvider<? extends ClientAuthStatelessListener<CxDxRequest,CxDxAnswer>, ? extends ServerAuthStatelessListener<CxDxRequest,CxDxAnswer>,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthStatelessListener<CxDxRequest,CxDxAnswer>, ? extends ServerAuthStatelessListener<CxDxRequest,CxDxAnswer>,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public CxDxClientSession createClientSession(LocationInfoRequest request) throws AvpNotSupportedException
	{
		return new CxDxClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxServerSession createServerSession(LocationInfoRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxClientSession createClientSession(MultimediaAuthRequest request) throws AvpNotSupportedException
	{
		return new CxDxClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxServerSession createServerSession(MultimediaAuthRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxClientSession createClientSession(PushProfileRequest request) throws AvpNotSupportedException
	{
		return new CxDxClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxServerSession createServerSession(PushProfileRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxClientSession createClientSession(RegistrationTerminationRequest request) throws AvpNotSupportedException
	{
		return new CxDxClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxServerSession createServerSession(RegistrationTerminationRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxClientSession createClientSession(ServerAssignmentRequest request) throws AvpNotSupportedException
	{
		return new CxDxClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxServerSession createServerSession(ServerAssignmentRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxClientSession createClientSession(UserAuthorizationRequest request) throws AvpNotSupportedException
	{
		return new CxDxClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxServerSession createServerSession(UserAuthorizationRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}