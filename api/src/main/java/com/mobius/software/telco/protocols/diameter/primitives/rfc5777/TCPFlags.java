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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.8.9.  TCP-Flags AVP

   The TCP-Flags AVP (AVP Code 543) is of type Grouped and specifies a
   set of TCP control flags that must be matched.

   TCP-Flags ::= < AVP Header: 543 >
                 { TCP-Flag-Type }
                 [ Negated ]
               * [ AVP ]

   If the Negated AVP is not present or present but set to False, the
   TCP-Flag-Type AVP specifies which flags MUST be set.  If the Negated
   AVP is set to True, the TCP-Flag-Type AVP specifies which flags MUST
   be cleared.
 */
@DiameterAvpDefinition(code = AvpCodes.TCP_FLAGS, vendorId = -1L, name = "TCP-Flags")
public interface TCPFlags extends DiameterGroupedAvp
{
	Long getTCPFlagType();
	
	void setTCPFlagType(Long value) throws MissingAvpException;	
	
	NegatedEnum getNegated();
	
	void setNegated(NegatedEnum value);			
}