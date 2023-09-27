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
	7.3.9	Visited-PLMN-Id
	The Visited-PLMN-Id AVP is of type OctetString. This AVP shall contain the concatenation of MCC and MNC. See 3GPP TS 23.003 [3]. The content of this AVP shall be encoded as an octet string according to table 7.3.9-1.
	See 3GPP TS 24.008 [31], clause 10.5.1.13, PLMN list, for the coding of MCC and MNC. If MNC is 2 digits long, bits 5 to 8 of octet 2 are coded as "1111".

	Table 7.3.9/1: Encoding format for Visited-PLMN-Id AVP
	8  7  6  5  4  3  2  1
	MCC digit 2 MCC digit 1  octet 1
	MNC digit 3 MCC digit 3  octet 2
	MNC digit 2 MNC digit 1  octet 3
 */
@DiameterAvpDefinition(code = 1407L, vendorId = KnownVendorIDs.TGPP_ID, name = "Visited-PLMN-Id")
public interface VisitedPLMNId extends DiameterOctetString
{
}