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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.7 Access-Network-Type AVP
	The Access-Network-Type AVP (AVP code 306 13019) is of type Grouped, and it indicates the type of port on which
	the user equipment is connected and the type of aggregation network.
	AVP Format:
 
 	Access-Network-Type ::= < AVP Header: 306 13019 >
		 {NAS-Port-Type}
		 [Aggregation-Network-Type]  
 */
@DiameterAvpDefinition(code = 306L, vendorId = KnownVendorIDs.ETSI_ID,must = false, name = "Access-Network-Type")
public interface AccessNetworkType extends DiameterAvp
{
	NASPortTypeEnum getNASPortType();
	
	void setNASPortType(NASPortTypeEnum value);	
	
	AggregationNetworkTypeEnum getAggregationNetworkType();
	
	void setAggregationNetworkType(AggregationNetworkTypeEnum value);
}