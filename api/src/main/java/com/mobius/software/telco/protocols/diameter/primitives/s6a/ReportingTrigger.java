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
	7.3.140	Reporting-Trigger
	The Reporting-Trigger AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits is defined in 
	3GPP TS 32.422 [23].  The most significant bit is bit 8 of the first octet.
	
	
	5.10.4	Reporting Trigger
	This parameter is mandatory if the list of measurements parameter is configured for UE side measurement ( M1 in LTE and NR, and M1/M2 in UMTS) and the jobtype is configured for Immediate MDT or combined Immediate MDT and Trace.
	The parameter shall not have the combination of periodical, event based and event based periodic reporting at the same time, i.e. :

	-	For LTE and NR, only one of the bits 1, 2, and 5 can be set.

	-	For UMTS, bit 1 cannot be set at the same time with either bit 3 or bit 4.

	The parameter is one octet long bitmap and can have the following values in LTE, UMTS, NR (detailed definition of the parameter is in 3GPP TS 37.320 [30]):

	-	Periodical,

	-	Event A2 for LTE and NR: 

	-	Event 1f for UMTS, 

	-	Event 1i for UMTS 1.28 Mcps TDD, 

	-	A2 event triggered periodic for LTE and NR. 

	-	All configured RRM event triggers for M1 measurement for LTE and NR. See also TS 37.320 [30] clauses 5.2.1.1 and 5.4.1.1.

	-	All configured RRM event triggers for M1/M2 measurement for UMTS. See also TS 37.320 [30] clause 5.3.1.1.

	
	Bit 8
	Reserved

	Bit 7
	All configured RRM event triggers for UMTS

	Bit 6
	All configured RRM event triggers for LTE and NR

	Bit 5
	A2 event triggered periodic for LTE and NR

	Bit 4
	Event 1i for UMTS 1.28 MCPS TDD

	Bit 3
	Event 1f for UMTS

	Bit 2
	Event A2 for LTE and NR

	Bit 1
  	Periodical
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REPORT_TRIGGER, vendorId = VendorIDs.TGPP_ID, must = false, name = "Reporting-Trigger")
public interface ReportingTrigger extends DiameterBitmask32
{
	public static final int PERIODICAL_BIT = 0;
	public static final int EVENT_A2_BIT = 1;
	public static final int EVENT_1F_BIT = 2;
	public static final int EVENT_1I_BIT = 3;
	public static final int EVENT_A2_PERIODIC_BIT = 4;
	public static final int ALL_CONFIGURED_RRM_EVENT_TRIGGERS_FOR_LTE_AND_NR_BIT = 5;
	public static final int ALL_CONFIGURED_RRM_EVENT_TRIGGERS_FOR_UMTS_BIT = 6;
	
	public void setPeriodicalBit(boolean isOn);
	
	public boolean isPeriodicalBitSet();
	
	public void setEventA2Bit(boolean isOn);
	
	public boolean isEventA2BitSet();
	
	public void setEvent1FBit(boolean isOn);
	
	public boolean isEvent1FBitSet();
	
	public void setEvent1IBit(boolean isOn);
	
	public boolean isEvent1IBitSet();
	
	public void setEventA2PeriodicBit(boolean isOn);
	
	public boolean isEventA2PeriodicBitSet();
	
	public void setAllConfiguredRRMEventTriggersForLTEAndNRBit(boolean isOn);
	
	public boolean isAllConfiguredRRMEventTriggersForLTEAndNRBitSet();
	
	public void setAllConfiguredRRMEventTriggersForUMTSBit(boolean isOn);
	
	public boolean isAllConfiguredRRMEventTriggersForUMTSBitSet();
}