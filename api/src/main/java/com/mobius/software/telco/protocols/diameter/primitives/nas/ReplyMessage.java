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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.2.9.  Reply-Message AVP

   The Reply-Message AVP (AVP Code 18) is of type UTF8String and
   contains text that MAY be displayed to the user.  When used in an AA-
   Answer message with a successful Result-Code AVP, it indicates
   success.  When found in an AAA message with a Result-Code other than
   DIAMETER_SUCCESS, the AVP contains a failure message.

   The Reply-Message AVP MAY contain text to prompt the user before
   another AA-Request attempt.  When used in an AA-Answer message
   containing a Result-Code AVP with the value DIAMETER_MULTI_ROUND_AUTH
   or in a Re-Auth-Request message, it MAY contain text to prompt the
   user for a response.
 */
@DiameterAvpDefinition(code = 18L, vendorId = -1L, name = "Reply-Message")
public interface ReplyMessage extends DiameterUTF8String
{
}