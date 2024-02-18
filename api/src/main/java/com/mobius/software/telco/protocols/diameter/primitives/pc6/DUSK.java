package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
	6.3.77	DUSK 
	The DUSK AVP is of type OctetString. It shall contain the Discovery User Scrambling Key used to scramble or unscramble the restricted ProSe direct discovery message containing the ProSe Restricted Code, ProSe Query Code or ProSe Response Code. The format of the DUSK is defined in 3GPP TS 33.303 [23].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DUSK, vendorId = VendorIDs.TGPP_ID, must = false, name = "DUSK")
public interface DUSK extends DiameterOctetString
{
}