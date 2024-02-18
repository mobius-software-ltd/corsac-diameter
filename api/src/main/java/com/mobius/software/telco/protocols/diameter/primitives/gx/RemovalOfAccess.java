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
 * 	5.3.126 Removal-Of-Access AVP
	The Removal-Of-Access AVP (AVP code 2842) is of type Enumerated and is used by the PCRF to indicate one access
	shall be removed from multi access IP-CAN session.
	The following values are defined:

	REMOVAL_OF_ACCESS (0)
 		This value indicates that one access shall be removed from multi access IP-CAN session.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REMOVAL_OF_ACCESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "Removal-Of-Access")
public interface RemovalOfAccess extends DiameterEnumerated<RemovalOfAccessEnum>
{
}