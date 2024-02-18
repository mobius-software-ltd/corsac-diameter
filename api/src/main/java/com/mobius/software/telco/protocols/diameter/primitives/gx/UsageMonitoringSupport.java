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
 * 	5.3.63 Usage-Monitoring-Support AVP
	The Usage-Monitoring-Support AVP (AVP code 1070) is of type Enumerated and is used by the PCRF to indicate
	whether usage monitoring shall be disabled for certain Monitoring Key.
	The following values are defined:

	USAGE_MONITORING_DISABLED (0)
 		This value indicates that usage monitoring is disabled for a monitoring key. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USAGE_MONITORING_SERVICE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Usage-Monitoring-Support")
public interface UsageMonitoringSupport extends DiameterEnumerated<UsageMonitoringSupportEnum>
{
}