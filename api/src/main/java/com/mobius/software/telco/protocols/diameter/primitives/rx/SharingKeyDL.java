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
 * 	5.3.37	Sharing-Key-DL AVP
	The Sharing-Key-DL AVP (AVP code 539) is of type Unsigned32 and is used to identify what media components may share resource in the downlink direction.
	The Sharing-Key-DL AVP shall be used as follows:
	-	If resource sharing applies between media components across AF sessions for the same user, the same value of the Sharing-Key-DL AVP shall be used;
	-	If resource sharing does not apply between media components across AF sessions for the same user, a different value of the Sharing-Key-DL AVP shall be used for each media component.
 */
@DiameterAvpDefinition(code = 539L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Sharing-Key-DL")
public interface SharingKeyDL extends DiameterUnsigned32
{
}