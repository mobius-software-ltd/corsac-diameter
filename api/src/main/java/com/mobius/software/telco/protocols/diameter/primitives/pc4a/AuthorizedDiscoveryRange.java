package com.mobius.software.telco.protocols.diameter.primitives.pc4a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.13	Authorized-Discovery-Range
	The Authorized-Discovery-Range AVP is of type Unsigned32 and it shall contain a value that indicates the authorised 
	announcing range (short/medium/long) at which the UE is allowed to announce in the given PLMN according to the defined 
	announcing authorisation policy for this UE. Refer to 3GPP TS 24.334 [16] for the policy handling and to 3GPP TS 24.333 [17] 
	for the possible values of the range.
 */
@DiameterAvpDefinition(code = 3708L, vendorId = KnownVendorIDs.TGPP_ID, name = "Authorized-Discovery-Range")
public interface AuthorizedDiscoveryRange extends DiameterUnsigned32
{
}