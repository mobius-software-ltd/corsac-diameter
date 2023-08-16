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
 * 4.4.2.  Callback-Number AVP

   The Callback-Number AVP (AVP Code 19) is of type UTF8String and
   contains a dialing string to be used for callback, the format of
   which is deployment specific.  The Callback-Number AVP MAY be used in
   an authentication and/or authorization request as a hint to the
   server that a callback service is desired, but the server is not
   required to honor the hint in the corresponding response.

   Any further codification of this field's allowed usage range is
   outside the scope of this specification.
 */
@DiameterAvpDefinition(code = 19L, vendorId = -1L, name = "Callback-Number")
public interface CallbackNumber extends DiameterUTF8String
{
}