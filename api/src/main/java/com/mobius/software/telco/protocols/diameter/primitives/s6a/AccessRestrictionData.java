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
	7.3.31	Access-Restriction-Data
	The Access-Restriction-Data AVP is of type Unsigned32 and it shall contain a bit mask where each bit when set to 1 indicates a restriction. The meaning of the bits is the following:
	Table 7.3.31/1: Access-Restriction-Data

	Bit Description

	0 UTRAN Not Allowed

	1 GERAN Not Allowed

	2 GAN Not Allowed

	3 I-HSPA-Evolution Not Allowed

	4 WB-E-UTRAN Not Allowed

	5 HO-To-Non-3GPP-Access Not Allowed

	6 NB-IoT Not Allowed

	7 Enhanced Coverage Not Allowed

	8 NR as Secondary RAT in E-UTRAN Not Allowed

	9 Unlicensed Spectrum as Secondary RAT Not Allowed

	10 NR in 5GS Not Allowed

	11 LTE-M Not Allowed

	12 WB-E-UTRAN Except LTE-M Not Allowed

	13 WB-E-UTRAN(LEO) Not Allowed
	
	14 WB-E-UTRAN(MEO) Not Allowed

	15 WB-E-UTRAN(GEO) Not Allowed

	16 WB-E-UTRAN(OTHERSAT) Not Allowed

	17 NB-oT(LEO) Not Allowed

	18 NB-IoT(MEO) Not Allowed

	19 NB-IoT(GEO) Not Allowed

	20 NB-IoT(OTHERSAT) Not Allowed

	21 LTE-M(LEO) Not Allowed

	22 LTE-M(MEO) Not Allowed

	23 LTE-M(GEO) Not Allowed

	24 LTE-M(OTHERSAT) Not Allowed

	NOTE 1:	Bits not defined in this table shall be cleared by the HSS and discarded by the receiving MME/SGSN.

	NOTE 2:	Bits 11 and 12 are only used when bit 4 is not set.

	The restriction "HO-To-Non-3GPP-Access Not Allowed" shall take a higher precedence than the APN-level parameter "WLAN-Offloadability" (see clause 7.3.181).
 */
@DiameterAvpDefinition(code = 1426L, vendorId = KnownVendorIDs.TGPP_ID, name = "Access-Restriction-Data")
public interface AccessRestrictionData extends DiameterBitmask32
{
	public static final int UTRAN_NOT_ALLOWED_BIT = 0;
	public static final int GERAN_NOT_ALLOWED_BIT = 1;
	public static final int GAN_NOT_ALLOWED_BIT = 2;
	public static final int IHSPA_EVOLUTION_NOT_ALLOWED_BIT = 3;
	public static final int WB_EUTRAN_NOT_ALLOWED_BIT = 4;
	public static final int HO_TO_NON_TGPP_ACCESS_NOT_ALLOWED_BIT = 5;
	public static final int NB_IOT_NOT_ALLOWED_BIT = 6;
	public static final int ENHANCED_COVERAGE_NOT_ALLOWED_BIT = 7;
	public static final int NR_AS_SECONDARY_RAT_IN_EUTRAN_NOT_ALLOWED_BIT = 8;
	public static final int UNLICENSED_SPECTRUM_AS_SECONDARY_RAT_NOT_ALLOWED_BIT = 9;
	public static final int NR_IN_5GS_NOT_ALLOWED_BIT = 10;
	public static final int LTEM_NOT_ALLOWED_BIT = 11;
	public static final int WB_EUTRAN_EXCEPT_LTEM_NOT_ALLOWED_BIT = 12;
	public static final int WB_EUTRAN_LEO_NOT_ALLOWED_BIT = 13;
	public static final int WB_EUTRAN_MEO_NOT_ALLOWED_BIT = 14;
	public static final int WB_EUTRAN_GEO_NOT_ALLOWED_BIT = 15;
	public static final int WB_EUTRAN_OTHERSAT_NOT_ALLOWED_BIT = 16;
	public static final int NB_IOT_LEO_NOT_ALLOWED_BIT = 17;
	public static final int NB_IOT_MEO_NOT_ALLOWED_BIT = 18;
	public static final int NB_IOT_GEO_NOT_ALLOWED_BIT = 19;
	public static final int NB_IOT_OTHERSAT_NOT_ALLOWED_BIT = 20;
	public static final int LTE_M_LEO_NOT_ALLOWED_BIT = 21;
	public static final int LTE_M_MEO_NOT_ALLOWED_BIT = 22;
	public static final int LTE_M_GEO_NOT_ALLOWED_BIT = 23;
	public static final int LTE_M_OTHERSAT_NOT_ALLOWED_BIT = 24;
	
