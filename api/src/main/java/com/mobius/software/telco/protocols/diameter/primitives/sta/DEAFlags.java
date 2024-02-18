package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
	5.2.3.21	DEA-Flags
	The DEA-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 5.2.3.21/1:
	Table 5.2.3.21/1: DEA-Flags

	Bit Name
	Description

	0 NSWO-Authorization
	This bit, when set, indicates to the TWAN that the non-seamless WLAN offload service is authorized (see clause 16 of 3GPP TS 23.402 [3]).

	1 TWAN-S2a-Connectivity-Indicator
	This bit is only applicable to the TWAN authentication and authorization procedure, when authorizing the SCM for EPC access; when set, it indicates to the TWAN that the EAP-AKA' authentication has been successful (i.e., the 3GPP AAA Server has checked the validity of the challenge response sent by the UE), and the network connectivity set up may proceed at the TWAN.

	2 IMEI-Check-Request-In-VPLMN
	This bit is only applicable to the TWAN authentication and authorization procedure, when the UE and the network support Mobile Equipment Identity signalling over trusted WLAN.
	When set, it indicates that the VPLMN shall perform the IMEI check and return the outcomes to the 3GPP AAA Server.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the recever of the command.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DEA_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "DEA-Flags")
public interface DEAFlags extends DiameterBitmask32
{
	public static final int NSWO_AUTHORIZATION_BIT = 0;	
	public static final int TWAN_S2A_CONNECTIVITY_INDICATOR_BIT = 1;	
	public static final int IMEI_CHECK_REQUEST_IN_VPLMN_BIT = 2;	
	
	public void setNSWOAuthorizationBit(boolean isOn);
	
	public boolean isNSWOAuthorizationBitSet();
	
	public void setTWANS2aConnectivityIndicatorBit(boolean isOn);
	
	public boolean isTWANS2aConnectivityIndicatorBitSet();
	
	public void setIMEICheckRequestInVPLMNBit(boolean isOn);
	
	public boolean isIMEICheckRequestInVPLMNBitSet();
}