package com.mobius.software.telco.protocols.diameter.app;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationAnswer;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
/**
*
* @author yulian oifa
*
*/
/*
 * 
 *                         SERVER, STATEFUL
      State     Event                          Action       New State
      ---------------------------------------------------------------
      Idle      Service-specific authorization Send         Open
                request received, and          successful
                user is authorized             service-
                                               specific
                                               answer

      Idle      Service-specific authorization Send         Idle
                request received, and          failed
                user is not authorized         service-
                                               specific
                                               answer

      Open      Service-specific authorization Send         Open
                request received, and user     successful
                is authorized                  service-
                                               specific
                                               answer

      Open      Service-specific authorization Send         Idle
                request received, and user     failed
                is not authorized              service-
                                               specific
                                               answer,
                                               Clean up

      Open      Home server wants to confirm   Send RAR     Pending
                authentication and/or
                authorization of the user

      Pending   Received RAA with a failed     Clean up     Idle
                Result-Code

      Pending   Received RAA with Result-Code  Update       Open
                = SUCCESS                      session

      Open      Home server wants to           Send ASR     Discon
                terminate the service
                
      Open      Authorization-Lifetime (and    Clean up     Idle
                Auth-Grace-Period) expires
                on home server

      Open      Session-Timeout expires on     Clean up     Idle
                home server

      Discon    Failure to send ASR            Wait,        Discon
                                               resend ASR

      Discon    ASR successfully sent and      Clean up     Idle
                ASA Received with Result-Code

      Not       ASA Received                   None         No Change
      Discon

      Any       STR Received                   Send STA,    Idle
                                               Clean up                                                           
 */
public interface ServerAuthSession<A1 extends DiameterAnswer,R2 extends ReAuthRequest,R3 extends AbortSessionRequest,A4 extends SessionTerminationAnswer>
{
	void sendInitialAnswer(A1 answer,AsyncCallback callback);
	
	void sendReauthRequest(R2 request,AsyncCallback callback);
	
	void sendSessionTerminationAnswer(A4 answer,AsyncCallback callback);
	
	void sendAbortSessionRequest(R3 request,AsyncCallback callback);		
}