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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpv6Address;

/**
*
* @author yulian oifa
*
*/

/*
	17.7.22	MBMS-BMSC-SSM-IPv6-Address AVP
	The MBMS-BMSC-SSM-IPv6-Address AVP (AVP code 919) is of type OctetString, and contains the value of BM-SC’s IPv6 address for Source Specific Multicasting. Dual stack BM-SC includes this AVP.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_BMS_SSM_IPV6_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "MBMS-BMSC-SSM-IPv6-Address")
public interface MBMSBMSCSSMIPv6Address extends DiameterIpv6Address
{
}