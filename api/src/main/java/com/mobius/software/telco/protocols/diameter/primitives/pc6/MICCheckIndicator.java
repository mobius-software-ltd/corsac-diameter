package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
 * 	6.3.80	MIC-Check-Indicator 
	The MIC-Check-Indicator AVP is of type Unsigned32. It shall contain the indication of whether the UE shall use the ProSe Function to verify the MIC field of the received discovery message. The following values are defined:

	MIC_CHECK_BY_PROSE_FUNCTION (1)
	This value is used when the MIC check is required to be done by the ProSe Function. 
 */
@DiameterAvpDefinition(code = 3865L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MIC-Check-Indicator")
public interface MICCheckIndicator extends DiameterEnumerated<MICCheckIndicatorEnum>
{
}