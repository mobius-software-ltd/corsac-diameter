package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.96	MO-LR
	The MO-LR AVP is of type Grouped. This AVP shall contain the classes of MO-LR for which a subscription exists for a particular UE.
	AVP format
	
	MO-LR ::= <AVP header: 1485 10415>
			 { SS-Code }
			 { SS-Status }
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MO_LR, vendorId = VendorIDs.TGPP_ID, name = "MO-LR")
public interface MOLR extends DiameterGroupedAvp
{
	ByteBuf getSSCode();
	
	void setSSCode(ByteBuf value) throws MissingAvpException;	
	
	ByteBuf getSSStatus();
	
	void setSSStatus(ByteBuf value) throws MissingAvpException;
}