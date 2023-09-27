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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.96	Location-Type AVP
	The Location-Type AVP (AVP code 1244) is of type Grouped and indicates the type of location estimate required by the LCS client.
	It has the following ABNF grammar:

	Location-Type:: = 			< AVP Header: 1244>
		[ Location-Estimate-Type ]
		[ Deferred-Location-Event-Type ]
 */
@DiameterAvpDefinition(code = 1244L, vendorId = KnownVendorIDs.TGPP_ID, name = "Location-Type")
public interface LocationType extends DiameterAvp
{
	LocationEstimateTypeEnum getLocationEstimateType();
	
	void setLocationEstimateType(LocationEstimateTypeEnum value);
	
	String getDeferredLocationEventType();
	
	void setDeferredLocationEventType(String value);
}