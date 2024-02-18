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
	9.9.  SIP-Visited-Network-Id AVP

   	The SIP-Visited-Network-Id AVP (AVP Code 386) is of type UTF8String.
   	This AVP contains an identifier that helps the home network identify
   	the visited network (e.g., the visited network domain name), in order
   	to authorize roaming to that visited network.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_VISITED_NETWORK_ID, vendorId = -1, name = "SIP-Visited-Network-Id")
public interface SIPVisitedNetworkId extends DiameterUTF8String
{
}