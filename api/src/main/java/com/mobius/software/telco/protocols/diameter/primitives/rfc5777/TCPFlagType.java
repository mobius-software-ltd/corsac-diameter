package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	4.1.8.10.  TCP-Flag-Type AVP

   	The TCP-Flag-Type AVP (AVP Code 544) is of type Unsigned32 and
   	specifies the TCP control flag types that must be matched.  The first
   	16 bits match the TCP header format defined in [RFC3168], and the
   	subsequent 16 bits are unused.  Within the first 16 bits, bits 0 to 3
   	are unused and bits 4 to 15 are managed by IANA under the TCP Header
   	Flag registry as defined in [RFC3168].
 */
@DiameterAvpDefinition(code = AvpCodes.TCP_FLAG_TYPE, vendorId = -1L, name = "TCP-Flag-Type")
public interface TCPFlagType extends DiameterUnsigned32
{
}