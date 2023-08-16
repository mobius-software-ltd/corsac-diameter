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
 * 4.4.11.5.4.  Login-LAT-Port AVP

   The Login-LAT-Port AVP (AVP Code 63) is of type OctetString and
   contains the port with which the user is to be connected by LAT.  It
   MAY be used in an authorization request as a hint to the server that
   a specific port is desired, but the server is not required to honor
   the hint in the corresponding response.  This AVP MUST only be
   present in a response if the Login-Service-Type AVP is set to LAT.

   The String field contains the identity of the LAT service to use.
   The LAT Architecture allows this string to contain $ (dollar), -
   (hyphen), . (period), _ (underscore), numerics, upper- and lower-case
   alphabetics, and the ISO Latin-1 character set extension
   [ISO.8859-1.1987].

   All LAT string comparisons are case insensitive.
 */
@DiameterAvpDefinition(code = 63L, vendorId = -1L, name = "Login-LAT-Port")
public interface LoginLATPort extends DiameterOctetString
{
}