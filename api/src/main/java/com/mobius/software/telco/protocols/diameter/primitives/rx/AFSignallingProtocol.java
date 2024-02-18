package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.26	AF-Signalling-Protocol-AVP
	The AF-Signalling-Protocol AVP (AVP code 529) is of type Enumerated, and indicates the protocol used for signalling between the UE and the AF. If the AF-Signalling-Protocol AVP is not provided in the AA-Request, the value NO_INFORMATION shall be assumed.

	NO_INFORMATION (0)
		This value is used to indicate that no information about the AF signalling protocol is being provided.

	SIP (1)
		This value is used to indicate that the signalling protocol is Session Initiation Protocol.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AF_SIGNALLING_PROTOCOL, vendorId = VendorIDs.TGPP_ID, must = false, name = "AF-Signalling-Protocol")
public interface AFSignallingProtocol extends DiameterEnumerated<AFSignallingProtocolEnum>
{
}