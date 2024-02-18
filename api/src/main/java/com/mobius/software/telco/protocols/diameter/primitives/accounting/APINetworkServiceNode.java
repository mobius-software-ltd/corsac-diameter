package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.20eA API-Network-Service-Node AVP
	The API-Network-Service-Node AVP (AVP code 1315) is of type Enumerated,and holds the identifier of the network
	element as defined in TS 23.682[243], that triggers the API notification. 
	
	0 MME
 	1 SGSN
 	2 HSS
 	3 PCRF
 	4 PFDF
 	5 BMSC
 	6 CSCF
 	7 RCAF 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.API_NETWORK_SERVICE_NODE, vendorId = VendorIDs.TGPP_ID,must = false, name = "API-Network-Service-Node")
public interface APINetworkServiceNode extends DiameterEnumerated<APINetworkServiceNodeEnum>
{
}