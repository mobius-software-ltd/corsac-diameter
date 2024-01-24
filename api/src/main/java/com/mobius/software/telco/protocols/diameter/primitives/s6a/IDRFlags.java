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
	7.3.103	IDR-Flags
	The IDR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.3.103/1:
	Table 7.3.103/1: IDR-Flags

	bit name
	Description

	0 UE Reachability Request
	This bit when set shall indicate to the MME or the SGSN that the HSS is awaiting a Notification of UE Reachability.

	1 T-ADS Data Request
	This bit, when set, shall indicate to the MME or SGSN that the HSS requests the support status of "IMS Voice over PS Sessions", and the RAT Type and timestamp of the last radio contact with the UE.

	2 EPS User State Request
	This bit, when set, shall indicate to the MME or the SGSN that the HSS requests the MME or the SGSN for the current user state.

	3 EPS Location Information Request
	This bit, when set, shall indicate to the MME or the SGSN that the HSS requests the MME or SGSN for location information

	4 Current Location Request
	This bit when set shall indicate to the MME or the SGSN that the HSS requests the MME or SGSN to provide the most current location information by paging the UE if the UE is in idle mode. This bit is used only in combination with the"EPS Location Information Request" bit.
	
	5 Local Time Zone Request
	This bit when set shall indicate to the MME or the SGSN that the HSS requests the MME or SGSN to provide information on the time zone of the location in the visited network where the UE is attached.

	6 Remove SMS Registration
	This bit when set shall indicate to the MME that it shall consider itself unregistered for SMS.

	7 RAT-Type Requested
	This bit when set shall indicate to the MME or the SGSN that the HSS requests the MME or SGSN to provide the RAT Type that corresponds to the requested EPS Location Information. This bit is used only in combination with the"EPS Location Information Request" bit.

	8 P-CSCF Restoration Request
	This bit, when set, shall indicate to the MME or SGSN that the HSS requests the execution of the HSS-based P-CSCF restoration procedures, as described in 3GPP TS 23.380 [51] clause 5.4.

	NOTE:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.
 */
@DiameterAvpDefinition(code = 1490L, vendorId = KnownVendorIDs.TGPP_ID, name = "IDR-Flags")
public interface IDRFlags extends DiameterBitmask32
{
	public static final int UE_REACHABILITY_REQUEST_BIT = 0;
	public static final int T_ADS_DATA_REQUEST_BIT = 1;
	public static final int EPS_USER_STATE_REQUEST_BIT = 2;
	public static final int EPS_LOCATION_INFORMATION_REQUEST_BIT = 3;
	public static final int CURRENT_LOCATION_REQUEST_BIT = 4;
	public static final int LOCAL_TIMEZONE_REQUEST_BIT = 5;
	public static final int REMOVE_SMS_REGISTRATION_REQUEST_BIT = 6;
	public static final int RAT_TYPE_REQUEST_BIT = 7;
	public static final int PCSCF_RESTORATION_REQUEST_BIT = 8;
	
	public void setUEReachabilityRequestBit(boolean isOn);
	
	public boolean isUEReachabilityRequestBitSet();
	
	public void setTADSDataRequestBit(boolean isOn);
	
	public boolean isTADSDataRequestBitSet();
	
	public void setEPSUserStateRequestBit(boolean isOn);
	
	public boolean isEPSUserStateRequestBitSet();
	
	public void setEPSLocationInformationRequestBit(boolean isOn);
	
	public boolean isEPSLocationInformationRequestBitSet();
	
	public void setCurrentLocationRequestBit(boolean isOn);
	
	public boolean isCurrentLocationRequestBitSet();
	
	public void setLocatTimezoneRequestBit(boolean isOn);
	
	public boolean isLocatTimezoneRequestBitSet();
	
	public void setRemoveSMSRegistrationRequestBit(boolean isOn);
	
	public boolean isRemoveSMSRegistrationRequestBitSet();
	
	public void setRATTypeRequestBit(boolean isOn);
	
	public boolean isRATTypeRequestBitSet();
	
	public void setPCSCFRestorationRequestBit(boolean isOn);
	
	public boolean isPCSCFRestorationRequestBitSet();
}