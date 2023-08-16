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
 * 4.5.11.  Tunnel-Server-Auth-Id AVP

   The Tunnel-Server-Auth-Id AVP (AVP Code 91) is of type UTF8String and
   specifies the 7-bit US-ASCII name used by the tunnel terminator
   during the authentication phase of tunnel establishment.  It MAY be
   used in an authorization request as a hint to the server that a
   specific preference is desired, but the server is not required to
   honor the hint in the corresponding response.  This AVP MUST be
   present in the authorization response if an authentication name other
   than the default is desired.  This AVP SHOULD be included in the ACR
   messages pertaining to the tunneled session.
 */
@DiameterAvpDefinition(code = 91L, vendorId = -1L, name = "Tunnel-Server-Auth-Id")
public interface TunnelServerAuthId extends DiameterUTF8String
{
}