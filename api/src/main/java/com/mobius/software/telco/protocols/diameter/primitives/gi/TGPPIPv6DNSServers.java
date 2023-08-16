package com.mobius.software.telco.protocols.diameter.primitives.gi;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	17 - 3GPP-IPv6-DNS-Servers
	IPv6 DNS Server value: IPv6 Address.
	IPv6 DNS Server address is Octet String type.
	The 3GPP- IPv6-DNS-Servers sub-attribute provides a list of one or more ('n') IPv6 addresses of Domain Name Server
	(DNS) servers for an APN. The DNS servers are listed in the order of preference for use by a client resolver, i.e. the
	first is 'Primary DNS Server', the second is 'Secondary DNS Server' etc. The sub-attribute may be included in AccessAccept packets. 
 */
@DiameterAvpDefinition(code = 17L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-IPv6-DNSServers")
public interface TGPPIPv6DNSServers extends DiameterOctetString
{
}