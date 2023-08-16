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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.66 Packet-Filter-Usage AVP (All access types)
	The Packet-Filter-Usage AVP (AVP code 1072) is of type of Enumerated, and it indicates whether the UE shall be
	provisioned with the related traffic mapping information, i.e. the packet filter. Traffic mapping information may be sent
	to the UE as per the relevant IP-CAN specifications even if not instructed to do so with the Packet-Filter-Usage AVP.
	The following values are defined:

	SEND_TO_UE (1)
 		This value is used to indicate that the related traffic mapping information, i.e. the packet filter, shall be sent to
		the UE, if applicable to the IP-CAN type as per relevant IP-CAN specifications.

	NOTE: The maximum number of packet filters sent to UE is limited by the IP-CAN type. See access specific
	annexes. 
 */
@DiameterAvpDefinition(code = 1072L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Packet-Filter-Usage")
public interface PacketFilterUsage extends DiameterEnumerated<PacketFilterUsageEnum>
{
}