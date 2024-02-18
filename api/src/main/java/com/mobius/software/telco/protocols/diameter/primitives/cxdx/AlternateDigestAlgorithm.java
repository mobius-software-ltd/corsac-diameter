package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.72	Alternate-Digest-Algorithm AVP
	The Alternate-Digest-Algorithm AVP contains algorithm values specified in IETF RFC 7616 [29].

	NOTE:	The MD5 algorithm is only supported for backward compatibility and can only be provided within the Digest-Algorithm AVP.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ALTERNATE_DIGEST_ALGORITHM, vendorId = VendorIDs.TGPP_ID, must = false, name = "Alternate-Digest-Algorithm")
public interface AlternateDigestAlgorithm extends DiameterUTF8String
{
}