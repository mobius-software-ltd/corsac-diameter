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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAsciiString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.2.3.  NAS-Port-Id AVP

   The NAS-Port-Id AVP (AVP Code 87) is of type UTF8String and consists
   of 7-bit US-ASCII text identifying the port of the NAS authenticating
   the user.  Note that "port" is meant in its sense as a service
   connection on the NAS, not as an IP protocol identifier.

   Either the NAS-Port-Id AVP or the NAS-Port AVP (Section 4.2.2) SHOULD
   be present in the AA-Request (AAR, Section 3.1) command if the NAS
   differentiates among its ports.  NAS-Port-Id is intended for use by
   NASes that cannot conveniently number their ports.
 */
@DiameterAvpDefinition(code = AvpCodes.NAS_PORT_ID, vendorId = -1L, name = "NAS-Port-Id")
public interface NASPortId extends DiameterAsciiString
{
}