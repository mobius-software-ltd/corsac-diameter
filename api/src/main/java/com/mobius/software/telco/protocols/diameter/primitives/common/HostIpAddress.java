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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

/**
*
* @author yulian oifa
*
*/
/*
 * 5.3.5.  Host-IP-Address AVP

   The Host-IP-Address AVP (AVP Code 257) is of type Address and is used
   to inform a Diameter peer of the sender's IP address.  All source
   addresses that a Diameter node expects to use with SCTP [RFC4960] or
   DTLS/SCTP [RFC6083] MUST be advertised in the CER and CEA messages by
   including a Host-IP-Address AVP for each address.
 */
@DiameterAvpDefinition(code = 257, vendorId = -1L, name = "Host-IP-Address")
public interface HostIpAddress extends DiameterAddress
{
		
}