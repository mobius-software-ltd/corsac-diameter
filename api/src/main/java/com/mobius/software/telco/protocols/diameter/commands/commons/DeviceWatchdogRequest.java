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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;

/**
*
* @author yulian oifa
*
*/

/*
 * The Device-Watchdog-Request (DWR), indicated by the Command Code set
   to 280 and the Command Flags' 'R' bit set, is sent to a peer when no
   traffic has been exchanged between two peers (see Section 5.5.3).
   Upon detection of a transport failure, this message MUST NOT be sent
   to an alternate peer.

      Message Format

         <DWR>  ::= < Diameter Header: 280, REQ >
                    { Origin-Host }
                    { Origin-Realm }
                    [ Origin-State-Id ]
                  * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 0, commandCode = 280, request = true, proxyable = false, name="Device-Watchdog-Request")
public interface DeviceWatchdogRequest extends DiameterMessage
{		
}