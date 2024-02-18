package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.62 Usage-Monitoring-Report AVP
	The Usage-Monitoring-Report AVP (AVP code 1069) is of type Enumerated and is used by the PCRF to indicate that
	accumulated usage is to be reported by the PCEF regardless of whether a usage threshold is reached.
	The following values are defined:

	USAGE_MONITORING_REPORT_REQUIRED (0)
 		This value, if provided within an RAR or CCA command by the PCRF indicates that accumulated usage shall be
		reported by the PCEF. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USAGE_MONITORING_REPORT, vendorId = VendorIDs.TGPP_ID, must = false, name = "Usage-Monitoring-Report")
public interface UsageMonitoringReport extends DiameterEnumerated<UsageMonitoringReportEnum>
{
}