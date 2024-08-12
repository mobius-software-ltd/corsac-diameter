package com.mobius.software.telco.protocols.diameter.impl.app.nt;
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
import com.mobius.software.telco.protocols.diameter.app.nt.NtClientSession;
import com.mobius.software.telco.protocols.diameter.app.nt.NtServerSession;
import com.mobius.software.telco.protocols.diameter.app.nt.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.nt.BackgroundDataTransferRequest;
import com.mobius.software.telco.protocols.diameter.commands.nt.NtAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nt.NtRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	//since we have multiple requests/
	private DiameterProvider<? extends ClientAuthStatelessListener<NtRequest,NtAnswer>, ? extends ServerAuthStatelessListener<NtRequest,NtAnswer>,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthStatelessListener<NtRequest,NtAnswer>, ? extends ServerAuthStatelessListener<NtRequest,NtAnswer>,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public NtClientSession createClientSession(BackgroundDataTransferRequest request) throws AvpNotSupportedException
	{
		return new NtClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public NtServerSession createServerSession(BackgroundDataTransferRequest request) throws AvpNotSupportedException
	{
		return new NtServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

}