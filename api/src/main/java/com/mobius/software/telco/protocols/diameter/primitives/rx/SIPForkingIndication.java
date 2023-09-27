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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.22	SIP-Forking-Indication AVP
	The SIP-Forking-Indication AVP (AVP code 523) is of type Enumerated, and describes if several SIP dialogues are related to one Diameter session:

	SINGLE_DIALOGUE (0)
		This value is used to indicate that the Diameter session relates to a single SIP dialogue.
		This is the default value applicable if the AVP is omitted.

	SEVERAL_DIALOGUES (1)
		This value is used to indicate that the Diameter session relates to several SIP dialogues.
 */
@DiameterAvpDefinition(code = 523L, vendorId = KnownVendorIDs.TGPP_ID, name = "SIP-Forking-Indication")
public interface SIPForkingIndication extends DiameterEnumerated<SIPForkingIndicationEnum>
{
}