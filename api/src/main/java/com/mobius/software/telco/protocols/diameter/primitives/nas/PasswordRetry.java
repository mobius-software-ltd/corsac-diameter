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
 * 4.3.2.  Password-Retry AVP

   The Password-Retry AVP (AVP Code 75) is of type Unsigned32 and MAY be
   included in the AA-Answer if the Result-Code indicates an
   authentication failure.  The value of this AVP indicates how many
   authentication attempts a user is permitted before being
   disconnected.  This AVP is primarily intended for use when the
   Framed-Protocol AVP (Section 4.4.10.1) is set to ARAP.
 */
@DiameterAvpDefinition(code = AvpCodes.PASSWORD_RETRY, vendorId = -1L, name = "Password-Retry")
public interface PasswordRetry extends DiameterUnsigned32
{
}