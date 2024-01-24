package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
	6.3.31	Feature-List AVP
	The Feature-List AVP is of type Unsigned32 and it contains a bit mask indicating the supported features of an application. When the bit set, indicates the corresponding feature is supported by the application. For the Cx application, the meaning of the bits has been defined in 7.1.1.
 */

/*
 *  Can not be translated into bitmask since the bitmask depends on feature list ID and thus not static
 */
@DiameterAvpDefinition(code = 630L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Feature-List")
public interface FeatureList extends DiameterUnsigned32
{
}