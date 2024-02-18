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
 * 	7.3.209	Preferred-Data-Mode
	The Preferred-Data-Mode AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits is defined in table 7.3.209/1:
	Table 7.3.209/1: Preferred-Data-Mode

	bit	name
	Description

	0 Data over User Plane Preferred
	This bit, when set, shall indicate that the User Plane is preferred for transmitting the traffic associated with the APN. If not set, it means that the User Plane is not preferred for transmitting the traffic associated with the APN.

	1 Data over Control Plane Preferred
	This bit, when set, shall indicate that the Control Plane is preferred for transmitting the traffic associated with the APN. If not set, it means that the Control Plane is not preferred for transmitting the traffic associated with the APN.

	NOTE 1:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME.

	NOTE 2:	At least one of the bits 0 and 1 shall be set to 1. Both bits 0 and 1 may be set to 1 to indicate that both User Plane and Control Plane are preferred for transmitting the traffic associated with the APN.
	
	NOTE 3:	This parameter only applies to E-UTRAN and SGi PDN connections. Data over User Plane refers to PDN data transported  over S1-U and Data Radio Bearer. Data over Control Plane refers to PDN data transported over NAS and Signalling Radio Bearer.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PREFERRED_DATA_MODE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Preferred-Data-Mode")
public interface PreferredDataMode extends DiameterUnsigned32
{
}