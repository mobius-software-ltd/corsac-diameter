package com.mobius.software.telco.protocols.diameter.impl.app.gx;
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

import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.app.gx.AvpFactory;
import com.mobius.software.telco.protocols.diameter.app.gx.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.gx.MessageFactory;
import com.mobius.software.telco.protocols.diameter.app.gx.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.gx.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterProviderImpl;

public class GxProviderImpl extends DiameterProviderImpl<ClientListener, ServerListener, AvpFactory, MessageFactory, SessionFactory>
{
	public GxProviderImpl(DiameterStack stack)
	{
		super(stack, new AvpFactoryImpl(), new MessageFactoryImpl(stack.getIDGenerator()));
		setSessionFactory(new SessionFactoryImpl(this));
	}

	@Override
	public DiameterSession getNewSession(DiameterRequest message)
	{		
		try
		{
			if(message instanceof CreditControlRequest)
				return new GxServerSessionImpl(message.getSessionId(), message.getOriginHost(), message.getOriginRealm(), this);
		}
		catch(DiameterException ex)
		{			
		}
		
		return null;
	}
}