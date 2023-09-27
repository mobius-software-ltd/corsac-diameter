package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 * 	5.3.12	Flow-Usage AVP
	The Flow-Usage AVP (AVP code 512) is of type Enumerated, and provides information about the usage of IP Flows. The following values are defined:
	
	NO_INFORMATION (0)
		This value is used to indicate that no information about the usage of the IP flow is being provided.

	RTCP (1)
		This value is used to indicate that an IP flow is used to transport RTCP.

	AF_SIGNALLING (2)
		This value is used to indicate that the IP flow is used to transport AF Signalling Protocols (e.g. SIP/SDP).

	NO_INFORMATION is the default value.
	
	NOTE:	An AF may choose not to identify RTCP flows, e.g. in order to avoid that RTCP flows are always enabled by the server.
 */
@DiameterAvpDefinition(code = 512L, vendorId = KnownVendorIDs.TGPP_ID, name = "Flow-Usage")
public interface FlowUsage extends DiameterEnumerated<FlowUsageEnum>
{
}