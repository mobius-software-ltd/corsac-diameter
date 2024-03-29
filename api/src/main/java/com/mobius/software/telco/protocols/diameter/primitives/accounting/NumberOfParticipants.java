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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.117 Number-Of-Participants AVP
	The Number-Of-Participants AVP (AVP code 885) is of type Unsigned32 and holds the number of invited parties of
	the multi-party session when included in the initial charging request message, e.g. in PoC, CONFerence and SIMPLE
	IM. When included in interim / update charging messages, it indicates the number of parties who are currently attached
	in the session at the time the interim / update messages are sent. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NUMBER_OF_PARTICIPANTS, vendorId = VendorIDs.TGPP_ID, name = "Number-Of-Participants")
public interface NumberOfParticipants extends DiameterUnsigned32
{
}