package com.mobius.software.telco.protocols.diameter.primitives.s9;
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
 * 	5.3.6	Multiple-BBERF-Action
	The Multiple-BBERF-Action AVP (AVP code 2204) is of type Enumerated, and it indicates that the Gateway Control Session in the VPLMN is established or terminated in the multiple BBERFs scenario.
	The following values are defined:

	ESTABLISHMENT (0)
	This value shall be used to indicate that the Gateway Control Session in the VPLMN is established in the multiple BBERFs scenario.

	TERMINATION (1)
	This value shall be used to indicate that the Gateway Control Session in the VPLMN is terminated in the multiple BBERFs scenario.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MULTIPLE_BBERF_ACTION, vendorId = VendorIDs.TGPP_ID, name = "Multiple-BBERF-Action")
public interface MultipleBBERFAction extends DiameterEnumerated<MultipleBBERFActionEnum>
{
}