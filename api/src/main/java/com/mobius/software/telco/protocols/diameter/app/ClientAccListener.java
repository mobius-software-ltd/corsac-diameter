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
 * 
 *						CLIENT, ACCOUNTING
      State     Event                          Action       New State
      ---------------------------------------------------------------
      Idle      Client or device requests      Send         PendingS
                access                         accounting
                                               start req.

      Idle      Client or device requests      Send         PendingE
                a one-time service             accounting
                                               event req

      Idle      Records in storage             Send         PendingB
                                               record

      PendingS  Successful accounting                       Open
                start answer received

      PendingS  Failure to send and buffer     Store        Open
                space available and real time  Start
                not equal to DELIVER_AND_GRANT Record

      PendingS  Failure to send and no buffer               Open
                space available and real time
                equal to GRANT_AND_LOSE

      PendingS  Failure to send and no         Disconnect   Idle
                buffer space available and     user/dev
                real time not equal to
                GRANT_AND_LOSE

      PendingS  Failed accounting start answer              Open
                received and real time equal
                to GRANT_AND_LOSE

      PendingS  Failed accounting start answer Disconnect   Idle
                received and real time not     user/dev
                equal to GRANT_AND_LOSE

      PendingS  User service terminated        Store        PendingS
                                               stop
                                               record

      Open      Interim interval elapses       Send         PendingI
                                               accounting
                                               interim
                                               record

      Open      User service terminated        Send         PendingL
                                               accounting
                                               stop req.

      PendingI  Successful accounting interim               Open
                answer received

      PendingI  Failure to send and (buffer    Store        Open
                space available or old         interim
                record can be overwritten)     record
                and real time not equal to
                DELIVER_AND_GRANT

      PendingI  Failure to send and no buffer               Open
                space available and real time
                equal to GRANT_AND_LOSE

      PendingI  Failure to send and no         Disconnect   Idle
                buffer space available and     user/dev
                real time not equal to
                GRANT_AND_LOSE

      PendingI  Failed accounting interim                   Open
                answer received and real time
                equal to GRANT_AND_LOSE

      PendingI  Failed accounting interim      Disconnect   Idle
                answer received and            user/dev
                real time not equal to
                GRANT_AND_LOSE

      PendingI  User service terminated        Store        PendingI
                                               stop
                                               record
      PendingE  Successful accounting                       Idle
                event answer received

      PendingE  Failure to send and buffer     Store        Idle
                space available                event
                                               record

      PendingE  Failure to send and no buffer               Idle
                space available

      PendingE  Failed accounting event answer              Idle
                received

      PendingB  Successful accounting answer   Delete       Idle
                received                       record

      PendingB  Failure to send                             Idle

      PendingB  Failed accounting answer       Delete       Idle
                received                       record

      PendingL  Successful accounting                       Idle
                stop answer received

      PendingL  Failure to send and buffer     Store        Idle
                space available                stop
                                               record

      PendingL  Failure to send and no buffer               Idle
                space available

      PendingL  Failed accounting stop answer               Idle
                received
 */
public interface ClientAccListener<R1 extends AccountingRequest,A1 extends AccountingAnswer> extends SessionListener
{
	void onAccountingResponse(A1 answer,ClientAccSession<R1> session,AsyncCallback callback);
}