	public void setUTRANNotAllowedBit(boolean isOn);
	
	public boolean isUTRANNotAllowedBitSet();
	
	public void setGERANNotAllowedBit(boolean isOn);
	
	public boolean isGERANNotAllowedBitSet();
	
	public void setGANNotAllowedBit(boolean isOn);
	
	public boolean isGANNotAllowedBitSet();
	
	public void setIHSPAEvolutionNotAllowedBit(boolean isOn);
	
	public boolean isIHSPAEvolutionNotAllowedBitSet();
	
	public void setWBEUTRANNotAllowedBit(boolean isOn);
	
	public boolean isWBEUTRANNotAllowedBitSet();
	
	public void setHOToNonTGPPAccessNotAllowedBit(boolean isOn);
	
	public boolean isHOToNonTGPPAccessNotAllowedBitSet();
	
	public void setNBIOTNotAllowedBit(boolean isOn);
	
	public boolean isNBIOTNotAllowedBitSet();
	
	public void setEnhancedCoverageNotAllowedBit(boolean isOn);
	
	public boolean isEnhancedCoverageNotAllowedBitSet();
	
	public void setNRAsSecondaryRATInEUTRANNotAllowedBit(boolean isOn);
	
	public boolean isNRAsSecondaryRATInEUTRANNotAllowedBitSet();
	
	public void setUnlicensedSpectrumAsSecondaryRATNotAllowedBit(boolean isOn);
	
	public boolean isUnlicensedSpectrumAsSecondaryRATNotAllowedBitSet();
	
	public void setNRIn5GSNotAllowedBit(boolean isOn);
	
	public boolean isNRIn5GSNotAllowedBitSet();
	
	public void setLTEMNotAllowedBit(boolean isOn);
	
	public boolean isLTEMNotAllowedBitSet();
	
	public void setWBEUTRANExceptLTEMNotAllowedBit(boolean isOn);
	
	public boolean isWBEUTRANExceptLTEMNotAllowedBitSet();
	
	public void setWBEUTRANLEONotAllowedBit(boolean isOn);
	
	public boolean isWBEUTRANLEONotAllowedBitSet();
	
	public void setWBEUTRANMEONotAllowedBit(boolean isOn);
	
	public boolean isWBEUTRANMEONotAllowedBitSet();
	
	public void setWBEUTRANGEONotAllowedBit(boolean isOn);
	
	public boolean isWBEUTRANGEONotAllowedBitSet();
	
	public void setWBEUTRANOtherSATNotAllowedBit(boolean isOn);
	
	public boolean isWBEUTRANOtherSATNotAllowedBitSet();
	
	public void setNBIOTLEONotAllowedBit(boolean isOn);
	
	public boolean isNBIOTLEONotAllowedBitSet();
	
	public void setNBIOTMEONotAllowedBit(boolean isOn);
	
	public boolean isNBIOTMEONotAllowedBitSet();
	
	public void setNBIOTGEONotAllowedBit(boolean isOn);
	
	public boolean isNBIOTGEONotAllowedBitSet();
	
	public void setNBIOTOtherSATNotAllowedBit(boolean isOn);
	
	public boolean isNBIOTOtherSATNotAllowedBitSet();
	
	public void setLTEMLEONotAllowedBit(boolean isOn);
	
	public boolean isLTEMLEONotAllowedBitSet();
	
	public void setLTEMMEONotAllowedBit(boolean isOn);
	
	public boolean isLTEMMEONotAllowedBitSet();
	
	public void setLTEMGEONotAllowedBit(boolean isOn);
	
	public boolean isLTEMGEONotAllowedBitSet();
	
	public void setLTEMOtherSATNotAllowedBit(boolean isOn);
	
	public boolean isLTEMOtherSATNotAllowedBitSet();
}