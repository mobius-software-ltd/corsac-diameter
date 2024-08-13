package com.mobius.software.telco.protocols.diameter.impl.app.rf;
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
import com.mobius.software.telco.protocols.diameter.app.rf.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.rf.RfClientSession;
import com.mobius.software.telco.protocols.diameter.app.rf.RfServerSession;
import com.mobius.software.telco.protocols.diameter.app.rf.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.rf.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
/**
*
* @author yulian oifa
*
*/
public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener, ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener, ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public RfClientSession createClientSession(AccountingRequest request) throws AvpNotSupportedException
	{
		return new RfClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public RfServerSession createServerSession(AccountingRequest request) throws AvpNotSupportedException
	{
		return new RfServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}