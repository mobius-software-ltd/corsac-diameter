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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpv4Address;

/**
*
* @author yulian oifa
*
*/

/*
	17.7.21	MBMS-BMSC-SSM-IP-Address AVP
	The MBMS-BMSC-SSM-IP-Address AVP (AVP code 918) is of type OctetString, and contains the value of BM-SC’s IPv4 address for Source Specific Multicasting. IPv4 only or dual stack BM-SC includes this AVP.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_BMS_SSM_IP_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "MBMS-BMSC-SSM-IP-Address")
public interface MBMSBMSCSSMIPAddress extends DiameterIpv4Address
{
}