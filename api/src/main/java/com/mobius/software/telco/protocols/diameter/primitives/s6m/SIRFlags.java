package com.mobius.software.telco.protocols.diameter.primitives.s6m;
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
	6.4.10	SIR-Flags
	The SIR-Flags AVP is of type Unsigned32 and it contains a bit mask. The meaning of the bits is defined in table 6.4.10/1:
	Table 6.4.10/1: SIR-Flags

	bit name
	Description	

	0 S6m/S6n Indicator
	This bit, when set, indicates that the SIR message is sent on the S6m interface, i.e. the source node is an MTC-IWF.
	This bit, when cleared, indicates that the SIR message is sent on the S6n interface, i.e. the source node is an MTC-AAA.

	Note:	Bits not defined in this table shall be cleared by the sending node, MTC-IWF or MTC-AAA, and discarded by the receiving HSS.
 */
@DiameterAvpDefinition(code = 3110L, vendorId = KnownVendorIDs.TGPP_ID, name = "SIR-Flags")
public interface SIRFlags extends DiameterUnsigned32
{
}