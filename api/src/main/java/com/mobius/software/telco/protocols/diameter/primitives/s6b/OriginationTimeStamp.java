package com.mobius.software.telco.protocols.diameter.primitives.s6b;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	9.2.3.2.6	Origination-Time-Stamp
	The Origination-Time-Stamp is of type Unsigned64. It indicates the UTC time when the originating entity initiated the request. It shall contain the number of milliseconds since 00:00:00 on 1 January 1900 UTC.

	NOTE:	This AVP contains the same numeric value, in milliseconds, as received over the GTPv2 protocol from the originating entity (see 3GPP TS 29.274 [38], clause 8.119).
 */
@DiameterAvpDefinition(code = 1536L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Origination-Time-Stamp")
public interface OriginationTimeStamp extends DiameterUnsigned64
{
}