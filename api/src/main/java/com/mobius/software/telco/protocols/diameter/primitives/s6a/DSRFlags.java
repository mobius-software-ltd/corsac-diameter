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
	7.3.25	DSR-Flags
	The DSR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits is defined in table 7.3.25/1:
	
	Bit Name
	Description

	0 Regional Subscription Withdrawal
	This bit, when set, indicates that Regional Subscription shall be deleted from the subscriber data.

	1 Complete APN Configuration Profile Withdrawal
	This bit, when set, indicates that all EPS APN configuration data for the subscriber shall be deleted from the subscriber data. This flag only applies to the S6d interface.

	2 Subscribed Charging Characteristics Withdrawal
	This bit, when set, indicates that the Subscribed Charging Characteristics have been deleted from the subscription data.

	3 PDN subscription contexts Withdrawal
	This bit, when set, indicates that the PDN subscription contexts whose identifier is included in the Context-Identifier AVP shall be deleted.
	(Note 1)

	4 STN-SR
	This bit, when set, indicates that the Session Transfer Number for SRVCC shall be deleted from the subscriber data.

	5 Complete PDP context list Withdrawal
	This bit, when set, indicates that all PDP contexts for the subscriber shall be deleted from the subscriber data.

	6 PDP contexts Withdrawal
	This bit, when set, indicates that the PDP contexts whose identifier is included in the Context-Identifier AVP shall be deleted.
	(Note 2)

	7 Roaming Restricted due to unsupported feature
	This bit, when set, indicates that the roaming restriction shall be deleted from the subscriber data in the MME or SGSN.

	8 Trace Data Withdrawal
	This bit, when set, indicates that the Trace Data shall be deleted from the subscriber data.

	9 CSG Deleted
	This bit, when set, indicates  that
		-	the "CSG-Subscription-Data from HSS" shall be deleted in the MME or SGSN when received over the S6a or S6d interface
		-	the "CSG-Subscription-Data from CSS" shall be deleted in the MME or SGSN when received over the S7a or S7d interface.

	10 APN-OI-Replacement
	This bit, when set, indicates that the UE level APN-OI-Replacement shall be deleted from the subscriber data.

	11 GMLC List Withdrawal
	This bit, when set, indicates that the subscriber's LCS GMLC List shall be deleted from the MME or SGSN.

	12 LCS Withdrawal
	This bit, when set, indicates that the LCS service whose code is included in the SS-Code AVP shall be deleted from the MME or SGSN.

	13 SMS Withdrawal
	This bit, when set, indicates that the SMS service whose code is included in the SS-Code AVP or TS-Code AVP shall be deleted from the MME or SGSN.

	14 Subscribed periodic RAU-TAU Timer Withdrawal
	This bit, when set, indicates that the subscribed periodic RAU TAU Timer value shall be deleted from the subscriber data.

	15 Subscribed VSRVCC Withdrawal
	This bit, when set, indicates that the Subscribed VSRVCC shall be deleted from the subscriber data.

	16 A-MSISDN Withdrawal
	This bit, when set, indicates that the additional MSISDN, if present, shall be deleted from the subscriber data.

	17 ProSeWithdrawal
	This bit, when set, indicates that the ProSe subscription data shall be deleted from the MME or combined MME/SGSN.

	18 Reset-IDs
	This bit, when set, indicates that the set of Reset-IDs shall be deleted from the MME or SGSN.

	19 DL-Buffering-Suggested-Packet-Count Withdrawal
	This bit, when set, indicates that the DL-Buffering-Suggested-Packet-Count shall be deleted in the MME or SGSN.

	20 Subscribed IMSI-Group-Id Withdrawal
	This bit, when set, indicates that all subscribed IMSI-Group-Id(s) shall be deleted in the MME or SGSN.

	21 Delete monitoring events
	This bit when set indicates to the MME or SGSN to delete all the Monitoring events for the subscriber which are associated with the provided SCEF-ID.

	22 User Plane Integrity Protection Withdrawal
	This bit, when set, indicates to the SGSN that User Plane Integrity Protection may no longer be required when GERAN is used. The MME shall ignore it.

	23 MSISDN Withdrawal
	This bit, when set, indicates that the MSISDN shall be deleted from the subscriber data.
	It is also used by the MME/SGSN to delete those monitoring events created using the MSISDN.

	24 UE Usage Type Withdrawal
	This bit, when set, indicates to the MME or SGSN that the UE Usage Type shall be deleted from the subscription data.

	25 V2X Withdrawal
	This bit, when set, indicates that the V2X subscription data shall be deleted from the MME or combined MME/SGSN.

	26 External-Identifier-Withdrawal
	This bit, when set, indicates that the External-Identifier shall be deleted from the subscriber data.
	It is also used by the MME/SGSN to delete those monitoring events created using the removed External Identifier or all monitoring events created for any External Identifier in case of removing the default External Identifier.

	27 Aerial-UE-Subscription Withdrawal
	This bit, when set, indicates that the Aerial UE subscription shall be deleted from the subscriber data.

	28 Paging Time Window Subscription Withdrawal
	This bit, when set, indicates that the Paging Time Window subscription shall be deleted from the subscriber data.

	29 Active-Time-Withdrawal
	This bit, when set, indicates that the Active Time used for PSM shall be deleted from the subscriber data.

	30 eDRX-Cycle-Length -Withdrawal
	This bit, when set, indicates that the eDRX-Cycle-Length shall be deleted from the subscriber data. .
	If the eDRX-Related-RAT is present in the DSR command, only the eDRX Cycle Length for indicated RAT types shall be deleted. Otherwise, the entire eDRX Cycle Length subscription for all RAT types shall be deleted.

	31 Service-Gap-Time-Withdrawal
	This bit, when set, indicates that the Service Gap Time shall be deleted from the subscriber data.

	Note 1:	If the Complete APN Configuration Profile Withdrawal bit is set, this bit should not be set.

	Note 2:	If the Complete PDP context list Withdrawal bit is set, this bit should not be set.

	Note 3:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.

	Note 4:	Bits 3 and 6 are excluding alternatives and shall not both be set.

	Note 5:	When this AVP is transferred over the S7a/S7d interface, only the bit 9 (CSG Deleted) is meaningful, other bits shall be cleared.
 */
