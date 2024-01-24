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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.52	PLR-Flags
	The PLR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.4.52/1:
	Table 7.4.52/1: PLR-Flags

	Bit Name
	Description

	0 MO-LR-ShortCircuit-Indicator
	This bit, when set, indicates that the MO-LR short circuit feature is requested for the periodic location. This bit is applicable only when the deferred MT-LR procedure is initiated for a periodic location event and when the message is sent over Lgd interface.

	1 Optimized-LCS-Proc-Req
	This bit, when set, indicates that the GMLC is requesting the optimized LCS procedure for the combined MME/SGSN. This bit is applicable only when the MT-LR procedure is initiated by the GMLC over the Lgd interface. The GMLC shall set this bit only when the HSS indicates the combined MME/SGSN node supporting the optimized LCS procedure.

	2 Delayed-Location-Reporting-Support-Indicator
	This bit, when set, indicates that the GMLC supports delayed location reporting for UEs transiently not reachable (e.g. UEs in extended idle mode DRX or Power Saving Mode) as specified in clauses 9.1.6 and 9.1.15 of 3GPP TS 23.271 [2], i.e. that the GMLC supports
	
	- receiving a PROVIDE SUBSCRIBER LOCATION RESPONSE with the UE-Transiently-Not-Reachable-Indicator set in the PLA-Flags IE; and
	- receiving the location information in a subsequent SUBSCRIBER LOCATION REPORT when the UE becomes reachable.

	NOTE1:	Bits not defined in this table shall be cleared by the sending GMLC and discarded by the receiving MME or SGSN
 */
@DiameterAvpDefinition(code = 2545L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PLR-Flags")
public interface PLRFlags extends DiameterBitmask32
{
	public static final int MOLR_SHORT_CIRCUIT_INDICATOR_BIT = 0;
	public static final int OPTIMIZED_LCS_PROC_REQ_BIT = 1;
	public static final int DELAYED_LOCATION_REPORTING_SUPPORT_INDICATOR_BIT = 2;
	
	public void setMOLRShortCircuitIndicatorBit(boolean isOn);
	
	public boolean isMOLRShortCircuitIndicatorBitSet();
	
	public void setOptimizedLCSProcReqBit(boolean isOn);
	
	public boolean isOptimizedLCSProcReqBitSet();
	
	public void setDelayedLocationReportingSupportIndicatorBit(boolean isOn);
	
	public boolean isDelayedLocationReportingSupportIndicatorBitSet();
}