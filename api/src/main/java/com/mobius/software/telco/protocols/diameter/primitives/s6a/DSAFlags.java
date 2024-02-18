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
	7.3.26	DSA-Flags	
	The DSA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits is defined in table 7.3.26/1:
	Table 7.3.26/1: DSA-Flags

	Bit Name
	Description

	0 Network Node area restricted
	This bit, when set, shall indicate that the complete Network Node area (SGSN area) is restricted due to regional subscription.

	Note: Bits not defined in this table shall be cleared by the sending SGSN and discarded by the receiving HSS.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DSA_FLAGS, vendorId = VendorIDs.TGPP_ID, name = "DSA-Flags")
public interface DSAFlags extends DiameterBitmask32
{
	public static final int NETWORK_NODE_AREA_RESTRICTED_BIT = 0;
	
	public void setNetworkNodeAreaRestrictedBit(boolean isOn);
	
	public boolean isNetworkNodeAreaRestrictedBitSet();	
}