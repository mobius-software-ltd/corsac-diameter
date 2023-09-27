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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.57 Dynamic-Address-Flag AVP
	The Dynamic-Address-Flag AVP (AVP code 2051) is of type Enumerated, and indicates whether the PDP
	context/PDN address is statically or dynamically allocated. If this AVP is not present, this means that the address is
	statically allocated. The following values are defined:

	0 Static
	1 Dynamic
 */
@DiameterAvpDefinition(code = 2051L, vendorId = KnownVendorIDs.TGPP_ID, name = "Dynamic-Address-Flag")
public interface DynamicAddressFlag extends DiameterEnumerated<DynamicAddressFlagEnum>
{
}