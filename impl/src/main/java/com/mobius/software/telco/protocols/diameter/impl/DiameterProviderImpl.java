package com.mobius.software.telco.protocols.diameter.impl;
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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.SessionListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;

/**
*
* @author yulian oifa
*
*/
public abstract class DiameterProviderImpl<L1 extends SessionListener, L2 extends SessionListener, A, M, F> implements DiameterProvider<L1, L2, A, M, F>
{
	private ConcurrentHashMap<ClusteredID<?>,L1> clientListenersMap=new ConcurrentHashMap<ClusteredID<?>,L1>();
	private ConcurrentHashMap<ClusteredID<?>,L2> serverListenersMap=new ConcurrentHashMap<ClusteredID<?>,L2>();
	
	private A avpFactory;
	private M messageFactory;
	private F sessionFactory;
	private DiameterStack stack;
	
	public DiameterProviderImpl(DiameterStack stack,A avpFactory,M messageFactory)
	{
		this.stack=stack;
		this.avpFactory=avpFactory;
		this.messageFactory=messageFactory;
	}
	
	protected void setSessionFactory(F factory)
	{
		this.sessionFactory=factory;
	}

	@Override
	public A getAvpFactory()
	{
		return avpFactory;
	}

	@Override
	public M getMessageFactory()
	{
		return messageFactory;
	}

	@Override
	public F getSessionFactory()
	{
		return sessionFactory;
	}

	@Override
	public void setClientListener(ClusteredID<?> listenerID, L1 listener)
	{
		clientListenersMap.put(listenerID, listener);
	}

	@Override
	public void removeClientListener(ClusteredID<?> listenerID)
	{
		clientListenersMap.remove(listenerID);
	}

	@Override
	public Map<ClusteredID<?>, L1> getClientListeners()
	{
		return clientListenersMap;
	}

	@Override
	public void setServerListener(ClusteredID<?> listenerID, L2 listener)
	{
		serverListenersMap.put(listenerID, listener);
	}

	@Override
	public void removeServerListener(ClusteredID<?> listenerID)
	{
		serverListenersMap.remove(listenerID);
	}

	@Override
	public Map<ClusteredID<?>, L2> getServerListeners()
	{
		return serverListenersMap;
	}

	@Override
	public DiameterStack getStack()
	{
		return stack;
	}

	@Override
	public void onMessage(DiameterMessage message, AsyncCallback callback)
	{
		String sessionID = null;
		try
		{
			sessionID = message.getSessionId();
		}
		catch(DiameterException ex)
		{
			callback.onError(ex);
			return;
		}
		
		if(sessionID == null)
		{
			callback.onError(new DiameterException("Session with this ID not found", null, ResultCodes.DIAMETER_UNKNOWN_SESSION_ID, null));
			return;
		}
		
		DiameterSession session = this.getStack().getSessionStorage().getSession(sessionID);
		if(session==null && (message instanceof DiameterRequest))
		{
			session=getNewSession((DiameterRequest)message);
			if(session!=null)
				getStack().getSessionStorage().storeSession(session);
		}
		
		if(session==null)
		{
			callback.onError(new DiameterException("Session with this ID not found", null, ResultCodes.DIAMETER_UNKNOWN_SESSION_ID, null));
			return;
		}
		
		if(message instanceof DiameterRequest)
			session.requestReceived((DiameterRequest)message, callback);
		else
			session.answerReceived((DiameterAnswer)message, callback, null, true);
	}
}