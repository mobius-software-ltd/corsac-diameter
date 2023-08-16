package com.mobius.software.telco.protocols.diameter.primitives.s6b;
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
	9.2.3.1.2	Visited-Network-Identifier
	The Visited-Network-Identifier AVP contains an identifier that helps the home network to identify the visited network (e.g. the visited network domain name). The Vendor-Id shall be set to 10415 (3GPP).
	The AVP shall be encoded as:
	mnc<MNC>.mcc<MCC>.3gppnetwork.org
	If MNC consists of only 2 digits, a leading digit "0" shall be added to the MNC value (e.g., if MNC=15 and MCC=234, the value of Visited-Network-Identifier shall be "mnc015.mcc234.3gppnetwork.org").
 */
@DiameterAvpDefinition(code = 600L, vendorId = KnownVendorIDs.TGPP_ID, name = "Visited-Network-Identifier")
public interface VisitedNetworkIdentifier extends DiameterOctetString
{
}