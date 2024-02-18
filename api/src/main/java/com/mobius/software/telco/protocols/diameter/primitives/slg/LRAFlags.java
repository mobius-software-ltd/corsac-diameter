package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
	7.4.56	LRA-Flags
	The LRA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.4.56/1:
	Table 7.4.56/1: LRA-Flags

	Bit Name
	Description

	0 MO-LR-ShortCircuit-Indicator
	This bit, when set, indicates that the MO-LR short circuit feature is used for obtaining location estimate. This bit is applicable only when the message is sent over Lgd interface.

	NOTE1:	Bits not defined in this table shall be cleared by the sending GMLC and discarded by the receiving MME or SGSN.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LRA_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "LRA-Flags")
public interface LRAFlags extends DiameterBitmask32
{
	public static final int MOLR_SHORT_CIRCUIT_INDICATOR_BIT = 0;	
	
	public void setMOLRShortCircuitIndicatorBit(boolean isOn);
	
	public boolean isMOLRShortCircuitIndicatorBitSet();	
}