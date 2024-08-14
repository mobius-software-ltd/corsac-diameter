package com.mobius.software.telco.protocols.diameter.app;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.SessionListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest;

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
 *                              CLIENT, STATEFUL
      State     Event                          Action       New State
      ---------------------------------------------------------------
      Idle      Client or device requests      Send         Pending
                access                         service-
                                               specific
                                               auth req

      Idle      ASR Received                   Send ASA     Idle
                for unknown session            with
                                               Result-Code =
                                               UNKNOWN_
                                               SESSION_ID

      Idle      RAR Received                   Send RAA     Idle
                for unknown session            with
                                               Result-Code =
                                               UNKNOWN_
                                               SESSION_ID

      Pending   Successful service-specific    Grant        Open
                authorization answer           Access
                received with default
                Auth-Session-State value

      Pending   Successful service-specific    Sent STR     Discon
                authorization answer received,
                but service not provided

      Pending   Error processing successful    Sent STR     Discon
                service-specific authorization
                answer

      Pending   Failed service-specific        Clean up     Idle
                authorization answer received

      Open      User or client device          Send         Open
                requests access to service     service-
                                               specific
                                               auth req

      Open      Successful service-specific    Provide      Open
                authorization answer received  service

      Open      Failed service-specific        Discon.      Idle
                authorization answer           user/device
                received.

      Open      RAR received and client will   Send RAA     Open
                perform subsequent re-auth     with
                                               Result-Code =
                                               SUCCESS

      Open      RAR received and client will   Send RAA     Idle
                not perform subsequent         with
                re-auth                        Result-Code !=
                                               SUCCESS,
                                               Discon.
                                               user/device

      Open      Session-Timeout expires on     Send STR     Discon
                access device

      Open      ASR received,                  Send ASA     Discon
                client will comply             with
                with request to end the        Result-Code =
                session                        = SUCCESS,
                                               Send STR.

      Open      ASR Received,                  Send ASA     Open
                client will not comply         with
                with request to end the        Result-Code !=
                session                        != SUCCESS

      Open      Authorization-Lifetime +       Send STR     Discon
                Auth-Grace-Period expires on
                access device

      Discon    ASR received                   Send ASA     Discon
      
      Discon    STA received                   Discon.      Idle
 */
public interface ClientAuthListener<R1 extends DiameterRequest,A1 extends DiameterAnswer,R2 extends ReAuthRequest,A2 extends ReAuthAnswer,R3 extends AbortSessionRequest,A3 extends AbortSessionAnswer,R4 extends SessionTerminationRequest,A4 extends SessionTerminationAnswer> extends SessionListener
{
	void onInitialAnswer(A1 answer,ClientAuthSession<R1,A2,A3,R4> session,String linkID,AsyncCallback callback);
	
	void onReauthRequest(R2 request,ClientAuthSession<R1,A2,A3,R4> session,String linkID,AsyncCallback callback);
	
	void onSessionTerminationAnswer(A4 answer,ClientAuthSession<R1,A2,A3,R4> session,String linkID,AsyncCallback callback);
	
	void onAbortSessionRequest(R3 request,ClientAuthSession<R1,A2,A3,R4> session,String linkID,AsyncCallback callback);
}