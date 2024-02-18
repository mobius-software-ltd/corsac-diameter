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
	6.3.1	Visited-Network-Identifier AVP
	The Visited-Network-Identifier AVP is of type OctetString. This AVP contains an identifier that helps the HSS to identify the visited network (e.g. the visited network domain name). 
	Coding of octets is H-PLMN operator specific. The I-CSCF maps a received P-Visited-Network-ID onto an Octet String value that is consistently configured in I-CSCF and HSS to uniquely identify 
	the visited network.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.VISITED_NETWORK_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, name = "Visited-Network-Identifier")
public interface VisitedNetworkIdentifier extends DiameterOctetString
{
}