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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.5.5.  Tunnel-Server-Endpoint AVP

   The Tunnel-Server-Endpoint AVP (AVP Code 67) is of type UTF8String
   and contains the address of the server end of the tunnel.  It MAY be
   used in an authorization request as a hint to the server that a
   specific endpoint is desired, but the server is not required to honor
   the hint in the corresponding response.

   This AVP SHOULD be included in the corresponding ACR messages, in
   which case it indicates the address from which the tunnel was
   initiated.  This AVP, along with the Tunnel-Client-Endpoint
   (Section 4.5.4) and Session-Id AVP ([RFC6733], Section 8.8), can be
   used to provide a globally unique means to identify a tunnel for
   accounting and auditing purposes.

   If Tunnel-Medium-Type is IPv4 (1), then this string is either the
   fully qualified domain name (FQDN) of the tunnel server machine, or a
   "dotted-decimal" IP address.  Implementations MUST support the
   dotted-decimal format and SHOULD support the FQDN format for IP
   addresses.
   
   If Tunnel-Medium-Type is IPv6 (2), then this string is either the
   FQDN of the tunnel server machine, or a text representation of the
   address in either the preferred or alternate form [RFC3516].
   Implementations MUST support the preferred form and SHOULD support
   both the alternate text form and the FQDN format for IPv6 addresses.

   If Tunnel-Medium-Type is not IPv4 or IPv6, this string is a tag
   referring to configuration data local to the Diameter client that
   describes the interface or medium-specific server address to use.

   Note that this application handles IDNs in the same way as the
   Diameter base protocol (see Appendix D of RFC 6733 for details).
 */
@DiameterAvpDefinition(code = AvpCodes.TUNNEL_SERVER_ENDPOINT, vendorId = -1L, name = "Tunnel-Server-Endpoint")
public interface TunnelServerEndpoint extends DiameterUTF8String
{
}