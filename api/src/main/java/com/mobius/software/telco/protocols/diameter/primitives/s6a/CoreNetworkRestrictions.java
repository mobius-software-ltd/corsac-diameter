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
 * 	7.3.230	Core-Network-Restrictions
	The Core-Network-Restrictions AVP is of type Unsigned32 and shall contain a bitmask indicating the types of Core Network that are disallowed for a given user. The meaning of the bits shall be as defined in table 7.3.230-1:
	Table 7.3.230-1: Core-Network-Restrictions

	Bit Name
	Description

	0 Reserved
	The use of this bit is deprecated. This bit shall be discarded by the receiving MME.

	1 5GC not allowed
	Access to 5GC not allowed.

	NOTE:	Bits not defined in this table shall be cleared by the HSS and discarded by the MME.
 */
@DiameterAvpDefinition(code = 1704L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Core-Network-Restrictions")
public interface CoreNetworkRestrictions extends DiameterUnsigned32
{
}