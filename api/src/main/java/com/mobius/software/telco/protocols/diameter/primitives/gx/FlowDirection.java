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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.65 Flow-Direction AVP
	The Flow-Direction AVP (AVP code 1080) is of type Enumerated. It indicates the direction/directions that a filter is
	applicable, downlink only, uplink only or both down- and uplink (bidirectional).

	UNSPECIFIED (0)
 		The corresponding filter applies for traffic to the UE (downlink), but has no specific direction declared. The
		service data flow detection shall apply the filter for uplink traffic as if the filter was bidirectional. The PCRF
		shall not use the value UNSPECIFIED in filters created by the network in NW-initiated procedures. The PCRF
		shall only include the value UNSPECIFIED in filters in UE-initiated procedures if the same value is received
		from in the CCR request from the PCEF.
	DOWNLINK (1)
 		The corresponding filter applies for traffic to the UE.
	UPLINK (2)
 		The corresponding filter applies for traffic from the UE.
	BIDIRECTIONAL (3)
 		The corresponding filter applies for traffic both to and from the UE.
	
	NOTE: The corresponding filter data is unidirectional. The filter for the opposite direction has the same
	parameters, but having the source and destination address/port parameters swapped. 
 */
@DiameterAvpDefinition(code = 1080L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Flow-Direction")
public interface FlowDirection extends DiameterEnumerated<FlowDirectionEnum>
{
}