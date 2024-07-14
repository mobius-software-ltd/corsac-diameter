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

import org.jdiameter.api.IllegalDiameterStateException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.OverloadException;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.auth.events.ReAuthAnswer;
import org.jdiameter.api.auth.events.ReAuthRequest;
import org.jdiameter.api.ro.ServerRoSession;
import org.jdiameter.api.ro.ServerRoSessionListener;
import org.jdiameter.api.ro.events.RoCreditControlRequest;
/**
*
* @author yulian oifa
*
*/
public class EmptyServerRoSessionListener implements ServerRoSessionListener
{

	@Override
	public void doCreditControlRequest(ServerRoSession session, RoCreditControlRequest request) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException
	{
		
	}

	@Override
	public void doReAuthAnswer(ServerRoSession session, ReAuthRequest request, ReAuthAnswer answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException
	{
		
	}

	@Override
	public void doOtherEvent(AppSession session, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException
	{
		
	}
}
