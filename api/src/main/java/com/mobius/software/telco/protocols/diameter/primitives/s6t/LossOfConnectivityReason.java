package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.58	Loss-Of-Connectivity-Reason
	The Loss-Of Connectivity-Reason AVP is of type Unsigned32 and shall identify the reason why loss of connectivity is reported. The following values are defined:

	UE_DETACHED_MME (0)

	UE_DETACHED_SGSN (1)

	MAX_DETECTION_TIME_EXPIRED_MME (2)

	MAX_DETECTION_TIME_EXPIRED_SGSN (3)

	UE_PURGED_MME (4)

	UE_PURGED_SGSN (5)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOSS_OF_CONNECTIVITY_REASON, vendorId = VendorIDs.TGPP_ID, must = false, name = "Loss-Of-Connectivity-Reason")
public interface LossOfConnectivityReason extends DiameterEnumerated<LossOfConnectivityReasonEnum>
{
}