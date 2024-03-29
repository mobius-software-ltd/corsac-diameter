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
	7.4.53	PLA-Flags
	The PLA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.4.53/1:
	Table 7.4.53/1: PLA-Flags

	Bit Name
	Description

	0 Deferred-MT-LR-Response-Indicator
	This bit, when set, indicates that the message is sent in response to the deferred-MT location request.

	1 MO-LR-ShortCircuit-Indicator
	This bit, when set, indicates that the MO-LR short circuit feature is accepted by the UE, for periodic location reporting. This bit is applicable only when the message is sent over Lgd interface.

	2 Optimized-LCS-Proc-Performed
	This bit, when set, indicates that the combined MME/SGSN has performed the optimized LCS procedure to retrieve the location of the target UE. This bit is applicable only when the message is sent for the MT-LR procedure over the Lgd interface.

	3 UE-Transiently-Not-Reachable-Indicator
	This bit, when set, indicates that the UE is transiently not reachable due to power saving (e.g. UE is in extended idle mode DRX or in Power Saving Mode), and that the location information will be returned in a subsequent Subscriber Location Report when the UE becomes reachable.

	NOTE1:	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving GMLC.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PLA_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "PLA-Flags")
public interface PLAFlags extends DiameterBitmask32
{
	public static final int DEFERRED_MTLR_RESPONSE_INDICATOR_BIT = 0;
	public static final int MOLR_SHORT_CIRCUIT_INDICATOR_BIT = 1;
	public static final int OPTIMIZED_LCS_PROC_PERFOMED_BIT = 2;
	public static final int UE_TRANSIENTLY_NOT_REACHABLE_INDICATOR_BIT = 3;
	
	public void setDeferredMTLRResponseIndicatorBit(boolean isOn);
	
	public boolean isDeferredMTLRResponseIndicatorBitSet();
	
	public void setMOLRShortCircuitIndicatorBit(boolean isOn);
	
	public boolean isMOLRShortCircuitIndicatorBitSet();
	
	public void setOptimizedLCSProcPerformedBit(boolean isOn);
	
	public boolean isOptimizedLCSProcPerformedBitSet();
	
	public void setUETransientlyNotReachableIndicatorBit(boolean isOn);
	
	public boolean isUETransientlyNotReachableIndicatorBitSet();
}