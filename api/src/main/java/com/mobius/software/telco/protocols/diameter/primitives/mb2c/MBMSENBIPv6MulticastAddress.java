package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.23	MBMS-eNB-IPv6-Multicast-Address AVP
	The MBMS-eNB-IPv6-Multicast-Address AVP (AVP code 3521) is of type Address and contains the M1 (transport) plane IPv6 prefix of destination multicast address used by MBMS-GW for IP multicast encapsulation of user plane IP multicast datagrams.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_ENB_IPV6_MULTICAST_ADDDRESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "MBMS-eNB-IPv6-Multicast-Address")
public interface MBMSENBIPv6MulticastAddress extends DiameterAddress
{
}