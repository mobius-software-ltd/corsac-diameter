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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.96 UE-Local-IP-Address AVP (Non-3GPP-EPS access type only)
	The UE-Local-IP-Address AVP (AVP code 2805) is of type Address and contains the UE local IP address. For BBAI,
	refer to Annex E.2.1. The UE local IP address type may be Ipv4 or Ipv6.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UE_LOCAL_IP_ADDRESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "UE-Local-IP-Address")
public interface UELocalIPAddress extends DiameterAddress
{
}