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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.84 PS-to-CS-Session-Continuity AVP (3GPP-EPS access type only)
	The PS-to-CS-Session-Continuity AVP (AVP code 1099) is of type Enumerated, and indicates whether the service data
	flow is a candidate for PS to CS session continuity as specified in 3GPP TS 23.216 [40].
	The following values are defined:

	VIDEO_PS2CS_CONT_CANDIDATE (0)
 		This value is used to indicate that the service data flow carries video and is a candidate for PS to CS session
		continuity. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PS_TO_CS_SESSION_CONTINUITY, vendorId = VendorIDs.TGPP_ID, name = "PS-to-CS-Session-Continuity")
public interface PSToCSSessionContinuity extends DiameterEnumerated<PSToCSSessionContinuityEnum>
{
}