package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.3.3 Logical-Access-ID AVP
	The Logical-Access-ID AVP (AVP code 302 13019) is of type OctetString. This AVP contains either a Circuit-ID (as
	defined in RFC 3046 [11]) or a technology independent identifier.

	NOTE: In the xDSL/ATM case, the Logical Access ID may explicitly contain the identity of the VP and VC
	carrying the traffic. 
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.LOGICAL_ACCESS_ID, vendorId = VendorIDs.ETSI_ID, name = "Logical-Access-ID")
public interface LogicalAccessID extends DiameterOctetString
{
}