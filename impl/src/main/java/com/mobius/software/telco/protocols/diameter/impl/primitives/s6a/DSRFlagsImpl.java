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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1421L, vendorId = KnownVendorIDs.TGPP_ID)
public class DSRFlagsImpl extends DiameterBitmask32Impl implements DSRFlags
{
	public DSRFlagsImpl()
	{
		super();
	}
	
	protected DSRFlagsImpl(Integer value)
	{
		super(value);
	}

	@Override
	public void setRegionalSubscriptionWithdrawalBit(boolean isOn)
	{
		setBit(REGIONAL_SUBSCRIPTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isRegionalSubscriptionWithdrawalBitSet()
	{
		return getBit(REGIONAL_SUBSCRIPTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setCompleteAPNConfigurationProfileWithdrawalBit(boolean isOn)
	{
		setBit(COMPLETE_APN_CONFIGURATION_PROFILE_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isCompleteAPNConfigurationProfileWithdrawalBitSet()
	{
		return getBit(COMPLETE_APN_CONFIGURATION_PROFILE_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscripbedChargingCharacteristricsWithdrawalBit(boolean isOn)
	{
		setBit(SUBSCRIBED_CHARGING_CHARACTERISTICS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscripbedChargingCharacteristricsWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_CHARGING_CHARACTERISTICS_WITHDRAWAL_BIT);
	}

	@Override
	public void setPDNSubscriptionContextsWithdrawalBit(boolean isOn)
	{
		setBit(PDN_SUBSCRIPTION_CONTEXTS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPDNSubscriptionContextsWithdrawalBitSet()
	{
		return getBit(PDN_SUBSCRIPTION_CONTEXTS_WITHDRAWAL_BIT);
	}

	@Override
	public void setSTNSRBit(boolean isOn)
	{
		setBit(STN_SR_BIT, isOn);
	}

	@Override
	public boolean isSTNSRBitSet()
	{
		return getBit(STN_SR_BIT);
	}

	@Override
	public void setCompletePDPContextListWithdrawalBit(boolean isOn)
	{
		setBit(COMPLETE_PDP_CONTEXT_LIST_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isCompletePDPContextListWithdrawalBitSet()
	{
		return getBit(COMPLETE_PDP_CONTEXT_LIST_WITHDRAWAL_BIT);
	}

	@Override
	public void setPDPContextWithdrawalBit(boolean isOn)
	{
		setBit(PDP_CONTEXTS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPDPContextWithdrawalBitSet()
	{
		return getBit(PDP_CONTEXTS_WITHDRAWAL_BIT);
	}

	@Override
	public void setRoamingRestrictedDueToUnsupportedFeatureWithdrawalBit(boolean isOn)
	{
		setBit(ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE_BIT, isOn);
	}

	@Override
	public boolean isRoamingRestrictedDueToUnsupportedFeatureWithdrawalBitSet()
	{
		return getBit(ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE_BIT);
	}

	@Override
	public void setTraceDataWithdrawalBit(boolean isOn)
	{
		setBit(TRACE_DATA_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isTraceDataWithdrawalBitSet()
	{
		return getBit(TRACE_DATA_WITHDRAWAL_BIT);
	}

	@Override
	public void setCSGDeletedWithdrawalBit(boolean isOn)
	{
		setBit(CSG_DELETED_BIT, isOn);
	}

	@Override
	public boolean isCSGDeletedWithdrawalBitSet()
	{
		return getBit(CSG_DELETED_BIT);
	}

	@Override
	public void setAPNIOReplacementBit(boolean isOn)
	{
		setBit(APN_IO_REPLACEMENT_BIT, isOn);
	}

	@Override
	public boolean isAPNIOReplacementBitSet()
	{
		return getBit(APN_IO_REPLACEMENT_BIT);
	}

	@Override
	public void setGMLCListWithdrawalBit(boolean isOn)
	{
		setBit(GMLC_LIST_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isGMLCListWithdrawalBitSet()
	{
		return getBit(GMLC_LIST_WITHDRAWAL_BIT);
	}

	@Override
	public void setLCSWithdrawalBit(boolean isOn)
	{
		setBit(LCS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isLCSWithdrawalBitSet()
	{
		return getBit(LCS_WITHDRAWAL_BIT);
	}

	@Override
	public void setSMSWithdrawalBit(boolean isOn)
	{
		setBit(SMS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSMSWithdrawalBitSet()
	{
		return getBit(SMS_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscribedPeriodicRAUTAUTimerWithdrawalBit(boolean isOn)
	{
		setBit(SUBSCRIBED_PERIODIC_RAU_TAU_TIMER_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscribedPeriodicRAUTAUTimerWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_PERIODIC_RAU_TAU_TIMER_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscribedVSRVCCWithdrawalBit(boolean isOn)
	{
		setBit(SUBSCRIBED_VSRVCC_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscribedVSRVCCWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_VSRVCC_WITHDRAWAL_BIT);
	}

	@Override
	public void setAMSISDNWithdrawalBit(boolean isOn)
	{
		setBit(AMSISDN_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isAMSISDNWithdrawalBitSet()
	{
		return getBit(AMSISDN_WITHDRAWAL_BIT);
	}

	@Override
	public void setPROSEWithdrawalBit(boolean isOn)
	{
		setBit(PROSE_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPROSEWithdrawalBitSet()
	{
		return getBit(PROSE_WITHDRAWAL_BIT);
	}

	@Override
	public void setResetIDsBit(boolean isOn)
	{
		setBit(RESET_IDS_BIT, isOn);
	}

	@Override
	public boolean isResetIDsBitSet()
	{
		return getBit(RESET_IDS_BIT);
	}

	@Override
	public void setDLBufferingSuggestedPacketCountWithdrawalBit(boolean isOn)
	{
		setBit(DL_BUFFERING_SUGGESTED_PACKET_COUNT_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isDLBufferingSuggestedPacketCountWithdrawalBitSet()
	{
		return getBit(DL_BUFFERING_SUGGESTED_PACKET_COUNT_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscribedIMSIGroupIDWithdrawalBit(boolean isOn)
	{
		setBit(SUBSCRIBED_IMSI_GROUP_ID_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscribedIMSIGroupIDWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_IMSI_GROUP_ID_WITHDRAWAL_BIT);
	}

	@Override
	public void setDeleteMonitoringEventsWithdrawalBit(boolean isOn)
	{
		setBit(DELETE_MONITORING_EVENTS_BIT, isOn);
	}

	@Override
	public boolean isDeleteMonitoringEventsWithdrawalBitSet()
	{
		return getBit(DELETE_MONITORING_EVENTS_BIT);
	}

	@Override
	public void setUserPlaneIntegrityProtectionWithdrawalBit(boolean isOn)
	{
		setBit(USER_PLANE_INTEGRITY_PROTECTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isUserPlaneIntegrityProtectionWithdrawalBitSet()
	{
		return getBit(USER_PLANE_INTEGRITY_PROTECTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setMSISDNWithdrawalBit(boolean isOn)
	{
		setBit(MSISDN_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isMSISDNWithdrawalBitSet()
	{
		return getBit(MSISDN_WITHDRAWAL_BIT);
	}

	@Override
	public void setUEUsageTypeWithdrawalBit(boolean isOn)
	{
		setBit(UE_USAGE_TYPE_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isUEUsageTypeWithdrawalBitSet()
	{
		return getBit(UE_USAGE_TYPE_WITHDRAWAL_BIT);
	}

	@Override
	public void setV2XWithdrawalBit(boolean isOn)
	{
		setBit(V2X_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isV2XWithdrawalBitSet()
	{
		return getBit(V2X_WITHDRAWAL_BIT);
	}

	@Override
	public void setExternalIdentifierWithdrawalBit(boolean isOn)
	{
		setBit(EXTERNAL_IDENTIFIER_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isExternalIdentifierWithdrawalBitSet()
	{
		return getBit(EXTERNAL_IDENTIFIER_WITHDRAWAL_BIT);
	}

	@Override
	public void setAerialUESubscriptionWithdrawalBit(boolean isOn)
	{
		setBit(AERIAL_UE_SUBSCRIPTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isAerialUESubscriptionWithdrawalBitSet()
	{
		return getBit(AERIAL_UE_SUBSCRIPTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setPagingTimeWindowSubscriptionWithdrawalBit(boolean isOn)
	{
		setBit(PAGING_TIME_WINDOW_SUBSCRIPTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPagingTimeWindowSubscriptionWithdrawalBitSet()
	{
		return getBit(PAGING_TIME_WINDOW_SUBSCRIPTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setActiveTimeWithdrawalBit(boolean isOn)
	{
		setBit(ACTIVE_TIME_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isActiveTimeWithdrawalBitSet()
	{
		return getBit(ACTIVE_TIME_WITHDRAWAL_BIT);
	}

	@Override
	public void setEDRXCycleLengthWithdrawalBit(boolean isOn)
	{
		setBit(EDRX_CYCLE_LENGTH_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isEDRXCycleLengthWithdrawalBitSet()
	{
		return getBit(EDRX_CYCLE_LENGTH_WITHDRAWAL_BIT);
	}

	@Override
	public void setServiceGapTimeWithdrawalBit(boolean isOn)
	{
		setBit(SERVICE_GAP_TIME_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isServiceGapTimeWithdrawalBitSet()
	{
		return getBit(SERVICE_GAP_TIME_WITHDRAWAL_BIT);
	}
}