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
	5.2.3.15	Short-Network-Name
	The Short-Network-Name AVP is of type OctetString; this AVP shall contain the Short Network Name and be encoded as the Short name value field of the AT_SHORT_NAME_FOR_NETWORK attribute specified in clause 8.2.5.2 of 3GPP TS 24.302 [26].
 */
@DiameterAvpDefinition(code = 1517L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Short-Network-Name")
public interface ShortNetworkName extends DiameterOctetString
{
}