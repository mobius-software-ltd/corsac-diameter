package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.54 Packet-Filter-Content AVP
	The Packet-Filter-Content AVP (AVP code 1059) is of type IPFilterRule, and it contains the content of the packet filter
	as requested by the UE and required by the PCRF to create the PCC rules. The following information shall be sent:

	- Action shall be set to "permit".

	- Direction shall be set to "out".

	- Protocol shall be set to the value provided within the packet filter provided by the UE. If not provided, Protocol
	  shall be set to "ip".

	- Source IP address (possibly masked). The Source IP address shall be derived from the packet filter parameters,
	  for the remote end, sent by the UE. If the Source IP address is not provided by the UE, this field shall be set to
	  "any".

	- Source and/or destination port (single value, list or ranges). The information shall be derived from the remote
	  and/or local port packet filter parameters. Source and/or destination port(s) shall be omitted if the corresponding
	  information is not provided in the packet filter.

	- Destination IP address (possibly masked). The Destination IP address shall be derived from the packet filter
	  parameters sent by the UE. The Destination shall be set to the value provided by the UE. If no Destination IP
	  address is provided in the packet filter the Destination shall be set to "assigned", which refers to the Ipv4 address
	  and/or Ipv6 prefix of the UE as indicated by the Framed-IP-Address and/or Framed-Ipv6-Prefix AVPs.

	The IPFilterRule type shall be used with the following restrictions:

	- No options shall be used.

	- The invert modifier "!" for addresses shall not be used.

	The direction "out" indicates that the IPFilterRule "source" parameters correspond to the "remote" parameters in the
	packet filter and the IPFilterRule "destination" parameters correspond to the "local" (UE end) parameters. The PacketFilter-Content AVP applies in the direction(s) as specified in the accompanying Flow-Direction AVP.
	Destination IP address including the value provided by the UE may be provided within the Packet-Filter-Content AVP
	when the ExtendedFilter feature is supported as described in clause 5.4.1. 
 */
@DiameterAvpDefinition(code = 1059L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Packet-Filter-Content")
public interface PacketFilterContent extends DiameterIpFilterRule
{
}