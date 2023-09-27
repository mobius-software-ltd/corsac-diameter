package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
	7.3.153	UVR-Flags
	The UVR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.3.154/1:
	Table 7.3.154/1: UVR-Flags

	Bit Name
	Description

	0 Skip Subscriber Data
	This bit, when set, indicates that the CSS may skip subscription data in UVA. If the CSG subscription data has changed in the CSS after the last successful update of the MME/SGSN, the CSS shall ignore this bit and send the updated CSG subscription data.
	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving CSS.
*/
@DiameterAvpDefinition(code = 1639L, vendorId = KnownVendorIDs.TGPP_ID, name = "UVR-Flags")
public interface UVRFlags extends DiameterUnsigned32
{
}