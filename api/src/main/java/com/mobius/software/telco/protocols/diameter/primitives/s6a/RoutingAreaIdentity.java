package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.120	Routing-Area-Identity
	The Routing-Area-Identity AVP is of type OctetString and shall contain the Routing Area Identity of the user which identifies 
	the routing area where the user is located, as specified in 3GPP TS 23.003 [3]. Octets are coded as described in 3GPP TS 29.002 [24].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROUTING_AREA_IDENTITY, vendorId = VendorIDs.TGPP_ID, must = false, name = "Routing-Area-Identity")
public interface RoutingAreaIdentity extends DiameterOctetString
{
}