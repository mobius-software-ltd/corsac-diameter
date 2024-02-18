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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.61	App-Identifier 
	The App-Identifier AVP is of type Grouped. It shall contain an OS ID and OS Application ID name.
	The AVP format shall conform to:
		
	App-Identifier ::=		<AVP header: 3840 10415>
		 { OS-ID }
		 { OS-App-ID }
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.APP_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, must = false, name = "App-Identifier")
public interface AppIdentifier extends DiameterGroupedAvp
{
	ByteBuf getOSID();
	
	void setOSID(ByteBuf value) throws MissingAvpException;
	
	String getOSAppID();
	
	void setOSAppID(String value) throws MissingAvpException;
}