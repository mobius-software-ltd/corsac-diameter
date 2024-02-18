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
 * 	5.3.61 Usage-Monitoring-Level AVP
	The Usage-Monitoring-Level AVP (AVP code 1068) is of type Enumerated and is used by the PCRF to indicate
	whether the usage monitoring instance applies to the IP-CAN session or to one or more PCC rules or to one or more
	ADC rules.
	If Usage-Monitoring-Level AVP is not provided, its absence shall indicate the value PCC_RULE_LEVEL (1).
	The following values are defined:

	SESSION_LEVEL (0)
 		This value, if provided within an RAR or CCA command by the PCRF, indicates that the usage monitoring
		instance applies to the entire IP-CAN session.
	PCC_RULE_LEVEL (1)
 		This value, if provided within an RAR or CCA command by the PCRF indicates that the usage monitoring
		instance applies to one or more PCC rules. This value is only applicable to Gx reference point.
	ADC_RULE_LEVEL (2)
 		This value, if provided within a TSR, RAR or CCA command by the PCRF, indicates that the usage monitoring
		instance applies to one or more ADC rules. This value is only applicable to Sd reference point. See clause 5b.4.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USAGE_MONITORING_LEVEL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Usage-Monitoring-Level")
public interface UsageMonitoringLevel extends DiameterEnumerated<UsageMonitoringLevelEnum>
{
}