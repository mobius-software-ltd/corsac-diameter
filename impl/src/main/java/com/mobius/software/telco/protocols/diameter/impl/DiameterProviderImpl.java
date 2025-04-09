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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.ApplicationID;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
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
	public static Logger logger=LogManager.getLogger(DiameterProviderImpl.class);
	
	private ConcurrentHashMap<String,L1> clientListenersMap=new ConcurrentHashMap<String,L1>();
	private ConcurrentHashMap<String,L2> serverListenersMap=new ConcurrentHashMap<String,L2>();
	
	private A avpFactory;
	private M messageFactory;
	private F sessionFactory;
	private DiameterStack stack;
	private String packageName;
	
	public DiameterProviderImpl(DiameterStack stack,A avpFactory,M messageFactory,String packageName)
	{
		this.stack=stack;
		this.avpFactory=avpFactory;
		this.messageFactory=messageFactory;
		this.packageName = packageName;
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
		clientListenersMap.put(listenerID.toString(), listener);
	}
	
	@Override
	public void setClientListener(String listenerID, L1 listener)
	{
		clientListenersMap.put(listenerID, listener);
	}

	@Override
	public void removeClientListener(ClusteredID<?> listenerID)
	{
		clientListenersMap.remove(listenerID.toString());
	}
	
	@Override
	public void removeClientListener(String listenerID)
	{
		clientListenersMap.remove(listenerID);
	}

	@Override
	public Map<String, L1> getClientListeners()
	{
		return clientListenersMap;
	}

	@Override
	public void setServerListener(ClusteredID<?> listenerID, L2 listener)
	{
		serverListenersMap.put(listenerID.toString(), listener);
	}
	
	@Override
	public void setServerListener(String listenerID, L2 listener)
	{
		serverListenersMap.put(listenerID, listener);
	}

	@Override
	public void removeServerListener(ClusteredID<?> listenerID)
	{
		serverListenersMap.remove(listenerID.toString());
	}
	
	@Override
	public void removeServerListener(String listenerID)
	{
		serverListenersMap.remove(listenerID);
	}

	@Override
	public Map<String, L2> getServerListeners()
	{
		return serverListenersMap;
	}

	@Override
	public DiameterStack getStack()
	{
		return stack;
	}

	@Override
	public void onMessage(DiameterMessage message, String linkID, AsyncCallback callback)
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
		
		if (!stack.isNewIncomingSessionAllowed()) {
			callback.onError(new DiameterException("The number of created incoming sessions exceeed the license limit", null, ResultCodes.DIAMETER_TOO_BUSY, null));
			return;
		}

		DiameterSession session = this.getStack().getSessionStorage().getSession(sessionID, this);
		if(session==null && (message instanceof DiameterRequest))
		{
			if(logger.isDebugEnabled())
				logger.debug(String.format("Getting new session for message %s in provider %s", message.getClass().getCanonicalName(), getClass().getCanonicalName()));
			

			session=getNewSession((DiameterRequest)message);
			if(session!=null)
			{
				DiameterLink originalLink = stack.getNetworkManager().getLink(linkID);
				if(originalLink!=null)
				{
					if(originalLink.getDestinationHost()!=null)
						session.setRemoteHost(originalLink.getDestinationHost());
					
					if(originalLink.getDestinationRealm()!=null)
						session.setRemoteRealm(originalLink.getDestinationRealm());
				}
				
				if(logger.isDebugEnabled())
					logger.debug(String.format("New session is not null in provider %s", message.getClass().getCanonicalName(), getClass().getCanonicalName()));
				
				if(session.getApplicationID()!=null)
				{
					ApplicationID applicationID = ApplicationID.fromInt(session.getApplicationID().intValue());
					if(applicationID!=null)
						stack.newIncomingSession(applicationID);
				}
				
				getStack().getSessionStorage().storeSession(session);
			} else if(logger.isDebugEnabled())
				logger.debug(String.format("New session is null in provider %s", message.getClass().getCanonicalName(), getClass().getCanonicalName()));
		} else if(logger.isDebugEnabled())
			logger.debug(String.format("Processing message %s in existing session in provider %s", message.getClass().getCanonicalName(), getClass().getCanonicalName()));	
			
		if(session==null)
		{
			callback.onError(new DiameterException("Session with this ID not found", null, ResultCodes.DIAMETER_UNKNOWN_SESSION_ID, null));
			return;
		}
		
		if(message instanceof DiameterRequest)
			session.requestReceived((DiameterRequest)message, linkID, callback);
		else
			session.answerReceived((DiameterAnswer)message, null, true, linkID, callback);
		
		if(logger.isDebugEnabled())
			logger.debug(String.format("Message %s delivered to session in provider %s", message.getClass().getCanonicalName(), getClass().getCanonicalName()));
	}
	
	@Override
	public String getPackageName()
	{
		return this.packageName;
	}
}