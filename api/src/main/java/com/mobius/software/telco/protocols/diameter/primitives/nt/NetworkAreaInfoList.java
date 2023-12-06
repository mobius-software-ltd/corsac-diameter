package com.mobius.software.telco.protocols.diameter.primitives.nt;
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
	5.3.2	Network-Area-Info-List AVP
	The Network-Area-Info-List AVP (AVP code 4201) is of type OctetString, it contains the network area information which is coded as specified in 3GPP TS 29.274 [6] in Presence Reporting Area Action IE, starting from octet 9.
 */
@DiameterAvpDefinition(code = 4201L, vendorId = KnownVendorIDs.TGPP_ID, name = "Network-Area-Info-List")
public interface NetworkAreaInfoList extends DiameterOctetString
{
}