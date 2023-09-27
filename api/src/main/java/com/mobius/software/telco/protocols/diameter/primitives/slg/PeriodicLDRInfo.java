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

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.45	Periodic-LDR-Info
	The Periodic-LDR-Info AVP is of type Grouped.
	AVP format:

	Periodic-LDR-Info ::= <AVP header: 2540 10415>
		 { Reporting-Amount }
		 { Reporting-Interval }
		*[ AVP ]

	Reporting-Interval x Rreporting-Amount shall not exceed 8639999 (99 days, 23 hours, 59 minutes and 59 seconds) for compatibility with OMA MLP and RLP.
 */
@DiameterAvpDefinition(code = 2540L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Periodic-LDR-Info")
public interface PeriodicLDRInfo extends DiameterGroupedAvp
{
	Long getReportingAmount();
	
	void setReportingAmount(Long value);
	
	Long getReportingInterval();
	
	void setReportingInterval(Long value);
}