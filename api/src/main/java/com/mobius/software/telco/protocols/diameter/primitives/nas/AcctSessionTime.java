package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.6.5.  Acct-Session-Time AVP

   The Acct-Session-Time AVP (AVP Code 46) is of type Unsigned32 and
   indicates the length of the current session in seconds.  It can only
   be present in ACR messages with an Accounting-Record-Type of
   INTERIM_RECORD or STOP_RECORD.
 */
@DiameterAvpDefinition(code = AvpCodes.ACCT_SESSION_TIME, vendorId = -1L, name = "Acct-Session-Time")
public interface AcctSessionTime extends DiameterUnsigned32
{
}