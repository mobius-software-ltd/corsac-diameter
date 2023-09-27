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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.13	AoC-Cost-Information AVP
	The AoC-Cost-Information AVP (AVP code 2053) is of type Grouped and holds accumulated and incremental cost infromation for the AoC service
	It has the following ABNF grammar:

	AoC-Cost-Information:: =  < AVP Header: 2053 >
			  [ Accumulated-Cost ]
			* [ Incremental-Cost ]
			  [ Currency-Code ]
 */
@DiameterAvpDefinition(code = 2053L, vendorId = KnownVendorIDs.TGPP_ID, name = "AoC-Cost-Information")
public interface AoCCostInformation extends DiameterAvp
{
	AccumulatedCost getAccumulatedCost();
	
	void setAccumulatedCost(AccumulatedCost value);
	
	List<IncrementalCost> getIncrementalCost();
	
	void setIncrementalCost(List<IncrementalCost> value);
	
	Long getCurrencyCode();
	
	void setCurrencyCode(Long value);
}