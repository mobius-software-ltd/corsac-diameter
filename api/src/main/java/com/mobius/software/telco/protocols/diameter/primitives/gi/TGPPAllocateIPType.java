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
	27 – 3GPP-Allocate-IP-Type
	If multiple Access-Request signalling towards a AAA server is needed during the lifetime of a PDN connection (e.g. for PDN/PDP type IPv4v6 and deferred IPv4 addressing), this sub-attribute shall be included in the Access-Request message to indicate how the AAA server needs to treat the request. The P-GW/GGSN may also use this sub-attribute if the AAA server is configured to allocate both IPv4 address and IPv6 prefix but the P-GW/GGSN requires assignment of only one IP type or both IP types (e.g. because the UE supports single IP stack and it has requested PDN/PDP type of IPv4 or IPv6).
	If this sub-attribute does not exist in Access-Request from P-GW/GGSN to the AAA server, the IP address allocation shall be based on the IP address allocation policy configured in the the AAA server. 
	IP Type field: It is encoded in Octet String type and the following decimal equivalent values apply:

	0	Do not allocate IPv4 address or IPv6 prefix. 
	The typical use case is for PDN/PDP type IPv4v6 and deferred IPv4 addressing and only IPv4 address is allocated by the AAA server but IPv6 prefix is allocated by some other means, e.g. local pool in the P-GW/GGSN. The Access-Request from the P-GW/GGSN to the AAA server during the UE’s initial access to the network shall set the value of this sub-attribute to 0.

	1	Allocate IPv4 address
	The typical use case is for PDN/PDP type IPv4v6 and deferred IPv4 addressing and the IPv4 address (and/or IPv6 prefix) is allocated by the AAA server. The Access-Request from the P-GW/GGSN to the AAA server when the P-GW/GGSN receives UE-initiated IPv4 address allocation signalling (e.g. DHCPv4) after UE’s successful initial access to the PDN shall set the value of this attribute to 1.  In this case, if the AAA server had allocated an IPv6 prefix earlier during UE’s initial access to the network, same IPv6 prefix shall be kept allocated. 

	2	Allocate IPv6 prefix
	The typical use case is for PDN/PDP type IPv4v6 and deferred IPv4 addressing and both IPv4 address and IPv6 prefix are allocated by the AAA server. The Access-Request from the P-GW/GGSN to the AAA server during the UE’s initial access to the network shall set the value of this sub-attribute to 2.

	3	Allocate IPv4 address and IPv6 prefix
	Currently there is no use case identified to use this specific value for PDN/PDP tpe IPv4v6 and deferred IPv4 addressing. One potential use case is for PDN/PDP type IPv4v6 and non-deferred IPv4 addressing and both IPv4 address and IPv6 prefix are allocated by the AAA server. The Accesss-Request from the P-GW/GGSN to the AAA server may use this value to have both IPv4 address and IPv6 prefix assigned to the UE. 

	4-255	Reserved for future use 
*/
@DiameterAvpDefinition(code = 27L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-Allocate-IP-Type")
public interface TGPPAllocateIPType extends DiameterOctetString
{
}