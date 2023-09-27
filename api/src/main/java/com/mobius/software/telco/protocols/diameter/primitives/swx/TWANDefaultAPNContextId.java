package com.mobius.software.telco.protocols.diameter.primitives.swx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	8.2.3.18	TWAN-Default-APN-Context-Id
	The TWAN-Default-APN-Context-Id AVP is of the type Unsigned32 and shall identify the context identifier of the subscriber's default APN to be used for Trusted WLAN access to EPC over S2a.

	Note: The default APN for Trusted WLAN access to EPC over S2a can differ from the default APN for 3GPP and other non-3GPP accesses.
 */
@DiameterAvpDefinition(code = 1512L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "TWAN-Default-APN-Context-Id")
public interface TWANDefaultAPNContextId extends DiameterUnsigned32
{
}