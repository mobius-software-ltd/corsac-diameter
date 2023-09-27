package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.15	P2P-Features
	The P2P-Features AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 6.3.15-1:

	Table 6.3.15-1: P2P-Features

	Bit Name
	Description

	0 Group Owner Indication
	This bit, when set, shall indicate that the UE should implement the Group Owner (GO) functionality specified in the Wi-Fi P2P specification [17]. When not set, this bit shall indicate the UE should behave as a Wi-Fi P2P client that attempts to discover and associate with a GO.

	NOTE:	Bits not defined in this table shall be cleared by the sending ProSe Function and discarded by the receiving ProSe Function.
 */
@DiameterAvpDefinition(code = 3809L, vendorId = KnownVendorIDs.TGPP_ID, name = "P2P-Features")
public interface P2PFeatures extends DiameterUnsigned32
{
}