package com.mobius.software.telco.protocols.diameter.primitives.e4;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.6 IP-Connectivity-Status AVP
	The IP-Connectivity-Status AVP (AVP code 305 13019) is of type Enumerated.
	The following values are defined:

	• IP-CONNECTIVITY-ON (0).

	• IP-CONNECTIVITY-LOST (1).  
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.IP_CONNECTIVITY_STATUS, vendorId = VendorIDs.ETSI_ID, must = false, name = "IP-Connectivity-Status")
public interface IPConnectivityStatus extends DiameterEnumerated<IPConnectivityStatusEnum>
{
}