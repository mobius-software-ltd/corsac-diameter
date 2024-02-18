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
 * 	5.3.21 Bearer-Operation AVP (Applicable access type 3GPP-GPRS)
	The Bearer-Operation AVP (AVP code 1021) is of type of Enumerated, and it indicates the bearer event that causes a
	request for PCC rules. This AVP shall be supplied if the bearer event relates to an IP CAN bearer initiated by the UE.
	The following values are defined:

	TERMINATION (0)
 		This value is used to indicate that a bearer is being terminated.
	ESTABLISHMENT (1)
 		This value is used to indicate that a new bearer is being established.
	MODIFICATION (2)
 		This value is used to indicate that an existing bearer is being modified.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.BEARER_OPERATION, vendorId = VendorIDs.TGPP_ID, name = "Bearer-Operation")
public interface BearerOperation extends DiameterEnumerated<BearerOperationEnum>
{
}