@DiameterAvpDefinition(code = 1421L, vendorId = KnownVendorIDs.TGPP_ID, name = "DSR-Flags")
public interface DSRFlags extends DiameterBitmask32
{
	public static final int REGIONAL_SUBSCRIPTION_WITHDRAWAL_BIT = 0;
	public static final int COMPLETE_APN_CONFIGURATION_PROFILE_WITHDRAWAL_BIT = 1;
	public static final int SUBSCRIBED_CHARGING_CHARACTERISTICS_WITHDRAWAL_BIT = 2;
	public static final int PDN_SUBSCRIPTION_CONTEXTS_WITHDRAWAL_BIT = 3;
	public static final int STN_SR_BIT = 4;
	public static final int COMPLETE_PDP_CONTEXT_LIST_WITHDRAWAL_BIT = 5;
	public static final int PDP_CONTEXTS_WITHDRAWAL_BIT = 6;
	public static final int ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE_BIT = 7;
	public static final int TRACE_DATA_WITHDRAWAL_BIT = 8;
	public static final int CSG_DELETED_BIT = 9;
	public static final int APN_IO_REPLACEMENT_BIT = 10;
	public static final int GMLC_LIST_WITHDRAWAL_BIT = 11;
	public static final int LCS_WITHDRAWAL_BIT = 12;
	public static final int SMS_WITHDRAWAL_BIT = 13;
	public static final int SUBSCRIBED_PERIODIC_RAU_TAU_TIMER_WITHDRAWAL_BIT = 14;
	public static final int SUBSCRIBED_VSRVCC_WITHDRAWAL_BIT = 15;
	public static final int AMSISDN_WITHDRAWAL_BIT = 16;
	public static final int PROSE_WITHDRAWAL_BIT = 17;
	public static final int RESET_IDS_BIT = 18;
	public static final int DL_BUFFERING_SUGGESTED_PACKET_COUNT_WITHDRAWAL_BIT = 19;
	public static final int SUBSCRIBED_IMSI_GROUP_ID_WITHDRAWAL_BIT = 20;
	public static final int DELETE_MONITORING_EVENTS_BIT = 21;
	public static final int USER_PLANE_INTEGRITY_PROTECTION_WITHDRAWAL_BIT = 22;
	public static final int MSISDN_WITHDRAWAL_BIT = 23;
	public static final int UE_USAGE_TYPE_WITHDRAWAL_BIT = 24;
	public static final int V2X_WITHDRAWAL_BIT = 25;
	public static final int EXTERNAL_IDENTIFIER_WITHDRAWAL_BIT = 26;
	public static final int AERIAL_UE_SUBSCRIPTION_WITHDRAWAL_BIT = 27;
	public static final int PAGING_TIME_WINDOW_SUBSCRIPTION_WITHDRAWAL_BIT = 28;
	public static final int ACTIVE_TIME_WITHDRAWAL_BIT = 29;
	public static final int EDRX_CYCLE_LENGTH_WITHDRAWAL_BIT = 30;
	public static final int SERVICE_GAP_TIME_WITHDRAWAL_BIT = 31;
	
	public void setRegionalSubscriptionWithdrawalBit(boolean isOn);
	
	public boolean isRegionalSubscriptionWithdrawalBitSet();	
	
