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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	1 - 3GPP-IMSI
	Length: m ≤ 17
	IMSI value: Text type:
	A GGSN (or a P-GW) receives IMSI that is encoded according to 3GPP TS 29.060 [24] (or 3GPP TS 29.274 [81]) and
	converts IMSI into the UTF-8 characters, which are encoded as defined in 3GPP TS 23.003 [40]. There shall be no
	padding characters between the MCC and MNC, and between the MNC and MSIN. If the IMSI is less than 15 digits,
	the padding in the GTP information element shall be removed by the GGSN (or the P-GW) and not encoded in this subattribute.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TGPP_IMSI, vendorId = VendorIDs.TGPP_ID, must = false, name = "3GPP-IMSI")
public interface TGPPIMSI extends DiameterUTF8String
{
}