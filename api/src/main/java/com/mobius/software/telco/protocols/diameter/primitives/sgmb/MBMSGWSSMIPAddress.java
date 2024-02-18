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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpv4Address;

/**
*
* @author yulian oifa
*
*/

/*
	20.5a.2	MBMS-GW-SSM-IP-Address AVP
	The MBMS-GW-SSM-IP-Address AVP (AVP code 924) is of type OctetString and contains the Sgi-mb (transport) plane IPv4 destination multicast address used by BM-SC for IP multicast encapsulation of application IP multicast datagrams.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_GW_SSM_IP_ADDRESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "MBMS-BMSC-SSM-IP-Address")
public interface MBMSGWSSMIPAddress extends DiameterIpv4Address
{
}