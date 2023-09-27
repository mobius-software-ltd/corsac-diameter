package com.mobius.software.telco.protocols.diameter.primitives.pc2;
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
	6.4.8	Allowed-Suffixes-Number AVP
	The Allowed-Suffixes-Number AVP (AVP code 3606) is of type Unsigned32, and it indicates the maximum number of suffix codes which are used as part of ProSe Application Code or ProSe Restricted Code  that the ProSe Application Server can assign to the UE for a ProSe Appplication ID or an RPAUID.
 */
@DiameterAvpDefinition(code = 3606L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Allowed-Suffixes-Number")
public interface AllowedSuffixesNumber extends DiameterUnsigned32
{
}