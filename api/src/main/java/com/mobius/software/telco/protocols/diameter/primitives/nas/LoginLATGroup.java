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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.11.5.3.  Login-LAT-Group AVP

   The Login-LAT-Group AVP (AVP Code 36) is of type OctetString and
   contains a string identifying the LAT group codes this user is
   authorized to use.  It MAY be used in an authorization request as a
   hint to the server that a specific group is desired, but the server
   is not required to honor the hint in the corresponding response.
   This AVP MUST only be present in a response if the Login-Service-Type
   AVP is set to LAT.

   LAT supports 256 different group codes, which LAT uses as a form of
   access rights.  LAT encodes the group codes as a 256-bit bitmap.

   Administrators can assign one or more of the group code bits at the
   LAT service provider; it will only accept LAT connections that have
   these group codes set in the bitmap.  The administrators assign a
   bitmap of authorized group codes to each user.  LAT gets these from
   the operating system and uses them in its requests to the service
   providers.

   The codification of the range of allowed usage of this field is
   outside the scope of this specification.
 */
@DiameterAvpDefinition(code = 36L, vendorId = -1L, name = "Login-LAT-Group")
public interface LoginLATGroup extends DiameterOctetString
{
}