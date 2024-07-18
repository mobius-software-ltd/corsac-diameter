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
import org.jdiameter.api.rf.ClientRfSession;
import org.jdiameter.api.rf.ServerRfSession;
import org.jdiameter.api.rf.ServerRfSessionListener;
import org.jdiameter.api.rf.events.RfAccountingAnswer;
import org.jdiameter.api.rf.events.RfAccountingRequest;
import org.jdiameter.common.impl.app.rf.RfSessionFactoryImpl;

/**
*
* @author yulian oifa
*
*/
public class RfSessionFactory extends RfSessionFactoryImpl 
{
	private static final Logger logger = LogManager.getLogger(RfSessionFactory.class);
	ServerRfSessionListener serverListener;
	  
	public RfSessionFactory(ServerRfSessionListener serverListener, SessionFactory sessionFactory) 
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
	public void doRfAccountingRequestEvent(ServerRfSession appSession, RfAccountingRequest acr) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException 
	{
		logger.info("Diameter Rf Session Factory :: doRfAccountingRequestEvent :: appSession[" + appSession + "], Request[" + acr + "]");
		try
		{
			serverListener.doRfAccountingRequestEvent(appSession, acr);
		} 
		catch (InternalException | IllegalDiameterStateException | RouteException | OverloadException e)
		{
			throw new InternalException(e);
		}
	}

	@Override
	public void doRfAccountingAnswerEvent(ClientRfSession appSession, RfAccountingRequest acr, RfAccountingAnswer aca) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException 
	{
		logger.info("Diameter Rf Session Factory :: doRfAccountingAnswerEvent :: appSession[" + appSession + "], Request[" + acr + "], Answer[" + aca + "]");
	}

	@Override
	public void doOtherEvent(AppSession appSession, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException 
	{
		logger.info("Diameter Rf Session Factory :: doOtherEvent :: appSession[" + appSession + "], Request[" + request + "], Answer[" + answer + "]");
		try
		{
			serverListener.doOtherEvent(appSession, request, answer);
		} 
		catch (InternalException | IllegalDiameterStateException | RouteException | OverloadException e)
		{
			throw new InternalException(e);
		}
	}
}