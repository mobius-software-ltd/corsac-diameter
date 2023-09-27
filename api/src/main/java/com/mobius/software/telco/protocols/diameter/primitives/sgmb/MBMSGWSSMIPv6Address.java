package com.mobius.software.telco.protocols.diameter.primitives.sgmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	20.5a.3	MBMS-GW-SSM-IPv6-Address AVP
	The MBMS-GW-SSM-IPv6-Address AVP (AVP code 925) is of type OctetString and contains the Sgi-mb (transport) plane IPv6 prefix of the destination multicast address used by BM-SC for IP multicast encapsulation of application IP multicast datagrams.
 */
@DiameterAvpDefinition(code = 925L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MBMS-BMSC-SSM-IPv6-Address")
public interface MBMSGWSSMIPv6Address extends DiameterIpv6Address
{
}