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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.138 Max-PLR-DL AVP
	The Max-PLR-DL AVP (AVP code 2852) is of type Unsigned32, and it indicates ratio of lost packets per number of
	packets sent in unit of tenth of percent for a downlink voice service data flow. This AVP is only applicable for PCC rule
	with QCI=1. The value of this AVP shall be within range 0 to 1000. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MAX_PLR_DL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Max-PLR-DL")
public interface MaxPLRDL extends DiameterUnsigned32
{
}