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
 * 6.8.  MIP-Authenticator AVP

   The MIP-Authenticator AVP (AVP Code 488) is of type OctetString and
   contains the Authenticator Data from the received BU message.  The HA
   extracts this data from the MN-AAA Mobility Message Authentication
   Option included in the received BU message.

   When the MIP6-Auth-Mode AVP is set to value MIP6_AUTH_MN_AAA, this
   AVP MUST be present in the MIR message.
 */
@DiameterAvpDefinition(code = 488L, vendorId = -1L, name = "MIP-Authenticator")
public interface MIPAuthenticator extends DiameterOctetString
{
}