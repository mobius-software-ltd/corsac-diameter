package com.mobius.software.telco.protocols.diameter.primitives.gi;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	12 - 3GPP-Selection-Mode
	Selection mode value: Text type.
	The format of this sub-attribute shall be a character that represents a single digit, mapping from the binary value of the
	selection mode in the Create PDP Context message (3GPP TS 29.060 [24]) for the GGSN, and the Create Default
	Bearer Request message (3GPP TS 29.274 [81]) for the P-GW. Where 3GPP TS 29.060 [24] provides for interpretation
	of the value, e.g. map '3' to '2', this shall be done by the GGSN. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TGPP_SELECTION_MODE, vendorId = VendorIDs.TGPP_ID, must = false, name = "3GPP-SelectionMode")
public interface TGPPSelectionMode extends DiameterUTF8String
{
}