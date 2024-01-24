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
	7.3.7 ULR-Flags
	The ULR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in 
	table 7.3.7/1:
	
	Bit Name
	Description

	0 Single-Registration-Indication
	This bit, when set, indicates that the HSS shall send Cancel Location to the SGSN. An SGSN shall not set this bit when sending ULR.

	1 S6a/S6d-Indicator
	This bit, when set, indicates that the ULR message is sent on the S6a interface, i.e. the source node is an MME (or a combined MME/SGSN to which the UE is attached via E-UTRAN).
	This bit, when cleared, indicates that the ULR message is sent on the S6d interface, i.e. the source node is an SGSN (or a combined MME/SGSN to which the UE is attached via UTRAN or GERAN).

	2 Skip Subscriber Data
	This bit, when set, indicates that the HSS may skip subscription data in ULA. If the subscription data has changed in the HSS after the last successful update of the MME/SGSN, the HSS shall ignore this bit and send the updated subscription data. If the HSS effectively skips the sending of subscription data, the GPRS-Subscription-Data-Indicator flag can be ignored.

	3 GPRS-Subscription-Data-Indicator
	This bit, when set, indicates that the HSS shall include in the ULA command the GPRS subscription data, if available in the HSS; it shall be included in the GPRS-Subscription-Data AVP inside the Subscription-Data AVP (see 7.3.2).
	Otherwise, the HSS shall not include the GPRS-Subscription-Data AVP in the response, unless the Update Location Request is received over the S6d interface and there is no APN configuration profile stored for the subscriber, or when the subscription data is returned by a Pre-Rel-8 HSS (via an IWF).
	A standalone MME shall not set this bit when sending a ULR.

	4 Node-Type-Indicator
	This bit, when set, indicates that the requesting node is a combined MME/SGSN.
	This bit, when cleared, indicates that the requesting node is a single MME or SGSN; in this case, if the S6a/S6d-Indicator is set, the HSS may skip the check of those supported features only applicable to the SGSN, and if, in addition the MME does not request to be registered for SMS, the HSS may consequently skip the download of the SMS related subscription data to a standalone MME. NOTE2

	5 Initial-Attach-Indicator
	This bit, when set, indicates that the HSS shall send Cancel Location to the MME or SGSN if there is the MME or SGSN registration.

	6 PS-LCS-Not-Supported-By-UE
	This bit, when set, indicates to the HSS that the UE does not support neither UE Based nor UE Assisted positioning methods for Packet Switched Location Services. The MME shall set this bit on the basis of the UE capability information. The SGSN shall set this bit on the basis of the UE capability information and the access technology supported by the SGSN.

	7 SMS-Only-Indication
	This bit, when set, indicates that the UE indicated "SMS only" when requesting a combined IMSI attach or combined RA/LU.

	8 Dual-Registration-5G-Indicator
	This bit, when set by an MME over S6a interface, indicates that the HSS+UDM shall not send Nudm_UECM_DeregistrationNotification to the registered AMF (if any); when not set by an MME over S6a interface, it indicates that the HSS+UDM shall send Nudm_UECM_DeregistrationNotification to the registered AMF (if any). See 3GPP TS 29.503 [66].
	An SGSN shall not set this bit when sending ULR over S6d interface.

	9 Inter-PLMN-inter-MME handover
	This bit, when set by an MME over S6a interface, indicates that an inter PLMN inter MME (or AMF to MME) handover is ongoing.

	10 Intra-PLMN-inter-MME handover
	This bit, when set by an MME over S6a interface, indicates that an intra PLMN inter MME (or AMF to MME) handover is ongoing.

	NOTE1:	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving HSS.

	NOTE2:	If the MME is registered for SMS then the HSS will download the SMS related data also for the standalone MME.
 */
@DiameterAvpDefinition(code = 1405L, vendorId = KnownVendorIDs.TGPP_ID, name = "ULR-Flags")
public interface ULRFlags extends DiameterBitmask32
{
	public static final int SINGLE_REGISTRATION_INDICATION_BIT = 0;
	public static final int S6A_S6D_INDICATOR_BIT = 1;
	public static final int SKIP_SUBSCRIBER_DATA_BIT = 2;
	public static final int GPRS_SUBSCRIPTION_DATA_INDICATOR_BIT = 3;
	public static final int NODE_TYPE_INDICATION_BIT = 4;
	public static final int INITIAL_ATTACH_INDICATION_BIT = 5;
	public static final int PS_LCS_NOT_SUPPORTED_BY_UE_BIT = 6;
	public static final int SMS_ONLY_INDICATION_BIT = 7;
	public static final int DUAL_REGISTRATION_5G_INDICATION_BIT = 8;
	public static final int INTER_PLMN_INTER_MME_HANDOVER_BIT = 9;
	public static final int INTRA_PLMN_INTER_MME_HANDOVER_BIT = 10;
	
	public void setSingleRegistrationIndicationBit(boolean isOn);
	
	public boolean isSingleRegistrationIndicationBitSet();
	
	public void setS6AS6DIndicationBit(boolean isOn);
	
	public boolean isS6AS6DIndicationBitSet();
	
	public void setSkipSubscriberDataBit(boolean isOn);
	
	public boolean isSkipSubscriberDataBitSet();
	
	public void setGPRSSubscriptionDataIndicationBit(boolean isOn);
	
	public boolean isGPRSSubscriptionDataIndicationBitSet();
	
	public void setNodeTypeIndicationBit(boolean isOn);
	
	public boolean isNodeTypeIndicationBitSet();
	
	public void setInitialAttachIndicationBit(boolean isOn);
	
	public boolean isInitialAttachIndicationBitSet();
	
	public void setPSLCSNotSupportedByUEBit(boolean isOn);
	
	public boolean isPSLCSNotSupportedByUEBitSet();
	
	public void setSMSOnlyIndicationBit(boolean isOn);
	
	public boolean isSMSOnlyIndicationBitSet();
	
	public void setDualRegistration5GIndicationBit(boolean isOn);
	
	public boolean isDualRegistration5GIndicationBitSet();
	
	public void setInterPLMNInterMMEHandoverBit(boolean isOn);
	
	public boolean isInterPLMNInterMMEHandoverBitSet();
	
	public void setIntraPLMNInterMMEHandoverBit(boolean isOn);
	
	public boolean isIntraPLMNInterMMEHandoverBitSet();
}