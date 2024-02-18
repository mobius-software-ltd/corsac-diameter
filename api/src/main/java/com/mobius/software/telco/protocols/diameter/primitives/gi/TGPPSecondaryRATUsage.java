package com.mobius.software.telco.protocols.diameter.primitives.gi;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	31 – 3GPP-Secondary-RAT-Usage
	3GPP Type: 31
	Length=28
	Multiple 3GPP-Secondary-RAT-Usage sub-attributes can be sent in one RADIUS Accounting Request Interim-Update/STOP message.

	Octet 3 is Octet String type. The encoding of RAT field (bit 1 to bit 4) is:
	0 – NR
	1 – NR-U
	2 – EUTRA
	3 – EUTRA-U
	4 – Unlicensed Spectrum
	5-15 – spare, reserved for future use 

	SESS (bit 5): If it is set to 1, it indicates the secondary RAT usage of the PDU session.
	The values 1, 2 and 3 of RAT field and SESS field do not apply for the present specification. For specifications referencing the present RADIUS VSA, they shall only apply if it is explicitely endorsed within the referencing specification. Bit 6 to bit 8 of octet 3 is spare and reserved for future use.
	The encoding of octets 4 to 28 is specified in Secondary RAT Usage Data Report IE of 3GPP TS 29.274 [81].
*/
@DiameterAvpDefinition(code = TgppAvpCodes.TGPP_SECONDARY_RAT_USAGE, vendorId = VendorIDs.TGPP_ID, must = false, name = "3GPP-Secondary-RAT-Usage")
public interface TGPPSecondaryRATUsage extends DiameterOctetString
{
}