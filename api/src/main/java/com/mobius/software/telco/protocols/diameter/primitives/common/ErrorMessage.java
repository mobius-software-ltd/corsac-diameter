package com.mobius.software.telco.protocols.diameter.primitives.common;
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
 * 7.3.  Error-Message AVP

   The Error-Message AVP (AVP Code 281) is of type UTF8String.  It MAY
   accompany a Result-Code AVP as a human-readable error message.  The
   Error-Message AVP is not intended to be useful in an environment
   where error messages are processed automatically.  It SHOULD NOT be
   expected that the content of this AVP be parsed by network entities.
 */
@DiameterAvpDefinition(code = 281L, vendorId = -1L, must = false, name = "Error-Message")
public interface ErrorMessage extends DiameterUTF8String
{
}