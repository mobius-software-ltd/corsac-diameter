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
	9 - 3GPP-GGSN MCC-MNC
	Length: n shall be 7 or 8 octets depending on the presence of MNC digit 3
	GGSN address value: Text type.
	This is the UTF-8 encoding of the GGSN MCC-MNC values. In accordance with 3GPP TS 23.003 [40] and 3GPP TS
	29.060 [24] the MCC shall be 3 digits and the MNC shall be either 2 or 3 digits. There shall be no padding characters
	between the MCC and MNC.  
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TGPP_GGSN_MCC_MNC, vendorId = VendorIDs.TGPP_ID, must = false, name = "3GPP-GGSNMCC-MNC")
public interface TGPPGGSNMCCMNC extends DiameterUTF8String
{
}