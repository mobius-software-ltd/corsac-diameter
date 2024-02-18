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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.2.  CC-Request-Number AVP

   The CC-Request-Number AVP (AVP Code 415) is of type Unsigned32 and
   identifies this request within one session.  As Session-Id AVPs are
   globally unique, the combination of the Session-Id AVP and the
   CC-Request-Number AVP is also globally unique and can be used in
   matching credit-control messages with confirmations.  An easy way to
   produce unique numbers is to set the value of the CC-Request-Number
   AVP to 0 for a credit-control request with a CC-Request-Type AVP of
   INITIAL_REQUEST (the initial request in a session).  The value of the
   CC-Request-Number AVP should be set to 1 for the first
   UPDATE_REQUEST, to 2 for the second, and so on until the value for
   TERMINATION_REQUEST is one more than the value for the last
   UPDATE_REQUEST.  In the case of event charging (when the CC-Request-
   Type AVP has the value EVENT_REQUEST), the CC-Request-Number AVP
   should be set to 0 for a credit-control request.
 */
@DiameterAvpDefinition(code = AvpCodes.CC_REQUEST_NUMBER, vendorId = -1L, name = "Cc-Request-Number")
public interface CcRequestNumber extends DiameterUnsigned32
{
}