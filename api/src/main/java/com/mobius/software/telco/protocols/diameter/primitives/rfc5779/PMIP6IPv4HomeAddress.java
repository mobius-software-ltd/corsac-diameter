package com.mobius.software.telco.protocols.diameter.primitives.rfc5779;
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
 * 5.2.  PMIP6-IPv4-Home-Address AVP

   The PMIP6-IPv4-Home-Address AVP (AVP Code 505) is of type Address and
   contains an IPv4 address.  This AVP is used to carry the IPv4-MN-HoA,
   if available, from the HAAA to the MAG.  This AVP SHOULD only be
   present when the MN is statically provisioned with the IPv4-MN-HoA.
   Note that proactive dynamic assignment of the IPv4-MN-HoA by the HAAA
   may result in unnecessary reservation of IPv4 address resources,
   because the MN may considerably delay or completely bypass its IPv4
   address configuration.

   The PMIP6-IPv4-Home-Address AVP is also used on the LMA-to-HAAA
   interface.  The AVP contains the IPv4-MN-HoA assigned to the MN.  If
   the LMA delegates the assignment of the IPv4-MN-HoA to the HAAA, the
   AVP MUST contain all zeroes IPv4 address (i.e., 0.0.0.0) in the
   request message.  If the LMA delegated the IPv4-MN-HoA assignment to
   the HAAA, then the AVP contains the HAAA assigned IPv4-MN-HoA in the
   response message.
 */
@DiameterAvpDefinition(code = AvpCodes.PMIP6_IPV4_HOME_ADDRESS, vendorId = -1L, name = "PMIP6-IPv4-Home-Address")
public interface PMIP6IPv4HomeAddress extends DiameterAddress
{
}