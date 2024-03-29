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
 * The Device-Watchdog-Answer (DWA), indicated by the Command Code set
   to 280 and the Command Flags' 'R' bit cleared, is sent as a response
   to the Device-Watchdog-Request message.

      Message Format

         <DWA>  ::= < Diameter Header: 280 >
                    { Result-Code }
                    { Origin-Host }
                    { Origin-Realm }
                    [ Error-Message ]
                    [ Failed-AVP ]
                    [ Origin-State-Id ]
                  * [ AVP ]
 */

@DiameterCommandDefinition(applicationId = ApplicationIDs.COMMON, commandCode = CommandCodes.DEVICE_WATCHDOG, request = false, proxyable = false, name="Device-Watchdog-Answer")
public interface DeviceWatchdogAnswer extends DiameterAnswer
{
}