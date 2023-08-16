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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.20 Bearer-Identifier AVP (Applicable access type 3GPP-GPRS)
	The Bearer-Identifier AVP (AVP code 1020) is of type OctetString, and it indicates the bearer to which specific
	information refers.
	When present within a CC-Request Diameter command, subsequent AVPs within the CC-Request refer to the specific
	bearer identified by this AVP.
	The bearer identifier of an IP CAN bearer shall be unique within the corresponding IP CAN session. The bearer
	identifier shall be selected by the PCEF.
 */
@DiameterAvpDefinition(code = 1020L, vendorId = KnownVendorIDs.TGPP_ID, name = "Bearer-Identifier")
public interface BearerIdentifier extends DiameterOctetString
{
}