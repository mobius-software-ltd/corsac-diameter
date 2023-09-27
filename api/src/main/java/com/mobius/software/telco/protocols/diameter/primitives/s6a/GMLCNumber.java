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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterE164Address;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.85	GMLC-Number
	The GMLC-Number AVP is of type OctetString. This AVP shall contain the ISDN number of the GMLC in international number format as described in ITU-T Rec E.164 [41] and shall be encoded as a TBCD-string. See 3GPP TS 29.002 [24] for encoding of TBCD-strings. This AVP shall not include leading indicators for the nature of address and the numbering plan; it shall contain only the TBCD-encoded digits of the address.
 */
@DiameterAvpDefinition(code = 1474L, vendorId = KnownVendorIDs.TGPP_ID, name = "GMLC-Number")
public interface GMLCNumber extends DiameterE164Address
{
}