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
 * 	8.4.78	PDN-Connectivity-Status-Type
	The PDN-Connectivity-Status-Type AVP is of type Unsigned32 and it shall indicate the status of the PDN Connection being monitored. The following values are defined:

	CREATED (0)
	The value CREATED (0) indicates that the event corresponds to the creation of a new PDN Connection on the monitored APN.

	DELETED (1)
	The value DELETED (1) indicates that the event corresponds to the deletion of a PDN Connection on the monitored APN.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PDN_CONNECTIVITY_STATUS_TYPE, vendorId = VendorIDs.TGPP_ID, must = false, name = "PDN-Connectivity-Status-Type")
public interface PDNConnectivityStatusType extends DiameterEnumerated<PDNConnectivityStatusTypeEnum>
{
}