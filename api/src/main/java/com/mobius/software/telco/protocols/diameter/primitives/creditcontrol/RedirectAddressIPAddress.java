package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
 * 8.65.  Redirect-Address-IPAddress AVP

   The Redirect-Address-IPAddress AVP (AVP Code 666) is of type Address
   and defines the IPv4 or IPv6 address of the redirect server with
   which the end user is to be connected when the account cannot cover
   the service cost.

   When encoded as an IPv6 address in 16 bytes, the IPv4-mapped IPv6
   format [RFC4291] MAY be used to indicate an IPv4 address.

   The interpretation of Redirect-Address-IPAddress by the Diameter
   Credit-Control client is a matter of local policy.
 */
@DiameterAvpDefinition(code = AvpCodes.REDIRECT_ADDRESS_IP_ADDRESS, vendorId = -1L, must = false, name = "Redirect-Address-IP-Address")
public interface RedirectAddressIPAddress extends DiameterAddress
{
}