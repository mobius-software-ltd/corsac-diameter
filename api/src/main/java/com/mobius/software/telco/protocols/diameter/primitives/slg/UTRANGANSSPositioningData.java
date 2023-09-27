package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.34	UTRAN-GANSS-Positioning-Data
	The UTRAN-GANSS-Positioning-Data AVP is of type OctetString. It shall contain the encoded content of the "GANSS-PositioningDataSet" only, included in the "positionData" Information Element as defined in 3GPP TS 25.413 [21]. 
 */
@DiameterAvpDefinition(code = 2529L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "UTRAN-GANSS-Positioning-Data")
public interface UTRANGANSSPositioningData extends DiameterOctetString
{
}