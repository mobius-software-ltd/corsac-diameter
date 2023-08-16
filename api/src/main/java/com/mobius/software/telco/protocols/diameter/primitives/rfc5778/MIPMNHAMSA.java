package com.mobius.software.telco.protocols.diameter.primitives.rfc5778;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPReplayModeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 6.12.  MIP-MN-HA-MSA AVP

   The MIP-MN-HA-MSA AVP (AVP Code 492) is of type Grouped and contains
   the session-related information for use with the Mobile IPv6
   Authentication Protocol.

   MIP-MN-HA-MSA ::= < AVP Header: 492 >
                     { MIP-Session-Key }
                     { MIP-MSA-Lifetime }
                     [ MIP-MN-HA-SPI ]
                     [ MIP-Algorithm-Type ]
                     [ MIP-Replay-Mode ]
                   * [ AVP ]

   The MIP-MN-HA-SPI sub-AVP within the MIP-MN-HA-MSA grouped AVP
   identifies the security association required for the validation of
   the Mobile IPv6 MN-HA Authentication Option.  The absence of the MIP-
   Replay-Mode AVP MUST be treated as no replay protection was selected.
 */
@DiameterAvpDefinition(code = 492L, vendorId = -1L, name = "MIP-MN-HA-MSA")
public interface MIPMNHAMSA extends DiameterGroupedAvp
{
	ByteBuf getMIPSessionKey();
	
	void setMIPSessionKey(ByteBuf value);
			
	Long getMIPMSALifetime();
	
	void setMIPMSALifetime(Long value);
	
	Long getMIPMNHASPI();
	
	void setMIPMNHASPI(Long value);	
	
	MIPAlgorithmTypeEnum getMIPAlgorithmType();
	
	void setMIPAlgorithmType(MIPAlgorithmTypeEnum value);	
	
	MIPReplayModeEnum getMIPReplayMode();
	
	void setMIPReplayMode(MIPReplayModeEnum value);			
}