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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 9.3.1.  NAS-Identifier AVP

   The NAS-Identifier AVP (AVP Code 32) [RADIUS] is of type UTF8String
   and contains the identity of the NAS providing service to the user.
   This AVP SHOULD only be added by a RADIUS/Diameter Translation Agent.
   When this AVP is present, the Origin-Host AVP identifies the NAS
   providing service to the user.
   In RADIUS it would be possible for a rogue NAS to forge the NAS-
   Identifier attribute.  Diameter/RADIUS translation agents SHOULD
   attempt to check a received NAS-Identifier attribute against the
   source address of the RADIUS packet, by doing an A/AAAA RR query.  If
   the NAS-Identifier attribute contains an FQDN, then such a query
   would resolve to an IP address matching the source address.  However,
   the NAS-Identifier attribute is not required to contain an FQDN, so
   such a query could fail.  If it fails, an error should be logged, but
   no action should be taken, other than a reverse lookup on the source
   address and insert the resulting FQDN into the Route-Record AVP.

   Diameter agents and servers SHOULD check whether a NAS-Identifier AVP
   corresponds to an entry in the Route-Record AVP.  If no match is
   found, then an error is logged, but no other action is taken.
 */
@DiameterAvpDefinition(code = AvpCodes.NAS_IDENTIFIER, vendorId = -1L, name = "NAS-Identifier")
public interface NASIdentifier extends DiameterUTF8String
{
}