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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.201	AIR-Flags
	The AIR-Flags AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits is defined in table 7.3.201/1:
	Table 7.3.201/1: AIR-Flags

	bit name
	Description

	0 Send UE Usage Type
	This bit, when set, indicates that the MME or SGSN requests the HSS to send the subscription parameter "UE Usage Type".

	NOTE:	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving HSS.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.AIR_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "AIR-Flags")
public interface AIRFlags extends DiameterBitmask32
{
	public static final int UE_USAGE_REQUESTED_BIT = 0;
	
	public void setUEUsageRequestedBit(boolean isOn);
	
	public boolean isUEUsageRequestedBitSet();
}