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
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxLocationInfoClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxLocationInfoServerSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxMultimediaAuthClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxMultimediaAuthServerSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxPushProfileClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxPushProfileServerSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxRegistrationTerminationClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxRegistrationTerminationServerSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxServerAssignmentClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxServerAssignmentServerSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxUserAuthorizationClientSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.CxDxUserAuthorizationServerSession;
import com.mobius.software.telco.protocols.diameter.app.cxdx.SessionFactory;
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
	private DiameterProvider<? extends ClientAuthStatelessListener, ? extends ServerAuthStatelessListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthStatelessListener, ? extends ServerAuthStatelessListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public CxDxLocationInfoClientSession createClientSession(LocationInfoRequest request) throws AvpNotSupportedException
	{
		return new CxDxLocationInfoClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxLocationInfoServerSession createServerSession(LocationInfoRequest request) throws AvpNotSupportedException
	{
		return new CxDxLocationInfoServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxMultimediaAuthClientSession createClientSession(MultimediaAuthRequest request) throws AvpNotSupportedException
	{
		return new CxDxMultimediaAuthClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxMultimediaAuthServerSession createServerSession(MultimediaAuthRequest request) throws AvpNotSupportedException
	{
		return new CxDxMultimediaAuthServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxPushProfileClientSession createClientSession(PushProfileRequest request) throws AvpNotSupportedException
	{
		return new CxDxPushProfileClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxPushProfileServerSession createServerSession(PushProfileRequest request) throws AvpNotSupportedException
	{
		return new CxDxPushProfileServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxRegistrationTerminationClientSession createClientSession(RegistrationTerminationRequest request) throws AvpNotSupportedException
	{
		return new CxDxRegistrationTerminationClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxRegistrationTerminationServerSession createServerSession(RegistrationTerminationRequest request) throws AvpNotSupportedException
	{
		return new CxDxRegistrationTerminationServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxServerAssignmentClientSession createClientSession(ServerAssignmentRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerAssignmentClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxServerAssignmentServerSession createServerSession(ServerAssignmentRequest request) throws AvpNotSupportedException
	{
		return new CxDxServerAssignmentServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public CxDxUserAuthorizationClientSession createClientSession(UserAuthorizationRequest request) throws AvpNotSupportedException
	{
		return new CxDxUserAuthorizationClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public CxDxUserAuthorizationServerSession createServerSession(UserAuthorizationRequest request) throws AvpNotSupportedException
	{
		return new CxDxUserAuthorizationServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}