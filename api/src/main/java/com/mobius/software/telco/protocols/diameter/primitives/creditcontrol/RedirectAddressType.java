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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.38.  Redirect-Address-Type AVP

   The Redirect-Address-Type AVP (AVP Code 433) is of type Enumerated
   and defines the address type of the address given in the Redirect-
   Server-Address AVP.

   Redirect-Address-Type can be set to one of the following values:

   IPv4 Address   0

   The address type is in the form of a "dotted-decimal" IPv4 address,
   as defined in [RFC791].

   IPv6 Address   1

   The address type is in the form of an IPv6 address, as defined in
   [RFC4291].  The address MUST conform to the textual representation of
   the address according to [RFC5952].

   Because [RFC5952] is more restrictive than the "RFC 3513" format
   required by [RFC4006], some legacy implementations may not be
   compliant with the new requirements.  Accordingly, implementations
   receiving this AVP MAY be liberal in the textual IPv6 representations
   that are accepted, without raising an error.

   URL            2

   The address type is in the form of a Uniform Resource Locator, as
   defined in [RFC3986].

   SIP URI        3

   The address type is in the form of a SIP Uniform Resource Identifier,
   as defined in [RFC3261].
 */
@DiameterAvpDefinition(code = 433L, vendorId = -1L, name = "Redirect-Address-Type")
public interface RedirectAddressType extends DiameterEnumerated<RedirectAddressTypeEnum>
{
}