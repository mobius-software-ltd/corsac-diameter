package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
	6.3.2 MSISDN AVP
	The MSISDN AVP is of type OctetString. This AVP contains an MSISDN, in international number format as described
	in ITU-T Rec E.164 [8], encoded as a TBCD-string, i.e. digits from 0 through 9 are encoded 0000 to 1001; 1111 is used
	as a filler when there is an odd number of digits; bits 8 to 5 of octet n encode digit 2n; bits 4 to 1 of octet n encode digit
	2(n-1)+1. 
 */
@DiameterAvpDefinition(code = 701L, vendorId = KnownVendorIDs.TGPP_ID, name = "MSISDN")
public interface MSISDN extends DiameterE164Address
{
}