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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.6	S1AP-Cause
	The S1AP-Cause AVP is of type Unsigned32. It shall contain a non-transparent copy of the S1AP cause code as specified clause 9.2.1.3 of 3GPP TS 36.413 [13]. The RAN cause sub-category of the S1AP-Cause as specified in 3GPP TS 36.413 [13] shall be encoded in the Cause-Type AVP as specified in clause 6.4.5 above.
 */
@DiameterAvpDefinition(code = 4302L, vendorId = KnownVendorIDs.TGPP_ID, name = "S1AP-Cause")
public interface S1APCause extends DiameterUnsigned32
{
}