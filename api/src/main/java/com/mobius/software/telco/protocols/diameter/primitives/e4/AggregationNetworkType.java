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
 * 	7.3.8 Aggregation-Network-Type AVP
	The Aggregation-Network-Type AVP (AVP code 307 13019) is of type Enumerated.
	The following values are defined:

	• UNKNOWN (0).

	• ATM (1).

	• ETHERNET (2).   
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.AGGREGATION_NETWORK_TYPE, vendorId = VendorIDs.ETSI_ID, must = false, name = "Aggregation-Network-Type")
public interface AggregationNetworkType extends DiameterEnumerated<AggregationNetworkTypeEnum>
{
}