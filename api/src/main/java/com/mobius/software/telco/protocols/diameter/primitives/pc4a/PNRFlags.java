package com.mobius.software.telco.protocols.diameter.primitives.pc4a;
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
	6.3.7	PNR-Flags 
	The PNR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 6.3.7-1:

	Table 6.3.7-1: PNR-Flags
	
	bit name
	Description

	0 Direct Discovery Revoked
	This bit, when set, shall indicate to the HSS that the authorization for ProSe direct discovery is to be revoked on the indicated PLMN.

	1 Direct Communication Revoked
	This bit, when set, shall indicate to the HSS that the authorization for ProSe direct communication is to be revoked on the indicated PLMN.

	2 Purged UE
	This bit, when set, shall indicate to the HSS that the subscriber's data has been deleted from the ProSe Function.

	NOTE 1:	Bits not defined in this table shall be cleared by the sending ProSe Function and discarded by the receiving HSS.

	NOTE 2:	If Purged UE bit is set, all other bits in this table shall be cleared by the sending ProSe Function and discarded by the receiving HSS.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PNR_FLAGS, vendorId = VendorIDs.TGPP_ID, name = "PNR-Flags")
public interface PNRFlags extends DiameterBitmask32
{
	public static final int DIRECT_DISCOVERY_REVOKED_BIT = 0;	
	public static final int DIRECT_COMMUNICATION_REVOKED_BIT = 1;	
	public static final int PURGED_UE_BIT = 2;	
	
	public void setDirectDiscoveryRevokedBit(boolean isOn);
	
	public boolean isDirectDiscoveryRevokedBitSet();	
	
	public void setDirectCommunicationRevokedBit(boolean isOn);
	
	public boolean isDirectCommunicationRevokedBitSet();	
	
	public void setPurgedUEBit(boolean isOn);
	
	public boolean isPurgedUEBitSet();
}