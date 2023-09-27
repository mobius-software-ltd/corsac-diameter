package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
	6.3.59	LIA-Flags
	The LIA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 6.3.59.1.
	Table 6.3.59.1: LIA-Flags
	Bit Name
	Description

	0 PSI Direct Routing Indication
	This bit, when set, indicates the request corresponds to PSI Direct Routing, what implies that HSS returns an AS name in Server-Name AVP.

	NOTE: Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving I-CSCF.
 */
@DiameterAvpDefinition(code = 653L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "LIA-Flags")
public interface LIAFlags extends DiameterUnsigned32
{
}