package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.48	Periodic-Location-Type
	The Periodic-Location-Type AVP is of type Grouped. It shall contain the time interval between successive location reports and the total number of reports.
	The AVP format shall conform to:
		
	Periodic-Location-Type::=	<AVP header: 3829 10415>
		 { Location-Report-Interval-Time }
		 { Total-Number-Of-Reports }
		*[AVP]
 */
@DiameterAvpDefinition(code = 3829L, vendorId = KnownVendorIDs.TGPP_ID, name = "Periodic-Location-Type")
public interface PeriodicLocationType extends DiameterGroupedAvp
{
	Long getLocationReportIntervalTime();
	
	void setLocationReportIntervalTime(Long value);
	
	Long getTotalNumberOfReports();
	
	void setTotalNumberOfReports(Long value);
}