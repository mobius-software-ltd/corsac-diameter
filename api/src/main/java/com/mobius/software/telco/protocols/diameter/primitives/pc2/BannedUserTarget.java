package com.mobius.software.telco.protocols.diameter.primitives.pc2;
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
 * 	6.4.17	Banned-User-Target AVP
	The Banned-User-Target AVP (AVP code 3611) is of type Grouped. It contains a Target-RPAUID and a Target-PDUID.
	The AVP format shall conform to:

	Banned-User-Target ::= <AVP header:3611>
                   { Target-RPAUID }
                   { Target-PDUID }
                  *[AVP]

If the Metadata-Indicator value is "0 (NO_METADATA)", the Metadata-Indicator AVP may be omitted.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.BANNED_USER_TARGER, vendorId = VendorIDs.TGPP_ID, must = false, name = "Banned-User-Target")
public interface BannedUserTarget extends DiameterGroupedAvp
{
	String getTargetRPAUID();
	
	void setTargetRPAUID(String value) throws MissingAvpException;
	
	ByteBuf getTargetPDUID();
	
	void setTargetPDUID(ByteBuf value) throws MissingAvpException;
}