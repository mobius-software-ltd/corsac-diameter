package com.mobius.software.telco.protocols.diameter.impl.app.np;
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
import com.mobius.software.telco.protocols.diameter.app.np.AggregatedRUCIReportClientSession;
import com.mobius.software.telco.protocols.diameter.app.np.AggregatedRUCIReportServerSession;
import com.mobius.software.telco.protocols.diameter.app.np.ModifyUeContextClientSession;
import com.mobius.software.telco.protocols.diameter.app.np.ModifyUeContextServerSession;
import com.mobius.software.telco.protocols.diameter.app.np.NonAggregatedRUCIReportClientSession;
import com.mobius.software.telco.protocols.diameter.app.np.NonAggregatedRUCIReportServerSession;
import com.mobius.software.telco.protocols.diameter.app.np.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.np.AggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.ModifyUeContextRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
	//since we have multiple requests/
	private DiameterProvider<? extends ClientAuthStatelessListener, ? extends ServerAuthStatelessListener,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthStatelessListener, ? extends ServerAuthStatelessListener,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public AggregatedRUCIReportClientSession createClientSession(AggregatedRUCIReportRequest request) throws AvpNotSupportedException
	{
		return new AggregatedRUCIReportClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public AggregatedRUCIReportServerSession createServerSession(AggregatedRUCIReportRequest request) throws AvpNotSupportedException
	{
		return new AggregatedRUCIReportServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public ModifyUeContextClientSession createClientSession(ModifyUeContextRequest request) throws AvpNotSupportedException
	{
		return new ModifyUeContextClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public ModifyUeContextServerSession createServerSession(ModifyUeContextRequest request) throws AvpNotSupportedException
	{
		return new ModifyUeContextServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

	@Override
	public NonAggregatedRUCIReportClientSession createClientSession(NonAggregatedRUCIReportRequest request) throws AvpNotSupportedException
	{
		return new NonAggregatedRUCIReportClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public NonAggregatedRUCIReportServerSession createServerSession(NonAggregatedRUCIReportRequest request) throws AvpNotSupportedException
	{
		return new NonAggregatedRUCIReportServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}

}