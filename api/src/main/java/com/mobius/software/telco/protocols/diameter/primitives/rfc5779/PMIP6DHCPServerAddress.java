package com.mobius.software.telco.protocols.diameter.primitives.rfc5779;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.4.  PMIP6-DHCP-Server-Address AVP

   The PMIP6-DHCP-Server-Address AVP (AVP Code 504) is of type Address
   and contains the IP address of the Dynamic Host Configuration
   Protocol (DHCP) server assigned to the MAG serving the newly attached
   MN.  If the AVP contains a DHCPv4 [RFC2131] server address, then the
   Address type MUST be IPv4.  If the AVP contains a DHCPv6 [RFC3315]
   server address, then the Address type MUST be IPv6.  The HAAA MAY
   assign a DHCP server to the MAG in deployments where the MAG acts as
   a DHCP Relay [NETLMM-PMIP6].
 */
@DiameterAvpDefinition(code = 504L, vendorId = -1L, name = "PMIP6-DHCP-Server-Address")
public interface PMIP6DHCPServerAddress extends DiameterAddress
{
}