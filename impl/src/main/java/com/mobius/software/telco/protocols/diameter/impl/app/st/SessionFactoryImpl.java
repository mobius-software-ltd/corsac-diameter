package com.mobius.software.telco.protocols.diameter.impl.app.st;
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
import com.mobius.software.telco.protocols.diameter.app.st.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.st.StClientSession;
import com.mobius.software.telco.protocols.diameter.app.st.StServerSession;
import com.mobius.software.telco.protocols.diameter.app.st.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.st.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.st.TSSFNotificationRequest;
import com.mobius.software.telco.protocols.diameter.commands.st.TDFSessionRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public StClientSession createClientSession(TDFSessionRequest request) throws AvpNotSupportedException
	{
		return new StClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}

	@Override
	public StServerSession createServerSession(TDFSessionRequest request) throws AvpNotSupportedException
	{
		return new StServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}
	
	@Override
	public StClientSession createClientSession(TSSFNotificationRequest request) throws AvpNotSupportedException
	{
		return new StClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(),provider);
	}
	
	@Override
	public StServerSession createServerSession(TSSFNotificationRequest request) throws AvpNotSupportedException
	{
		return new StServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(),provider);
	}

}