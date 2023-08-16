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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	9.13.  MIP-MSA-Lifetime AVP

   	The MIP-MSA-Lifetime AVP (AVP Code 367) is of type Unsigned32 and
   	represents the period of time (in seconds) for which the session key
   	or nonce is valid.  The associated session key or nonce, as the case
   	may be, MUST NOT be used if the lifetime has expired; if the session
   	key or nonce lifetime expires while the session to which it applies
   	is still active, either the session key or nonce MUST be changed or
   	the association Mobile IPv4 session MUST be terminated.	   
 */
@DiameterAvpDefinition(code = 367L, vendorId = -1, name = "MIP-MSA-Lifetime")
public interface MIPMSALifetime extends DiameterUnsigned32
{
}