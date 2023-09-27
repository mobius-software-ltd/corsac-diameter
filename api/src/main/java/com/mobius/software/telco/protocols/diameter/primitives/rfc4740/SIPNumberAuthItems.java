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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	9.6.  SIP-Number-Auth-Items AVP

   	The SIP-Number-Auth-Items AVP (AVP Code 382) is of type Unsigned32
   	and indicates the number of authentication and/or authorization
   	credentials that the Diameter server included in a Diameter message.

   	When the AVP is present in a request, it indicates the number of
   	SIP-Auth-Data-Items the Diameter client is requesting.  This can be
   	used, for instance, when the SIP server is requesting several
   	pre-calculated authentication credentials.  In the answer message,
   	the SIP-Number-Auth-Items AVP indicates the actual number of items
   	that the Diameter server included.
 */
@DiameterAvpDefinition(code = 382L, vendorId = -1, name = "SIP-Number-Auth-Items")
public interface SIPNumberAuthItems extends DiameterUnsigned32
{
}