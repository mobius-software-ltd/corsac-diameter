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
 * 	7.3.132	VPLMN-LIPA-Allowed
	The VPLMN-LIPA-Allowed AVP is of type Enumerated. It shall indicate whether the UE is allowed to use LIPA in the VPLMN where the UE is roaming. The following values are defined:

	LIPA_NOTALLOWED (0)
	This value indicates that the UE is not allowed to use LIPA in the VPLMN where the UE is roaming.

	LIPA_ALLOWED (1)
	This value indicates that the UE is allowed to use LIPA in the VPLMN where the UE is roaming.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.VPLMN_LIPA_ALLOWED, vendorId = VendorIDs.TGPP_ID, must = false, name = "VPLMN-LIPA-Allowed")
public interface VPLMNLIPAAllowed extends DiameterEnumerated<VPLMNLIPAAllowedEnum>
{
}