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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.70	5GMM-Cause AVP
	The 5GMM-Cause AVP (AVP code 573) is of type Unsigned32 and indicates the 5GMM cause code information. The AVP shall be coded as per the 5GMM Cause in clause 9.11.3.2 of 3GPP TS 24.501 [70].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FIVE_GMM_CAUSE, vendorId = VendorIDs.TGPP_ID, must = false, name = "5GMM-Cause")
public interface FiveGMMCause extends DiameterUnsigned32
{
}