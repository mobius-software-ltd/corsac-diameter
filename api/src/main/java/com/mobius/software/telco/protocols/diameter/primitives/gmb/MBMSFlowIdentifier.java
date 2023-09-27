package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
	17.7.23	MBMS-Flow-Identifier AVP
	The MBMS-Flow-Identifier AVP (AVP code 920) is of type OctetString. Its length is two octets. It represents a location dependent subflow of a broadcast MBMS bearer service. When present, the MBMS-Flow-Identifier together with the TMGI uniquely identify an MBMS Bearer Context.
 */
@DiameterAvpDefinition(code = 920L, vendorId = KnownVendorIDs.TGPP_ID, name = "MBMS-Flow-Identifier")
public interface MBMSFlowIdentifier extends DiameterOctetString
{
}