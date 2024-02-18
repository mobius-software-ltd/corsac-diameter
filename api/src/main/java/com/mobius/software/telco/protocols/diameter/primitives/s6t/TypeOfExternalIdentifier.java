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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.64	Type-Of-External-Identifier
	The Type-Of-External-Identifier AVP is of type Unsigned32 and it shall indicate which type of identity is carried in the External-Identifier AVP. The following values are defined:

	EXTERNAL-UE-IDENTIFIER-TYPE (0)
	The value 0 indicates the External-Identifier AVP carries the identity of an individual UE.

	EXTERNAL-GROUP-IDENTIFIER-TYPE (1)
	The value 1 indicates the External-Identifier AVP carries the identity of a Group of UEs.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TYPE_OF_EXTERNAL_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, must = false, name = "Type-Of-External-Identifier")
public interface TypeOfExternalIdentifier extends DiameterEnumerated<TypeOfExternalIdentifierEnum>
{
}