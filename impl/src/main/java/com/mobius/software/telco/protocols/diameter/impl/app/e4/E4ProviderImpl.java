package com.mobius.software.telco.protocols.diameter.impl.app.e4;
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
import com.mobius.software.telco.protocols.diameter.app.e4.AvpFactory;
import com.mobius.software.telco.protocols.diameter.app.e4.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.e4.MessageFactory;
import com.mobius.software.telco.protocols.diameter.app.e4.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.e4.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.e4.E4Request;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterProviderImpl;

public class E4ProviderImpl extends DiameterProviderImpl<ClientListener, ServerListener, AvpFactory, MessageFactory, SessionFactory>
{
	public E4ProviderImpl(DiameterStack stack,String packageName)
	{
		super(stack, new AvpFactoryImpl(), new MessageFactoryImpl(stack.getIDGenerator()), packageName);
		setSessionFactory(new SessionFactoryImpl(this));
	}

	@Override
	public DiameterSession getNewSession(DiameterRequest message)
	{		
		try
		{
			if(message instanceof E4Request)
				return new E4ServerSessionImpl(message.getSessionId(), message.getOriginHost(), message.getOriginRealm(), this);
		
		}
		catch(DiameterException ex)
		{			
		}
		
		return null;
		}
}