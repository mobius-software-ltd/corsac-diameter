package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/
/*
 * 
   8.20.  Tariff-Time-Change AVP

   The Tariff-Time-Change AVP (AVP Code 451) is of type Time.  It is
   sent from the server to the client and includes the time in seconds
   since January 1, 1900, 00:00 UTC, when the tariff of the service will
   be changed.

   The tariff change mechanism is optional for the client and server,
   and it is not used for time-based services defined in section 5.  If
   a client does not support the tariff time change mechanism, it MUST
   treat Tariff-Time-Change AVP in the answer message as an incorrect
   CCA answer.  In this case, the client terminates the credit-control
   session and indicates in the Termination-Cause AVP reason
   DIAMETER_BAD_ANSWER.

   Omission of this AVP means that no tariff change is to be reported.
 */
@DiameterAvpDefinition(code = AvpCodes.TARIFF_TIME_CHANGE, vendorId = -1L, name = "Tariff-Time-Change")
public interface TariffTimeChange extends DiameterTime
{
}