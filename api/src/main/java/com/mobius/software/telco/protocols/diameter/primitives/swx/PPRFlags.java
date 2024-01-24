package com.mobius.software.telco.protocols.diameter.primitives.swx;
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
	8.2.3.17	PPR-Flags
	The PPR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.2.3.17/1:
	Table 8.2.3.17/1: PPR-Flags

	Bit Name
	Description

	0 Reset-Indication
	This bit, when set, indicates that the HSS has undergone a restart event and the registration data and dynamic data needs to be restored, if available at the 3GPP AAA Server.

	1 Access-Network-Info-Request
	This bit, when set, indicates that the HSS requests the 3GPP AAA Server the identity and location information of the access network where the UE is currently attached.

	2 UE-Local-Time-Zone-Request
	This bit, when set, indicates that the HSS requests the 3GPP AAA Server the time zone of the location in the access network where the UE is attached.

	3 P-CSCF Restoration Request
	This bit, when set, indicates to the 3GPP AAA Server that the HSS requests the execution of the HSS-based P-CSCF restoration procedures for WLAN, as described in 3GPP TS 23.380 [52] clause 5.6.

	NOTE:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving 3GPP AAA Server.
 */
@DiameterAvpDefinition(code = 1508L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PPR-Flags")
public interface PPRFlags extends DiameterBitmask32
{
	public static final int RESET_INDICATION_BIT = 0;	
	public static final int ACCESS_NETWORK_INFO_REQUEST_BIT = 1;	
	public static final int UE_LOCAL_TIMEZONE_REQUEST_BIT = 2;	
	public static final int PCSCF_RESTORATION_REQUEST_BIT = 3;
	
	public void setResetIndicationBit(boolean isOn);
	
	public boolean isResetIndicationBitSet();
	
	public void setAccessNetworkInfoRequestBit(boolean isOn);
	
	public boolean isAccessNetworkInfoRequestBitSet();
	
	public void setUELocalTimeZoneRequestBit(boolean isOn);
	
	public boolean isUELocalTimeZoneRequestBitSet();
	
	public void setPCSCFRestorationRequestBit(boolean isOn);
	
	public boolean isPCSCFRestorationRequestBitSet();
}