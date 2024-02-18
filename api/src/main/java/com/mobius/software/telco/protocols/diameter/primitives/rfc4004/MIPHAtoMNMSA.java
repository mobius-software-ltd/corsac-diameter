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
 * 9.4.  MIP-HA-to-MN-MSA AVP

   The MIP-HA-to-MN-MSA AVP (AVP Code 332) is of type Grouped, and
   contains the HA-MN session key.  This AVP is conveyed to the HA in an
   HAR for FA COA Mobile IPv4 and in an AMA for collocated COA Mobile
   IPv4.  The MN allocates the MIP-HA-to-MN-SPI.  The HA creates the
   HA-MN authentication extension by using the session key and
   algorithm, and the MN verifies that extension by using the same key
   and algorithm.  The AVP's field has the following ABNF grammar:

         MIP-HA-to-MN-MSA ::= < AVP Header: 332 >
                              { MIP-HA-to-MN-SPI   }
                              { MIP-Algorithm-Type }
                              { MIP-Replay-Mode }
                              { MIP-Session-Key }
                            * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_HA_TO_MN_MSA, vendorId = -1L, name = "MIP-HA-to-MN-MSA")
public interface MIPHAtoMNMSA extends DiameterGroupedAvp
{
	Long getMIPHAtoMNSPI();
	
	void setMIPHAtoMNSPI(Long value) throws MissingAvpException;	
	
	MIPAlgorithmTypeEnum getMIPAlgorithmType();
	
	void setMIPAlgorithmType(MIPAlgorithmTypeEnum value) throws MissingAvpException;	
	
	MIPReplayModeEnum getMIPReplayMode();
	
	void setMIPReplayMode(MIPReplayModeEnum value) throws MissingAvpException;	
	
	ByteBuf getMIPSessionKey();
	
	void setMIPSessionKey(ByteBuf value) throws MissingAvpException;
}