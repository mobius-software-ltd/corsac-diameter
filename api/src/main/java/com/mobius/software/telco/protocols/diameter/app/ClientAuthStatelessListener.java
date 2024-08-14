package com.mobius.software.telco.protocols.diameter.app;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.SessionListener;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;

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
 *                        CLIENT, STATELESS
      State     Event                          Action       New State
      ---------------------------------------------------------------
      Idle      Client or device requests      Send         Pending
                access                         service-
                                               specific
                                               auth req

      Pending   Successful service-specific    Grant        Open
                authorization answer           access
                received with Auth-Session-
                State set to
                NO_STATE_MAINTAINED

      Pending   Failed service-specific        Clean up     Idle
                authorization answer
                received

      Open      Session-Timeout expires on     Discon.      Idle
                access device                  user/device

      Open      Service to user is terminated  Discon.      Idle
                                               user/device
 */
public interface ClientAuthStatelessListener<R1 extends DiameterRequest,A1 extends DiameterAnswer> extends SessionListener
{
	void onInitialAnswer(A1 answer,ClientAuthSessionStateless<R1> session,String linkID,AsyncCallback callback);		
}