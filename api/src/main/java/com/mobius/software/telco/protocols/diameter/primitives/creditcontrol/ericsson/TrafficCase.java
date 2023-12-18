package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson;
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
 * 	3.1.9 Traffic-Case AVP
	The Traffic-Case AVP (AVP code 1082) is of type Unsigned32 and holds the traffic case for the charged event.

	Table 2 Traffic-Case AVP	
	Traffic Case ACP	ValueTraffic Case
	0–19				Reserved for future use.
	20					Originating Service Charging
	21					Terminating Service Charging
	22 – MAXRANGE		Reserved for future use. MAXRANGE is defined as the maximum range of the unit type.

	The AVP is in this service context defined as ‘static’ and ‘cached’.
 */
@DiameterAvpDefinition(code = 1082L, vendorId = KnownVendorIDs.ERICSSON_ID, name = "Traffic-Case")
public interface TrafficCase extends DiameterUnsigned32
{
}