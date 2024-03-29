package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.124 Traffic-Steering-Policy-Identifier-UL AVP
	The Traffic-Steering-Policy-Identifier-UL (AVP code 2837) is of type OctetString and is used to contain a reference to
	a pre-configured traffic steering policy at the PCEF as defined in subclause 4.4.2 in the uplink direction.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TRAFFIC_STEERING_POLICY_IDENTIFIER_UL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Traffic-Steering-Policy-Identifier-UL")
public interface TrafficSteeringPolicyIdentifierUL extends DiameterOctetString
{
}