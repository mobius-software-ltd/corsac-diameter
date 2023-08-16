package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.3.  Protocol AVP

   The Protocol AVP (AVP Code 513) is of type Enumerated and specifies
   the protocol being matched.  The attributes included in the
   Classifier AVP MUST be consistent with the value of the Protocol AVP.
   Exactly zero or one Protocol AVP may be contained within a Classifier
   AVP.  If the Protocol AVP is omitted from the classifier, then
   comparison of the protocol of the packet is irrelevant.  The values
   for this AVP are managed by IANA under the Protocol Numbers registry
   as defined in [RFC2780].
 */
@DiameterAvpDefinition(code = 513L, vendorId = -1L, name = "Protocol")
public interface Protocol extends DiameterEnumerated<ProtocolEnum>
{
}