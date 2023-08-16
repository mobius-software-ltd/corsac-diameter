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
	25 - 3GPP-Packet-Filter
	Each 3GPP-Packet-Filter sub-attribute contains only one packet filter. Multiple 3GPP-Packet-Filter sub-attributes can
	be sent in one RADIUS Accounting Request message.
	When the GGSN/P-GW sends the packet filter information, the RADIUS message shall carry ALL (or none) of the
	packet filters.
	
	Direction Value:
	00000000: Downlink
	00000001: Uplink
	
	The packet filter content is represented as Octet String type. The packet filter content is defined below:
	Type Value
	1:  IPv4 address type Contains the source address if the direction value is set
		to Downlink, and the destination address if the 
		direction value is set to Uplink.
		shall be encoded as a sequence of a four octet IPv4
		address field and a four octet IPv4 address mask field.
		The IPv4 address field shall be transmitted first
	2:  IPv6 address type Contains the source address if the direction value is set
		to Downlink, and the destination address if the
		direction value is set to Uplink.
		shall be encoded as a sequence of a sixteen octet IPv6
		address field and a sixteen octet IPv6 address mask
		field. The IPv6 address field shall be transmitted first
	3:  Protocol identifier/Next header
	    type
		shall be encoded as one octet which specifies the IPv4
		protocol identifier or IPv6 next header
	4:  Single destination port type shall be encoded as two octet which specifies a port
	    number
	5 : Destination port range type shall be encoded as a sequence of a two octet port
	    range low limit field and a two octet port range high
		limit field. The port range low limit field shall be
		transmitted first
	6 : Single source port type shall be encoded as two octet which specifies a port
		number
	7:  Source port range type shall be encoded as a sequence of a two octet port
		range low limit field and a two octet port range high
		limit field. The port range low limit field shall be
		transmitted first
	8:  Security parameter index type
		(IPv6)
		shall be encoded as four octet which specifies the IPSec
		security parameter index
	9:  Type of service/Traffic class type shall be encoded as a sequence of a one octet Type-ofService/Traffic Class field and a one octet Type-ofService/Traffic Class mask field. The Type-ofService/Traffic Class field shall be transmitted first
	10: Flow label type (IPv6) shall be encoded as three octets which specify the IPv6
		flow label. The bits 8 through 5 of the first octet shall
		be spare whereas the remaining 20 bits shall contain the
		IPv6 flow label
 */
@DiameterAvpDefinition(code = 25L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-Packet-Filter")
public interface TGPPPacketFilter extends DiameterOctetString
{
}