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
 * 	6.3.75	Code-Receiving-Security-Material 
	The Code-Receiving-Security-Material AVP is of type Grouped. It shall contain security parameters used to indicate to a UE how a received restricted ProSe direct discovery message is protected. The Code Receiving Security Material may contain a DUSK and may contain either a DUIK or an indication whether to use Match Reports for MIC checking. It may also contain both a DUCK and a corresponding Encrypted Bitmask.
	The AVP format shall conform to:
		
	Code-Receiving-Security-Material ::=		<AVP header: 3860 10415>
		 [ DUSK ]
		 [ DUIK ]
		 [ MIC-Check-Indicator ]
		 [ DUCK ]
		 [ Encrypted-Bitmask ]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CODE_RECEIVING_SECURITY_MATERIAL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Code-Receiving-Security-Material")
public interface CodeReceivingSecurityMaterial extends DiameterGroupedAvp
{
	ByteBuf getDUSK();
	
	void setDUSK(ByteBuf value);
	
	ByteBuf getDUIK();
	
	void setDUIK(ByteBuf value);
	
	MICCheckIndicatorEnum getMICCheckIndicator();
	
	void setMICCheckIndicator(MICCheckIndicatorEnum value);
	
	ByteBuf getDUCK();
	
	void setDUCK(ByteBuf value);
	
	ByteBuf getEncryptedBitmask();
	
	void setEncryptedBitmask(ByteBuf value);
}