package com.mobius.software.telco.protocols.diameter.impl.app.slg;
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
import com.mobius.software.telco.protocols.diameter.app.slg.AvpFactory;
import com.mobius.software.telco.protocols.diameter.app.slg.ClientListener;
import com.mobius.software.telco.protocols.diameter.app.slg.MessageFactory;
import com.mobius.software.telco.protocols.diameter.app.slg.ServerListener;
import com.mobius.software.telco.protocols.diameter.app.slg.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.slg.SlgRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterProviderImpl;
/**
*
* @author yulian oifa
*
*/
public class SlgProviderImpl extends DiameterProviderImpl<ClientListener, ServerListener, AvpFactory, MessageFactory, SessionFactory>
{
	public SlgProviderImpl(DiameterStack stack,String packageName)
	{
		super(stack, new AvpFactoryImpl(), new MessageFactoryImpl(stack.getIDGenerator()), packageName);
		setSessionFactory(new SessionFactoryImpl(this));
	}

	@Override
	public DiameterSession getNewSession(DiameterRequest message)
	{		
		try
		{
			if(message instanceof SlgRequest)
				return new SlgServerSessionImpl(message.getSessionId(), message.getOriginHost(), message.getOriginRealm(), this);
		}
		catch(DiameterException ex)
		{			
		}
		
		return null;
	}
}