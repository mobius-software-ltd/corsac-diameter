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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.3.9.  ARAP-Password AVP

   The ARAP-Password AVP (AVP Code 70) is of type OctetString and is
   only present when the Framed-Protocol AVP (Section 4.4.10.1) is
   included in the message and is set to ARAP.  This AVP MUST NOT be
   present if either the User-Password or the CHAP-Auth AVP is present.
   See [RFC2869] for more information on the contents of this AVP.
 */
@DiameterAvpDefinition(code = AvpCodes.ARAP_PASSWORD, vendorId = -1L, name = "ARAP-Password")
public interface ARAPPassword extends DiameterOctetString
{
}