package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
	6.3.81	Encrypted-Bitmask 
	The Encrypted-Bitmask AVP is of type OctetString. It shall contain a 184-bit bitmask which uses bit "1" to mark the positions of the bits of a ProSe Restricted Code, ProSe Query Code or ProSe Response Code, for which the DUCK encryption is applied.
 */
@DiameterAvpDefinition(code = 3866L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Encrypted-Bitmask")
public interface EncryptedBitmask extends DiameterOctetString
{
}