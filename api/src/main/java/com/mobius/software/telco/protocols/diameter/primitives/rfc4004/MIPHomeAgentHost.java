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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 7.11.  MIP-Home-Agent-Host AVP

   The MIP-Home-Agent-Host AVP (AVP Code 348) is of type Grouped and
   contains the identity of the assigned Home Agent.  If the MIP-Home-
   Agent-Host AVP is present in the AMR, the AAAH MUST copy it into the
   HAR.

         MIP-Home-Agent-Host ::= < AVP Header: 348 >
                                  { Destination-Realm }
                                  { Destination-Host }
                                * [ AVP ]
 */
@DiameterAvpDefinition(code = 348L, vendorId = -1L, name = "MIP-Home-Agent-Host")
public interface MIPHomeAgentHost extends DiameterGroupedAvp
{
	String getDestinationHost();
	
	void setDestinationHost(String value);	
	
	String getDestinationRealm();
	
	void setDestinationRealm(String value);		
}