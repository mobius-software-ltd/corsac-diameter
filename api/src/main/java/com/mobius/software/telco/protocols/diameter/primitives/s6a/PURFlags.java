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
	7.3.149	PUR-Flags
	The PUR-Flags AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits is defined in table 7.3.149/1:

	Table 7.3.149/1: PUR-Flags
	bit name
	Description

	0 UE Purged in MME
	This bit, when set, indicates that the combined MME/SGSN has purged the UE in the MME part of the node. This bit shall not be set by a standalone SGSN.

	1 UE Purged in SGSN
	This bit, when set, shall indicate that the combined MME/SGSN has purged the UE in the SGSN part of the node. This bit shall not be set by a standalone MME.

	NOTE:	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving HSS.
*/
@DiameterAvpDefinition(code = 1635L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PUR-Flags")
public interface PURFlags extends DiameterUnsigned32
{
}