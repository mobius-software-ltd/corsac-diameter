package com.mobius.software.telco.protocols.diameter.impl.app.mb2c;
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
import com.mobius.software.telco.protocols.diameter.app.mb2c.Mb2cClientSession;
import com.mobius.software.telco.protocols.diameter.app.mb2c.Mb2cServerSession;
import com.mobius.software.telco.protocols.diameter.app.mb2c.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSActionRequest;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSNotificationRequest;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.MB2CAnswer;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.MB2CRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public class SessionFactoryImpl implements SessionFactory
{
private DiameterProvider<? extends ClientAuthStatelessListener<MB2CRequest>, ? extends ServerAuthStatelessListener<MB2CAnswer>,?, ?, ?> provider;
	
	public SessionFactoryImpl(DiameterProvider<? extends ClientAuthStatelessListener<MB2CRequest>, ? extends ServerAuthStatelessListener<MB2CAnswer>,?, ?, ?> provider)
	{
		this.provider = provider;
	}

	@Override
	public Mb2cClientSession createClientSession(GCSActionRequest request) throws AvpNotSupportedException
	{
		return new Mb2cClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public Mb2cServerSession createServerSession(GCSActionRequest request) throws AvpNotSupportedException
	{
		return new Mb2cServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
	
	@Override
	public Mb2cClientSession createClientSession(GCSNotificationRequest request) throws AvpNotSupportedException
	{
		return new Mb2cClientSessionImpl(request.getSessionId(), request.getDestinationHost(), request.getDestinationRealm(), provider);
	}

	@Override
	public Mb2cServerSession createServerSession(GCSNotificationRequest request) throws AvpNotSupportedException
	{
		return new Mb2cServerSessionImpl(request.getSessionId(), request.getOriginHost(), request.getOriginRealm(), provider);
	}
}