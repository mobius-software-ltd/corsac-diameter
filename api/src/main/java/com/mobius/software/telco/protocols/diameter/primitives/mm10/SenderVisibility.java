package com.mobius.software.telco.protocols.diameter.primitives.mm10;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	6.3.16	Sender-Visibility AVP
	The Sender-Visibility AVP (AVP code 1113) is of type Enumerated. It indicates whether the sender identification is requested to be hidden or not.

	Sender Identification requested not to be hidden (0)

	Sender Identification requested to be hidden (1)

	If the Sender-Visibility AVP is not present, then the default "Sender Identification requested not to be hidden" shall be assumed.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SENDER_VISIBILITY, vendorId = VendorIDs.TGPP_ID, name = "Sender-Visibility")
public interface SenderVisibility extends DiameterEnumerated<SenderVisibilityEnum>
{
}