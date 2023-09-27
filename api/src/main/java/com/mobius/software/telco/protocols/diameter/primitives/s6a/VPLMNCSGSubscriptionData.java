package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.155	VPLMN-CSG-Subscription-Data
	The VPLMN-CSG-Subscription-Data AVP is of type Grouped. This AVP shall contain the CSG-Id, and optionally an associated expiration date.
	AVP format

	VPLMN-CSG-Subscription-Data ::= <AVP header: 1641 10415>
			 { CSG-Id }
			 [ Expiration-Date ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 1641L, vendorId = KnownVendorIDs.TGPP_ID, name = "VPLMN-CSG-Subscription-Data")
public interface VPLMNCSGSubscriptionData extends DiameterGroupedAvp
{
	Long getCSGId();
	
	void setCSGId(Long value);	
	
	Date getExpirationDate();
	
	void setExpirationDate(Date value);
}