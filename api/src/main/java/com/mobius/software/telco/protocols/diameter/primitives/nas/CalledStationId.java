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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.2.5.  Called-Station-Id AVP

   The Called-Station-Id AVP (AVP Code 30) is of type UTF8String and
   contains a 7-bit US-ASCII string sent by the NAS to describe the
   Layer 2 address the user contacted in the request.  For dialup
   access, this can be a phone number obtained by using the Dialed
   Number Identification Service (DNIS) or a similar technology.  Note
   that this may be different from the phone number the call comes in
   on.  For use with IEEE 802 access, the Called-Station-Id MAY contain
   a Media Access Control (MAC) address formatted as described in
   [RFC3580].

   If the Called-Station-Id AVP is present in an AAR message, the Auth-
   Request-Type AVP is set to AUTHORIZE_ONLY, and the User-Name AVP is
   absent, the Diameter server MAY perform authorization based on this
   AVP.  This can be used by a NAS to request whether a call should be
   answered based on the DNIS result.

   Further codification of this field's allowed content and usage is
   outside the scope of this specification.
 */
@DiameterAvpDefinition(code = 30L, vendorId = -1L, name = "Called-Station-Id")
public interface CalledStationId extends DiameterUTF8String
{
}