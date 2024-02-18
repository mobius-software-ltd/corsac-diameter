package com.mobius.software.telco.protocols.diameter.primitives.rfc4004;
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
	9.12.  MIP-Nonce AVP

   	The MIP-Nonce AVP (AVP Code 335) is of type OctetString and contains
   	the nonce sent to the mobile node for the associated authentication
   	extension.  The mobile node follows the procedures in [MIPKEYS] to
   	generate the session key used to authenticate Mobile IPv4
   	registration messages.  The HAAA selects the nonce.
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_NONCE, vendorId = -1L, name = "MIP-Nonce")
public interface MIPNonce extends DiameterOctetString
{
}