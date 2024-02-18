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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.49	NOR-Flags
	The NOR-Flags AVP is of type Unsigned32 and it contains a bit mask. The meaning of the bits is defined in table 7.3.49/1:
	Table 7.3.49/1: NOR-Flags

	bit name
	Description

	0 Single-Registration-Indication
	This bit, when set, indicates that the HSS shall send Cancel Location to the SGSN. An SGSN shall not set this bit when sending NOR.

	1 SGSN area restricted
	This bit, when set, shall indicate that the complete SGSN area is restricted due to regional subscription.

	2 Ready for SM from SGSN
	This bit, when set, shall indicate that the UE is present or the UE has memory capacity available to receive one or more short messages via SGSN.

	3 UE Reachable from MME
	This bit, when set, shall indicate that the UE has become reachable again from MME.

	4 Reserved
	The use of this bit is deprecated. This bit shall be discarded by the receiving HSS.

	5 UE Reachable from SGSN
	This bit, when set, shall indicate that the UE has become reachable again from SGSN.
	
	6 Ready for SM from MME
	This bit, when set, shall indicate that the UE is present or the UE has memory capacity available to receive one or more short messages via MME.

	7 Homogeneous Support of IMS Voice Over PS Sessions
	This bit, when set, shall indicate that the Homogeneous Support of IMS Voice Over PS Sessions is updated.

	8 S6a/S6d-Indicator
	This bit, when set, shall indicate that the NOR message is sent on the S6a interface, i.e. the message is from the MME or the MME part on the combined MME/SGSN.
	This bit, when cleared, indicates that the NOR message is sent on the S6d interface, i.e. the message is from the SGSN or the SGSN part on the combined MME/SGSN.

	9 Removal of MME Registration for SMS
	This bit, when set, shall indicate that the MME requests to remove its registration for SMS.

	NOTE 1:	The S6a/S6d-Indicator flag shall be used together with Homogeneous Support of IMS Voice Over PS Sessions flag, i.e. if the Homogeneous Support of IMS Voice Over PS Sessions bit is set, the S6a/S6d-Indicator bit shall be set if the message is sent from the MME or the MME part on the combined MME/SGSN, and shall be cleared if the message is sent from the SGSN or the SGSN part on the combined MME/SGSN. This S6a/S6d-Indicator bit shall be discarded by the receiving HSS if the Homogeneous Support of IMS Voice Over PS Sessions bit is not set.

	NOTE 2:	Bits not defined in this table shall be cleared by the sending MME or SGSN and discarded by the receiving HSS.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.NOR_FLAGS, vendorId = VendorIDs.TGPP_ID, name = "NOR-Flags")
public interface NORFlags extends DiameterBitmask32
{
	public static final int SINGLE_REGISTRATION_INDICATION_BIT = 0;
	public static final int SGSN_AREA_RESTRICTED_BIT = 1;
	public static final int READY_FOR_SM_FROM_SGSN_BIT = 2;
	public static final int UE_REACHABILITY_FROM_MME_BIT = 3;
	public static final int UE_REACHABILITY_FROM_SGSN_BIT = 5;
	public static final int READY_FOR_SM_FROM_MME_BIT = 6;
	public static final int HOMOGENOUS_SUPPORT_OF_IMS_VOICE_OVER_PS_SESSIONS_BIT = 7;
	public static final int S6A_S6D_INDICATOR_BIT = 8;
	public static final int REMOVAL_OF_MME_REGISTRATION_FOR_SMS_BIT = 9;
	
	public void setSingleRegistrationIndicationBit(boolean isOn);
	
	public boolean isSingleRegistrationIndicationBitSet();
	
	public void setSGSNAreaRestrictedBit(boolean isOn);
	
	public boolean isSGSNAreaRestrictedBitSet();
	
	public void setReadyForSMFromSGSNBit(boolean isOn);
	
	public boolean isReadyForSMFromSGSNBitSet();
	
	public void setUEReachabilityFromMMEBit(boolean isOn);
	
	public boolean isUEReachabilityFromMMEBitSet();
	
	public void setUEReachabilityFromSGSNBit(boolean isOn);
	
	public boolean isUEReachabilityFromSGSNBitSet();
	
	public void setReadyForSMFromMMEBit(boolean isOn);
	
	public boolean isReadyForSMFromMMEBitSet();
	
	public void setHomogenousSupportOfIMSVoiceOverPSSessionsBit(boolean isOn);
	
	public boolean isHomogenousSupportOfIMSVoiceOverPSSessionsBitSet();
	
	public void setS6AS6DIndicatorBit(boolean isOn);
	
	public boolean isS6AS6DIndicatorBitSet();
	
	public void setRemovalOfMMERegistrationForSMSBit(boolean isOn);
	
	public boolean isRemovalOfMMERegistrationForSMSBitSet();
}