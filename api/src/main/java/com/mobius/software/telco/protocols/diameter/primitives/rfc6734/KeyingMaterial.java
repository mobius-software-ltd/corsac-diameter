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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	3.1.3.  Keying-Material AVP

   	The Keying-Material AVP (AVP Code 583) is of type OctetString.  The
   	exact usage of this keying material depends upon several factors,
   	including the type of the key and the link layer in use and is beyond
   	the scope of this document.
*/
@DiameterAvpDefinition(code = AvpCodes.KEYING_MATERIAL, vendorId = -1L, must = false, name = "Keying-Material")
public interface KeyingMaterial extends DiameterOctetString
{
}