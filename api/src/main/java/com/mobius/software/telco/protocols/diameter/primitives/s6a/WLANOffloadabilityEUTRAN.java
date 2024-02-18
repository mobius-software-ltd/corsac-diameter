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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.182	WLAN-offloadability-EUTRAN
	The WLAN-offloadability-EUTRAN AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits is defined in table 7.3.182/1:
	Table 7.3.182/1: WLAN-offloadability-EUTRAN

	bit name
	Description

	0 WLAN offloadability for E-UTRAN
	This bit, when set, shall indicate that the traffic associated with the APN is allowed to be offloaded to WLAN from E-UTRAN using the WLAN/3GPP Radio Interworking feature. If not set, it means the traffic associated with the APN is not allowed to be offloaded to WLAN from E-UTRAN.

	NOTE:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.WLAN_OFFLOADABILITY_EUTRAN, vendorId = VendorIDs.TGPP_ID, must = false, name = "WLAN-offloadability-EUTRAN")
public interface WLANOffloadabilityEUTRAN extends DiameterUnsigned32
{
}