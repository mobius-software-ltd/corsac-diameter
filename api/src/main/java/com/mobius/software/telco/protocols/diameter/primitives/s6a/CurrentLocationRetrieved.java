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
 * 	7.3.125	Current-Location-Retrieved
	The Current-Location-Retrieved AVP is of type Enumerated. The following values are defined:

	ACTIVE-LOCATION-RETRIEVAL (0)

	This value is used when location information was obtained after a successful paging procedure for Active Location Retrieval when the UE is in 
	idle mode or after retrieving the most up-to-date location information from the eNB when the UE is in connected mode.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CURRENT_LOCATION_RETRIEVED, vendorId = VendorIDs.TGPP_ID, must = false, name = "Current-Location-Retrieved")
public interface CurrentLocationRetrieved extends DiameterEnumerated<CurrentLocationRetrievedEnum>
{
}