package com.mobius.software.telco.protocols.diameter.primitives.rfc6734;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	3.1.4.  Key-Lifetime AVP

   	The Key-Lifetime AVP (AVP Code 584) is of type Unsigned32 and
   	represents the period of time (in seconds) for which the contents of
   	the Keying-Material AVP (Section 3.1.3) is valid.

   	NOTE:
      Applications using this value SHOULD consider the beginning of the
      lifetime to be the point in time when the message containing the
      keying material is received.  In addition, client implementations
      SHOULD check to ensure that the value is reasonable; for example,
      the lifetime of a key should not generally be longer than the
      session lifetime (see Section 8.13 of [RFC6733]).
*/
@DiameterAvpDefinition(code = 584L, vendorId = -1L, must = false, name = "Key-Lifetime")
public interface KeyLifetime extends DiameterUnsigned32
{
}