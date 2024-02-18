package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

/*	5.3.24 Network-Request-Support AVP
	The Network-Request-Support AVP (AVP code 1024) is of type of Enumerated and indicates the UE and network
	support of the network initiated procedures.
	If the Network Request Support AVP has not been previously provided, its absence shall indicate the value
	NETWORK_REQUEST NOT SUPPORTED. If the Network Request Support AVP has been provided, its value shall
	remain valid until it is provided the next time.
	The following values are defined:

	NETWORK_REQUEST NOT SUPPORTED (0)
 		This value is used to indicate that the UE and the access network do not support the network initiated bearer
		establishment request procedure.
	NETWORK_REQUEST SUPPORTED (1)
 		This value is used to indicate that the UE and the access network support the network initiated bearer
		establishment request procedure.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.NETWORK_REQUEST_SUPPORT, vendorId = VendorIDs.TGPP_ID, name = "Network-Request-Support")
public interface NetworkRequestSupport extends DiameterEnumerated<NetworkRequestSupportEnum>
{
}