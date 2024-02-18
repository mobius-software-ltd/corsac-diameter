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
 * 	7.3.174	Restoration-Priority
	The Restoration-Priority AVP is of type Unsigned32. It shall indicate the relative priority of a user's PDN connection among PDN connections to the same APN when restoring PDN connections affected by an SGW or PGW failure/restart (see 3GPP TS 23.007 [43]).
	Values 1 to 16 are defined, with value 1 as the highest level of priority.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RESTORATION_PRIORITY, vendorId = VendorIDs.TGPP_ID, must = false, name = "Event-Threshold-Event-1I")
public interface RestorationPriority extends DiameterUnsigned32
{
}