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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask64Impl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedMonitoringEvents;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3144L, vendorId = KnownVendorIDs.TGPP_ID)
public class SupportedMonitoringEventsImpl extends DiameterBitmask64Impl implements SupportedMonitoringEvents
{
	public SupportedMonitoringEventsImpl()
	{
		super();
	}

	public SupportedMonitoringEventsImpl(List<Integer> bitsToSet)
	{
		super(bitsToSet);
	}
	
	public void setUEAndUICCBit(boolean isOn)
	{
		setBit(UE_AND_UICC_BIT, isOn);
	}
	
	public boolean isUEAndUICCBitSet()
	{
		return getBit(UE_AND_UICC_BIT);
	}
	
	public void setUEReachabilityBit(boolean isOn)
	{
		setBit(UE_REACHABILITY_BIT, isOn);
	}
	
	public boolean isUEReachabilityBitSet()
	{
		return getBit(UE_REACHABILITY_BIT);
	}
	
	public void setLocationOfUEBit(boolean isOn)
	{
		setBit(LOCATION_OF_UE_BIT, isOn);
	}
	
	public boolean isLocationOfUEBitSet()
	{
		return getBit(LOCATION_OF_UE_BIT);
	}
	
	public void setLossOfConnectivityBit(boolean isOn)
	{
		setBit(LOSS_OF_CONNECTIVITY_BIT, isOn);
	}
	
	public boolean isLossOfConnectivityBitSet()
	{
		return getBit(LOSS_OF_CONNECTIVITY_BIT);
	}
	
	public void setCommunicationFailureBit(boolean isOn)
	{
		setBit(COMMUNICATION_FAILURE_BIT, isOn);
	}
	
	public boolean isCommunicationFailureBitSet()
	{
		return getBit(COMMUNICATION_FAILURE_BIT);
	}
	
	public void setRoamingStatusBit(boolean isOn)
	{
		setBit(ROAMING_STATUS_BIT, isOn);
	}
	
	public boolean isRoamingStatusBitSet()
	{
		return getBit(ROAMING_STATUS_BIT);
	}
	
	public void setAvailabilityAfterDDNFailureBit(boolean isOn)
	{
		setBit(AVAILABILITY_AFTER_DDN_FAILURE_BIT, isOn);
	}
	
	public boolean isAvailabilityAfterDDNFailureBitSet()
	{
		return getBit(AVAILABILITY_AFTER_DDN_FAILURE_BIT);
	}
	
	public void setIdleStatusIndicationBit(boolean isOn)
	{
		setBit(IDLE_STATUS_INDICATION_BIT, isOn);
	}
	
	public boolean isIdleStatusIndicationBitSet()
	{
		return getBit(IDLE_STATUS_INDICATION_BIT);
	}
	
	public void setPDNConnectivityStatusBit(boolean isOn)
	{
		setBit(PDN_CONNECTIVITY_STATUS_BIT, isOn);
	}
	
	public boolean isPDNConnectivityStatusBitSet()
	{
		return getBit(PDN_CONNECTIVITY_STATUS_BIT);
	}
}