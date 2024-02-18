package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
 * 	6.3.10 Identity-Set AVP
	The Identity-Set AVP is of type Enumerated and indicates the requested set of IMS Public Identities. The following
	values are defined:

	ALL_IDENTITIES (0)
	REGISTERED_IDENTITIES (1)
	IMPLICIT_IDENTITIES (2)
	ALIAS_IDENTITIES (3) 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IDENTITY_SET, vendorId = VendorIDs.TGPP_ID, must = false, name = "Identity-Set")
public interface IdentitySet extends DiameterEnumerated<IdentitySetEnum>
{
}