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
 * 	7.2.20	AoC-Subscription-Information AVP
	The AoC-Subscription-Information AVP (AVP code 2314) is of type Grouped and holds the subscription and formatting parameters received from HSS.
	It has the following ABNF grammar:

	AoC-Subscription-Information:: =      < AVP Header: 2314 >
 		* 	[ AoC-Service ]
   			[ AoC-Format ]
   			[ Preferred-AoC-Currency ]
 */
@DiameterAvpDefinition(code = 2314L, vendorId = KnownVendorIDs.TGPP_ID, name = "AoC-Subscription-Information")
public interface AoCSubscriptionInformation extends DiameterAvp
{
	List<AoCService> getAoCService();
	
	void setAoCService(List<AoCService> value);
	
	AoCFormatEnum getAoCFormat();
	
	void setAoCFormat(AoCFormatEnum value);
	
	Long getPreferredAoCCurrency();
	
	void setPreferredAoCCurrency(Long value);
}