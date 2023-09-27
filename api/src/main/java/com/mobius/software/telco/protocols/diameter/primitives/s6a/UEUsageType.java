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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.202	UE-Usage-Type
	The UE-Usage-Type AVP is of type Unsigned32. This value shall indicate the usage characteristics of the UE that enables the selection of a specific Dedicated Core Network (DCN). See clause 4.3.25 of 3GPP TS 23.401 [2].
	The allowed values of UE-Usage-Type shall be in the range of 0 to 255.
	Values in the range of 0 to 127 are standardized and defined as follows:
	
	0:	Spare, for future use
	…
	127:	Spare, for future use
	Values in the range of 128 to 255 are operator-specific.
*/
@DiameterAvpDefinition(code = 1680L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "UE-Usage-Type")
public interface UEUsageType extends DiameterUnsigned32
{
}