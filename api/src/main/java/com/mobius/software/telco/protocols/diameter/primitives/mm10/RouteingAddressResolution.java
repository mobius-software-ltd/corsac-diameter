package com.mobius.software.telco.protocols.diameter.primitives.mm10;
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

/**
*
* @author yulian oifa
*
*/
/*
 * 	6.3.22	Routeing-Address-Resolution AVP
	The Routeing-Address-Resolution AVP (AVP code 1119) is of type Enumerated. It indicates whether the corresponding Routeing-Address has been resolved already.

	unresolved (0)

	resolved (1)
 */
@DiameterAvpDefinition(code = 1119L, vendorId = -1L, name = "Routeing-Address-Resolution")
public interface RouteingAddressResolution extends DiameterEnumerated<RouteingAddressResolutionEnum>
{
}