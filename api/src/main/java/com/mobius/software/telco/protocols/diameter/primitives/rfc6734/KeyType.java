package com.mobius.software.telco.protocols.diameter.primitives.rfc6734;
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
 * 3.1.1.  Key-Type AVP

   The Key-Type AVP (AVP Code 582) is of type Enumerated.  This AVP
   identifies the type of the key being sent.  The following decimal
   values are defined in this document:

   DSRK (0)
      A Domain-Specific Root Key [RFC5295].

   rRK (1)
      A re-authentication Root Key [RFC6696].

   rMSK (2)
      A re-authentication Master Session Key [RFC6696].

   If additional values are needed, they are to be assigned by IANA
   according to the policy stated in Section 5.2.
 */
@DiameterAvpDefinition(code = 582L, vendorId = -1L, must = false, name = "Key-Type")
public interface KeyType extends DiameterEnumerated<KeyTypeEnum>
{
}