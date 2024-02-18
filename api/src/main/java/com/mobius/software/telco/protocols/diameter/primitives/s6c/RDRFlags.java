package com.mobius.software.telco.protocols.diameter.primitives.s6c;
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
	5.3.3.21	RDR-Flags
	The RDR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 5.3.3.21/1:
	Table 5.3.3.21/1: RDR-Flags

	Bit Name
	Description

	0 Single-Attempt-Delivery
	This bit if set indicates that only one delivery attempt shall be performed for this particular SM.

	NOTE 1: Bits not defined in this table shall be cleared by the sending entity and discarded by the receiving entity.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RDR_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "RDR-Flags")
public interface RDRFlags extends DiameterBitmask32
{
	public static final int SINGLE_ATTEMPT_DELIVERY_BIT = 0;	
	
	public void setSingleAttemptDeliveryBit(boolean isOn);
	
	public boolean isSingleAttemptDeliveryBitSet();
}