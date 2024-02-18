package com.mobius.software.telco.protocols.diameter.primitives.s6b;
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
	9.2.3.7	DER-S6b-Flags
	The DER-S6b-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be asdefined in table 9.2.3.7/1:
	
	Table 9.2.3.7/1: DER-S6b-Flags
	Bit Name Description
	0  Initial-Attach-Indicator
	This bit, when set, indicates that a UE performs the Initial Attach procedure from non-3GPP access network. When not set, it indicates that a UE performs 
	the Handover procedure.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.

 */
@DiameterAvpDefinition(code = TgppAvpCodes.DER_S6B_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "DER-S6b-Flags")
public interface DERS6bFlags extends DiameterBitmask32
{
	public static final int INITIAL_ATTACH_INDICATOR_BIT = 0;	
	
	public void setInitialAttachIndicatorBit(boolean isOn);
	
	public boolean isInitialAttachIndicatorBitSet();
}