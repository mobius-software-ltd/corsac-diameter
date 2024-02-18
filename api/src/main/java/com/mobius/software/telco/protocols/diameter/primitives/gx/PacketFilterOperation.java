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

/*
 * 	5.3.57 Packet-Filter-Operation AVP
	The Packet-Filter-Operation AVP (AVP code 1062) is of type of Enumerated, and it indicates a UE initiated resource
	operation that causes a request for PCC rules.
	The following values are defined:

	DELETION (0)
 		This value is used to indicate that the resources reserved for the provided packet filter identifiers are to be
		deleted and are no longer used by the UE.
	ADDITION (1)
 		This value is used to indicate that the UE requests resources allocated for the provided packet filters.
	MODIFICATION (2)
 		This value is used to indicate that the reserved QoS, the filter, the precedence, or any of the fields for the
		provided packet filter identifiers are being modified.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PACKET_FILTER_OPERATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Packet-Filter-Operation")
public interface PacketFilterOperation extends DiameterEnumerated<PacketFilterOperationEnum>
{
}