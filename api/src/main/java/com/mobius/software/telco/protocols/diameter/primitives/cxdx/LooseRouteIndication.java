package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.45	Loose-Route-Indication AVP
	The Loose-Route-Indication AVP is of type Enumerated and indicates to the S-CSCF whether or not the loose route mechanism is required to serve the registered Public User Identities. The following values are defined:

	LOOSE_ROUTE_NOT_REQUIRED (0)

	LOOSE_ROUTE_REQUIRED (1)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOOSE_ROUTE_INDICATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Loose-Route-Indication")
public interface LooseRouteIndication extends DiameterEnumerated<LooseRouteIndicationEnum>
{
}