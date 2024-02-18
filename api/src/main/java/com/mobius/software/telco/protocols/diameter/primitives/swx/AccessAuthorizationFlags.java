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
	8.2.3.20	Access-Authorization-Flags
	The Access-Authorization-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.2.3.20/1:

	Table 8.2.3.20/1: Access-Authorization-Flags
	Bit Name
	Description

	0 EPC-Access-Authorization
	This bit, when set, indicates that the UE is allowed to access the EPC when connected via Trusted WLAN access. This flag, when not set, indicates that the UE is not allowed to access EPC when connected via Trusted WLAN access.

	1 NSWO-Access-Authorization
	This bit, when set, indicates that the UE is allowed Non-Seamless WLAN Offload access via Trusted WLAN access. This flag, when not set, indicates that the UE is not allowed to Non-Seamless WLAN Offload via Trusted WLAN access.

	NOTE:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving 3GPP AAA Server.

	NOTE:	UE is allowed to access the EPC when connected via Trusted WLAN access only if the Non-3GPP-IP-Access-APN AVP does not disable all APNs and the EPC-Access-Authorization bit is set.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ACCESS_AUTHORIZATION_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "Access-Authorization-Flags")
public interface AccessAuthorizationFlags extends DiameterBitmask32
{
	public static final int EPC_ACCCESS_AUTHORIZATION_BIT = 0;	
	public static final int NSWO_ACCCESS_AUTHORIZATION_BIT = 1;	
	
	public void setEPCAccessAuthorizationBit(boolean isOn);
	
	public boolean isEPCAccessAuthorizationBitSet();
	
	public void setNSWOAccessAuthorizationBit(boolean isOn);
	
	public boolean isNSWOAccessAuthorizationBitSet();
}