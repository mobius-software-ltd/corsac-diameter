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
	7.3.8 ULA-Flags
	The ULA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.3.8/1:
	Table 7.3.8/1: ULA-Flags
	
	Bit Name
	Description

	0 Separation Indication
	This bit, when set, indicates that the HSS stores SGSN number and MME number in separate memory. A Rel-8 HSS shall set the bit. An IWF interworking with a pre Rel-8 HSS/HLR shall clear the bit.

	1 MME Registered for SMS
	This bit, when set, indicates that the HSS has registered the MME for SMS.

	NOTE:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ULA_FLAGS, vendorId = VendorIDs.TGPP_ID, name = "ULA-Flags")
public interface ULAFlags extends DiameterBitmask32
{
	public static final int SEPARATION_INDICATION_BIT = 0;
	public static final int MME_REGISTERED_FOR_SMS_BIT = 1;
	
	public void setSeparationIndicationBit(boolean isOn);
	
	public boolean isSeparationIndicationBitSet();
	
	public void setMMERegistredForSMSBit(boolean isOn);
	
	public boolean isMMERegistredForSMSBitSet();
}