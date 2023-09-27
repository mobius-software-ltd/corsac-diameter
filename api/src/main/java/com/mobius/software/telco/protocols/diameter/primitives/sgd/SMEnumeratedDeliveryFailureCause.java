package com.mobius.software.telco.protocols.diameter.primitives.sgd;
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
 * 	6.3.3.6	SM-Enumerated-Delivery-Failure-Cause
	The SM-Enumerated-Delivery-Failure-Cause AVP is of type enumerated and it shall contain the cause of the failure of a SM delivery. The following values are defined:

	MEMORY_CAPACITY_EXCEEDED  (0),

	EQUIPMENT_PROTOCOL_ERROR  (1),

	EQUIPMENT_NOT_SM-EQUIPPED  (2),

	UNKNOWN_SERVICE_CENTRE  (3),

	SC-CONGESTION  (4),

	INVALID_SME-ADDRESS  (5),

	USER_NOT_SC-USER  (6).

	NOTE:	The values of the SM- Enumerated-Delivery-Failure-Cause AVP correspond to the ones for the SM-EnumeratedDeliveryFailureCause parameter in MAP as described in 3GPP TS 29.002[9].  
 */
@DiameterAvpDefinition(code = 3304L, vendorId = KnownVendorIDs.TGPP_ID, name = "SM-Enumerated-Delivery-Failure-Cause")
public interface SMEnumeratedDeliveryFailureCause extends DiameterEnumerated<SMEnumeratedDeliveryFailureCauseEnum>
{
}