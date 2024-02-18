package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;
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
	9.14.  SIP-Method AVP

   	The SIP-Method-AVP (AVP Code 393) is of type UTF8String and contains
   	the method of the SIP request that triggered the Diameter message.
   	The Diameter server MUST use this AVP solely for authorization of SIP
   	requests, and MUST NOT use it to compute the Digest authentication.
   	To compute the Digest authentication, the Diameter server MUST use
   	the Digest-Method AVP instead.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_METHOD, vendorId = -1, name = "SIP-Method")
public interface SIPMethod extends DiameterUTF8String
{
}