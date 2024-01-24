package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CIRFlags;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3145L, vendorId = KnownVendorIDs.TGPP_ID)
public class CIRFlagsImpl extends DiameterBitmask32Impl implements CIRFlags
{
	public CIRFlagsImpl()
	{
		super();
	}

	protected CIRFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setDeleteAllMonitoringEventsBit(boolean isOn)
	{
		setBit(DELETED_ALL_MONITORING_EVENTS_BIT, isOn);
	}

	@Override
	public boolean isDeleteAllMonitoringEventsBitSet()
	{
		return getBit(DELETED_ALL_MONITORING_EVENTS_BIT);
	}

	@Override
	public void setEnhancedCoverageQueryBit(boolean isOn)
	{
		setBit(ENHANCED_COVERAGE_QUERY_BIT, isOn);
	}

	@Override
	public boolean isEnhancedCoverageQueryBitSet()
	{
		return getBit(ENHANCED_COVERAGE_QUERY_BIT);
	}

	@Override
	public void setIMSIGroupIdRetrievalBit(boolean isOn)
	{
		setBit(IMSI_GROUP_ID_RETRIEVAL_BIT, isOn);
	}

	@Override
	public boolean isIMSIGroupIdRetrievalBitSet()
	{
		return getBit(IMSI_GROUP_ID_RETRIEVAL_BIT);
	}

	@Override
	public void setDeleteAllCommunicationPatternBit(boolean isOn)
	{
		setBit(DELETE_ALL_COMMUNICATION_PATTERN_BIT, isOn);
	}

	@Override
	public boolean isDeleteAllCommunicationPatternBitSet()
	{
		return getBit(DELETE_ALL_COMMUNICATION_PATTERN_BIT);
	}

	@Override
	public void setDeleteAllNetworkParameterConfigurationsBit(boolean isOn)
	{
		setBit(DELETE_ALL_NETWORK_PARAMETER_CONFIGURATIONS_BIT, isOn);
	}

	@Override
	public boolean isDeleteAllNetworkParameterConfigurationsBitSet()
	{
		return getBit(DELETE_ALL_NETWORK_PARAMETER_CONFIGURATIONS_BIT);
	}
}