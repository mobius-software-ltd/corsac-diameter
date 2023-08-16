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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.3.4.  CHAP-Auth AVP

   The CHAP-Auth AVP (AVP Code 402) is of type Grouped and contains the
   information necessary to authenticate a user using the PPP Challenge-
   Handshake Authentication Protocol (CHAP) [RFC1994].  If the CHAP-Auth
   AVP is found in a message, the CHAP-Challenge AVP (Section 4.3.8)
   MUST be present as well.  The optional AVPs containing the CHAP
   response depend upon the value of the CHAP-Algorithm AVP
   (Section 4.3.8).  The grouped AVP has the following ABNF [RFC5234]
   grammar:
   
   CHAP-Auth  ::= < AVP Header: 402 >
                  { CHAP-Algorithm }
                  { CHAP-Ident }
                  [ CHAP-Response ]
                * [ AVP ]
 */
@DiameterAvpDefinition(code = 402L, vendorId = -1L, name = "CHAP-Auth")
public interface CHAPAuth extends DiameterGroupedAvp
{
	ByteBuf getCHAPAlgorithm();
	
	void setCHAPAlgorithm(ByteBuf value);
	
	ByteBuf getCHAPIdent();
	
	void setCHAPIdent(ByteBuf value);	
	
	ByteBuf getCHAPResponse();
	
	void setCHAPResponse(ByteBuf value);	
}