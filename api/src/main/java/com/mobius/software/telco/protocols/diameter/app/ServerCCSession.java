package com.mobius.software.telco.protocols.diameter.app;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterSession;
import com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer;
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
 *     +-------+------------------------+--------------------------+-------+
   | State | Event                  | Action                   | New   |
   |       |                        |                          | State |
   +-------+------------------------+--------------------------+-------+
   | Idle  | CC initial request     | Send CC initial answer,  | Open  |
   |       | received and           | reserve units, start Tcc |       |
   |       | successfully processed |                          |       |
   |       |                        |                          |       |
   | Idle  | CC initial request     | Send CC initial answer   | Idle  |
   |       | received but not       | with Result-Code !=      |       |
   |       | successfully processed | SUCCESS                  |       |
   |       |                        |                          |       |
   | Idle  | CC event request       | Send CC event answer     | Idle  |
   |       | received and           |                          |       |
   |       | successfully processed |                          |       |
   |       |                        |                          |       |
   | Idle  | CC event request       | Send CC event answer     | Idle  |
   |       | received but not       | with Result-Code !=      |       |
   |       | successfully processed | SUCCESS                  |       |
   |       |                        |                          |       |
   | Open  | CC update request      | Send CC update answer,   | Open  |
   |       | received and           | debit used units,        |       |
   |       | successfully processed | reserve new units,       |       |
   |       |                        | restart Tcc              |       |
   |       |                        |                          |       |
   | Open  | CC update request      | Send CC update answer    | Idle  |
   |       | received but not       | with Result-Code !=      |       |
   |       | successfully processed | SUCCESS, debit used      |       |
   |       |                        | units                    |       |
   |       |                        |                          |       |
   | Open  | CC termination request | Send CC termin. answer,  | Idle  |
   |       | received and           | stop Tcc, debit used     |       |
   |       | successfully processed | units                    |       |
   |       |                        |                          |       |
   | Open  | CC termination request | Send CC termin. answer   | Idle  |
   |       | received but not       | with Result-Code !=      |       |
   |       | successfully processed | SUCCESS, debit used      |       |
   |       |                        | units                    |       |
   |       |                        |                          |       |
   | Open  | Session supervision    | Release reserved units   | Idle  |
   |       | timer Tcc expired      |                          |       |
   +-------+------------------------+--------------------------+-------+                                                      
 */
public interface ServerCCSession<A1 extends CreditControlAnswer,R2 extends ReAuthRequest,R3 extends AbortSessionRequest,A4 extends SessionTerminationAnswer> extends DiameterSession
{
	void sendInitialAnswer(A1 answer,AsyncCallback callback);
	
	void sendReauthRequest(R2 request,AsyncCallback callback);
	
	void sendSessionTerminationAnswer(A4 answer,AsyncCallback callback);
	
	void sendAbortSessionRequest(R3 request,AsyncCallback callback);
}