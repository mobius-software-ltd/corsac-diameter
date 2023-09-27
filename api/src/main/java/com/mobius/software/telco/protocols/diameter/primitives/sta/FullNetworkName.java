package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	5.2.3.14	Full-Network-Name
	The Full-Network-Name AVP is of type OctetString; this AVP shall contain the Full Network Name and be encoded as the Full name value field of the AT_FULL_NAME_FOR_NETWORK attribute specified in clause 8.2.5.1 of 3GPP TS 24.302 [26].
 */
@DiameterAvpDefinition(code = 1516L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Full-Network-Name")
public interface FullNetworkName extends DiameterOctetString
{
}