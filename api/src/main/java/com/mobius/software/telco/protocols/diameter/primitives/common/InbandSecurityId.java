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
 * 6.10.  Inband-Security-Id AVP

   The Inband-Security-Id AVP (AVP Code 299) is of type Unsigned32 and
   is used in order to advertise support of the security portion of the
   application.  The use of this AVP in CER and CEA messages is NOT
   RECOMMENDED.  Instead, discovery of a Diameter entity's security
   capabilities can be done either through static configuration or via
   Diameter Peer Discovery as described in Section 5.2.

   The following values are supported:


   NO_INBAND_SECURITY 0

      This peer does not support TLS/TCP and DTLS/SCTP.  This is the
      default value, if the AVP is omitted.

   TLS 1

      This node supports TLS/TCP [RFC5246] and DTLS/SCTP [RFC6083]
      security.
 */
@DiameterAvpDefinition(code = 299L, vendorId = -1L, name = "Inband-Security-Id")
public interface InbandSecurityId extends DiameterUnsigned32
{
		
}