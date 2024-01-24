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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.152	CLR-Flags
	The CLR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.3.152/1:
	Table 7.3.152/1: CLR-Flags

	Bit Name
	Description

	0 S6a/S6d-Indicator (Note 1)
	This bit, when set, indicates that the CLR message is sent on the S6a interface, i.e. the message is to the MME or the MME part on the combined MME/SGSN.
	This bit, when cleared, indicates that the CLR message is sent on the S6d interface, i.e. the message is to the SGSN or the SGSN part on the combined MME/SGSN.

	1 Reattach-Required
	This bit, when set, indicates that the MME or SGSN shall request the UE to initiate an immediate re-attach procedure as described in 3GPP TS 23.401 [2] and in 3GPP TS 23.060 [12].

	NOTE 1: The S6a/S6d-Indicator flag shall be used during initial attach procedure for a combined MME/SGSN. The S6a/S6d-Indicator flag may also be sent to a standalone node.

	NOTE 2: Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.

	NOTE 3: For the purpose of withdrawing "Aerial UE Subscription", HSS may send CLR with CLR-Flag set to Reattach-Required.
*/
@DiameterAvpDefinition(code = 1638L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "CLR-Flags")
public interface CLRFlags extends DiameterBitmask32
{
	public static final int S6A_S6D_INDICATOR_BIT = 0;
	public static final int REATTACH_REQUIRED_BIT = 1;
	
	public void setS6AS6DIndicatorBit(boolean isOn);
	
	public boolean isS6AS6DIndicatorBitSet();
	
	public void setReattachedRequiredBit(boolean isOn);
	
	public boolean isReattachedRequiredBitSet();
}