package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 * 	5.3.19	Media-Type AVP
	The Media-Type AVP (AVP code 520) is of type Enumerated, and it determines the media type of a session component. The media types indicate the type of media in the same way as the SDP media types with the same names defined in RFC 4566 [13]. The following values are defined:

	-	AUDIO (0)

	-	VIDEO (1)

	-	DATA (2)

	-	APPLICATION (3)

	-	CONTROL (4)

	-	TEXT (5)

	-	MESSAGE (6)

	-	OTHER (0xFFFFFFFF)
 */
@DiameterAvpDefinition(code = 520L, vendorId = KnownVendorIDs.TGPP_ID, name = "Media-Type")
public interface MediaType extends DiameterEnumerated<MediaTypeEnum>
{
}