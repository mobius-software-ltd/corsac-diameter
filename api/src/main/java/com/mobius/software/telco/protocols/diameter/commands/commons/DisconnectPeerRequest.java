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
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCauseEnum;

/**
*
* @author yulian oifa
*
*/

/*
 *  The Disconnect-Peer-Request (DPR), indicated by the Command Code set
   to 282 and the Command Flags' 'R' bit set, is sent to a peer to
   inform it of its intentions to shut down the transport connection.
   Upon detection of a transport failure, this message MUST NOT be sent
   to an alternate peer.

      Message Format

         <DPR>  ::= < Diameter Header: 282, REQ >
                    { Origin-Host }
                    { Origin-Realm }
                    { Disconnect-Cause }
                  * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.COMMON, commandCode = CommandCodes.DISCONNECT_PEER, request = true, proxyable = false, name="Disconnect-Peer-Request")
public interface DisconnectPeerRequest extends DiameterMessage
{
	public DisconnectCauseEnum getDisconnectCause();
	
	void setDisconnectCause(DisconnectCauseEnum value) throws MissingAvpException;		
}