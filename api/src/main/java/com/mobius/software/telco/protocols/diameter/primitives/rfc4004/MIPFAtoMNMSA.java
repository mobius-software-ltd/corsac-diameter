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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 9.1.  MIP-FA-to-MN-MSA AVP

   The MIP-FA-to-MN-MSA AVP (AVP Code 326) is of type Grouped and
   contains the FA-MN session key.  This AVP is conveyed to the FA in an
   AMA message.  The MN allocates the MIP-FA-to-MN-SPI.  The FA creates
   an FA-MN authentication extension by using the session key and
   algorithm, and the MN verifies that extension by using the same
   session key and algorithm.  The data field of this AVP has the
   following ABNF grammar:

         MIP-FA-to-MN-MSA ::= < AVP Header: 326 >
                              { MIP-FA-to-MN-SPI }
                              { MIP-Algorithm-Type }
                              { MIP-Session-Key }
                            * [ AVP ]
 */
@DiameterAvpDefinition(code = 326L, vendorId = -1L, name = "MIP-FA-to-MN-MSA")
public interface MIPFAtoMNMSA extends DiameterGroupedAvp
{
	Long getMIPFAtoMNSPI();
	
	void setMIPFAtoMNSPI(Long value);	
	
	MIPAlgorithmTypeEnum getMIPAlgorithmType();
	
	void setMIPAlgorithmType(MIPAlgorithmTypeEnum value);	
	
	ByteBuf getMIPSessionKey();
	
	void setMIPSessionKey(ByteBuf value);
}