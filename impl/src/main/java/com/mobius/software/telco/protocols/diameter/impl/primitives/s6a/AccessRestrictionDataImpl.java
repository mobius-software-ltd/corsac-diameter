package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AccessRestrictionData;

/**
*
* @author yulian oifa
*
*/
public class AccessRestrictionDataImpl extends DiameterBitmask32Impl implements AccessRestrictionData
{
	public AccessRestrictionDataImpl()
	{
		super();
	}
	
	protected AccessRestrictionDataImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setUTRANNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(UTRAN_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isUTRANNotAllowedBitSet()
	{
		return getBit(UTRAN_NOT_ALLOWED_BIT);
	}

	@Override
	public void setGERANNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(GERAN_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isGERANNotAllowedBitSet()
	{
		return getBit(GERAN_NOT_ALLOWED_BIT);
	}

	@Override
	public void setGANNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(GAN_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isGANNotAllowedBitSet()
	{
		return getBit(GAN_NOT_ALLOWED_BIT);
	}

	@Override
	public void setIHSPAEvolutionNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(IHSPA_EVOLUTION_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isIHSPAEvolutionNotAllowedBitSet()
	{
		return getBit(IHSPA_EVOLUTION_NOT_ALLOWED_BIT);
	}

	@Override
	public void setWBEUTRANNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(WB_EUTRAN_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isWBEUTRANNotAllowedBitSet()
	{
		return getBit(WB_EUTRAN_NOT_ALLOWED_BIT);
	}

	@Override
	public void setHOToNonTGPPAccessNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(HO_TO_NON_TGPP_ACCESS_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isHOToNonTGPPAccessNotAllowedBitSet()
	{
		return getBit(HO_TO_NON_TGPP_ACCESS_NOT_ALLOWED_BIT);
	}

	@Override
	public void setNBIOTNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(NB_IOT_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNBIOTNotAllowedBitSet()
	{
		return getBit(NB_IOT_NOT_ALLOWED_BIT);
	}

	@Override
	public void setEnhancedCoverageNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(ENHANCED_COVERAGE_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isEnhancedCoverageNotAllowedBitSet()
	{
		return getBit(ENHANCED_COVERAGE_NOT_ALLOWED_BIT);
	}

	@Override
	public void setNRAsSecondaryRATInEUTRANNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(NR_AS_SECONDARY_RAT_IN_EUTRAN_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNRAsSecondaryRATInEUTRANNotAllowedBitSet()
	{
		return getBit(NR_AS_SECONDARY_RAT_IN_EUTRAN_NOT_ALLOWED_BIT);
	}

	@Override
	public void setUnlicensedSpectrumAsSecondaryRATNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(UNLICENSED_SPECTRUM_AS_SECONDARY_RAT_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isUnlicensedSpectrumAsSecondaryRATNotAllowedBitSet()
	{
		return getBit(UNLICENSED_SPECTRUM_AS_SECONDARY_RAT_NOT_ALLOWED_BIT);
	}

	@Override
	public void setNRIn5GSNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(NR_IN_5GS_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNRIn5GSNotAllowedBitSet()
	{
		return getBit(NR_IN_5GS_NOT_ALLOWED_BIT);
	}

	@Override
	public void setLTEMNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(LTEM_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isLTEMNotAllowedBitSet()
	{
		return getBit(LTEM_NOT_ALLOWED_BIT);
	}

	@Override
	public void setWBEUTRANExceptLTEMNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(WB_EUTRAN_EXCEPT_LTEM_NOT_ALLOWED_BIT, isOn);	
	}

	@Override
	public boolean isWBEUTRANExceptLTEMNotAllowedBitSet()
	{
		return getBit(WB_EUTRAN_EXCEPT_LTEM_NOT_ALLOWED_BIT);
	}

	@Override
	public void setWBEUTRANLEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(WB_EUTRAN_LEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isWBEUTRANLEONotAllowedBitSet()
	{
		return getBit(WB_EUTRAN_LEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setWBEUTRANMEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(WB_EUTRAN_MEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isWBEUTRANMEONotAllowedBitSet()
	{
		return getBit(WB_EUTRAN_MEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setWBEUTRANGEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(WB_EUTRAN_GEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isWBEUTRANGEONotAllowedBitSet()
	{
		return getBit(WB_EUTRAN_GEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setWBEUTRANOtherSATNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(WB_EUTRAN_OTHERSAT_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isWBEUTRANOtherSATNotAllowedBitSet()
	{
		return getBit(WB_EUTRAN_OTHERSAT_NOT_ALLOWED_BIT);
	}

	@Override
	public void setNBIOTLEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(NB_IOT_LEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNBIOTLEONotAllowedBitSet()
	{
		return getBit(NB_IOT_LEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setNBIOTMEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(NB_IOT_MEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNBIOTMEONotAllowedBitSet()
	{
		return getBit(NB_IOT_MEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setNBIOTGEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(NB_IOT_GEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNBIOTGEONotAllowedBitSet()
	{
		return getBit(NB_IOT_GEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setNBIOTOtherSATNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(NB_IOT_OTHERSAT_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isNBIOTOtherSATNotAllowedBitSet()
	{
		return getBit(NB_IOT_OTHERSAT_NOT_ALLOWED_BIT);
	}

	@Override
	public void setLTEMLEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(LTE_M_LEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isLTEMLEONotAllowedBitSet()
	{
		return getBit(LTE_M_LEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setLTEMMEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(LTE_M_MEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isLTEMMEONotAllowedBitSet()
	{
		return getBit(LTE_M_MEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setLTEMGEONotAllowedBit(boolean isOn)
	{
		setBitUnchecked(LTE_M_GEO_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isLTEMGEONotAllowedBitSet()
	{
		return getBit(LTE_M_GEO_NOT_ALLOWED_BIT);
	}

	@Override
	public void setLTEMOtherSATNotAllowedBit(boolean isOn)
	{
		setBitUnchecked(LTE_M_OTHERSAT_NOT_ALLOWED_BIT, isOn);
	}

	@Override
	public boolean isLTEMOtherSATNotAllowedBitSet()
	{
		return getBit(LTE_M_OTHERSAT_NOT_ALLOWED_BIT);
	}	
}