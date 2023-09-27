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
 * 	7.3.93	PLMN-Client
	The PLMN-Client AVP is of type Enumerated. The following values are defined:
	
	BROADCAST_SERVICE (0)

	O_AND_M_HPLMN (1)

	O_AND_M_VPLMN (2)

	ANONYMOUS_LOCATION (3)

	TARGET_UE_SUBSCRIBED_SERVICE (4)
 */
@DiameterAvpDefinition(code = 1482L, vendorId = KnownVendorIDs.TGPP_ID, name = "PLMN-Client")
public interface PLMNClient extends DiameterEnumerated<PLMNClientEnum>
{
}