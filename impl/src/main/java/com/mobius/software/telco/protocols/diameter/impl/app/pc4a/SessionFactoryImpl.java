package com.mobius.software.telco.protocols.diameter.impl.app.pc4a;
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
import com.mobius.software.telco.protocols.diameter.app.pc4a.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.pc4a.PC4AClientSession;
import com.mobius.software.telco.protocols.diameter.app.pc4a.PC4AServerSession;
import com.mobius.software.telco.protocols.diameter.app.pc4a.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.pc4a.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeInitialLocationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeNotifyRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeSubscriberInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.UpdateProSeSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	private DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<ClientListener,ServerListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}
	
	@Override
	public PC4AClientSession createClientSession(ProSeInitialLocationInformationRequest request) throws AvpNotSupportedException
	{
		return new PC4AClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AServerSession createServerSession(ProSeInitialLocationInformationRequest request) throws AvpNotSupportedException
	{
		return new PC4AServerSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AClientSession createClientSession(ProSeNotifyRequest request) throws AvpNotSupportedException
	{
		return new PC4AClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AServerSession createServerSession(ProSeNotifyRequest request) throws AvpNotSupportedException
	{
		return new PC4AServerSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	@Override
	public PC4AClientSession createClientSession(ProSeSubscriberInformationRequest request) throws AvpNotSupportedException
	{
		return new PC4AClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AServerSession createServerSession(ProSeSubscriberInformationRequest request) throws AvpNotSupportedException
	{
		return new PC4AServerSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AClientSession createClientSession(ResetRequest request) throws AvpNotSupportedException
	{
		return new PC4AClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AServerSession createServerSession(ResetRequest request) throws AvpNotSupportedException
	{
		return new PC4AServerSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AClientSession createClientSession(UpdateProSeSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new PC4AClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
	
	@Override
	public PC4AServerSession createServerSession(UpdateProSeSubscriberDataRequest request) throws AvpNotSupportedException
	{
		return new PC4AServerSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}
}