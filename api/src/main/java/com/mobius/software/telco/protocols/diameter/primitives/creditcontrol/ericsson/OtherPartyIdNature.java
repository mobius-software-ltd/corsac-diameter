package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson;
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
 * 	3.1.4 Other-Party-Id-Nature AVP
	The Other-Party-Id-Nature AVP (AVP code 1076) is of type Enumerated
	and holds the nature of address indicator for the number carried by the
	Other-Party-Id-Data AVP.
	
	This specification defines the following nature of address indicators.

	UNKNOWN 0

	INTERNATIONAL 1 (default)
	
	NATIONAL (SIGNIFICANT) 2

	As the Other-Party-Id-Nature address is an optional AVP, the default value
	used by the SCAPv2 service context shall be 1 (INTERNATIONAL) when the
	AVP is omitted and the Other-Party-Id-Type AVP is 0 (END_USER_E164).
 */
@DiameterAvpDefinition(code = 1076L, vendorId = KnownVendorIDs.ERICSSON_ID, name = "Other-Party-Id-Nature")
public interface OtherPartyIdNature extends DiameterEnumerated<OtherPartyIdNatureEnum>
{
}