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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.20B	APN-Rate-Control-Downlink   AVP
	The APN-Rate-Control-Downlink AVP (AVP code 3934) is of type Grouped and holds the APN Rate Control parameters applicable to data PDUs transfers in downlink for this APN.  
	It has the following ABNF grammar:
	
	APN-Rate-Control-Downlink :: = 	< AVP Header: 3934 >
		[ Rate-Control-Time-Unit ]
		[ Rate-Control-Max-Rate ]
		[ Rate-Control-Max-Message-Size ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.APN_RATE_CONTROL_DOWNLINK, vendorId = VendorIDs.TGPP_ID, name = "APN-Rate-Control-Downlink")
public interface APNRateControlDownlink extends DiameterAvp
{
	RateControlTimeUnitEnum getRateControlTimeUnit();
	
	void setRateControlTimeUnit(RateControlTimeUnitEnum value);
	
	Long getRateControlMaxRate();
	
	void setRateControlMaxRate(Long value);
	
	Long getRateControlMaxMessageSize();
	
	void setRateControlMaxMessageSize(Long value);
}