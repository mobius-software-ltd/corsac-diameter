package com.mobius.software.telco.protocols.diameter.commands.commons;
/*
 * Mobius Software LTD
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;

/**
*
* @author yulian oifa
*
*/

/*
 * The Disconnect-Peer-Answer (DPA), indicated by the Command Code set
   to 282 and the Command Flags' 'R' bit cleared, is sent as a response
   to the Disconnect-Peer-Request message.  Upon receipt of this
   message, the transport connection is shut down.
   
   Message Format

         <DPA>  ::= < Diameter Header: 282 >
                    { Result-Code }
                    { Origin-Host }
                    { Origin-Realm }
                    [ Error-Message ]
                    [ Failed-AVP ]
                  * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.COMMON, commandCode = CommandCodes.DISCONNECT_PEER, request = false, proxyable = false, name="Disconnect-Peer-Answer")
public interface DisconnectPeerAnswer extends DiameterAnswer
{	
}