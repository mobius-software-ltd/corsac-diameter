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
import org.jdiameter.api.Avp;
import org.jdiameter.api.AvpSet;
import org.jdiameter.api.IllegalDiameterStateException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.OverloadException;
import org.jdiameter.api.Request;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.rf.ServerRfSession;
import org.jdiameter.api.rf.ServerRfSessionListener;
import org.jdiameter.api.rf.events.RfAccountingAnswer;
import org.jdiameter.api.rf.events.RfAccountingRequest;
import org.jdiameter.common.impl.app.rf.RfAccountingAnswerImpl;

import com.mobius.software.telco.protocols.diameter.ResultCodes;
/**
*
* @author yulian oifa
*
*/
public class BasicServerRfSessionListener implements ServerRfSessionListener
{
	private static final Logger logger = LogManager.getLogger(BasicServerRfSessionListener.class);
	
	@Override
	public void doRfAccountingRequestEvent(ServerRfSession appSession, RfAccountingRequest request) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException
	{	
		try
		{
			RfAccountingAnswer answer;
			//this for timeout
			if(request.getAccountingRecordNumber()==2001L)
				return;
			
			if(request.getAccountingRecordNumber()==1001L)
			    answer = new RfAccountingAnswerImpl((Request) request.getMessage(), request.getAccountingRecordType(), (int) request.getAccountingRecordNumber(), ResultCodes.DIAMETER_UNABLE_TO_COMPLY);
			else
				answer = new RfAccountingAnswerImpl((Request) request.getMessage(), request.getAccountingRecordType(), (int) request.getAccountingRecordNumber(), ResultCodes.DIAMETER_SUCCESS);
				
			AvpSet set = answer.getMessage().getAvps();
			set.removeAvp(Avp.DESTINATION_HOST);
		    set.removeAvp(Avp.DESTINATION_REALM);	
			appSession.sendAccountAnswer(answer);			
		}
		catch(Exception ex)
		{
			logger.error("An error occured while handling RF Accounting Request," + ex.getMessage(),ex);
		}		    
	}

	@Override
	public void doOtherEvent(AppSession session, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException
	{		
	}	
}
