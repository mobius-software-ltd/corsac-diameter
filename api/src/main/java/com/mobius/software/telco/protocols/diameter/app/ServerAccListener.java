package com.mobius.software.telco.protocols.diameter.app;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.SessionListener;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest;

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
 *						 SERVER, STATEFUL ACCOUNTING
      State     Event                          Action       New State
      ---------------------------------------------------------------

      Idle      Accounting start request       Send         Open
                received and successfully      accounting
                processed.                     start
                                               answer;
                                               Start Ts

      Idle      Accounting event request       Send         Idle
                received and successfully      accounting
                processed.                     event
                                               answer
      Idle      Accounting request received;   Send         Idle
                no space left to store         accounting
                records                        answer;
                                               Result-Code =
                                               OUT_OF_
                                               SPACE

      Open      Interim record received        Send         Open
                and successfully processed.    accounting
                                               interim
                                               answer;
                                               Restart Ts

      Open      Accounting stop request        Send         Idle
                received and successfully      accounting
                processed                      stop answer;
                                               Stop Ts

      Open      Accounting request received;   Send         Idle
                no space left to store         accounting
                records                        answer;
                                               Result-Code =
                                               OUT_OF_
                                               SPACE;
                                               Stop Ts

      Open      Session supervision timer Ts   Stop Ts      Idle
                expired
 */
public interface ServerAccListener<R1 extends AccountingRequest,A1 extends AccountingAnswer> extends SessionListener
{
	void onAccountingRequest(R1 request,ServerAccSession<A1> session,AsyncCallback callback);
}