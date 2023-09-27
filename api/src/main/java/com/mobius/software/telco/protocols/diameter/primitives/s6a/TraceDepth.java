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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.67	Trace-Depth AVP
	The Trace-Depth AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Trace Depth.

	Trace depth shall be an enumerated parameter with the following possible values:
	0 – Minimum,
	1 – Medium
	2 – Maximum
	3 – MinimumWithoutVendorSpecificExtension
	4 – MediumWithoutVendorSpecificExtension
	5 - MaximumWithoutVendorSpecificExtension 
 */
@DiameterAvpDefinition(code = 1462L, vendorId = KnownVendorIDs.TGPP_ID, name = "Trace-Depth")
public interface TraceDepth extends DiameterEnumerated<TraceDepthEnum>
{
}