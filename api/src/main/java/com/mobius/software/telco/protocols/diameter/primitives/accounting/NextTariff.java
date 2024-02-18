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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.112	Next-Tariff AVP
	The Next-Tariff AVP (AVP code 2057) is of type Grouped and holds tariff information. The Tariff is a formula for cost calculation given the Used-Service-Unit AVP. The calculated cost is given in the Currency-Code AVP. 
	The formula sums all the rating elements and multiplies the sum by the Scale-Factor AVP. 
	It has the following ABNF grammar:

	Next-Tariff :: =  < AVP Header: 2057 >
			[ Currency-Code ]
			[ Scale-Factor ]
		* 	[ Rate-Element ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NEXT_TARIFF, vendorId = VendorIDs.TGPP_ID, name = "Next-Tariff")
public interface NextTariff extends DiameterAvp
{
	Long getCurrencyCode();
	
	void setCurrencyCode(Long value);
	
	ScaleFactor getScaleFactor();
	
	void setScaleFactor(ScaleFactor value);
	
	List<RateElement> getRateElement();
	
	void setRateElement(List<RateElement> value);
}