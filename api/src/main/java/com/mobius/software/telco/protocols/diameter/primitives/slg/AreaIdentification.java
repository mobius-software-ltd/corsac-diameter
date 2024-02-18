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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.42	Area-Identification
	The Area-Identification AVP is of type OctetString and shall contain the identification of the area applicable for the change of area event based deferred location reporting. For Area-Type 0 to 5, octets are coded as described in 3GPP TS 29.002 [24]. For Area-Type 6, octets are coded as defined for the Tracking Area Identity area identification in 3GPP TS 24.080 [24]. For Area-Type 7, octets are coded as defined for the ECGI area identification in 3GPP TS 24.080 [24]. For a deferred EPC-MT-LR for the area event, only Area-Type 6 and 7 are applicable.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AREA_IDENTIFICATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Area-Identification")
public interface AreaIdentification extends DiameterOctetString
{
}