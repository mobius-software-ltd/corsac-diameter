package com.mobius.software.telco.protocols.diameter.primitives.nas;
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

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.11.1.  Login-IP-Host AVP

   The Login-IP-Host AVP (AVP Code 14) [RFC2865] is of type OctetString
   and contains the IPv4 address of a host with which to connect the
   user when the Login-Service AVP is included.  It MAY be used in an
   
   AA-Request command as a hint to the Diameter server that a specific
   host is desired, but the Diameter server is not required to honor the
   hint in the AA-Answer.

   Two addresses have special significance: all ones and 0.  The value
   of all ones indicates that the NAS SHOULD allow the user to select an
   address.  The value 0 indicates that the NAS SHOULD select a host to
   connect the user to.
 */
@DiameterAvpDefinition(code = 14L, vendorId = -1L, name = "Login-IP-Host")
public interface LoginIPHost extends DiameterIpv4Address
{
}