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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.6	3GPP2-MEID
	This AVP is of type OctetString. This AVP contains the Mobile Equipment Identifier of the user's terminal. For further 
	details on the encoding of the AVP data, refer to the encoding of the Mobile Identity (MEID) octets 3 to 10 in 3GPP2 A.S0022 [28] Annex A.
 */
@DiameterAvpDefinition(code = 1471L, vendorId = KnownVendorIDs.TGPP_ID, name = "3GPP2-MEID")
public interface TGPP2MEID extends DiameterOctetString
{
}