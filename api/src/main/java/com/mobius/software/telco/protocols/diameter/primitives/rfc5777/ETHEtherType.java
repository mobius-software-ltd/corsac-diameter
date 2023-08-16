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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	4.1.8.16.  ETH-Ether-Type AVP

   	The ETH-Ether-Type AVP (AVP Code 550) is of type OctetString.  The
   	value is a double octet that contains the value of the Ethertype
   	field in the packet to match.  This AVP MAY be present in the case of
   	Digital, Intel, and Xerox (DIX) or if the Subnetwork Access Protocol
   	(SNAP) is present at 802.2, but the ETH-SAP AVP MUST NOT be present
   	in this case.
 */
@DiameterAvpDefinition(code = 550L, vendorId = -1L, name = "ETH-Ether-Type")
public interface ETHEtherType extends DiameterOctetString
{
}