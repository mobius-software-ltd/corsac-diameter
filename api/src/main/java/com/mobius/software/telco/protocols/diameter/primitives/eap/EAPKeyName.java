package com.mobius.software.telco.protocols.diameter.primitives.eap;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.1.4.  EAP-Key-Name AVP

   The EAP-Key-Name AVP (Radius Attribute Type 102) is of type
   OctetString.  It contains an opaque key identifier (name) generated
   by the EAP method.  Exactly how this name is used depends on the link
   layer in question, and is beyond the scope of this document (see
   [EAPKey] for more discussion).

   Note that not all link layers use this name, and currently most EAP
   methods do not generate it.  Since the NAS operates in pass-through
   mode, it cannot know the Key-Name before receiving it from the AAA
   server.  As a result, a Key-Name AVP sent in a Diameter-EAP-Request
   MUST NOT contain any data.  A home Diameter server receiving a
   Diameter-EAP-Request with a Key-Name AVP with non-empty data MUST
   silently discard the AVP.  In addition, the home Diameter server
   SHOULD include this AVP in Diameter-EAP-Response only if an empty
   EAP-Key-Name AVP was present in Diameter-EAP-Request.
 */
@DiameterAvpDefinition(code = 102L, vendorId = -1L, name = "EAP-Key-Name")
public interface EAPKeyName extends DiameterOctetString
{
}