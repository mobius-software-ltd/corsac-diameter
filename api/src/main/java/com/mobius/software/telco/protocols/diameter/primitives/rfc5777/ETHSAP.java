package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	4.1.8.17.  ETH-SAP AVP

   The ETH-SAP AVP (AVP Code 551) is of type OctetString.  The value is
   a double octet representing the 802.2 SAP as specified in
   [IEEE802.2].  The first octet contains the Destination Service Access
   Point (DSAP) and the second the Source Service Access Point (SSAP).
 */
@DiameterAvpDefinition(code = AvpCodes.ETH_SAP, vendorId = -1L, name = "ETH-SAP")
public interface ETHSAP extends DiameterOctetString
{
}