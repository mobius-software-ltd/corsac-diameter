package com.mobius.software.telco.protocols.diameter.app;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer;
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
 * +----------+-------------------------------+-------------+----------+
   | State    | Event                         | Action      | New      |
   |          |                               |             | State    |
   +----------+-------------------------------+-------------+----------+
   | Idle     | Client or device requests     | Send        | PendingI |
   |          | access/service                | AA-Request  |          |
   |          |                               | with added  |          |
   |          |                               | CC AVPs,    |          |
   |          |                               | start Tx    |          |
   |          |                               | timer       |          |
   |          |                               |             |          |
   | PendingI | Successful answer to          | Grant       | Open     |
   |          | AA-Request received           | service to  |          |
   |          |                               | end user,   |          |
   |          |                               | stop Tx     |          |
   |          |                               | timer       |          |
   |          |                               |             |          |
   | PendingI | Tx timer expired              | Disconnect  | Idle     |
   |          |                               | user/dev    |          |
   |          |                               |             |          |
   | PendingI | Failed AA-Answer received     | Disconnect  | Idle     |
   |          |                               | user/dev    |          |
   |          |                               |             |          |
   | PendingI | AA-Answer received with       | Grant       | Idle     |
   |          | Result-Code equal to          | service to  |          |
   |          | CREDIT_CONTROL_NOT_APPLICABLE | end user    |          |
   |          |                               |             |          |
   | PendingI | User service terminated       | Queue       | PendingI |
   |          |                               | termination |          |
   |          |                               | event       |          |
   |          |                               |             |          |
   | PendingI | Change in rating condition    | Queue       | PendingI |
   |          |                               | changed     |          |
   |          |                               | rating      |          |
   |          |                               | condition   |          |
   |          |                               | event       |          |
   +----------+-------------------------------+-------------+----------+

            Table 2: Session-Based Client State Machine for the
                    First Interrogation with AA-Request

   +----------+-------------------------------+-------------+----------+
   | State    | Event                         | Action      | New      |
   |          |                               |             | State    |
   +----------+-------------------------------+-------------+----------+
   | Idle     | Client or device requests     | Send CC     | PendingI |
   |          | access/service                | initial     |          |
   |          |                               | req., start |          |
   |          |                               | Tx timer    |          |
   |          |                               |             |          |
   | PendingI | Successful CC initial answer  | Stop Tx     | Open     |
   |          | received                      | timer       |          |
   |          |                               |             |          |
   | PendingI | Failure to send, or temporary | Grant       | Idle     |
   |          | error and CCFH equal to       | service to  |          |
   |          | CONTINUE                      | end user    |          |
   |          |                               |             |          |
   | PendingI | Failure to send, or temporary | Terminate   | Idle     |
   |          | error and CCFH equal to       | end user's  |          |
   |          | TERMINATE or to               | service     |          |
   |          | RETRY_AND_TERMINATE           |             |          |
   |          |                               |             |          |
   | PendingI | Tx timer expired and CCFH     | Terminate   | Idle     |
   |          | equal to TERMINATE            | end user's  |          |
   |          |                               | service     |          |
   |          |                               |             |          |
   | PendingI | Tx timer expired and CCFH     | Grant       | PendingI |
   |          | equal to CONTINUE or to       | service to  |          |
   |          | RETRY_AND_TERMINATE           | end user    |          |
   |          |                               |             |          |
   | PendingI | CC initial answer received    | Terminate   | Idle     |
   |          | with Result-Code equal to     | end user's  |          |
   |          | END_USER_SERVICE_DENIED or to | service     |          |
   |          | USER_UNKNOWN                  |             |          |
   |          |                               |             |          |
   | PendingI | CC initial answer received    | Grant       | Idle     |
   |          | with Result-Code equal to     | service to  |          |
   |          | CREDIT_CONTROL_NOT_APPLICABLE | end user    |          |
   |          |                               |             |          |
   | PendingI | Failed CC initial answer      | Grant       | Idle     |
   |          | received and CCFH equal to    | service to  |          |
   |          | CONTINUE                      | end user    |          |
   |          |                               |             |          |
   | PendingI | Failed CC initial answer      | Terminate   | Idle     |
   |          | received and CCFH equal to    | end user's  |          |
   |          | TERMINATE or to               | service     |          |
   |          | RETRY_AND_TERMINATE           |             |          |
   |          |                               |             |          |
   | PendingI | User service terminated       | Queue       | PendingI |
   |          |                               | termination |          |
   |          |                               | event       |          |
   |          |                               |             |          |
   | PendingI | Change in rating condition    | Queue       | PendingI |
   |          |                               | changed     |          |
   |          |                               | rating      |          |
   |          |                               | condition   |          |
   |          |                               | event       |          |
   +----------+-------------------------------+-------------+----------+

            Table 3: Session-Based Client State Machine for the
                       First Interrogation with CCR

   +----------+-------------------------------+-------------+----------+
   | State    | Event                         | Action      | New      |
   |          |                               |             | State    |
   +----------+-------------------------------+-------------+----------+
   | Open     | Granted unit elapses and no   | Send CC     | PendingU |
   |          | final-unit indication         | update      |          |
   |          | received                      | req., start |          |
   |          |                               | Tx timer    |          |
   |          |                               |             |          |
   | Open     | Granted unit elapses and      | Terminate   | PendingT |
   |          | final unit action equal to    | end user's  |          |
   |          | TERMINATE received            | service,    |          |
   |          |                               | send CC     |          |
   |          |                               | termination |          |
   |          |                               | req.        |          |
   |          |                               |             |          |
   | Open     | Change in rating condition in | Send CC     | PendingU |
   |          | queue                         | update      |          |
   |          |                               | req., start |          |
   |          |                               | Tx timer    |          |
   |          |                               |             |          |
   | Open     | Service terminated in queue   | Send CC     | PendingT |
   |          |                               | termination |          |
   |          |                               | req.        |          |
   |          |                               |             |          |
   | Open     | Change in rating condition or | Send CC     | PendingU |
   |          | Validity-Time elapses         | update      |          |
   |          |                               | req., start |          |
   |          |                               | Tx timer    |          |
   |          |                               |             |          |
   | Open     | User service terminated       | Send CC     | PendingT |
   |          |                               | termination |          |
   |          |                               | req.        |          |
   |          |                               |             |          |
   | Open     | RAR received                  | Send RAA    | PendingU |
   |          |                               | followed by |          |
   |          |                               | CC update   |          |
   |          |                               | req., start |          |
   |          |                               | Tx timer    |          |
   |          |                               |             |          |
   | PendingU | Successful CC update answer   | Stop Tx     | Open     |
   |          | received                      | timer       |          |
   |          |                               |             |          |
   | PendingU | Failure to send, or temporary | Grant       | Idle     |
   |          | error and CCFH equal to       | service to  |          |
   |          | CONTINUE                      | end user    |          |
   |          |                               |             |          |
   | PendingU | Failure to send, or temporary | Terminate   | Idle     |
   |          | error and CCFH equal to       | end user's  |          |
   |          | TERMINATE or to               | service     |          |
   |          | RETRY_AND_TERMINATE           |             |          |
   |          |                               |             |          |
   | PendingU | Tx timer expired and CCFH     | Terminate   | Idle     |
   |          | equal to TERMINATE            | end user's  |          |
   |          |                               | service     |          |
   |          |                               |             |          |
   | PendingU | Tx timer expired and CCFH     | Grant       | PendingU |
   |          | equal to CONTINUE or to       | service to  |          |
   |          | RETRY_AND_TERMINATE           | end user    |          |
   |          |                               |             |          |
   | PendingU | CC update answer received     | Terminate   | Idle     |
   |          | with Result-Code equal to     | end user's  |          |
   |          | END_USER_SERVICE_DENIED       | service     |          |
   |          |                               |             |          |
   | PendingU | CC update answer received     | Grant       | Idle     |
   |          | with Result-Code equal to     | service to  |          |
   |          | CREDIT_CONTROL_NOT_APPLICABLE | end user    |          |
   |          |                               |             |          |
   | PendingU | Failed CC update answer       | Grant       | Idle     |
   |          | received and CCFH equal to    | service to  |          |
   |          | CONTINUE                      | end user    |          |
   |          |                               |             |          |
   | PendingU | Failed CC update answer       | Terminate   | Idle     |
   |          | received and CCFH equal to    | end user's  |          |
   |          | TERMINATE or to               | service     |          |
   |          | RETRY_AND_TERMINATE           |             |          |
   |          |                               |             |          |
   | PendingU | User service terminated       | Queue       | PendingU |
   |          |                               | termination |          |
   |          |                               | event       |          |
   |          |                               |             |          |
   | PendingU | Change in rating condition    | Queue       | PendingU |
   |          |                               | changed     |          |
   |          |                               | rating      |          |
   |          |                               | condition   |          |
   |          |                               | event       |          |
   |          |                               |             |          |
   | PendingU | RAR received                  | Send RAA    | PendingU |
   |          |                               |             |          |
   | PendingT | Successful CC termination     |             | Idle     |
   |          | answer received               |             |          |
   |          |                               |             |          |
   | PendingT | Failure to send, temporary    |             | Idle     |
   |          | error, or failed answer       |             |          |
   |          |                               |             |          |
   | PendingT | Change in rating condition    |             | PendingT |
   +----------+-------------------------------+-------------+----------+

     Table 4: Session-Based Client State Machine for Intermediate and
                           Final Interrogations


   +----------+--------------------------------+------------+----------+
   | State    | Event                          | Action     | New      |
   |          |                                |            | State    |
   +----------+--------------------------------+------------+----------+
   | Idle     | Client or device requests a    | Send CC    | PendingE |
   |          | one-time service               | event      |          |
   |          |                                | req.,      |          |
   |          |                                | start Tx   |          |
   |          |                                | timer      |          |
   |          |                                |            |          |
   | Idle     | Request in storage             | Send       | PendingB |
   |          |                                | stored     |          |
   |          |                                | request    |          |
   |          |                                |            |          |
   | PendingE | Successful CC event answer     | Grant      | Idle     |
   |          | received                       | service to |          |
   |          |                                | end user   |          |
   |          |                                |            |          |
   | PendingE | Failure to send, temporary     | Indicate   | Idle     |
   |          | error, failed CC event answer  | service    |          |
   |          | received, or Tx timer expired; | error      |          |
   |          | requested action CHECK_BALANCE |            |          |
   |          | or PRICE_ENQUIRY               |            |          |
   |          |                                |            |          |
   | PendingE | CC event answer received with  | Terminate  | Idle     |
   |          | Result-Code equal to           | end user's |          |
   |          | END_USER_SERVICE_DENIED or to  | service    |          |
   |          | USER_UNKNOWN and Tx timer      |            |          |
   |          | running                        |            |          |
   |          |                                |            |          |
   | PendingE | CC event answer received with  | Grant      | Idle     |
   |          | Result-Code equal to           | service to |          |
   |          | CREDIT_CONTROL_NOT_APPLICABLE; | end user   |          |
   |          | requested action               |            |          |
   |          | DIRECT_DEBITING                |            |          |
   |          |                                |            |          |
   | PendingE | Failure to send, temporary     | Grant      | Idle     |
   |          | error, or failed CC event      | service to |          |
   |          | answer received; requested     | end user   |          |
   |          | action DIRECT_DEBITING; DDFH   |            |          |
   |          | equal to CONTINUE              |            |          |
   |          |                                |            |          |
   | PendingE | Failed CC event answer         | Terminate  | Idle     |
   |          | received or temporary error;   | end user's |          |
   |          | requested action               | service    |          |
   |          | DIRECT_DEBITING; DDFH equal to |            |          |
   |          | TERMINATE_OR_BUFFER and Tx     |            |          |
   |          | timer running                  |            |          |
   |          |                                |            |          |
   | PendingE | Tx timer expired; requested    | Grant      | PendingE |
   |          | action DIRECT_DEBITING         | service to |          |
   |          |                                | end user   |          |
   |          |                                |            |          |
   | PendingE | Failure to send; requested     | Store      | Idle     |
   |          | action DIRECT_DEBITING; DDFH   | request    |          |
   |          | equal to TERMINATE_OR_BUFFER   | with       |          |
   |          |                                | T flag     |          |
   |          |                                |            |          |
   | PendingE | Temporary error; requested     | Store      | Idle     |
   |          | action DIRECT_DEBITING; DDFH   | request    |          |
   |          | equal to TERMINATE_OR_BUFFER;  |            |          |
   |          | Tx timer expired               |            |          |
   |          |                                |            |          |
   | PendingE | Failed answer or answer        |            | Idle     |
   |          | received with Result-Code      |            |          |
   |          | equal to END_USER_SERVICE      |            |          |
   |          | DENIED or to USER_UNKNOWN;     |            |          |
   |          | requested action               |            |          |
   |          | DIRECT_DEBITING; Tx timer      |            |          |
   |          | expired                        |            |          |
   |          |                                |            |          |
   | PendingE | Failed CC event answer         | Indicate   | Idle     |
   |          | received; requested action     | service    |          |
   |          | REFUND_ACCOUNT                 | error and  |          |
   |          |                                | delete     |          |
   |          |                                | request    |          |
   |          |                                |            |          |
   | PendingE | Failure to send or Tx timer    | Store      | Idle     |
   |          | expired; requested action      | request    |          |
   |          | REFUND_ACCOUNT                 | with       |          |
   |          |                                | T flag     |          |
   |          |                                |            |          |
   | PendingE | Temporary error; requested     | Store      | Idle     |
   |          | action REFUND_ACCOUNT          | request    |          |
   |          |                                |            |          |
   | PendingB | Successful CC answer received  | Delete     | Idle     |
   |          |                                | request    |          |
   |          |                                |            |          |
   | PendingB | Failed CC answer received      | Delete     | Idle     |
   |          |                                | request    |          |
   |          |                                |            |          |
   | PendingB | Failure to send or temporary   |            | Idle     |
   |          | error                          |            |          |
   +----------+--------------------------------+------------+----------+

               Table 5: One-Time Event Client State Machine
 */
public interface ClientCCSession<R1 extends CreditControlRequest,A2 extends ReAuthAnswer,A3 extends AbortSessionAnswer,R4 extends SessionTerminationRequest>
{
	void sendInitialRequest(R1 request,AsyncCallback callback);
	
	void sendReauthAnswer(A2 answer,AsyncCallback callback);
	
	void sendSessionTerminationRequest(R4 request,AsyncCallback callback);
	
	void sendAbortSessionAnswer(A3 answer,AsyncCallback callback);
	
	SessionStateEnum getSessionState();
	
	void terminate();
}