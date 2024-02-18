package com.mobius.software.telco.protocols.diameter.primitives.rfc5778;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

/**
*
* @author yulian oifa
*
*/

/*
	6.7.  MIP-Careof-Address AVP

   The MIP-Careof-Address AVP (AVP Code 487) is of type Address and
   contains the IPv6 or the IPv4 care-of address of the mobile node.
   The HA extracts this IP address from the received BU message.h.
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_CAREOF_ADDRESS, vendorId = -1L, name = "MIP-Careof-Address")
public interface MIPCareofAddress extends DiameterAddress
{
}