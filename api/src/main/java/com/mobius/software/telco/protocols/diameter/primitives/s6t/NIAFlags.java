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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	8.4.72	NIA-Flags
	The NIA-Flags AVP is of type AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.4.72-1:
	Table 8.4.72-1: NIA-Flags

	Bit Name
	Description

	0 Incomplete Group-User-Identifier-List
	This bit is set when the HSS indicates that the sent Group User Identifier List is incomplete and more segments of the list will follow within subsequent NIR commands.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NIA_FLAGS, vendorId = VendorIDs.TGPP_ID,must = false, name = "NIA-Flags")
public interface NIAFlags extends DiameterBitmask32
{
	public static final int INCOMPLETE_GROUP_USER_IDENTIFIER_LIST_BIT = 0;
	
	public void setIncompleteGroupUserIdentifierListBit(boolean isOn);
	
	public boolean isIncompleteGroupUserIdentifierListBitSet();
}