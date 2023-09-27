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
	7.3.154	UVA-Flags
	The UVA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.3.156/1:
	Table 7.3.156/1: UVA-Flags

	Bit Name
	Description

	0 Temporary Empty VPLMN CSG Subscription Data
	This bit, when set, indicates that the CSS has currently no VPLMN CSG subscription data for this user but has registered the MME or SGSN, so to inform them if later changes in VPLMN CSG subscription data occur.
	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving CSS.
*/
@DiameterAvpDefinition(code = 1640L, vendorId = KnownVendorIDs.TGPP_ID, name = "UVA-Flags")
public interface UVAFlags extends DiameterUnsigned32
{
}