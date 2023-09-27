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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
* 	5.3.77	GLI-Identifier AVP
	The GLI-Identifier AVP (AVP code 580) is of type OctetString and contains a Global Line Identifier (see clause 28.16.3 of 3GPP TS 23.003 [38]) encoded as base64-encoded characters, representing the GLI value (up to 150 bytes) as specified in BBF WT-470 [74].
 */
@DiameterAvpDefinition(code = 580L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "GLI-Identifier")
public interface GLIIdentifier extends DiameterOctetString
{
}