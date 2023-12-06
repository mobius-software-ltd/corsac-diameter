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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	3.1.2.  Key-Name AVP

   	The Key-Name AVP (AVP Code 586) is of type OctetString.  It contains
   	an opaque key identifier.  Exactly how this name is generated and
   	used depends on the key type and usage in question and is beyond the
   	scope of this document (see [RFC5247] and [RFC5295] for discussions
   	of key name generation in the context of EAP).
*/
@DiameterAvpDefinition(code = 586L, vendorId = -1L, must = false, name = "Key-Name")
public interface KeyName extends DiameterOctetString
{
}