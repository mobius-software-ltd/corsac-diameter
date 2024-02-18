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
	7.4.35	LRR-Flags
	The LRR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.4.35/1:
	Table 7.4.35/1: LRR-Flags

	Bit Name
	Description

	0 Lgd/SLg-Indicator
	This bit, when set, indicates that the Location Report Request message is sent on the Lgd interface, i.e. the source node is an SGSN (or a combined MME/SGSN to which the UE is attached via UTRAN or GERAN).
	This bit, when cleared, indicates that the Location Report Request message is sent on the SLg interface, i.e. the source node is an MME (or a combined MME/SGSN to which the UE is attached via E-UTRAN).
	
	1 MO-LR-ShortCircuit-Indicator
	This bit, when set, indicates that the MO-LR short circuit feature is used by the UE for location estimate. This bit is applicable only when for deferred MT-LR procedure and when the message is sent over Lgd interface.

	2 MO-LR-ShortCircuit-Requested
	This bit, when set, indicates that the UE is requesting to use MO-LR short circuit feature for location estimate. This bit is applicable only when periodic MO-LR TTTP procedure is initiated by the UE and when the message is sent over Lgd interface.

	NOTE1:	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving GMLC.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LRR_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "LRR-Flags")
public interface LRRFlags extends DiameterBitmask32
{
	public static final int LGD_SLG_INDICATOR_BIT = 0;
	public static final int MOLR_SHORT_CIRCUIT_INDICATOR_BIT = 1;
	public static final int MOLR_SHORT_CIRCUIT_REQUESTED_BIT = 2;
	
	public void setLGDSLGIndicatorBit(boolean isOn);
	
	public boolean isLGDSLGIndicatorBitSet();
	
	public void setMOLRShortCircuitIndicatorBit(boolean isOn);
	
	public boolean isMOLRShortCircuitIndicatorBitSet();
	
	public void setMOLRShortCircuitRequestedBit(boolean isOn);
	
	public boolean isMOLRShortCircuitRequestedBitSet();
}