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
	7.3.139	List-Of-Measurements
	The List-Of-Measurements AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits is defined 
	in 3GPP TS 32.422 [23]. The most significant bit is bit 8 of the first octet.
	
	5.10.3	List of Measurements 
	This parameter is mandatory if the Job Type is configured for Immediate MDT or combined Immediate MDT and Trace. This parameter defines the measurements that shall be collected. For further details see also TS 37.320 [30]. The parameter is 4 octet long bitmap.
	The parameter can have the following values in UMTS:

	-	M1: CPICH RSCP and CPICH Ec/No measurement by UE.

	-	M2: For 1.28 Mcps TDD, P-CCPCH RSCP and Timeslot ISCP measurement by UE.

	-	M3: SIR and SIR error (FDD) by NodeB

	-	M4: UE power headroom (UPH) by the UE, applicable for E-DCH transport channels.

	-	M5: Received total wideband power (RTWP) by Node B

	-	M6: Data Volume measurement, separately for DL and UL, by RNC. 

	-	M7: Throughput measurement, separately for DL and UL, per RAB and per UE, by RNC.

	-	Any combination of the above
	Detailed information for M3, M5, is defined TS 25.215 [54], for M1, M2 in TS 25.331[31] and for M4 in TS 25.321[55].
 */
@DiameterAvpDefinition(code = 1625L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "List-Of-Measurements")
public interface ListOfMeasurements extends DiameterBitmask32
{
	public static final int CPICH_RSCP_BIT = 1;
	public static final int P_CCPCH_BIT = 2;
	public static final int SIR_AND_SIR_ERROR_BIT = 3;
	public static final int UE_POWER_HEADROOM_BIT = 4;
	public static final int RECEIVED_TOTAL_WIDEBAND_POWER_BIT = 5;
	public static final int DATA_VOLUME_MEASUREMENT_BIT = 6;
	public static final int THROUGHPUT_MEASUREMENT_BIT = 7;

	public void setCPICHRSCPBit(boolean isOn);

	public boolean isCPICHRSCPBitSet();
	
	public void setPCCPCHBit(boolean isOn);

	public boolean isPCCPCHBitSet();
	
	public void setSIRAndSIRErrorBit(boolean isOn);

	public boolean isSIRAndSIRErrorBitSet();
	
	public void setUEPowerHeadroomBit(boolean isOn);

	public boolean isUEPowerHeadroomBitSet();
	
	public void setReceivedTotalWidebandPowerBit(boolean isOn);

	public boolean isReceivedTotalWidebandPowerBitSet();
	
	public void setDataVolumeMeasurementBit(boolean isOn);

	public boolean isDataVolumeMeasurementBitSet();
	
	public void setThroughputMeasurementBit(boolean isOn);

	public boolean isThroughputMeasurementBitSet();
}