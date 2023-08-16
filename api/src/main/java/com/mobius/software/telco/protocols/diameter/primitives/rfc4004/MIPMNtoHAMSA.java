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
 * 9.6.  MIP-MN-to-HA-MSA AVP

   The MIP-MN-to-HA-MSA AVP (AVP Code 331) is of type Grouped and
   contains the MN-HA session nonce, which the mobile node uses to
   derive the MN-HA session key.  This AVP is conveyed to the HA in an
   HAR message for FA COA Mobile IPv4 and in an AMR for collocated
   Mobile IPv4.  The HA allocates the MIP-MN-to-HA-SPI.  The MN creates
   the MN-FA authentication extension using the session key and
   algorithm, and the HA verifies that extension using the same session
   key and algorithm.

   The Home Agent uses this AVP in the construction of the Mobile IP
   "Generalized MN-HA Key Generation Nonce Reply" extension [MIPKEYS].

         MIP-MN-to-HA-MSA ::= < AVP Header: 331 >
                              { MIP-MN-HA-SPI }
                              { MIP-Algorithm-Type }
                              { MIP-Replay-Mode }
                              { MIP-nonce }
                            * [ AVP ]
 */
@DiameterAvpDefinition(code = 331L, vendorId = -1L, name = "MIP-MN-to-HA-MSA")
public interface MIPMNtoHAMSA extends DiameterGroupedAvp
{
	Long getMIPMNHASPI();
	
	void setMIPMNHASPI(Long value);	
	
	MIPAlgorithmTypeEnum getMIPAlgorithmType();
	
	void setMIPAlgorithmType(MIPAlgorithmTypeEnum value);	
	
	MIPReplayModeEnum getMIPReplayMode();
	
	void setMIPReplayMode(MIPReplayModeEnum value);	
	
	ByteBuf getMIPNonce();
	
	void setMIPNonce(ByteBuf value);
}