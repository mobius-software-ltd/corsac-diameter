package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.205	Non-IP-Data-Delivery-Mechanism
	The Non-IP-Data-Delivery-Mechanism AVP is of type Unsigned32 and indicates the mechanism to be used for Non-IP data delivery for a given APN. The following values are defined:

	SGi-BASED-DATA-DELIVERY (0)
	This value indicates that the Non-IP data is delivered via Point-To-Point tunnelling over the SGi interface.

	SCEF-BASED-DATA-DELIVERY (1)
	This value indicates that the Non-IP data is delivered via the SCEF.

	The default value when this AVP is not present is SGi-BASED-DATA-DELIVERY (0).
 */
@DiameterAvpDefinition(code = 1682L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Non-IP-Data-Delivery-Mechanism")
public interface NonIPDataDeliveryMechanism extends DiameterEnumerated<NonIPDataDeliveryMechanismEnum>
{
}