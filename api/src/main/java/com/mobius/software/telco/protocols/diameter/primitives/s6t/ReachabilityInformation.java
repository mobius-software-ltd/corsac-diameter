package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.20	Reachability-Information
	The Reachability-Information AVP is of type Unsigned32. It shall indicate the reachability of the subscriber. The following values are defined:

	REACHABLE_FOR_SMS (0)

	REACHABLE_FOR_DATA (1)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REACHABILITY_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Reachability-Information")
public interface ReachabilityInformation extends DiameterEnumerated<ReachabilityInformationEnum>
{
}