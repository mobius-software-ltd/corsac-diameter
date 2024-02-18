package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
 * 	6.3.29 Call-Reference-Info AVP
	The Call-Reference-Info AVP is of type Grouped. This AVP shall contain a Call-Reference-Number AVP and an ASNumber AVP.
	AVP format

	Call-Reference-Info ::= <AVP header: 720 10415>
		{Call-Reference-Number}
		{AS-Number}
 	   *[AVP] 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CALL_REFERENCE_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "Call-Reference-Info")
public interface CallReferenceInfo extends DiameterGroupedAvp
{
	ByteBuf getCallReferenceNumber();
	
	void setCallReferenceNumber(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getASNumber();
	
	void setASNumber(ByteBuf value) throws MissingAvpException;	
}