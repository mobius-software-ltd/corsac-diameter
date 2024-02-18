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
 * 	5.3.49 AN-GW-Address AVP (All access types)
	The AN-GW-Address AVP (AVP code 1050) is of type Address, and it contains the control plane Ipv4 and/ or Ipv6 (if
	available) address(es) of the access node gateway (SGW for 3GPP and AGW/ePDG for non-3GPP networks). 

	NOTE: If both Ipv4 and Ipv6 addresses are provided then two instances of this AVP are required in Diameter
	commands
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ANGW_ADDRESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "AN-GW-Address")
public interface ANGWAddress extends DiameterAddress
{
}