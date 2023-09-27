package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.49	PLMN-ID-List
	The PLMN-ID-List AVP is of type Grouped.
	AVP format:

	PLMN-ID-List ::= <AVP header: 2544 10415>
		 { Visited-PLMN-Id }
		 [ Periodic-Location-Support-Indicator ]
		*[ AVP ]

	If not included, the default value of Periodic-Location-Support-Indicator shall be considered as "NOT_SUPPORTED" (0).
 */
@DiameterAvpDefinition(code = 2544L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PLMN-ID-List")
public interface PLMNIDList extends DiameterGroupedAvp
{
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	PeriodicLocationSupportIndicatorEnum getPeriodicLocationSupportIndicator();
	
	void setPeriodicLocationSupportIndicator(PeriodicLocationSupportIndicatorEnum value);
}