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
 * 	5.3.34 Tunnel-Header-Filter AVP (All access types)
	The Tunnel-Header-Filter AVP (AVP code 1036) is of type IPFilterRule, and it defines the tunnel (outer) header filter
	information of a MIP tunnel where the associated QoS rules apply for the tunnel payload.
	The Tunnel-Header-Filter AVP shall include the following information:

	- Action shall be set to "permit";

	- Direction (in or out);

	- Protocol;

	- Source IP address;

	- Source port (single value) for UDP tunneling;

	- Destination IP address;

	- Destination port (single value) for UDP tunneling.

	The IPFilterRule type shall be used with the following restrictions:

	- Options shall not be used.

	- The invert modifier "!" for addresses shall not be used.

	The direction "out" refers to downlink direction.
	The direction "in" refers to uplink direction. 
 */
@DiameterAvpDefinition(code = 1036L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Tunnel-Header-Filter")
public interface TunnelHeaderFilter extends DiameterIpFilterRule
{
}