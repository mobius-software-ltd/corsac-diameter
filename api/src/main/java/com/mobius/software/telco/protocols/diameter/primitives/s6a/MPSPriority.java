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
	7.3.131	MPS-Priority
	The MPS-Priority AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 7.3.131/1:
	Table 7.3.131/1: MPS-Priority

	Bit Name
	Description

	0 MPS-CS-Priority
	This bit, when set, indicates that the UE is subscribed to the eMLPP or 1x RTT priority service in the CS domain.

	1 MPS-EPS-Priority
	This bit, when set, indicates that the UE is subscribed to the MPS in the EPS domain.

	Note: Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.

	NOTE:	The HSS derives the information for MPS-CS-Priority from the eMLPP Subscription Data as defined in the 3GPP TS 29.002 [24] or 1x RTT priority service which is out of the scope of 3GPP.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MPS_PRIORITY, vendorId = VendorIDs.TGPP_ID, must = false, name = "MPS-Priority")
public interface MPSPriority extends DiameterBitmask32
{
	public static final int MPS_CS_PRIORITY_BIT = 0;
	public static final int MPS_EPS_PRIORITY_BIT = 0;
	
	public void setMPSCSPriorityBit(boolean isOn);
	
	public boolean isMPSCSPriorityBitSet();
	
	public void setMPSEPSPriorityBit(boolean isOn);
	
	public boolean isMPSEPSPriorityBitSet();
}