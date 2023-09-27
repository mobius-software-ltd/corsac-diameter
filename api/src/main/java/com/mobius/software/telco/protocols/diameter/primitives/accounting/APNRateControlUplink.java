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
 * 	7.2.20C	APN-Rate-Control-Uplink   AVP
	The APN-Rate-Control-Uplink AVP (AVP code 3935) is of type Grouped and holds the APN Rate Control parameters applicable to data PDUs transfers in uplink for this APN.
	It has the following ABNF grammar:
	
	APN-Rate-Control-Uplink :: = 	< AVP Header: 3935>
		[ Additional-Exception-Reports ]
		[ Rate-Control-Time-Unit ]
		[ Rate-Control-Max-Rate ]
 */
@DiameterAvpDefinition(code = 3935L, vendorId = KnownVendorIDs.TGPP_ID, name = "APN-Rate-Control-Uplink")
public interface APNRateControlUplink extends DiameterAvp
{
	AdditionalExceptionReportsEnum getAdditionalExceptionReports();
	
	void setAdditionalExceptionReports(AdditionalExceptionReportsEnum value);
	
	RateControlTimeUnitEnum getRateControlTimeUnit();
	
	void setRateControlTimeUnit(RateControlTimeUnitEnum value);
	
	Long getRateControlMaxRate();
	
	void setRateControlMaxRate(Long value);
}