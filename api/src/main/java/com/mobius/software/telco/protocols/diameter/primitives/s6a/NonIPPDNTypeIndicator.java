package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.204	Non-IP-PDN-Type-Indicator
	The Non-IP-PDN-Type-Indicator AVP is of type Enumerated and indicates whether the APN has a Non-IP PDN type.
 	The following values are defined:

	FALSE (0)
	This value indicates that the APN does not have a Non-IP PDN type.

	TRUE (1)
	This value indicates that the APN has a Non-IP PDN type and, in this case, the value indicated by the PDN-Type AVP inside APN-Configuration AVP shall be ignored.

	The default value when this AVP is not present is FALSE (0).
 */
@DiameterAvpDefinition(code = 1681L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Non-IP-PDN-Type-Indicator")
public interface NonIPPDNTypeIndicator extends DiameterEnumerated<NonIPPDNTypeIndicatorEnum>
{
}