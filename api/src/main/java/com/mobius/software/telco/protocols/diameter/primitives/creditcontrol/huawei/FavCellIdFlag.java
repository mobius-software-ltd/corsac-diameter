package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.123  Fav-Cell-Id-Flag AVP
	
	AVP Name
	Fav-Cell-Id-Flag

	AVP Code
	20361

	AVP Data Type
	Enumerated

	Vender-ID
	2011

	Description
	Indicates the flag of a preferential cell (HomeZone). The values are as follows:
    	- 0: Not in any preferential cell.
    	- 1: In the system level preferential cell.
    	- 2: In the user level preferential cell.
    	- 3: In the user level HomeZone and system level SpecialZone.
 */
@DiameterAvpDefinition(code = 20361L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Fav-Cell-Id-Flag")
public interface FavCellIdFlag extends DiameterEnumerated<FavCellIdFlagEnum>
{
}