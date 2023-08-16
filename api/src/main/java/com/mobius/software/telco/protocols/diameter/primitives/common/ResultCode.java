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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 7.1.  Result-Code AVP

   The Result-Code AVP (AVP Code 268) is of type Unsigned32 and
   indicates whether a particular request was completed successfully or
   an error occurred.  All Diameter answer messages in IETF-defined
   Diameter application specifications MUST include one Result-Code AVP.
   A non-successful Result-Code AVP (one containing a non-2xxx value
   other than DIAMETER_REDIRECT_INDICATION) MUST include the Error-
   Reporting-Host AVP if the host setting the Result-Code AVP is
   different from the identity encoded in the Origin-Host AVP.

   The Result-Code data field contains an IANA-managed 32-bit address
   space representing errors (see Section 11.3.2).  Diameter provides
   the following classes of errors, all identified by the thousands
   digit in the decimal notation:
   
   o  1xxx (Informational)

   o  2xxx (Success)

   o  3xxx (Protocol Errors)

   o  4xxx (Transient Failures)

   o  5xxx (Permanent Failure)

   An unrecognized class (one whose first digit is not defined in this
   section) MUST be handled as a permanent failure.
 */
@DiameterAvpDefinition(code = 268L, position = 2, vendorId = -1L, name = "Result-Code")
public interface ResultCode extends DiameterUnsigned32
{
}