	public void setCompleteAPNConfigurationProfileWithdrawalBit(boolean isOn);
	
	public boolean isCompleteAPNConfigurationProfileWithdrawalBitSet();	
	
	public void setSubscripbedChargingCharacteristricsWithdrawalBit(boolean isOn);
	
	public boolean isSubscripbedChargingCharacteristricsWithdrawalBitSet();	
	
	public void setPDNSubscriptionContextsWithdrawalBit(boolean isOn);
	
	public boolean isPDNSubscriptionContextsWithdrawalBitSet();	
	
	public void setSTNSRBit(boolean isOn);
	
	public boolean isSTNSRBitSet();	
	
	public void setCompletePDPContextListWithdrawalBit(boolean isOn);
	
	public boolean isCompletePDPContextListWithdrawalBitSet();	
	
	public void setPDPContextWithdrawalBit(boolean isOn);
	
	public boolean isPDPContextWithdrawalBitSet();	
	
	public void setRoamingRestrictedDueToUnsupportedFeatureWithdrawalBit(boolean isOn);
	
	public boolean isRoamingRestrictedDueToUnsupportedFeatureWithdrawalBitSet();
	
	public void setTraceDataWithdrawalBit(boolean isOn);
	
	public boolean isTraceDataWithdrawalBitSet();	
	
	public void setCSGDeletedWithdrawalBit(boolean isOn);
	
	public boolean isCSGDeletedWithdrawalBitSet();	
	
	public void setAPNIOReplacementBit(boolean isOn);
	
	public boolean isAPNIOReplacementBitSet();	
	
	public void setGMLCListWithdrawalBit(boolean isOn);
	
	public boolean isGMLCListWithdrawalBitSet();	
	
	public void setLCSWithdrawalBit(boolean isOn);
	
	public boolean isLCSWithdrawalBitSet();	
	
	public void setSMSWithdrawalBit(boolean isOn);
	
	public boolean isSMSWithdrawalBitSet();	
	
	public void setSubscribedPeriodicRAUTAUTimerWithdrawalBit(boolean isOn);
	
	public boolean isSubscribedPeriodicRAUTAUTimerWithdrawalBitSet();	
	
	public void setSubscribedVSRVCCWithdrawalBit(boolean isOn);
	
	public boolean isSubscribedVSRVCCWithdrawalBitSet();
	
	public void setAMSISDNWithdrawalBit(boolean isOn);
	
	public boolean isAMSISDNWithdrawalBitSet();	
	
	public void setPROSEWithdrawalBit(boolean isOn);
	
	public boolean isPROSEWithdrawalBitSet();	
	
	public void setResetIDsBit(boolean isOn);
	
	public boolean isResetIDsBitSet();	
	
	public void setDLBufferingSuggestedPacketCountWithdrawalBit(boolean isOn);
	
	public boolean isDLBufferingSuggestedPacketCountWithdrawalBitSet();	
	
	public void setSubscribedIMSIGroupIDWithdrawalBit(boolean isOn);
	
	public boolean isSubscribedIMSIGroupIDWithdrawalBitSet();	
	
	public void setDeleteMonitoringEventsWithdrawalBit(boolean isOn);
	
	public boolean isDeleteMonitoringEventsWithdrawalBitSet();	
	
	public void setUserPlaneIntegrityProtectionWithdrawalBit(boolean isOn);
	
	public boolean isUserPlaneIntegrityProtectionWithdrawalBitSet();	
	
	public void setMSISDNWithdrawalBit(boolean isOn);
	
	public boolean isMSISDNWithdrawalBitSet();
	
	public void setUEUsageTypeWithdrawalBit(boolean isOn);
	
	public boolean isUEUsageTypeWithdrawalBitSet();	
	
	public void setV2XWithdrawalBit(boolean isOn);
	
	public boolean isV2XWithdrawalBitSet();	
	
	public void setExternalIdentifierWithdrawalBit(boolean isOn);
	
	public boolean isExternalIdentifierWithdrawalBitSet();	
	
	public void setAerialUESubscriptionWithdrawalBit(boolean isOn);
	
	public boolean isAerialUESubscriptionWithdrawalBitSet();	
	
	public void setPagingTimeWindowSubscriptionWithdrawalBit(boolean isOn);
	
	public boolean isPagingTimeWindowSubscriptionWithdrawalBitSet();	
	
	public void setActiveTimeWithdrawalBit(boolean isOn);
	
	public boolean isActiveTimeWithdrawalBitSet();	
	
	public void setEDRXCycleLengthWithdrawalBit(boolean isOn);
	
	public boolean isEDRXCycleLengthWithdrawalBitSet();	
	
	public void setServiceGapTimeWithdrawalBit(boolean isOn);
	
	public boolean isServiceGapTimeWithdrawalBitSet();
}