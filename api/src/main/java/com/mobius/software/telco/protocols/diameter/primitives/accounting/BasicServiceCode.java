package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.29A	Basic-Service-Code AVP
	The Basic-Service-Code AVP (AVP code 3411) is of type Grouped and holds service information utilized by a voice call service. Either a Bearer-Service AVP or a Teleservice AVP is included.
	It has the following ABNF grammar:

	Basic-Service-Code:: =   < AVP Header: 3411 >
			[ Bearer-Service ]
			[ Teleservice ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.BASIC_SERVICE_CODE, vendorId = VendorIDs.TGPP_ID, name = "Basic-Service-Code")
public interface BasicServiceCode extends DiameterAvp
{
	ByteBuf getBearerService();
	
	void setBearerService(ByteBuf value);
	
	ByteBuf getTeleservice();
	
	void setTeleservice(ByteBuf value);
}