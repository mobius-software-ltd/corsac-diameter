package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.76	Code-Sending-Security-Material 
	The Code-Sending-Security-Material AVP is of type Grouped. It shall contain security parameters used to indicate to a UE how to protect the transmission of restricted ProSe direct discovery message. The Code Sending Security Material may contain a DUSK and may contain a DUIK. It may also contain both a DUCK and a corresponding Encrypted Bitmask.
	The AVP format shall conform to:
		
	Code-Sending-Security-Material ::=		<AVP header: 3861 10415>
		 [ DUSK ]
		 [ DUIK ]
		 [ DUCK ]
		 [ Encrypted-Bitmask ]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CODE_SENDING_SECURITY_MATERIAL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Code-Sending-Security-Material")
public interface CodeSendingSecurityMaterial extends DiameterGroupedAvp
{
	ByteBuf getDUSK();
	
	void setDUSK(ByteBuf value);
	
	ByteBuf getDUIK();
	
	void setDUIK(ByteBuf value);
	
	ByteBuf getDUCK();
	
	void setDUCK(ByteBuf value);
	
	ByteBuf getEncryptedBitmask();
	
	void setEncryptedBitmask(ByteBuf value);
}