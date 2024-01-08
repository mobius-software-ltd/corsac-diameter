package com.mobius.software.telco.protocols.diameter.primitives.common;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIdentity;

/**
*
* @author yulian oifa
*
*/

/*
 * 6.6.  Destination-Realm AVP

   The Destination-Realm AVP (AVP Code 283) is of type DiameterIdentity
   and contains the realm to which the message is to be routed.  The
   Destination-Realm AVP MUST NOT be present in answer messages.
   Diameter clients insert the realm portion of the User-Name AVP.
   Diameter servers initiating a request message use the value of the
   Origin-Realm AVP from a previous message received from the intended
   target host (unless it is known a priori).  When present, the
   Destination-Realm AVP is used to perform message routing decisions.

   The CCF for a request message that includes the Destination-Realm AVP
   SHOULD list the Destination-Realm AVP as a required AVP (an AVP
   indicated as {AVP}); otherwise, the message is inherently a non-
   routable message.
   
   This AVP SHOULD be placed as close to the Diameter header as
   possible.
 */
@DiameterAvpDefinition(code = 283L, vendorId = -1L, name = "Destination-Realm")
public interface DestinationRealm extends DiameterIdentity
{
}