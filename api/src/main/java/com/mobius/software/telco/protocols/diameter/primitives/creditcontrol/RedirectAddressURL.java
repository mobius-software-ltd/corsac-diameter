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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.66.  Redirect-Address-URL AVP

   The Redirect-Address-URL AVP (AVP Code 667) is of type UTF8String and
   defines the address of the redirect server with which the end user is
   to be connected when the account cannot cover the service cost.  The
   address type is in the form of a Uniform Resource Locator, as defined
   in [RFC3986].  Note that individual URL schemes may restrict the
   contents of the UTF8String.
 */
@DiameterAvpDefinition(code = AvpCodes.REDIRECT_ADDRESS_URL, vendorId = -1L, must = false, name = "Redirect-Address-URL")
public interface RedirectAddressURL extends DiameterUTF8String
{
}