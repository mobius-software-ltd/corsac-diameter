package com.mobius.software.telco.protocols.diameter.impl.app.t4;
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
import com.mobius.software.telco.protocols.diameter.app.t4.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.t4.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.t4.SessionFactory;
import com.mobius.software.telco.protocols.diameter.app.t4.T4ClientSession;
import com.mobius.software.telco.protocols.diameter.app.t4.T4ServerSession;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeliveryReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeviceTriggerRequest;
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
	public T4ClientSession createClientSession(DeliveryReportRequest request) throws AvpNotSupportedException
	{
		return new T4ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public T4ServerSession createServerSession(DeliveryReportRequest request) throws AvpNotSupportedException
	{
		return new T4ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public T4ClientSession createClientSession(DeviceTriggerRequest request) throws AvpNotSupportedException
	{
		return new T4ClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public T4ServerSession createServerSession(DeviceTriggerRequest request) throws AvpNotSupportedException
	{
		return new T4ServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	
	
}