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

import java.util.List;

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
 * 	8.4.69	AdditionalIdentifiers
	The AdditionalIdentifiers AVP is of type Grouped, and it shall contain External Group Identifiers.
	AVP format:

	AdditionalIdentifiers::=	<AVP header: 3173 10415>
			*[ External-Identifier ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ADDITIONAL_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, must = false, name = "Additional-Identifiers")
public interface AdditionalIdentifiers extends DiameterGroupedAvp
{
	List<String> getExternalIdentifier();
	
	void setExternalIdentifier(List<String> value);
}