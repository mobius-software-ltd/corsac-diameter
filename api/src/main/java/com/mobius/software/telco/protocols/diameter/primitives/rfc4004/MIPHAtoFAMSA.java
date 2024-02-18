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
 * 9.3.  MIP-HA-to-FA-MSA AVP

   The MIP-HA-to-FA-MSA AVP (AVP Code 329) is of type Grouped and
   contains the Home Agent's session key, which it shares with the
   foreign agent.  This AVP is conveyed to the HA in an HAR message.
   The FA allocates the MIP-HA-to-FA-SPI.  The HA creates the HA-FA
   authentication extension by using the session key and algorithm, and
   the FA verifies that extension by using the same session key and
   algorithm.  The AVP's data field has the following ABNF grammar:

         MIP-HA-to-FA-MSA ::= < AVP Header: 329 >
                              { MIP-HA-to-FA-SPI   }
                              { MIP-Algorithm-Type }
                              { MIP-Session-Key }
                            * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_HA_TO_FA_MSA, vendorId = -1L, name = "MIP-HA-to-FA-MSA")
public interface MIPHAtoFAMSA extends DiameterGroupedAvp
{
	Long getMIPHAtoFASPI();
	
	void setMIPHAtoFASPI(Long value) throws MissingAvpException;	
	
	MIPAlgorithmTypeEnum getMIPAlgorithmType();
	
	void setMIPAlgorithmType(MIPAlgorithmTypeEnum value) throws MissingAvpException;	
	
	ByteBuf getMIPSessionKey();
	
	void setMIPSessionKey(ByteBuf value) throws MissingAvpException;
}