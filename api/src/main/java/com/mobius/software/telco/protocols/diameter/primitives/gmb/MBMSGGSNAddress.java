package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpv4Address;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	17.7.19	MBMS-GGSN-Address AVP
	The MBMS-GGSN-Address AVP (AVP code 916) is of type OctetString, and contains the value of GGSN’s Ipv4 address for user plane data. Ipv4 only or dual stack GGSN includes this AVP in case BM-SC requests GGSN’s user plane unicast address.
 */
@DiameterAvpDefinition(code = 916L, vendorId = KnownVendorIDs.TGPP_ID, name = "MBMS-GGSN-Address")
public interface MBMSGGSNAddress extends DiameterIpv4Address
{
}