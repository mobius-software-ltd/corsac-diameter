package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 *	5.3.75	Wireline-User-Location-Info AVP
	The Wireline-User-Location-Info AVP (AVP code 578) is of type Grouped and contains either wireline Cable or wireline BBF user location information.
	The HFC-Node-Identifier AVP indicates wireline cable location and contains an HFC Node Identifer.  
	The GLI-Identifier AVP indicates wireline BBF location and contains a Global Line Identifier. The Line-Type AVP indicates the type of line included in the GLI-Identifier AVP. 
	AVP Format:
	
		Wireline-User-Location-Info ::= < AVP Header: 578 >
					  [ HFC-Node-Identifier ]
					  [ GLI-Identifier ]
					  [ Line-Type ]
					 *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.WIRELINE_USER_LOCATION_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "Wireline-User-Location-Info")
public interface WirelineUserLocationInfo extends DiameterGroupedAvp
{
	ByteBuf getHFCNodeIdentifier();
	
	void setHFCNodeIdentifier(ByteBuf value);
	
	ByteBuf getGLIIdentifier();
	
	void setGLIIdentifier(ByteBuf value);
	
	LineTypeEnum getLineType();
	
	void setLineType(LineTypeEnum value);
}