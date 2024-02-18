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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 9.2.  MIP-FA-to-HA-MSA AVP

   The MIP-FA-to-HA-MSA AVP (AVP Code 328) is of type Grouped and
   contains the FA-HA session key.  This AVP is conveyed to the FA in an
   AMA message.  The HA allocates the MIP-FA-to-HA-SPI.  The FA creates
   the FA-HA authentication extension by using the session key and
   algorithm, and the HA verifies that extension by using the same key
   and algorithm.  The AVP's data field has the following ABNF grammar:

         MIP-FA-to-HA-MSA ::= < AVP Header: 328 >
                              { MIP-FA-to-HA-SPI }
                              { MIP-Algorithm-Type }
                              { MIP-Session-Key }
                            * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_FA_TO_HA_MSA, vendorId = -1L, name = "MIP-FA-to-HA-MSA")
public interface MIPFAtoHAMSA extends DiameterGroupedAvp
{
	Long getMIPFAtoHASPI();
	
	void setMIPFAtoHASPI(Long value) throws MissingAvpException;	
	
	MIPAlgorithmTypeEnum getMIPAlgorithmType();
	
	void setMIPAlgorithmType(MIPAlgorithmTypeEnum value) throws MissingAvpException;	
	
	ByteBuf getMIPSessionKey();
	
	void setMIPSessionKey(ByteBuf value) throws MissingAvpException;
}