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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.2.8.  Originating-Line-Info AVP

   The Originating-Line-Info AVP (AVP Code 94) is of type OctetString
   and is sent by the NAS system to convey information about the origin
   of the call from a Signaling System 7 (SS7).

   The Originating Line Information (OLI) element indicates the nature
   and/or characteristics of the line from which a call originated
   (e.g., pay phone, hotel phone, cellular phone).  Telephone companies
   are starting to offer OLI to their customers as an option over
   Primary Rate Interface (PRI).  Internet Service Providers (ISPs) can
   use OLI in addition to Called-Station-Id and Calling-Station-Id
   attributes to differentiate customer calls and to define different
   services.

   The Value field contains two octets (00 - 99).  ANSI T1.113 and
   BELLCORE 394 can be used for additional information about these
   values and their use.  For information on the currently assigned
   values, see [ANITypes].
 */
@DiameterAvpDefinition(code = 94L, vendorId = -1L, name = "Originating-Line-Info")
public interface OriginatingLineInfo extends DiameterOctetString
{
}