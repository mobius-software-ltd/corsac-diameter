package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
 * 	7.4.20	Location-Event
	The Location-Event AVP is of type Enumerated. The following values are defined:

	EMERGENCY_CALL_ORIGINATION (0)

	EMERGENCY_CALL_RELEASE (1)

	MO_LR (2)

	EMERGENCY_CALL_HANDOVER (3)

	DEFERRED_MT_LR_RESPONSE (4)
	
	DEFERRED_MO_LR_TTTP_INITIATION (5)

	DELAYED_LOCATION_REPORTING (6)

	HANDOVER_TO_5GC (7)

	DEFERRED_MT_LR_RESPONSE is applicable to the delivery of an event report and/or a location estimate for an LDR initiated earlier by either the network (via an MT-LR activate deferred location) or the UE (via a periodic MO-LR TTTP initiation for a UE with UTRAN access).

	DELAYED_LOCATION_REPORTING is applicable to the delivery of a location estimate for an EPC-MT-LR or PS-MT-LR initiated earlier by the network for a UE which was transiently not reachable.
 */
@DiameterAvpDefinition(code = 2518L, vendorId = KnownVendorIDs.TGPP_ID, name = "Location-Event")
public interface LocationEvent extends DiameterEnumerated<LocationEventEnum>
{
}