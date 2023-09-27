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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	A.4.1. Access-Network-Identifier AVP
	The Access-Network-Identifier AVP (AVP Code 1000) is of type Unsigned32 and identifies the access network associated with the request triggering the M2M Event Record. 
	The IN-CSE detects the link on which a request came from or was  sent to and that link maps to a specific Network and locally configured identifier.
 */
@DiameterAvpDefinition(code = 1000L, vendorId = KnownVendorIDs.ONEM2M_ID, name = "Access-Network-Identifier")
public interface AccessNetworkIdentifier extends DiameterUnsigned32
{
}