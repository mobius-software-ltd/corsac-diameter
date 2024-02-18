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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.25	CMR-Flags
	The CMR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 6.4.25/1:
	Table 6.4.25/1: CMR-Flags

	Bit Name
	Description

	0 UE-Reachable-Indicator
	This bit if set indicates that the UE has become or is about to become reachable.

	NOTE 1: Bits not defined in this table shall be cleared by the sending entity and discarded by the receiving entity.	
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CMR_FLAGS, vendorId = VendorIDs.TGPP_ID, name = "CMR-Flags")
public interface CMRFlags extends DiameterBitmask32
{
	public static final int UE_REACHABLE_INDICATOR_BIT = 0;	
	
	public void setUEReachableIndicatorBit(boolean isOn);
	
	public boolean isUEReachableIndicatorSet();
}