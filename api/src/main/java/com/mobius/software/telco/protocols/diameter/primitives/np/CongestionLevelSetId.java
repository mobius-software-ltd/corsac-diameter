package com.mobius.software.telco.protocols.diameter.primitives.np;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	5.3.6	Congestion-Level-Set-Id AVP
	The Congestion-Level-Set-Id AVP (AVP code 4004) is of type Unsigned32, and it is used to indicate the congestion level set identifier between the PCRF and the RCAF.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CONGESTION_LEVEL_SET_ID, vendorId = VendorIDs.TGPP_ID,must = false, name = "Congestion-Level-Set-Id")
public interface CongestionLevelSetId extends DiameterUnsigned32
{
}