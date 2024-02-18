package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.51	Enhanced-Coverage-Restriction
	The Enhanced-Coverage-Restriction AVP is of type Grouped and shall identify either a complete (and possibly empty) list of serving PLMNs where Enhanced Coverage shall be restricted or a complete (and possibly empty) list of serving PLMNs where Enhanced Coverage shall not be restricted.
	AVP format:

	Enhanced-Coverage-Restriction ::=	<AVP header: 3155 10415>
			 [ Restricted-PLMN-List ]
			 [ Allowed-PLMN-List ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ENHANCED_COVERAGE_RESTRICTION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Enhanced-Coverage-Restriction")
public interface EnhancedCoverageRestriction extends DiameterGroupedAvp
{
	RestrictedPLMNList getRestrictedPLMNList();
	
	void setRestrictedPLMNList(RestrictedPLMNList value);
	
	AllowedPLMNList getAllowedPLMNList();
	
	void setAllowedPLMNList(AllowedPLMNList value);
}