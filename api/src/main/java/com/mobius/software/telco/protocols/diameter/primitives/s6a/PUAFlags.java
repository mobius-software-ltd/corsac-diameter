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
	7.3.48	PUA-Flags
	The PUA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meanings of the bits are defined in table 7.3.48/1:
	Table 7.3.48/1: PUA-Flags

	bit name
	Description

	0 Freeze M-TMSI
	This bit, when set, shall indicate to the MME that the M-TMSI needs to be frozen, i.e. shall not be immediately re-used.

	1 Freeze P-TMSI
	This bit, when set, shall indicate to the SGSN that the P-TMSI needs to be frozen, i.e. shall not be immediately re-used.

	Note: Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PUA_FLAGS, vendorId = VendorIDs.TGPP_ID, name = "PUA-Flags")
public interface PUAFlags extends DiameterBitmask32
{
	public static final int FREEZE_MTMSI_BIT = 0;
	public static final int FREEZE_PTMSI_BIT = 1;
	
	public void setFreezeMTMSIBit(boolean isOn);
	
	public boolean isFreezeMTMSIBitSet();
	
	public void setFreezePTMSIBit(boolean isOn);
	
	public boolean isFreezePTMSIBitSet();
}