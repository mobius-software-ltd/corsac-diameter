package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
	6.4.8	BSSGP-Cause
	The BSSGP-Cause AVP is of type Unsigned32. It shall contain the non-transparent copy of the cause value of the BSSGP "Cause" as specified in clause 11.3.8 in 3GPP TS 48.018 [14].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.BSS_GP_CAUSE, vendorId = VendorIDs.TGPP_ID, name = "BSSGP-Cause")
public interface BSSGPCause extends DiameterUnsigned32
{
}