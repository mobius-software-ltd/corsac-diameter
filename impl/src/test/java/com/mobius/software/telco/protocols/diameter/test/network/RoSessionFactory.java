package com.mobius.software.telco.protocols.diameter.test.network;
/*
 * Mobius Software LTD
 * Copyright 2019 - 2023, Mobius Software LTD and individual contributors
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.IllegalDiameterStateException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.OverloadException;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.SessionFactory;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.auth.events.ReAuthAnswer;
import org.jdiameter.api.auth.events.ReAuthRequest;
import org.jdiameter.api.ro.ClientRoSession;
import org.jdiameter.api.ro.ServerRoSession;
import org.jdiameter.api.ro.ServerRoSessionListener;
import org.jdiameter.api.ro.events.RoCreditControlAnswer;
import org.jdiameter.api.ro.events.RoCreditControlRequest;
import org.jdiameter.common.impl.app.ro.RoSessionFactoryImpl;

/**
*
* @author yulian oifa
*
*/
public class RoSessionFactory extends RoSessionFactoryImpl 
{
	private static final Logger logger = LogManager.getLogger(RoSessionFactory.class);
	ServerRoSessionListener serverListener;
	  
	public RoSessionFactory(ServerRoSessionListener serverListener, SessionFactory sessionFactory) 
	{
		super(sessionFactory);
		this.serverListener = serverListener;
	}

	@Override
	public AppSession getNewSession(String sessionId, Class<? extends AppSession> appSessionClass, ApplicationId applicationId, Object[] args) 
	{
		return super.getNewSession(sessionId, appSessionClass, applicationId, args);
	}

	@Override
	public void doCreditControlRequest(ServerRoSession session, RoCreditControlRequest request) throws InternalException 
	{
		logger.info("Diameter Ro Session Factory :: doCreditControlRequest :: appSession[" + session + "], Request[" + request + "]");
		try
		{
			serverListener.doCreditControlRequest(session, request);
		} 
		catch (InternalException | IllegalDiameterStateException | RouteException | OverloadException e)
		{
			throw new InternalException(e);
		}
	}

	@Override
	public void doCreditControlAnswer(ClientRoSession session, RoCreditControlRequest request, RoCreditControlAnswer answer) throws InternalException 
	{
		logger.info("Diameter Ro Session Factory :: doCreditControlAnswer :: appSession[" + session + "], Request[" + request + "]");	    
	}

	@Override
	public void doReAuthRequest(ClientRoSession session, ReAuthRequest request) throws InternalException 
	{
		logger.info("Diameter Ro Session Factory :: doReAuthRequest :: appSession[" + session + "], Request[" + request + "]");	  		
	}

	@Override
	public void doReAuthAnswer(ServerRoSession session, ReAuthRequest request, ReAuthAnswer answer) throws InternalException
	{
		logger.info("Diameter Ro Session Factory :: doReAuthAnswer :: appSession[" + session + "], Request[" + request + "], Answer[" + answer + "]");
		try
		{
			serverListener.doReAuthAnswer(session, request, answer);
		} 
		catch (InternalException | IllegalDiameterStateException | RouteException | OverloadException e)
		{
			throw new InternalException(e);
		}
	}

	@Override
	public void doOtherEvent(AppSession session, AppRequestEvent request, AppAnswerEvent answer) throws InternalException 
	{
		logger.info("Diameter Ro Session Factory :: doOtherEvent :: appSession[" + session + "], Request[" + request + "], Answer[" + answer + "]");
		try
		{
			serverListener.doOtherEvent(session, request, answer);
		} 
		catch (InternalException | IllegalDiameterStateException | RouteException | OverloadException e)
		{
			throw new InternalException(e);
		}	
	}
}