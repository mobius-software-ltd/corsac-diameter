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
 * 	5.3.11	Flow-Status AVP
	The Flow-Status AVP (AVP code 511) is of type Enumerated, and describes whether the IP flow(s) are enabled or disabled. The following values are defined:

	ENABLED-UPLINK (0)
		This value shall be used to enable associated uplink IP flow(s) and to disable associated downlink IP flow(s).
	
	ENABLED-DOWNLINK (1)
		This value shall be used to enable associated downlink IP flow(s) and to disable associated uplink IP flow(s).

	ENABLED (2)
		This value shall be used to enable all associated IP flow(s) in both directions.
	
	DISABLED (3)
		This value shall be used to disable all associated IP flow(s) in both directions.

	REMOVED (4)
		This value shall be used to remove all associated IP flow(s). The IP Filters for the associated IP flow(s) shall be removed. The associated IP flows shall not be taken into account when deriving the authorized QoS.

	NOTE 1:	The interpretation of values for the RTCP flows in the Rx interface is described within the procedures in clause 4.4.3.

	NOTE 2: The interpretation of values for IMS flows when SIP Forking is supported is described within the procedures in Annex A.3.1.
 */
@DiameterAvpDefinition(code = 511L, vendorId = KnownVendorIDs.TGPP_ID, name = "Flow-Status")
public interface FlowStatus extends DiameterEnumerated<FlowStatusEnum>
{
}