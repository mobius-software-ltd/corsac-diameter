package com.mobius.software.telco.protocols.diameter.primitives.rfc5778;
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
 * 	6.16.  MIP-Timestamp AVP

   	The MIP-Timestamp AVP (AVP Code 490) is of type OctetString and
   	contains an 8-octet timestamp value (i.e., 64-bit timestamp) from the
   	Mobility message replay protection option, defined in [RFC4285].  The
   	HA extracts this value from the received BU message, if available.
   	The HA includes this AVP in the MIR message when the MN-AAA Mobility
   	Message Authentication Option is available in the received BU and the
   	Diameter server is expected to return the key material required for
   	the calculation and validation of the Mobile IPv6 MN-HA
   	Authentication Option (and the MIP6-Auth-Mode AVP is set to value
   	MIP6_AUTH_MN_AAA).
 */
@DiameterAvpDefinition(code = 490L, vendorId = -1L, name = "MIP-Timestamp")
public interface MIPTimestamp extends DiameterOctetString
{
}