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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;

/**
*
* @author yulian oifa
*
*/
public class ListOfMeasurementsImpl extends DiameterBitmask32Impl implements ListOfMeasurements
{
	public ListOfMeasurementsImpl()
	{
		super();
	}
	
	protected ListOfMeasurementsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setCPICHRSCPBit(boolean isOn)
	{
		setBitUnchecked(CPICH_RSCP_BIT, isOn);
	}

	@Override
	public boolean isCPICHRSCPBitSet()
	{
		return getBit(CPICH_RSCP_BIT);
	}

	@Override
	public void setPCCPCHBit(boolean isOn)
	{
		setBitUnchecked(P_CCPCH_BIT, isOn);
	}

	@Override
	public boolean isPCCPCHBitSet()
	{
		return getBit(P_CCPCH_BIT);
	}

	@Override
	public void setSIRAndSIRErrorBit(boolean isOn)
	{
		setBitUnchecked(SIR_AND_SIR_ERROR_BIT, isOn);
	}

	@Override
	public boolean isSIRAndSIRErrorBitSet()
	{
		return getBit(SIR_AND_SIR_ERROR_BIT);
	}

	@Override
	public void setUEPowerHeadroomBit(boolean isOn)
	{
		setBitUnchecked(UE_POWER_HEADROOM_BIT, isOn);
	}

	@Override
	public boolean isUEPowerHeadroomBitSet()
	{
		return getBit(UE_POWER_HEADROOM_BIT);
	}

	@Override
	public void setReceivedTotalWidebandPowerBit(boolean isOn)
	{
		setBitUnchecked(RECEIVED_TOTAL_WIDEBAND_POWER_BIT, isOn);
	}

	@Override
	public boolean isReceivedTotalWidebandPowerBitSet()
	{
		return getBit(RECEIVED_TOTAL_WIDEBAND_POWER_BIT);
	}

	@Override
	public void setDataVolumeMeasurementBit(boolean isOn)
	{
		setBitUnchecked(DATA_VOLUME_MEASUREMENT_BIT, isOn);
	}

	@Override
	public boolean isDataVolumeMeasurementBitSet()
	{
		return getBit(DATA_VOLUME_MEASUREMENT_BIT);
	}

	@Override
	public void setThroughputMeasurementBit(boolean isOn)
	{
		setBitUnchecked(THROUGHPUT_MEASUREMENT_BIT, isOn);
	}

	@Override
	public boolean isThroughputMeasurementBitSet()
	{
		return getBit(THROUGHPUT_MEASUREMENT_BIT);
	}
}