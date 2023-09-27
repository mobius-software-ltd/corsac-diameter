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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.6.  Mobile-Node-Identifier AVP

   The Mobile-Node-Identifier AVP (AVP Code 506) is of type UTF8String
   and contains the mobile node identifier (MN-Identifier; see
   [RFC5213]) in the NAI [RFC4282] format.  This AVP is used on the MAG-
   to-HAAA interface.  The Mobile-Node-Identifier AVP is designed for

   deployments where the MAG does not have a way to find out such MN
   identity that could be used in subsequent PBU/PBA exchanges (e.g.,
   due to identity hiding during the network access authentication) or
   the HAAA wants to assign periodically changing identities to the MN.

   The Mobile-Node-Identifier AVP is returned in the answer message that
   ends a successful authentication (and possibly an authorization)
   exchange between the MAG and the HAAA, assuming the HAAA is also able
   to provide the MAG with the MN-Identifier in the first place.  The
   MAG MUST use the received MN-Identifier, if it has not been able to
   get the mobile node identifier through other means.  If the MAG
   already has a valid mobile node identifier, then the MAG MUST
   silently discard the received MN-Identifier.
 */
@DiameterAvpDefinition(code = 506L, vendorId = -1L, name = "Mobile-Node-Identifier")
public interface MobileNodeIdentifier extends DiameterUTF8String
{
}