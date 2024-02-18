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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;

/**
*
* @author yulian oifa
*
*/
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
		setBitUnchecked(REGIONAL_SUBSCRIPTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isRegionalSubscriptionWithdrawalBitSet()
	{
		return getBit(REGIONAL_SUBSCRIPTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setCompleteAPNConfigurationProfileWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(COMPLETE_APN_CONFIGURATION_PROFILE_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isCompleteAPNConfigurationProfileWithdrawalBitSet()
	{
		return getBit(COMPLETE_APN_CONFIGURATION_PROFILE_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscripbedChargingCharacteristricsWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(SUBSCRIBED_CHARGING_CHARACTERISTICS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscripbedChargingCharacteristricsWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_CHARGING_CHARACTERISTICS_WITHDRAWAL_BIT);
	}

	@Override
	public void setPDNSubscriptionContextsWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(PDN_SUBSCRIPTION_CONTEXTS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPDNSubscriptionContextsWithdrawalBitSet()
	{
		return getBit(PDN_SUBSCRIPTION_CONTEXTS_WITHDRAWAL_BIT);
	}

	@Override
	public void setSTNSRBit(boolean isOn)
	{
		setBitUnchecked(STN_SR_BIT, isOn);
	}

	@Override
	public boolean isSTNSRBitSet()
	{
		return getBit(STN_SR_BIT);
	}

	@Override
	public void setCompletePDPContextListWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(COMPLETE_PDP_CONTEXT_LIST_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isCompletePDPContextListWithdrawalBitSet()
	{
		return getBit(COMPLETE_PDP_CONTEXT_LIST_WITHDRAWAL_BIT);
	}

	@Override
	public void setPDPContextWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(PDP_CONTEXTS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPDPContextWithdrawalBitSet()
	{
		return getBit(PDP_CONTEXTS_WITHDRAWAL_BIT);
	}

	@Override
	public void setRoamingRestrictedDueToUnsupportedFeatureWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE_BIT, isOn);
	}

	@Override
	public boolean isRoamingRestrictedDueToUnsupportedFeatureWithdrawalBitSet()
	{
		return getBit(ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE_BIT);
	}

	@Override
	public void setTraceDataWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(TRACE_DATA_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isTraceDataWithdrawalBitSet()
	{
		return getBit(TRACE_DATA_WITHDRAWAL_BIT);
	}

	@Override
	public void setCSGDeletedWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(CSG_DELETED_BIT, isOn);
	}

	@Override
	public boolean isCSGDeletedWithdrawalBitSet()
	{
		return getBit(CSG_DELETED_BIT);
	}

	@Override
	public void setAPNIOReplacementBit(boolean isOn)
	{
		setBitUnchecked(APN_IO_REPLACEMENT_BIT, isOn);
	}

	@Override
	public boolean isAPNIOReplacementBitSet()
	{
		return getBit(APN_IO_REPLACEMENT_BIT);
	}

	@Override
	public void setGMLCListWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(GMLC_LIST_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isGMLCListWithdrawalBitSet()
	{
		return getBit(GMLC_LIST_WITHDRAWAL_BIT);
	}

	@Override
	public void setLCSWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(LCS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isLCSWithdrawalBitSet()
	{
		return getBit(LCS_WITHDRAWAL_BIT);
	}

	@Override
	public void setSMSWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(SMS_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSMSWithdrawalBitSet()
	{
		return getBit(SMS_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscribedPeriodicRAUTAUTimerWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(SUBSCRIBED_PERIODIC_RAU_TAU_TIMER_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscribedPeriodicRAUTAUTimerWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_PERIODIC_RAU_TAU_TIMER_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscribedVSRVCCWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(SUBSCRIBED_VSRVCC_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscribedVSRVCCWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_VSRVCC_WITHDRAWAL_BIT);
	}

	@Override
	public void setAMSISDNWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(AMSISDN_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isAMSISDNWithdrawalBitSet()
	{
		return getBit(AMSISDN_WITHDRAWAL_BIT);
	}

	@Override
	public void setPROSEWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(PROSE_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPROSEWithdrawalBitSet()
	{
		return getBit(PROSE_WITHDRAWAL_BIT);
	}

	@Override
	public void setResetIDsBit(boolean isOn)
	{
		setBitUnchecked(RESET_IDS_BIT, isOn);
	}

	@Override
	public boolean isResetIDsBitSet()
	{
		return getBit(RESET_IDS_BIT);
	}

	@Override
	public void setDLBufferingSuggestedPacketCountWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(DL_BUFFERING_SUGGESTED_PACKET_COUNT_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isDLBufferingSuggestedPacketCountWithdrawalBitSet()
	{
		return getBit(DL_BUFFERING_SUGGESTED_PACKET_COUNT_WITHDRAWAL_BIT);
	}

	@Override
	public void setSubscribedIMSIGroupIDWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(SUBSCRIBED_IMSI_GROUP_ID_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isSubscribedIMSIGroupIDWithdrawalBitSet()
	{
		return getBit(SUBSCRIBED_IMSI_GROUP_ID_WITHDRAWAL_BIT);
	}

	@Override
	public void setDeleteMonitoringEventsWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(DELETE_MONITORING_EVENTS_BIT, isOn);
	}

	@Override
	public boolean isDeleteMonitoringEventsWithdrawalBitSet()
	{
		return getBit(DELETE_MONITORING_EVENTS_BIT);
	}

	@Override
	public void setUserPlaneIntegrityProtectionWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(USER_PLANE_INTEGRITY_PROTECTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isUserPlaneIntegrityProtectionWithdrawalBitSet()
	{
		return getBit(USER_PLANE_INTEGRITY_PROTECTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setMSISDNWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(MSISDN_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isMSISDNWithdrawalBitSet()
	{
		return getBit(MSISDN_WITHDRAWAL_BIT);
	}

	@Override
	public void setUEUsageTypeWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(UE_USAGE_TYPE_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isUEUsageTypeWithdrawalBitSet()
	{
		return getBit(UE_USAGE_TYPE_WITHDRAWAL_BIT);
	}

	@Override
	public void setV2XWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(V2X_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isV2XWithdrawalBitSet()
	{
		return getBit(V2X_WITHDRAWAL_BIT);
	}

	@Override
	public void setExternalIdentifierWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(EXTERNAL_IDENTIFIER_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isExternalIdentifierWithdrawalBitSet()
	{
		return getBit(EXTERNAL_IDENTIFIER_WITHDRAWAL_BIT);
	}

	@Override
	public void setAerialUESubscriptionWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(AERIAL_UE_SUBSCRIPTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isAerialUESubscriptionWithdrawalBitSet()
	{
		return getBit(AERIAL_UE_SUBSCRIPTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setPagingTimeWindowSubscriptionWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(PAGING_TIME_WINDOW_SUBSCRIPTION_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isPagingTimeWindowSubscriptionWithdrawalBitSet()
	{
		return getBit(PAGING_TIME_WINDOW_SUBSCRIPTION_WITHDRAWAL_BIT);
	}

	@Override
	public void setActiveTimeWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(ACTIVE_TIME_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isActiveTimeWithdrawalBitSet()
	{
		return getBit(ACTIVE_TIME_WITHDRAWAL_BIT);
	}

	@Override
	public void setEDRXCycleLengthWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(EDRX_CYCLE_LENGTH_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isEDRXCycleLengthWithdrawalBitSet()
	{
		return getBit(EDRX_CYCLE_LENGTH_WITHDRAWAL_BIT);
	}

	@Override
	public void setServiceGapTimeWithdrawalBit(boolean isOn)
	{
		setBitUnchecked(SERVICE_GAP_TIME_WITHDRAWAL_BIT, isOn);
	}

	@Override
	public boolean isServiceGapTimeWithdrawalBitSet()
	{
		return getBit(SERVICE_GAP_TIME_WITHDRAWAL_BIT);
	}
}