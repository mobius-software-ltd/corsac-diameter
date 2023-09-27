package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
	7.4.59	1xRTT-RCID
	The 1xRTT-RCID AVP is of type OctetString. It indicates the 1xRTT Reference Cell Id that consists of a Cell Identification Discriminator and a Cell Identification and shall be formatted according to octets 3 through the end of the Cell Identifier element defined in clause 4.2.17 in 3GPP2 A.S0014-D [22]. The allowable cell discriminator values are "0000 0010", and "0000 0111".
 */
@DiameterAvpDefinition(code = 2554L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "1xRTT-RCID")
public interface OneXRTTRCID extends DiameterOctetString
{
}