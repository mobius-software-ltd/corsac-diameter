package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
	8.4.50	S6t-HSS-Cause
	The S6t-HSS-Cause AVP is of type Unsigned32 and it contains a bitmask. The meaning of the bits is defined in table 8.4.50-1:
	Table 8.4.50-1: S6t-HSS-Cause

	Bit Name
	Description

	0 Absent Subscriber
	This bit, when set, indicates that the UE is not reachable at the serving node and the configuration could not be forwarded, either because there is no serving node registered in the HSS  or because the subscriber is purged in the registered serving node(s).

	1 Group Event Monitoring Partially Cancel
	This bit, when set, indicates that a configured group-based event monitoring is cancelled for the member UE.

	NOTE:	Bits not defined in this table shall be cleared by the sending node and discarded by the receiving node.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.S6T_HSS_CAUSE, vendorId = VendorIDs.TGPP_ID, name = "S6t-HSS-Cause")
public interface S6tHSSCause extends DiameterUnsigned32
{
}