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
 * 9.5.  MIP-MN-to-FA-MSA AVP

   The MIP-MN-to-FA-MSA AVP (AVP Code 325) is of type Grouped, and
   contains the MN-FA session nonce, which the mobile node uses to
   derive the MN-FA session key.  This AVP is conveyed to the HA in an
   HAR message.  The FA allocates the MIP-MN-to-FA-SPI.  The MN creates
   the MN-FA authentication extension by using the session key and
   algorithm, and the FA verifies that extension using the same key and
   algorithm.

   The home agent uses this AVP in the construction of the Mobile IP
   "Generalized MN-FA Key Generation Nonce Reply" extension [MIPKEYS].

         MIP-MN-to-FA-MSA ::= < AVP Header: 325 >
                              { MIP-MN-FA-SPI }
                              { MIP-Algorithm-Type }
                              { MIP-nonce }
                            * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_MN_TO_FA_SPI, vendorId = -1L, name = "MIP-MN-to-FA-MSA")
public interface MIPMNtoFAMSA extends DiameterGroupedAvp
{
	Long getMIPMNFASPI();
	
	void setMIPMNFASPI(Long value) throws MissingAvpException;	
	
	MIPAlgorithmTypeEnum getMIPAlgorithmType();
	
	void setMIPAlgorithmType(MIPAlgorithmTypeEnum value) throws MissingAvpException;	
	
	ByteBuf getMIPNonce();
	
	void setMIPNonce(ByteBuf value) throws MissingAvpException;
}