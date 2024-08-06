package com.mobius.software.telco.protocols.diameter.impl.app.sd;
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
import com.mobius.software.telco.protocols.diameter.app.sd.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.sd.SdClientSession;
import com.mobius.software.telco.protocols.diameter.app.sd.SdServerSession;
import com.mobius.software.telco.protocols.diameter.app.sd.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.sd.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.sd.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.TDFSessionRequest;
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
	public SdClientSession createClientSession(TDFSessionRequest request) throws AvpNotSupportedException
	{
		return new SdClientSessionImpl(false, request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public SdServerSession createServerSession(TDFSessionRequest request) throws AvpNotSupportedException
	{
		return new SdServerSessionImpl(false, request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public SdClientSession createClientSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new SdClientSessionImpl(true, request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public SdServerSession createServerSession(CreditControlRequest request) throws AvpNotSupportedException
	{
		return new SdServerSessionImpl(true, request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
}