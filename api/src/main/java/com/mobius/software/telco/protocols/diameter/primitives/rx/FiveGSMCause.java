package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.3.71	5GSM-Cause AVP
	The 5GSM-Cause AVP (AVP code 574) is of type Unsigned32 and indicates the 5GSM cause code information. The AVP shall be coded as per the 5GSM Cause in clause 9.11.4.2 of 3GPP TS 24.501 [70].
 */
@DiameterAvpDefinition(code = 574L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "5GSM-Cause")
public interface FiveGSMCause extends DiameterUnsigned32
{
}